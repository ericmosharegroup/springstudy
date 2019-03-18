package org.springstudy.utils.page;

/**
 * <p>排序信息
 * <p>排序信息
 */
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Direction direction;
    private String property;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("direction=").append(direction);
        sb.append(", property='").append(property).append('\'');
        sb.append('}');
        return sb.toString();
    }
}