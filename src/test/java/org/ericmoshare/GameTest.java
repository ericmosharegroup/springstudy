package org.ericmoshare;

import org.ericmoshare.duixiang.jiekou.Fly;
import org.ericmoshare.duixiang.jiekou.Hobbit;
import org.ericmoshare.duixiang.jiekou.Run;
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

}
