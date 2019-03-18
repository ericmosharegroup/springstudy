package org.springstudy.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springstudy.entity.Dailybill;
import org.springstudy.entity.DailybillExample;
import org.springstudy.entity.DcAmount;
import org.springstudy.utils.page.Pageable;

import java.util.List;

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

    List<Dailybill> selectByPage(@Param("example") DailybillExample example,
                                 @Param("pageable") Pageable pageable);

}