package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springstudy.entity.Account;
import org.springstudy.entity.AccountExample;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.vo.AccountVO;
import org.springstudy.webapp.vo.Resp;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class AccountController extends AbstractController {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 创建账户,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@ModelAttribute @Valid AccountVO vo) {
        log.info("创建账户: " + vo);

        Account entity = new Account();
        entity.setUserId(vo.getUserId());
        entity.setAccountName(vo.getAccountName());
        entity.setBalance(vo.getBalance());
        entity.setAccountType(AccountTypeEnum.valueOf(vo.getAccountType()));
        entity.setRemark(vo.getRemark());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setCardType(CardTypeEnum.valueOf(vo.getCardType()));

        if (entity.getAccountType() == AccountTypeEnum.Fund || entity.getAccountType() == AccountTypeEnum.Receivable) {
            //如果是资金账户
            if (entity.getCardType() == CardTypeEnum.CREDIT) {
                //如果是信用卡记卡,余额=贷方金额
                entity.setCrAmount(entity.getBalance());
            } else {
                //如果是借记卡,余额=借方金额
                entity.setDrAmount(entity.getBalance());
            }
        } else {
            //如果是应付账户,那么直接为贷方金额
            entity.setCrAmount(entity.getBalance());
        }

        accountRepository.insertSelective(entity);

        log.info("创建 {}, id={}", JSON.toJSONString(vo), entity.getId());
        return prepareResp(entity);
    }

    /**
     * 查询所有资产,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/queryAllAssets/{userId}", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryAllAssets(@PathVariable @Valid String userId) {
        log.info("查询所有资产: " + userId);

        Map<String, String> map = new HashMap<>();

        AccountExample example = new AccountExample();
        example.createCriteria().andUserIdEqualTo(userId);

        List<Account> list = accountRepository.selectByExample(example);

        Long drAmount = 0L;
        Long crAmount = 0L;

        if (!CollectionUtils.isEmpty(list)) {
            //遍历
            for (Account entity : list) {
                drAmount = drAmount + entity.getDrAmount();
                crAmount = crAmount + entity.getCrAmount();
            }
        }

        map.put("totalAsset", MoneyUtils.fenToYuan(drAmount));
        map.put("totalDebt", MoneyUtils.fenToYuan(crAmount));
        map.put("plainAsset", MoneyUtils.fenToYuan(drAmount - crAmount));

        log.info("{} 的资产为:{}", userId, JSON.toJSONString(map, true));
        return prepareResp(map);
    }

}
