package org.springstudy.enums;

import lombok.Getter;

/**
 * @author Eric.Mo
 * @since 2019/2/27
 */
public enum TxTypeEnum {
    /**
     * 支出
     */
    Expenditure(0, "支出"),

    /**
     * 收入
     */
    Income(1, "收入"),

    /**
     * 转账
     */
    Transfer(2, "转账");

    @Getter
    private final Integer code;

    @Getter
    private final String msg;

    TxTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static TxTypeEnum findByValue(int value) {
        for (TxTypeEnum index : TxTypeEnum.values()) {
            if (index.getCode() == value) {
                return index;
            }
        }
        return null;

    }

}
