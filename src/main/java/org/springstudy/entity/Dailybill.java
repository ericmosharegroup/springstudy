package org.springstudy.entity;

import lombok.Data;
import org.springstudy.enums.TxTypeEnum;

@Data
public class Dailybill {
    private Long id;

    private String userId;

    private String txYear;

    private String txMonth;

    private String txDate;

    private Long drAmount;

    private Long crAmount;

    private Long accountId;

    private TxTypeEnum txType;

    private String remark;

}