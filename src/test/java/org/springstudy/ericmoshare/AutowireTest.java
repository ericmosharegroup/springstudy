package org.springstudy.ericmoshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springstudy.ericmoshare.duixiang.Wang;
import org.springstudy.ericmoshare.duixiang.Zhang;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public class AutowireTest extends BaseNGTest {

    /**
     * 王氏家族只有一个人, 所以可以用 autowired
     */
    // @Resource(name = "wangFeihong")
    @Autowired
    private Wang wang;

    /**
     * 张氏家族有多个人, 所以要指定人名
     */
    @Resource(name = "zhangSan")
    private Zhang zhang;

    @Test
    public void testAutowired() {

        System.out.println(wang.name());

        System.out.println(zhang.name());

    }

}
