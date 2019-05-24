package com.litl.www.services;

import com.litl.www.base.DriverBase;
import com.litl.www.handles.RefundAduitingHandle;

import static java.lang.Thread.sleep;

public class RefundAduitingService {
    private RefundAduitingHandle refundaduitinghandle;
    public DriverBase driver;
    public RefundAduitingService(DriverBase driver){
        this.driver = driver;
        refundaduitinghandle = new RefundAduitingHandle(driver);
    }

    public void refundAduiting(String batchNo) throws InterruptedException {
        refundaduitinghandle.clickItemElements();
        refundaduitinghandle.clickRefundAduitingElement();
        refundaduitinghandle.switchRightIframeElement();
        sleep(2000);
        refundaduitinghandle.sendkeysBatchNoElement(batchNo);
        refundaduitinghandle.clickSearchbuttonElement();
        refundaduitinghandle.clickHeaderChechBoxElement();
        refundaduitinghandle.clickWaitfundElement();
        driver.switchDefaultIframe();
        refundaduitinghandle.clickWaitfundAlertDismissElement();
    }

}
