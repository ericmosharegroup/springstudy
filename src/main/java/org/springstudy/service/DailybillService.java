package org.springstudy.service;

import org.springstudy.entity.Dailybill;
import org.springstudy.webapp.vo.DailybillVO;

/**
 * Created by sheng on 2019/3/5.
 */
public interface DailybillService {

    /**
     * 添加账单流水
     *
     * @param vo
     * @return 结果
     */
    Dailybill addBill(DailybillVO vo);


    /**
     * 重新计算账户借,贷余额
     *
     * @param userId
     * @param accountId
     */
    void recalculateAccountDcAmount(String userId, Long accountId);
}
