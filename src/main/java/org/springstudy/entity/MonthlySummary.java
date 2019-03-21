package org.springstudy.entity;

import lombok.Data;

/**
 * 每月流水汇总
 * Created by sheng on 2019/3/6.
 */
@Data
public class MonthlySummary {
    private String txMonth;
    private Long drAmount;
    private Long crAmount;
}
