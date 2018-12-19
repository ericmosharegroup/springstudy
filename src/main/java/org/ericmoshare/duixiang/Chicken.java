package org.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Chicken extends Bird {

    @Override
    public void speak() {
        System.out.println("speak: 咕咕咕");
    }

    @Override
    public void fly() {
        System.out.println("fly: 每小时飞 1 公里");
    }
}
