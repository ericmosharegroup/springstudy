package org.springstudy.utils;

import java.math.BigDecimal;

/**
 * @author Eric.Mo
 * @since 2019/1/21
 */
public class MoneyUtils {

    public static String fenToYuan(Long fen) {
        return new BigDecimal(fen).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_DOWN).toString();
    }
}
