package com.ceshi.entity;

import java.util.Date;

public class TestData {
    /**
    * id
    */
    private Integer id;

    /**
    * 用例通过
    */
    private String testPass;

    /**
    * 用例跳过
    */
    private String testSkip;

    /**
    * 用例总数
    */
    private String testAll;

    /**
    * 用例跳过
    */
    private String testsFail;

    /**
    * 开始时间
    */
    private String startTime;

    /**
    * 运行时间
    */
    private String runningTime;

    /**
    * 用例名称
    */
    private String caseName;

    /**
    * 用例结果
    */
    private String caseResult;

    /**
    * 创建时间
    */
    private String creationTime;

    /**
    * 修改时间
    */
    private String modificationTime;

    /**
    * 是否删除
    */
    private String isItDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestPass() {
        return testPass;
    }

    public void setTestPass(String testPass) {
        this.testPass = testPass;
    }

    public String getTestSkip() {
        return testSkip;
    }

    public void setTestSkip(String testSkip) {
        this.testSkip = testSkip;
    }

    public String getTestAll() {
        return testAll;
    }

    public void setTestAll(String testAll) {
        this.testAll = testAll;
    }

    public String getTestsFail() {
        return testsFail;
    }

    public void setTestsFail(String testsFail) {
        this.testsFail = testsFail;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getIsItDeleted() {
        return isItDeleted;
    }

    public void setIsItDeleted(String isItDeleted) {
        this.isItDeleted = isItDeleted;
    }
}