package org.springstudy;

/**
 * 枚举
 *
 * @author Eric.Mo
 * @since 2019/1/6
 */
public enum MessageCode {
    success("200", "success");

    String code;
    String msg;

    MessageCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
