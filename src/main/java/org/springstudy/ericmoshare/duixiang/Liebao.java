package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Liebao extends Cat {

    @Override
    public void speak() {
        System.out.println("猎豹 speak: 草原猎豹~");
    }

    @Override
    public void run() {
        System.out.println("猎豹 跑 60 公里/小时");
    }

    @Override
    public Integer rate() {
        return 60;
    }

    @Override
    public String alias() {
        return "猎豹";
    }
}
