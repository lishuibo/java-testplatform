package com.litl.www.handles;

import com.litl.www.base.DriverBase;
import com.litl.www.pages.LoginPage;

public class LoginHandle {
    private DriverBase driver;
    private LoginPage loginpage;
    public LoginHandle(DriverBase driver){
        this.driver = driver;
        loginpage = new LoginPage(driver);
    }

    /**
     * 输入用户名
     * */
    public void sendKeysUserName(String username){
        loginpage.sendkeys(loginpage.getUserNameElement(), username);
    }

    /**
     * 输入密码
     * */
    public void sendKeysPassword(String password){
        loginpage.sendkeys(loginpage.getPasswordElement(), password);
    }
    /**
     * 点击登陆
     * */
    public void clickLoginButton(){
        loginpage.click(loginpage.getLoginButtonElement());
    }
    /**
     * 点击登陆系统
     * */
    public void clickSystem(){
        loginpage.click(loginpage.getSystemElement());
    }

    /**
     * 点击下拉选择登陆系统
     * */
    public void clickSelectLoginSystem(){
        loginpage.click(loginpage.getSelectLoginSystemElement());
    }

    /**
     * 点击下拉选择退出系统
     * */
    public void clickSelectLogoutSystem(){
        loginpage.click(loginpage.getSelectLogoutElement());
    }

    /**
     * 点击退出系统按钮
     * */
    public void clickLogoutButton(){
        loginpage.click(loginpage.getLogoutButtonElement());
    }
}
