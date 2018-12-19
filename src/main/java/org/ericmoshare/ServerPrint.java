package org.ericmoshare;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
@Service
public class ServerPrint {

    @Getter
    @Setter
    private String appName;

    public void print() {
        System.out.println("print appName:" + appName);
    }

}
