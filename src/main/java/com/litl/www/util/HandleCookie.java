package com.litl.www.util;

import com.litl.www.base.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class HandleCookie {
    public DriverBase driver;
    public ProUtil pro;

    public HandleCookie(DriverBase driver) {
        this.driver = driver;
        this.pro = new ProUtil("src/cookie.properties");
    }

//JSESSIONID=01B86873DE28A1FB0DD416D2C30C36AA
    public void setCookie() {
        String value = pro.getPro("JSESSIONID");
        Cookie cookie = new Cookie("JSESSIONID", value, "fat01-common-fmis.zykj.com", "/", null);
        driver.addCookie(cookie);
    }

    public void writeCookie() {
        Set<Cookie> cookies = driver.getCookie();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                pro.writePro(cookie.getName(), cookie.getValue());
            }
        }

    }
}
