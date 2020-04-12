package com.ceshi.dao;

import com.ceshi.entity.User;
import io.lettuce.core.dynamic.annotation.Param;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUsers(@Param("userName")String userName);
}