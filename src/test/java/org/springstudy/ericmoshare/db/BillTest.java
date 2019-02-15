package org.springstudy.ericmoshare.db;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springstudy.entity.*;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.ericmoshare.BaseNGTest;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.MonthbillRepository;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class BillTest extends BaseNGTest {


    @Autowired
    private MonthbillRepository monthbillRepository;


    @Test
    public void testInsert() {

        Monthbill monthbill = new Monthbill();
        monthbill.setUserId("10086");
        monthbill.setDrAmount(10L);
        monthbill.setCrAmount(20L);
        monthbill.setBalance(100L);
        monthbill.setAccountId(4L);
        monthbill.setTxMonth("201901");
        monthbill.setStartDate("01");
        monthbill.setEndDate("31");

        monthbillRepository.insertSelective(monthbill);
    }

    @Test
    public void testSelect() {

        MonthbillExample example = new MonthbillExample();
        example.createCriteria()
                .andIdLessThanOrEqualTo(10L)
                .andIdGreaterThanOrEqualTo(0L);


        List<Monthbill> result = monthbillRepository.selectByExample(example);

        System.out.println(result);

        log.info("result=\n" + JSON.toJSONString(result, true));
    }

}
