package org.springstudy.enums;

import lombok.Getter;

/**
 * 卡类型
 *
 * @author Eric.Mo
 * @since 2019/1/13
 */
public enum CardTypeEnum {
    /**
     * 其他卡
     */
    OTHERS(0, "其他"),

    /**
     * 借记卡
     */
    DEBIT(1, "借记卡"),

    /**
     * 贷记卡
     */
    CREDIT(2, "信用卡"),

    /**
     * 现金钱包
     */
    CASH(3, "现金钱包"),

    /**
     * 借入
     */
    JIE_RU(4, "借入"),

    /**
     * 借出
     */
    JIE_CHU(5, "借出"),

    //
    ;

    @Getter
    private final Integer code;

    @Getter
    private final String msg;

    CardTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CardTypeEnum findByValue(int value) {
        for (CardTypeEnum index : CardTypeEnum.values()) {
            if (index.getCode() == value) {
                return index;
            }
        }
        return null;

    }

}
