package com.ceshi.dao;

import com.ceshi.entity.TestData;
import io.lettuce.core.dynamic.annotation.Param;

import java.math.BigInteger;
import java.util.List;

public interface TestDataDao {

    void SendCode();

    int insert(TestData record);

    TestData details(@Param("testDataId") int testDataId);

    List<TestData> queryall();

    void deleteCase(@Param("id") int id);
}
