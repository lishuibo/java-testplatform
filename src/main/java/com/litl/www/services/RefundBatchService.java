package com.litl.www.services;

import com.litl.www.base.DriverBase;
import com.litl.www.handles.RefundBatchHandle;
import com.litl.www.handles.RefundListHandle;
import com.litl.www.pages.RefundBatchPage;

import static java.lang.Thread.sleep;

public class RefundBatchService {
    private RefundBatchHandle refundpagehandle;
    public DriverBase driver;
    public RefundBatchService(DriverBase driver){
        this.driver = driver;
        refundpagehandle = new RefundBatchHandle(driver);
    }

    public void refundList(String batchno) throws InterruptedException {
        driver.switchDefaultIframe();
        refundpagehandle.clickRefundBatchElements();
        refundpagehandle.switchRightIframeElement();
        sleep(2000);
        refundpagehandle.sendkeysBatchNosElement(batchno);
        refundpagehandle.clickSearchbuttonElement();
        driver.implicitlyWait(10);
        refundpagehandle.clickRefundListAuditBatchElement();
        refundpagehandle.clickRefundListAuditBatchConfirmElement();
    }

}
