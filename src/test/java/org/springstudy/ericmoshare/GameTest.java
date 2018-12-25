package org.springstudy.ericmoshare;

import org.springstudy.ericmoshare.duixiang.Dog;
import org.springstudy.ericmoshare.duixiang.jiekou.Fly;
import org.springstudy.ericmoshare.duixiang.jiekou.Hobbit;
import org.springstudy.ericmoshare.duixiang.jiekou.Run;
import org.springstudy.ericmoshare.duixiang.service.RunRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public class GameTest extends BaseNGTest {

    @Autowired
    private List<Run> runners;

    @Autowired
    private List<Fly> flyers;

    @Autowired
    private List<Hobbit> hobbits;

    @Autowired
    private List<Dog> dogs;

    @Autowired
    private RunRate runRate;

    @Test
    public void testRun() {

        for (int i = 0; i < runners.size(); i++) {
            runners.get(i).run();
        }
    }

    @Test
    public void testFly() {

        for (int i = 0; i < flyers.size(); i++) {
            flyers.get(i).fly();
        }
    }

    @Test
    public void testhobbit() {

        for (int i = 0; i < hobbits.size(); i++) {
            hobbits.get(i).aihao();
        }
    }

    @Test
    public void testRun2() {

        for (int i = 0; i < runners.size(); i++) {
            String msg = "" + runners.get(i).alias() + " 时速=" + runners.get(i).rate();
            System.out.println(msg);
        }
    }


    @Test
    public void testRun3() {

        List<Run> list = runRate.rateDesc();

        for (int i = 0; i < list.size(); i++) {
            String msg = "" + list.get(i).alias() + " 时速=" + list.get(i).rate();
            System.out.println(msg);
        }
    }

    @Test
    public void testDog() {

        for (int i = 0; i < dogs.size(); i++) {
           String name =  dogs.get(i).alias();
            System.out.println("名字 "+name);
        }
    }
}
