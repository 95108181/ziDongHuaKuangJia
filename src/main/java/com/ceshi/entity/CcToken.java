package com.ceshi.entity;

import java.util.Date;

public class CcToken {
    /**
    * id主键
    */
    private Integer id;

    /**
     * 系统token用户id
     */
    private String userIdToken;

    /**
    * 系统token
    */
    private String token;

    /**
     * 视频id
     */
    private String videoId;

    /**
    * 系统代码
    */
    private String systemCode;

    /**
    * 创建时间
    */
    private Date creationTime;

    /**
    * 是否删除
    */
    private String delete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIdToken() {
        return userIdToken;
    }

    public void setUserIdToken(String userIdToken) {
        this.userIdToken = userIdToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}