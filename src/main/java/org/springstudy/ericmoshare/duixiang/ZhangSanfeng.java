package org.springstudy.ericmoshare.duixiang;

import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2019/1/8
 */
@Service
public class ZhangSanfeng implements Zhang {
    @Override
    public String name() {
        return "ZhangSanfeng";
    }
}
