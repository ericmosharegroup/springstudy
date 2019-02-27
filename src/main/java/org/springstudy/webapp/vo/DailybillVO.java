package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class DailybillVO {

    private String tx_year;

    private String tx_month;

    private String tx_date;

    private Long dr_amount;

    private Long cr_amount;

    private Long account_id;

    private String tx_type;

    private String remark;

    private String userId;
}