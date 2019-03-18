

package org.springstudy.utils.page;

import java.util.List;

/**
 * <p>排序信息
 * <p>排序信息
 */
public class Sort implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * <p>排序
     */
    private List<Order> orders;

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> value) {
        this.orders = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sort{");
        sb.append("orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}