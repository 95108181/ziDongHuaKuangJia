package com.ceshi.controller;

import com.ceshi.entity.TestData;
import com.ceshi.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/testData")
public class TestDataController {

    @Autowired
    TestDataService testDataService;


    /**
     * 测试
     * @throws Exception
     */
    @GetMapping("/test")
    public void SendCode() throws Exception {
        TestData testData = new TestData();
        testData.setCaseName("name");
        testData.setCaseResult("result.toString()");
        testData.setTestAll("String.valueOf(testsPass+testsFail+testsSkip)");
        testData.setTestPass("String.valueOf(testsPass)");
        testData.setTestSkip("String.valueOf(testsSkip)");
        testData.setTestsFail("String.valueOf(testsFail)");
        Boolean status = testDataService.SendCode(testData);
    }

    /**
     * 加载详情界面
     *
     * @return
     */
    @GetMapping("/testDetails")
    public String testDetails() {
        return "module/views/testDetails";
    }

    /**
     * 全部测试用例界面
     *
     * @return
     */
    @GetMapping("/testqueryall")
    public String testqueryall() {
        return "module/views/queryall";
    }


    /**
     * 查询测试用例详情
     *
     * @param testDataId
     * @return
     */
    @RequestMapping(value = "details/{id}", method = RequestMethod.GET)
    public String details(Model model, @PathVariable("id") Integer testDataId) {
        TestData testData = testDataService.details(testDataId.toString());
        model.addAttribute("resultDataDetails", testData.getCaseResult());
        return "module/views/testDetails";
    }

    /**
     * 查询全部测试用例
     *
     * @return
     */
    @RequestMapping("/queryall")
    public String queryall(Model model) {
        model.addAttribute("goodsList", testDataService.queryall());
        return "module/views/queryall";
    }


    /**
     * 执行测试用例
     * @return
     */
    @ResponseBody
    @PostMapping("/function")
    public BaseResult function() {
        Boolean status = testDataService.function();
        if (status) {return BaseResult.Success();} else {return BaseResult.Error("系统繁忙，请稍后再试");}
    }


}
