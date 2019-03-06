package org.springstudy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springstudy.entity.Account;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.service.AccountService;
import org.springstudy.service.DailybillService;
import org.springstudy.utils.DateUtils;
import org.springstudy.webapp.vo.AccountVO;
import org.springstudy.webapp.vo.DailybillVO;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by sheng on 2019/3/5.
 */

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private DailybillService dailybillService;


    @Override
    public Long addAccount(AccountVO vo) {
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


        //创建账单
        DailybillVO bill = new DailybillVO();
        bill.setAccountId(entity.getId());
        bill.setUserId(vo.getUserId());
        bill.setTxDate(DateUtils.getCurrentDate());
        bill.setTxType(TxTypeEnum.Income.name());
        bill.setRemark("余额调整");
        bill.setTxAmount(String.valueOf(vo.getBalance()));

        dailybillService.addBill(bill);

        return entity.getId();
    }


}
