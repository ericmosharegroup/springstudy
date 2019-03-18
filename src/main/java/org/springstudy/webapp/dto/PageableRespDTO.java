package org.springstudy.webapp.dto;

import lombok.Data;
import org.springstudy.utils.page.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class PageableRespDTO<T> implements Serializable {

    private List<T> results;

    /**
     * 当前页码
     */
    private Integer pageNumber;

    /**
     * 每页数据量
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Long count;

    /**
     * 总页数
     */
    private Integer totalPage;

    private Map<String, String> ext;

    public PageableRespDTO() {
        this.pageNumber = 0;
        this.pageSize = 0;
        this.count = 0L;
        this.totalPage = 0;
        this.results = null;
        this.ext = null;
    }

    public PageableRespDTO(Pageable pageable) {
        this.pageNumber = pageable.getPageNumber() + 1;
        this.pageSize = pageable.getPageSize();
        this.count = pageable.getCount();
        this.totalPage = pageable.getTotalPage();
        this.results = null;
    }

}