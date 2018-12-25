package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Tiger extends Cat {

    @Override
    public void speak() {
        System.out.println("Tiger speak: 森林大喵~");
    }

    @Override
    public void run() {
        System.out.println("Tiger 跑 25 公里/小时");

    }

    @Override
    public Integer rate() {
        return 25;
    }

    @Override
    public String alias() {
        return "老虎";
    }
}
