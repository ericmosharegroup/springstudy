package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springstudy.enums.TxTypeEnum;

import javax.validation.constraints.NotNull;

@Data
public class DailybillVO {

    private String userId;

    private String txDate;

    private String txAmount;

    private Long accountId;

    private String txType;

    private String remark;

    private String txDetail;

    private String iconId;

}