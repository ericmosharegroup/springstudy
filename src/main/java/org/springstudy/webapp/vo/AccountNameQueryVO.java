package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AccountNameQueryVO {

    @NotEmpty(message = "userId:必须输入")
    @Length(min = 1, max = 12, message = "userId:长度应在{max}位之内")
    private String userId;

}