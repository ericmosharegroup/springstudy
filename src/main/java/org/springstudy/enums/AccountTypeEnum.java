package org.springstudy.enums;

import lombok.Getter;

/**
 * @author Eric.Mo
 * @since 2019/1/13
 */
public enum AccountTypeEnum {
    /**
     * 资金账户
     */
    Fund(0, "资金账户"),

    /**
     * 应收账户
     */
    Receivable(1, "应收账户"),

    /**
     * 应付账户
     */
    Payable(2, "应付账户");

    @Getter
    private final Integer code;

    @Getter
    private final String msg;

    AccountTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AccountTypeEnum findByValue(int value) {
        for (AccountTypeEnum index : AccountTypeEnum.values()) {
            if (index.getCode() == value) {
                return index;
            }
        }
        return null;

    }

}
