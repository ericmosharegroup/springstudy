package org.springstudy.entity;

import lombok.Data;
import org.springstudy.enums.TxTypeEnum;

import java.util.Date;

@Data
public class Dailybill {
    private Long id;

    private String userId;

    private String txDate;

    private Long txAmount;

    private Long drAmount;

    private Long crAmount;

    private Long accountId;

    private TxTypeEnum txType;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String txDetail;

    private String iconId;
}