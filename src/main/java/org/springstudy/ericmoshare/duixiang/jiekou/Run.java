package org.springstudy.ericmoshare.duixiang.jiekou;

/**
 * 行为: 飞
 *
 * @author Eric.Mo
 * @since 2018/12/19
 */
public interface Run extends Alias {

    void run();

    /**
     * 奔跑速度
     *
     * @return 速度, 公里/小时. 例如 60公里/小时
     */
    Integer rate();

}
