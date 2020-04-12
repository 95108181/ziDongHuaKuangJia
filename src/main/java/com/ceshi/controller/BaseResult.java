package com.ceshi.controller;


/**
 * Created by 12451 on 2017/7/3.
 */
public class BaseResult {

  private boolean IsSucceed = false;
  private Integer ErrorCode = 0;
  private String ErrorMessage = "";
  private Object Data = null;
  private Integer TotalCount = 0;


  /**
   * 成功
   */
  public static BaseResult Success() {
    BaseResult result = new BaseResult(true, "");
    result.IsSucceed = true;
    return result;
  }

  /**
   * 有返回值的成功
   */
  public static BaseResult Success(Object data) {
    BaseResult result = new BaseResult(true, data);
    result.IsSucceed = true;
    return result;
  }

  /**
   * 有返回值和分页的成功
   */
  public static BaseResult Success(Object data, Integer totalCount) {
    BaseResult result = new BaseResult(true, data, totalCount);
    result.IsSucceed = true;
    return result;
  }

  /**
   * 失败
   */
  public static BaseResult Error(Integer errorCode, String errorMessage) {
    BaseResult result = new BaseResult(false, errorCode, errorMessage);
    result.IsSucceed = false;
    return result;
  }

  public static BaseResult Error(String errorMessage) {
    BaseResult result = new BaseResult(false, 0, errorMessage);
    result.IsSucceed = false;
    return result;
  }

  public BaseResult(boolean isSucceed, Object data) {
    IsSucceed = isSucceed;
    Data = data;
  }

  public BaseResult(boolean isSucceed, Object data, Integer totalCount) {
    IsSucceed = isSucceed;
    Data = data;
    TotalCount = totalCount;
  }

  public BaseResult(boolean isSucceed, Integer errorCode, String errorMessage) {
    IsSucceed = isSucceed;
    ErrorCode = errorCode;
    ErrorMessage = errorMessage;
  }

  public BaseResult(boolean IsSucceed, String msg) {
    this.IsSucceed = IsSucceed;
    this.ErrorMessage = msg;
  }

  public BaseResult(boolean IsSucceed) {
    this.IsSucceed = IsSucceed;
  }

  public boolean isSucceed() {
    return IsSucceed;
  }

  public void setSucceed(boolean succeed) {
    this.IsSucceed = succeed;
  }

  public Object getData() {
    return Data;
  }

  public void setData(Object data) {
    this.Data = data;
  }

  public Integer getTotalCount() {
    return TotalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.TotalCount = totalCount;
  }

  public Integer getErrorCode() {
    return ErrorCode;
  }

  public void setErrorCode(Integer errorCode) {
    ErrorCode = errorCode;
  }

  public String getErrorMessage() {
    return ErrorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    ErrorMessage = errorMessage;
  }
}
