package com.ceshi.service;

import com.ceshi.controller.BaseResult;
import com.ceshi.entity.TestData;

import java.util.List;

/**
 *
 */
public interface TestDataService {

    Boolean SendCode(TestData testData) throws Exception;

    /**
     * 查询测试用例详情
     *
     * @param testDataId
     * @return
     */
    TestData details(String testDataId);

    /**
     * 查询全部测试用例
     *
     * @return
     */
    List<TestData> queryall();

    /**
     * 执行测试用例
     * @return
     */
    Boolean function();

    /**
     * 删除测试用例
     * @param id
     * @return
     */
    Boolean deleteCase(String[] id);


}
