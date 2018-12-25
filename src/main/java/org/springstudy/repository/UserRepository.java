package org.springstudy.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springstudy.entity.User;
import org.springstudy.entity.UserExample;

import java.util.List;

@Repository
public interface UserRepository {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}