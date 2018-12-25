package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Lion extends Cat {

    @Override
    public void speak() {
        System.out.println("Lion speak: 草原大喵~");
    }

    @Override
    public void run() {
        System.out.println("Lion 跑 30 公里/小时");

    }

    @Override
    public Integer rate() {
        return 30;
    }

    @Override
    public String alias() {
        return "狮子";
    }
}
