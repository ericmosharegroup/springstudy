package org.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Service
public class Homecat extends Cat {

    @Override
    public void speak() {

        System.out.println("Homecat speak: 富贵~");
    }

    @Override
    public void run() {

        System.out.println("Homecat 跑 10 公里/小时");

    }
}
