package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class AccountVO {

    @NotEmpty(message = "accountName:必须输入")
    @Length(min = 1, max = 30, message = "accountName:长度应在{max}位之内")
    private String accountName;

    @NotNull(message = "balance:必须输入")
    private Long balance;

    @NotEmpty(message = "accountType:必须输入")
    @Length(min = 1, max = 12, message = "accountType:长度应在{max}位之内")
    private String accountType;

    private String remark;

    @NotEmpty(message = "cardType:必须输入")
    @Length(min = 1, max = 12, message = "cardType:长度应在{max}位之内")
    private String cardType;

    @NotEmpty(message = "userId:必须输入")
    @Length(min = 1, max = 12, message = "userId:长度应在{max}位之内")
    private String userId;
}