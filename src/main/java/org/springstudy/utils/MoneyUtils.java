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

    public static Long yuanToFen(String yuan) {
        if (yuan == null) {
            return 0L;
        }
        return Long.valueOf(new BigDecimal(yuan).multiply(new BigDecimal(100)).setScale(0, BigDecimal.ROUND_DOWN).toString());
    }
}
