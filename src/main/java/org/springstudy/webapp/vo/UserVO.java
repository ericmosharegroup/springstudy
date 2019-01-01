package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserVO {

    @NotEmpty(message = "username:必须输入")
    @Length(min = 1, max = 30, message = "username:长度应在{max}位之内")
    private String username;

    @NotEmpty(message = "userMobileNo:必须输入")
    @Length(min = 1, max = 12, message = "userMobileNo:长度应在{max}位之内")
    private String userMobileNo;

    @NotEmpty(message = "userMobileNo:必须输入")
    @Length(min = 1, max = 12, message = "userMobileNo:长度应在{max}位之内")
    private String userEmail;
}