package org.springstudy.utils.page;

/**
 * <p>排序方式
 */
public enum Direction {

    /**
     * <p>升序
     */
    ASC(0),

    /**
     * <p>降序
     */
    DESC(1);

    private final int value;

    private Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Direction findByValue(int value) {

        for (Direction keyType : Direction.values()) {
            if (keyType.getValue() == value) {
                return keyType;
            }
        }
        return null;

    }
}