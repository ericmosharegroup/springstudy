package org.springstudy.ericmoshare.duixiang;

import org.springstudy.ericmoshare.duixiang.jiekou.Hobbit;
import org.springstudy.ericmoshare.duixiang.jiekou.Run;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public abstract class Dog extends Animal implements Run, Hobbit {

    @Override
    public void aihao() {
        System.out.println("爱好: 吃肉");
    }

}
