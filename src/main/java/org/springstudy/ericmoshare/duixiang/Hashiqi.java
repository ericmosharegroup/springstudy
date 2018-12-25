package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Hashiqi extends Dog {

    @Override
    public void speak() {
        System.out.println("哈士奇 speak: 汪汪汪~");
    }

    @Override
    public void run() {
        System.out.println("哈士奇 跑 28 公里/小时");
    }

    @Override
    public Integer rate() {
        return 28;
    }

    @Override
    public String alias() {
        return "哈士奇";
    }
}
