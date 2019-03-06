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
import org.springstudy.service.AccountService;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.vo.AccountDetailQueryVO;
import org.springstudy.webapp.vo.AccountQueryVO;
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


    @Autowired
    private AccountService accountService;


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

        Long id = accountService.addAccount(vo);
        log.info("创建 {}, id={}", JSON.toJSONString(vo), id);
        return prepareResp(id);
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

        //统计资金账户的余额
        //资金账户数量
        int fundCount = 0;
        Long fundDrAmount = 0L;
        Long fundCrAmount = 0L;
        if (!CollectionUtils.isEmpty(list)) {
            //遍历
            for (Account entity : list) {
                if (entity.getAccountType() == AccountTypeEnum.Fund) {
                    log.debug("//   get 资金账户:" + entity);
                    fundCount = fundCount + 1;
                    fundDrAmount = fundDrAmount + entity.getDrAmount();
                    fundCrAmount = fundCrAmount + entity.getCrAmount();
                }
            }
        }
        map.put("fundCount", String.valueOf(fundCount));
        map.put("fundBalance", MoneyUtils.fenToYuan(fundDrAmount - fundCrAmount));

        int receivableCount = 0;
        Long receivableDrAmount = 0L;
        Long receivableCrAmount = 0L;
        if (!CollectionUtils.isEmpty(list)) {
            //遍历
            for (Account entity : list) {
                if (entity.getAccountType() == AccountTypeEnum.Receivable) {
                    log.debug("//   get 应收账户:" + entity);
                    receivableCount = receivableCount + 1;
                    receivableDrAmount = receivableDrAmount + entity.getDrAmount();
                    receivableCrAmount = receivableCrAmount + entity.getCrAmount();
                }
            }
        }
        map.put("receivableCount", String.valueOf(receivableCount));
        map.put("receivableBalance", MoneyUtils.fenToYuan(receivableDrAmount - receivableCrAmount));

        int payableCount = 0;
        Long payableDrAmount = 0L;
        Long payableCrAmount = 0L;
        if (!CollectionUtils.isEmpty(list)) {
            //遍历
            for (Account entity : list) {
                if (entity.getAccountType() == AccountTypeEnum.Payable) {
                    log.debug("//   get 应付账户:" + entity);
                    payableCount = payableCount + 1;
                    payableDrAmount = payableDrAmount + entity.getDrAmount();
                    payableCrAmount = payableCrAmount + entity.getCrAmount();
                }
            }
        }
        map.put("payableCount", String.valueOf(payableCount));
        map.put("payableBalance", MoneyUtils.fenToYuan(payableDrAmount - payableCrAmount));

        log.debug("//   {} 的资产为:{}", userId, JSON.toJSONString(map));
        return prepareResp(map);
    }

    /**
     * 根据账户类型查询所有账户,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/queryAccounts", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryAccounts(@ModelAttribute @Valid AccountQueryVO vo) {
        log.info("查询账户: " + vo);

        AccountExample example = new AccountExample();
        example.createCriteria()
                .andUserIdEqualTo(vo.getUserId())
                .andAccountTypeEqualTo(vo.getAccountType());

        List<Account> list = accountRepository.selectByExample(example);

        log.info("{} 的资产为:{}", vo.getUserId(), JSON.toJSONString(list));
        return prepareResp(list);
    }


    /**
     * 根据账户detail详情,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/queryAccountDetail", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryAccountDetail(@ModelAttribute @Valid AccountDetailQueryVO vo) {
        log.info("查询账户detail: " + vo);

        AccountExample example = new AccountExample();
        example.createCriteria()
                .andUserIdEqualTo(vo.getUserId())
                .andIdEqualTo(Long.valueOf(vo.getId()));

        List<Account> list = accountRepository.selectByExample(example);

        //判断这个集合(list, set)是不是空的
        if (CollectionUtils.isEmpty(list)) {
            //遍历
            log.info("{} 的资产detail为:null", vo.getUserId());
            return prepareResp(null);
        }


        log.info("{} 的资产detail为:{}", vo.getUserId(), list.get(0));
        return prepareResp(list.get(0));
    }

}
