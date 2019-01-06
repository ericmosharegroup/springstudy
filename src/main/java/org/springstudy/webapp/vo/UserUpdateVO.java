package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateVO {

    @NotNull(message = "id:必须输入")
    private Long id;

    @Length(min = 0, max = 30, message = "username:长度应在{max}位之内")
    private String username;

    @Length(min = 0, max = 12, message = "userMobileNo:长度应在{max}位之内")
    private String userMobileNo;

    @Length(min = 0, max = 12, message = "userEmail:长度应在{max}位之内")
    private String userEmail;


    private String remark;
    private String remark2;
}