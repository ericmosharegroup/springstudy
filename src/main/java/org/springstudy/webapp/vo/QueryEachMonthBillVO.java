
package org.springstudy.webapp.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springstudy.webapp.dto.PageableReqVO;

/**
 * 查询每月账单
 */
@Data
public class QueryEachMonthBillVO extends PageableReqVO{

    @NotEmpty(message = "userId:必须输入")
    @Length(min = 1, max = 12, message = "userId:长度应在{max}位之内")
    private String userId;

    /**
     * 账户id
     */
    @NotEmpty(message = "accountId:必须输入")
    @Length(min = 1, max = 12, message = "accountId:长度应在{max}位之内")
    private String accountId;

    /**
     * 月份
     */
    @NotEmpty(message = "txMonth:必须输入")
    @Length(min = 1, max = 12, message = "txMonth:长度应在{max}位之内")
    private String txMonth;

}