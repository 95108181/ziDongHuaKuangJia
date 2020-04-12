package com.ceshi.dao;

import com.ceshi.entity.CcToken;

public interface CcTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CcToken record);

    int insertSelective(CcToken record);

    CcToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CcToken record);

    int updateByPrimaryKey(CcToken record);
}