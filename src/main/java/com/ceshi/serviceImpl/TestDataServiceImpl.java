package com.ceshi.serviceImpl;

import com.ceshi.Application;
import com.ceshi.dao.TestDataDao;
import com.ceshi.entity.TestData;
import com.ceshi.service.TestDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.TestngRun;

import java.util.List;

@Service("TestDataService")
class TestDataServiceImpl implements TestDataService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    TestDataDao testDataDao;

    @Override
    public Boolean SendCode(TestData testData) throws Exception {
        testDataDao.SendCode();
        testDataDao.insert(testData);
        return null;
    }

    /**
     * 查询测试用例详情
     *
     * @param testDataId
     * @return
     */
    @Override
    public TestData details(String testDataId) {
        TestData testData = testDataDao.details(Integer.parseInt(testDataId));
        logger.info("打印查询测试用例详情结果：" + testData);
        return testData;
    }

    /**
     * 查询全部测试用例
     *
     * @return
     */
    @Override
    public List<TestData> queryall() {
        List<TestData> testDataList = testDataDao.queryall();
        logger.info("打印查询全部测试用例结果数：" + testDataList.size());
        logger.info("打印查询全部测试用例结果：" + testDataList.toString());
        return testDataList;
    }


    /**
     * 执行测试用例
     * @return
     */
    @Override
    public Boolean function() {
        try {
            TestngRun.run();
            logger.info("执行测试任务");
            return true;
        }catch (Exception e){return false;}
    }


}
