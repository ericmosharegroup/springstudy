package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Jinmao extends Dog {

    @Override
    public void speak() {
        System.out.println("金毛 speak: 汪汪汪~");
    }

    @Override
    public void run() {
        System.out.println("金毛 跑 28 公里/小时");
    }

    @Override
    public Integer rate() {
        return 26;
    }

    @Override
    public String alias() {
        return "金毛";
    }
}
