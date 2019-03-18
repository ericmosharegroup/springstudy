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

/**
 * @author Jeff.Chen
 */
@Data
public class PageableReqVO<T> implements Serializable {

    @Valid
    T data;

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

    /**
     * 排序方式
     */
    @Pattern(regexp = "^(DESC|ASC)$", message = "排序方式填写错误")
    private String direction;

//    /**
//     * 排序列
//     */
//    private String column;

    public Pageable getPageable() {
        Pageable pageable = new Pageable();
        pageable.setPageNumber(Math.max(Integer.valueOf(pageNumber) - 1, 0));
        pageable.setPageSize(Integer.valueOf(pageSize));

        Order order = new Order();
        order.setProperty("create_time");
        order.setDirection(Direction.DESC);

        if (StringUtils.isNotEmpty(direction)) {
            order.setDirection(Direction.valueOf(this.direction));
        }

        Sort sort = new Sort();

        pageable.setSort(sort);
        pageable.setOffset(0);
        return pageable;
    }

}
