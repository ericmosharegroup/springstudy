package org.springstudy.entity;

import lombok.Data;
import org.springstudy.enums.AccountTypeEnum;

import java.util.Date;

@Data
public class Account {
    private Long id;

    private String accountName;

    private Long balance;

    private AccountTypeEnum accountType;

    private String remark;

    private String remark2;

    private Date createTime;

    private Date updateTime;
}