package org.ericmoshare.duixiang.service;

import org.ericmoshare.duixiang.jiekou.Run;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 奔跑比赛
 *
 * @author Eric.Mo
 * @since 2018/12/20
 */
@Service
public class RunRate {

    @Autowired
    private List<Run> runners;

    /**
     * 奔跑比赛
     *
     * @return 倒序
     */
    public List<Run> rateDesc() {
        List<Run> list = new ArrayList<>(runners);
        list.sort(new Comparator<Run>() {

            @Override
            public int compare(Run o1, Run o2) {
                if (o1.rate() < o2.rate()) {
                    return 1;
                }
                return -1;
            }
        });

        return list;
    }

    /**
     * 奔跑比赛
     *
     * @return 顺序
     */
    public List<Run> rateAsc() {
        List<Run> list = new ArrayList<>(runners);
        list.sort(new Comparator<Run>() {

            @Override
            public int compare(Run o1, Run o2) {
                if (o1.rate() < o2.rate()) {
                    return -1;
                }
                return 1;
            }
        });

        return list;
    }
}
