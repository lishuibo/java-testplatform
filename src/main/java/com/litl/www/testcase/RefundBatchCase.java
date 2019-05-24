package com.litl.www.testcase;

import com.litl.www.base.DriverBase;
import com.litl.www.services.LoginService;
import com.litl.www.services.RefundApplyService;
import com.litl.www.services.RefundBatchService;
import com.litl.www.services.RefundListService;
import com.litl.www.util.DataProviderUtil;
import com.litl.www.util.ProUtil;
import com.litl.www.util.UUIDUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RefundBatchCase extends CaseBase {
    public DriverBase driver;
    private ProUtil proutil;
    private LoginService loginservice;
    private RefundApplyService refundapplyservice;
    private RefundListService refundlistservice;
    private RefundBatchService refundbatchservice;
    private String batchno;


    @BeforeTest
    public void testRefundAduiting() {
        driver = InitDriver("chrome");
        proutil = new ProUtil("src/element.properties");
        loginservice = new LoginService(driver);
        refundapplyservice = new RefundApplyService(driver);
        refundlistservice = new RefundListService(driver);
        refundbatchservice = new RefundBatchService(driver);

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
    public void testLogin(String username,String password)  throws InterruptedException {
        String login_username = username;
        String login_password = password;
        batchno = UUIDUtil.getUUID();
        loginservice.login(login_username, login_password);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            refundapplyservice.refundApply("李天乐","618bda45fb5945d887a7f5887123a1c2");
            refundlistservice.refundList(batchno,"618bda45fb5945d887a7f5887123a1c2");
            refundbatchservice.refundList(batchno);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }

    @DataProvider(name = "testData")
    public static Object[][] getDataProvider() throws SQLException, ClassNotFoundException {
        return DataProviderUtil.getTestData("data_provider");
    }

}
