package org.springstudy.webapp.dto;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springstudy.utils.page.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jeff.Chen
 */
@Data
public class PageableReqVO implements Serializable {

    /**
     * 页码
     */
    @org.hibernate.validator.constraints.NotEmpty(message = "pageNumber必须输入")
    @Digits(message = "页码不正确", fraction = 0, integer = 8)
    @Min(value = 0L, message = "pageNumber必须大于等于{value}")
    private String pageNumber;

    /**
     * 每页数据量
     */
    @org.hibernate.validator.constraints.NotEmpty(message = "pageSize必须输入")
    @Digits(message = "每页数据量不正确", fraction = 0, integer = 8)
    @Min(value = 1L, message = "pageSize必须大于等于{value}")
    private String pageSize;


    public Pageable getPageable() {
        Pageable pageable = new Pageable();
        pageable.setPageNumber(Math.max(Integer.valueOf(pageNumber) - 1, 0));
        pageable.setPageSize(Integer.valueOf(pageSize));

        Order order = new Order();
        order.setProperty("tx_date");
        order.setDirection(Direction.DESC);

        Sort sort = new Sort();
        //数组转成list

  //      List<Order> list = new ArrayList<>();
    //    list.add(order);

        sort.setOrders(Arrays.asList(order));

        pageable.setSort(sort);
        pageable.setOffset(pageable.getPageNumber() * pageable.getPageSize());
        return pageable;
    }

}
