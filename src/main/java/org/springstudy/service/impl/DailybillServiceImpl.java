package org.springstudy.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springstudy.entity.Account;
import org.springstudy.entity.Dailybill;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.service.DailybillService;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.vo.DailybillVO;

/**
 * Created by sheng on 2019/3/5.
 */
@Slf4j
@Service
public class DailybillServiceImpl implements DailybillService {

    @Autowired
    private DailybillRepository dailybillRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Dailybill addBill(DailybillVO vo) {
        log.info("收到创建流水请求, " + vo);
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

        return model;
    }
}
