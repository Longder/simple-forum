package com.longder.forum.entity;

/**
 * 系统用户实体，登陆认证用
 */
public class SysUser extends BaseIdEntity{
    /**
     * 姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;


    public SysUser(String name, String loginName, String password) {
        this.name = name;
        this.loginName = loginName;
        this.password = password;
    }

    public SysUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
