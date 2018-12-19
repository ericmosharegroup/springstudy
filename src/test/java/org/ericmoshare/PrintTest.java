package org.ericmoshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author Eric.Mo
 * @since 2018/12/19
 */
public class PrintTest extends BaseNGTest {

    //自动注入
    @Autowired
    private ServerPrint serverPrint;

    @Test
    public void testPrint() {
        serverPrint.print();
    }
}
