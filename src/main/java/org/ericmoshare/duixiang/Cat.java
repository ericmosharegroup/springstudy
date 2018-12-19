package org.ericmoshare.duixiang;

import org.ericmoshare.duixiang.jiekou.Hobbit;
import org.ericmoshare.duixiang.jiekou.Run;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public abstract class Cat extends Animal implements Run, Hobbit {

    @Override
    public void aihao() {
        System.out.println("爱好: 吃鱼");
    }

}
