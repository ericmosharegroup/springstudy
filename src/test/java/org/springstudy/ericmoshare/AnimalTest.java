package org.springstudy.ericmoshare;

import org.springstudy.ericmoshare.duixiang.Animal;
import org.springstudy.ericmoshare.duixiang.Bird;
import org.springstudy.ericmoshare.duixiang.Cat;
import org.springstudy.ericmoshare.duixiang.Dog;
import org.springstudy.ericmoshare.duixiang.jiekou.Hobbit;
import org.springstudy.ericmoshare.duixiang.jiekou.Run;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public class AnimalTest extends BaseNGTest {

    @Resource(name = "duck")
    private Animal animal;

    @Resource(name = "duck")
    private Bird bird;

    @Resource(name = "tiger")
    private Cat tiger;

    @Resource(name = "lion")
    private Cat lion;

    @Resource(name = "liebao")
    private Cat liebao;

    @Resource(name = "liebao")
    private Hobbit hobbit;

    @Resource(name = "liebao")
    private Run run;

    @Resource(name = "homecat")
    private Cat homecat;

    @Resource(name = "hashiqi")
    private Dog hashiqi;

    @Resource(name = "jinmao")
    private Dog jinmao;


    @Test
    public void testAnimal() {
        animal.speak();

        bird.fly();
    }

    @Test
    public void testCat() {
        tiger.speak();
        lion.speak();

        tiger.aihao();
        lion.aihao();
    }

    @Test
    public void testCat2() {
        lion.speak();
        lion.aihao();
        lion.run();
    }

    @Test
    public void testCat3() {
        liebao.speak();
        liebao.aihao();
        liebao.run();
    }

    @Test
    public void testCat4() {
        hobbit.aihao();
        run.run();
    }

    @Test
    public void testCat5() {
        homecat.speak();
        homecat.aihao();
        homecat.run();
    }

    @Test
    public void testDog() {
        hashiqi.speak();
        hashiqi.aihao();
        hashiqi.run();
    }

    @Test
    public void testDog2() {
        jinmao.speak();
        jinmao.aihao();
        jinmao.run();
    }
}
