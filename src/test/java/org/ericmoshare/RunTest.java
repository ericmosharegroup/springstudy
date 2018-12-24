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
public class RunTest extends BaseNGTest {

    @Autowired
    private RunRate runRate;


    //显示速度大于30的动物
    @Test
    public void testRun5() {

        System.out.println("========");

        List<Run> list = runRate.rateDesc();

        for (int i = 0; i < list.size(); i++) {
            String msg = "" + list.get(i).alias() + " 时速=" + list.get(i).rate();
            if (list.get(i).rate() >= 30) {
                System.out.println(msg);
            }
        }
    }


}



