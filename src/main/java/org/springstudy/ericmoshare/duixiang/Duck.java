package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Duck extends Bird {

    @Override
    public void speak() {
        System.out.println("speak: 呱呱呱");
    }

    @Override
    public void fly() {
        System.out.println("fly: 每小时飞 2 公里");
    }

    @Override
    public String alias() {
        return "鸭子";
    }
}
