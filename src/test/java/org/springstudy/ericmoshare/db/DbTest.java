package org.springstudy.ericmoshare.db;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springstudy.entity.*;
import org.springstudy.ericmoshare.BaseNGTest;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.repository.UserRepository;
import org.springstudy.utils.page.Direction;
import org.springstudy.utils.page.Order;
import org.springstudy.utils.page.Pageable;
import org.springstudy.utils.page.Sort;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class DbTest extends BaseNGTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailybillRepository dailybillRepository;

    @Test
    public void testPrint() {

        //相当于 statement.execute
        String result = jdbcTemplate.queryForObject("SELECT username FROM t_user ", String.class);

        log.info("result={}", result);

    }

    @Test
    public void testInsert() {

        User user = new User();
        user.setUsername("王" + new Random().nextInt(100));
        user.setUserMobileNo("123456");
        user.setUserEmail("123456");
        user.setRemark("");
        user.setRemark2("");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        userRepository.insertSelective(user);

        System.out.println("id:" + user.getId());

    }

    @Test
    public void testSelect() {

        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(1L)
                .andIdLessThan(10L);

        List<User> result = userRepository.selectByExample(example);

        System.out.println(result);

        log.info("result=\n" + JSON.toJSONString(result, true));
    }

    @Test
    public void testSelect2() {

        DailybillExample example = new DailybillExample();

        DcAmount result = dailybillRepository.sumByExample(example);

        System.out.println(result);

        log.info("result=\n" + JSON.toJSONString(result, true));
    }

    @Test
    public void testSelectByPage() {

        Pageable pageable = new Pageable();
        pageable.setOffset(0);
        pageable.setPageSize(2);

        Order order = new Order();
        order.setDirection(Direction.DESC);
        order.setProperty("id");

        Sort sort = new Sort();
        sort.setOrders(Lists.newArrayList(order));
        pageable.setSort(sort);

        DailybillExample example = new DailybillExample();

        List<Dailybill> result = dailybillRepository.selectByPage(example, pageable);

        log.info("result=\n" + JSON.toJSONString(result, true));
    }
}
