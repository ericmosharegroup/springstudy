package org.springstudy.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springstudy.entity.*;
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

        try {
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
                } else if (model.getTxType() == TxTypeEnum.Expend) {
                    model.setCrAmount(model.getTxAmount());
                }
            } else if (accountType == AccountTypeEnum.Payable) {
                //应付账户
                if (model.getTxType() == TxTypeEnum.Income) {
                    model.setDrAmount(model.getTxAmount());
                } else if (model.getTxType() == TxTypeEnum.Expend) {
                    model.setCrAmount(model.getTxAmount());
                }
            } else {
                if (model.getTxType() == TxTypeEnum.Income) {
                    model.setDrAmount(model.getTxAmount());
                } else if (model.getTxType() == TxTypeEnum.Expend) {
                    model.setCrAmount(model.getTxAmount());
                }
            }
            dailybillRepository.insertSelective(model);

            log.info("创建 {}, id={}", JSON.toJSONString(vo), model.getId());


            //重新计算该账户的余额
            recalculateAccountDcAmount(vo.getUserId(), vo.getAccountId());
            return model;

        } catch (Exception e) {
            log.error("catch Exception, " + e.getMessage(), e);
            throw e;
        }


    }

    @Override
    public void recalculateAccountDcAmount(String userId, Long accountId) {

        log.info("重新计算该账户的余额, {}:{}", userId, accountId);
        DailybillExample example = new DailybillExample();
        example.createCriteria().andUserIdEqualTo(userId)
                .andAccountIdEqualTo(accountId);

        DcAmount result = dailybillRepository.sumByExample(example);

        Account model = new Account();
        model.setDrAmount(result.getDrAmount());
        model.setCrAmount(result.getCrAmount());
        model.setBalance(result.getDrAmount() - result.getCrAmount());

        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUserIdEqualTo(userId)
                .andIdEqualTo(accountId);
        accountRepository.updateByExampleSelective(model, accountExample);


    }
}
