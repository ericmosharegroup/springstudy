/*
* Copyright (c) 2008-2016 vip.com, All Rights Reserved.
*
* Powered by com.vip.osp.osp-idlc-2.6.14.
*
*/

package org.springstudy.utils.page;

/**
 * <p>分页信息
 */
public class Pageable implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * <p>每页记录数
     */
    private Integer pageSize = 0;

    /**
     * <p>当前页数
     */
    private Integer pageNumber = 0;

    /**
     * <p>总条数
     */
    private Long count;

    /**
     * <p>总页数
     */
    private Integer totalPage;

    /**
     * <p>排序
     */
    private Sort sort;

    /**
     * <p>当前limit最小值
     */
    private Integer offset;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pageable{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append(", count=").append(count);
        sb.append(", totalPage=").append(totalPage);
        sb.append(", sort=").append(sort);
        sb.append(", offset=").append(offset);
        sb.append('}');
        return sb.toString();
    }
}