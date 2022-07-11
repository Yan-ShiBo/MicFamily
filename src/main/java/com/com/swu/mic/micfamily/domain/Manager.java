package com.com.swu.mic.micfamily.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ 作者： 闫士博
 * @ 日期： 2022/6/28 星期二 14:22
 * @ package name： com.com.swu.mic.micfamily.domain
 * @ Project name： MicFamily
 * @ Description：
 */
@TableName("manager")
@Data
public class Manager {
    @TableId("id")
    private Integer id;
    private String userName;

    private String password;
    private Integer permission;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}