package org.springstudy.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springstudy.entity.Dailybill;
import org.springstudy.entity.DailybillExample;
import org.springstudy.entity.DcAmount;

@Repository
public interface DailybillRepository {
    int countByExample(DailybillExample example);

    int deleteByExample(DailybillExample example);

    int insert(Dailybill record);

    int insertSelective(Dailybill record);

    List<Dailybill> selectByExample(DailybillExample example);

    int updateByExampleSelective(@Param("record") Dailybill record, @Param("example") DailybillExample example);

    int updateByExample(@Param("record") Dailybill record, @Param("example") DailybillExample example);

    DcAmount sumByExample(DailybillExample example);
}