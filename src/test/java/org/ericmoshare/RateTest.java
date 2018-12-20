package org.ericmoshare;

import org.ericmoshare.duixiang.jiekou.Run;
import org.ericmoshare.duixiang.service.RunRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public class RateTest extends BaseNGTest {

    @Autowired
    private RunRate runRate;

    @Test
    public void testRun() {
        System.out.println("========");

        List<Run> list = runRate.rateDesc();

        for (int i = 0; i < list.size(); i++) {
            String msg = "" + list.get(i).alias() + " 时速=" + list.get(i).rate();
            System.out.println(msg);
        }
    }

    @Test
    public void testRunAsc() {
        System.out.println("========");
        List<Run> list = runRate.rateAsc();

        for (int i = 0; i < list.size(); i++) {
            String msg = "" + list.get(i).alias() + " 时速=" + list.get(i).rate();
            System.out.println(msg);
        }
    }
}
