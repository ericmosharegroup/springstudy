package org.springstudy.entity;

import lombok.Data;

@Data
public class Monthbill {
    private Long id;

    private String userId;

    private Long drAmount;

    private Long crAmount;

    private Long balance;

    private Long accountId;

    private String txMonth;

    private String startDate;

    private String endDate;


}