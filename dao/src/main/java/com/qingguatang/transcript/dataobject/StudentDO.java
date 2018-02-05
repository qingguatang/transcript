package com.qingguatang.transcript.dataobject;

import java.util.Date;

public class StudentDO {
    /**主键*/
    private String id;

    /**名称*/
    private String name;

    /**性别：male男性，female女性*/
    private String gender;

    /**创建时间*/
    private Date gmtCreated;

    /**修改时间*/
    private Date gmtModified;

    /**获取主键*/
    public String getId() {
        return id;
    }

    /**设置主键*/
    public void setId(String id) {
        this.id = id;
    }

    /**获取名称*/
    public String getName() {
        return name;
    }

    /**设置名称*/
    public void setName(String name) {
        this.name = name;
    }

    /**获取性别：male男性，female女性*/
    public String getGender() {
        return gender;
    }

    /**设置性别：male男性，female女性*/
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**获取创建时间*/
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**设置创建时间*/
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**获取修改时间*/
    public Date getGmtModified() {
        return gmtModified;
    }

    /**设置修改时间*/
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}