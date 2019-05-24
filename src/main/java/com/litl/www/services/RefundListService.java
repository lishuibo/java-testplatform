package com.litl.www.services;

import com.litl.www.base.DriverBase;
import com.litl.www.handles.RefundApplyHandle;
import com.litl.www.handles.RefundListHandle;

import static java.lang.Thread.sleep;

public class RefundListService {
    private RefundListHandle refundlisthandle;
    public DriverBase driver;
    public RefundListService(DriverBase driver){
        this.driver = driver;
        refundlisthandle = new RefundListHandle(driver);
    }

    public void refundList(String batchno,String requestNos) throws InterruptedException {
        driver.switchDefaultIframe();
        refundlisthandle.clickRefundListElements();
        refundlisthandle.switchRightIframeElement();
        sleep(2000);
        refundlisthandle.sendkeysRequestNosElement(requestNos);
        refundlisthandle.clickSearchbuttonElement();
        driver.implicitlyWait(10);
        refundlisthandle.clickHeaderChechBoxElement();
        refundlisthandle.clickAddBatchBtnElement();
        driver.implicitlyWait(10);
        refundlisthandle.switchAddBatchIframeElement();
        refundlisthandle.sendkeysBatchNoElement(batchno);
        refundlisthandle.clickAddBatchNoElement();
    }

}
