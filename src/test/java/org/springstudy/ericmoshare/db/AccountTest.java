package org.springstudy.ericmoshare.db;
import org.springstudy.enums.AccountTypeEnum;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springstudy.entity.Account;
import org.springstudy.entity.User;
import org.springstudy.entity.UserExample;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.ericmoshare.BaseNGTest;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.UserRepository;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class AccountTest extends BaseNGTest {


    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void testInsert() {

        Account entity = new Account();
        entity.setUserId("10086");
        entity.setDrAmount(15000L);
        entity.setCrAmount(0L);
        entity.setBalance(15000L);
        entity.setCardType(CardTypeEnum.DEBIT);
        entity.setAccountName("招商银行");
        entity.setAccountType(AccountTypeEnum.Fund);
        entity.setRemark("招商银行借记卡");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());


        accountRepository.insertSelective(entity);

        entity.setUserId("10086");
        entity.setDrAmount(36000L);
        entity.setCrAmount(0L);
        entity.setBalance(36000L);
        entity.setCardType(CardTypeEnum.DEBIT);
        entity.setAccountName("现金钱包");
        entity.setAccountType(AccountTypeEnum.Fund);
        entity.setRemark("现金钱包");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());

        accountRepository.insertSelective(entity);
    }

}
