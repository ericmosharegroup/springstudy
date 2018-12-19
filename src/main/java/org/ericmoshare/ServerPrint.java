package org.ericmoshare;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class ServerPrint {

    @Getter
    @Setter
    private String appName;

    @Getter
    @Setter
    private String username;

    public void print() {
        System.out.println("print appName:" + appName);
        System.out.println("print username:" + username);

    }

}
