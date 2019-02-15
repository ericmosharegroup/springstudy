package org.springstudy.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springstudy.entity.Monthbill;
import org.springstudy.entity.MonthbillExample;

@Repository
public interface MonthbillRepository {
    int countByExample(MonthbillExample example);

    int deleteByExample(MonthbillExample example);

    int insert(Monthbill record);

    int insertSelective(Monthbill record);

    List<Monthbill> selectByExample(MonthbillExample example);

    int updateByExampleSelective(@Param("record") Monthbill record, @Param("example") MonthbillExample example);

    int updateByExample(@Param("record") Monthbill record, @Param("example") MonthbillExample example);
}