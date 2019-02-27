package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springstudy.entity.Account;
import org.springstudy.entity.Dailybill;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.vo.*;

import javax.smartcardio.Card;
import javax.validation.Valid;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class DailybillController extends AbstractController {

    @Autowired
    private DailybillRepository dailybillRepository;

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 创建账户,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/dailybill/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@ModelAttribute @Valid DailybillVO vo) {
        log.info("创建账单: " + vo);

        String txDate = vo.getTxDate();
        txDate = txDate.replaceAll("-", "");

        Dailybill model = new Dailybill();
        model.setUserId(vo.getUserId());
        model.setTxDate(txDate);
        model.setTxType(TxTypeEnum.valueOf(vo.getTxType()));
        model.setRemark(vo.getRemark());
        model.setAccountId(vo.getAccountId());
        model.setTxAmount(MoneyUtils.yuanToFen(vo.getTxAmount()));

        //拿到账户id
        Account account = accountRepository.selectByPrimaryKey(vo.getAccountId());

        AccountTypeEnum accountType = account.getAccountType();
        if (accountType == AccountTypeEnum.Fund) {
            //资金账户
            //借记卡, 信用卡
            if (model.getTxType() == TxTypeEnum.Income) {
                model.setDrAmount(model.getTxAmount());
            } else if (model.getTxType() == TxTypeEnum.Expenditure) {
                model.setCrAmount(model.getTxAmount());
            }
        } else if (accountType == AccountTypeEnum.Payable) {
            //应付账户
            if (model.getTxType() == TxTypeEnum.Income) {
                model.setDrAmount(model.getTxAmount());
            } else if (model.getTxType() == TxTypeEnum.Expenditure) {
                model.setCrAmount(model.getTxAmount());
            }
        } else {
            if (model.getTxType() == TxTypeEnum.Income) {
                model.setDrAmount(model.getTxAmount());
            } else if (model.getTxType() == TxTypeEnum.Expenditure) {
                model.setCrAmount(model.getTxAmount());
            }
        }
        dailybillRepository.insertSelective(model);

        log.info("创建 {}, id={}", JSON.toJSONString(vo), model.getId());
        return prepareResp(model);
    }


}
