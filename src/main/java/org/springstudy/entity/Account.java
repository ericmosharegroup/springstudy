package org.springstudy.entity;

import lombok.Data;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;

import java.util.Date;

@Data
public class Account {
    private Long id;

    private String userId;

    private Long drAmount;

    private Long crAmount;

    private Long balance;

    private CardTypeEnum cardType;

    private String accountName;

    private AccountTypeEnum accountType;

    private String remark;

    private Date createTime;

    private Date updateTime;

}