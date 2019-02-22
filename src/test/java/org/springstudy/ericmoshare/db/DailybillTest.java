package org.springstudy.ericmoshare.db;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springstudy.entity.Dailybill;
import org.springstudy.entity.DailybillExample;
import org.springstudy.ericmoshare.BaseNGTest;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.repository.MonthbillRepository;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class DailybillTest extends BaseNGTest {


    @Autowired
    private DailybillRepository dailybillRepository;


    @Test
    public void testInsert() {

        Dailybill dailybill = new Dailybill();

        dailybill.setUserId("10086");
        dailybill.setTxYear("2019");
        dailybill.setTxMonth("201901");
        dailybill.setTxDate("20190126");
        dailybill.setDrAmount(2000L);
        dailybill.setCrAmount(4000L);
        dailybill.setAccountId(1L);
        dailybill.setTxType("1");
        dailybill.setRemark("");

        dailybillRepository.insertSelective(dailybill);
    }


    @Test
    public void testSelect() {

        DailybillExample dailybill = new DailybillExample();
        dailybill.createCriteria()
                .andIdLessThanOrEqualTo(10L)
                .andIdGreaterThanOrEqualTo(0L);


        List<Dailybill> result = dailybillRepository.selectByExample(dailybill);

        System.out.println(result);

        log.info("result=\n" + JSON.toJSONString(result, true));
    }


}
