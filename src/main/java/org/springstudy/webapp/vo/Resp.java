package org.springstudy.webapp.vo;

import lombok.Data;
import org.springstudy.MessageCode;

/**
 * @author Eric.Mo
 * @since 2019/1/6
 */
@Data
public class Resp {

    private String code;
    private String msg;
    private Object data;

    public Resp(){

    }

    public Resp(MessageCode messageCode){
        this.code = messageCode.getCode();
        this.msg = messageCode.getMsg();
        this.data = null;
    }

    public Resp(MessageCode messageCode, Object data){
        this.code = messageCode.getCode();
        this.msg = messageCode.getMsg();
        this.data = data;
    }
}
