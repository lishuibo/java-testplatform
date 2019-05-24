package com.litl.www.pages;

import com.litl.www.base.DriverBase;
import com.litl.www.util.getByLocator;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取用户名输入框
     * */
    public WebElement getUserNameElement(){
        return element(getByLocator.getByLocator("username"));
    }

    /**
     * 获取密码输入框Element
     * */
    public WebElement getPasswordElement(){
        return element(getByLocator.getByLocator("userpassword"));
    }
    /**
     * 获取登陆按钮element
     * */
    public WebElement getLoginButtonElement(){
        return element(getByLocator.getByLocator("loginbutton"));
    }
    /**
     * 登陆系统
     * */
    public WebElement getSystemElement(){
        return element(getByLocator.getByLocator("loginsystem"));
    }

    /**
     * 下拉选择登陆系统
     * */
    public WebElement getSelectLoginSystemElement(){
        return element(getByLocator.getByLocator("selectloginsystem"));
    }


    /**
     * 下拉选择退出系统
     * */
    public WebElement getSelectLogoutElement(){
        return element(getByLocator.getByLocator("selectlogout"));
    }

    /**
     * 退出系统
     * */
    public WebElement getLogoutButtonElement(){
        return element(getByLocator.getByLocator("logoutbutton"));
    }
}
