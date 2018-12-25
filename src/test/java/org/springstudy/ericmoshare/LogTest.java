package org.springstudy.ericmoshare;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
@Slf4j
public class LogTest extends BaseNGTest {

    @Test
    public void testPrint() {

        log.info("hello world");
        System.out.println("hello world");

        log.info("this is {} and {}", "tom", "tony");

    }

}
