package org.springstudy.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;

    private String username;

    private String userMobileNo;

    private String userEmail;

    private String remark;

    private String remark2;

    private Date createTime;

    private Date updateTime;

}