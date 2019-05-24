package com.litl.www.testcase;

import com.litl.www.base.DriverBase;
import com.litl.www.services.LoginService;
import com.litl.www.util.DataProviderUtil;
import com.litl.www.util.ProUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class LoginCase extends CaseBase {
    public DriverBase driver;
    private ProUtil proutil;
    private LoginService loginservice;


    @BeforeTest
    public void testLoginHome() {
        driver = InitDriver("chrome");
        proutil = new ProUtil("src/element.properties");
        loginservice = new LoginService(driver);

        driver.implicitlyWait(10);
        driver.get(proutil.getPro("url"));
        driver.getMaxSize();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "testData")
    public void testLogin(String username,String password) throws InterruptedException, SQLException {
        String login_username = username;
        String login_password = password;
        loginservice.login(login_username, login_password);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        DataProviderUtil.insertResult("data_provider_result",this.getClass().getSimpleName(),"true");

    }

    @AfterTest
    public void quitBrowser() {
        driver.takeScreenShot();
        driver.quit();
    }

    @DataProvider(name = "testData")
    public static Object[][] getDataProvider() throws SQLException, ClassNotFoundException {
        return DataProviderUtil.getTestData("data_provider");
    }


}
