package com.litl.www.services;

import com.litl.www.base.DriverBase;
import com.litl.www.handles.LoginHandle;

import static java.lang.Thread.sleep;

public class LoginService {
    private LoginHandle loginhandle;
    private DriverBase driver;
    public LoginService(DriverBase driver){
        this.driver = driver;
        loginhandle = new LoginHandle(driver);
    }
    public void login(String username,String password) throws InterruptedException {
            loginhandle.sendKeysUserName(username);
            loginhandle.sendKeysPassword(password);
            loginhandle.clickSystem();
            loginhandle.clickSelectLoginSystem();
            loginhandle.clickLoginButton();
            sleep(2000);
            loginhandle.clickSelectLogoutSystem();
            sleep(2000);
            loginhandle.clickLogoutButton();
    }
}
