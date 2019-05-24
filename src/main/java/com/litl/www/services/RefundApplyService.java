package com.litl.www.services;

import com.litl.www.base.DriverBase;
import com.litl.www.handles.RefundAduitingHandle;
import com.litl.www.handles.RefundApplyHandle;

import static java.lang.Thread.sleep;

public class RefundApplyService {
    private RefundApplyHandle refundapplyhandle;
    public DriverBase driver;
    public RefundApplyService(DriverBase driver){
        this.driver = driver;
        refundapplyhandle = new RefundApplyHandle(driver);
    }

    public void refundApply(String userNames,String requestNos) throws InterruptedException {
        refundapplyhandle.clickItemElements();
        refundapplyhandle.clickRefundAduitingElements();
        refundapplyhandle.switchRightIframeElement();
        sleep(2000);
        refundapplyhandle.sendkeysUserNamesElement(userNames);
        refundapplyhandle.sendkeysRequesNosElement(requestNos);
        refundapplyhandle.clickSearchbuttonElement();
        driver.implicitlyWait(10);
        refundapplyhandle.clickHeaderChechBoxElement();
        sleep(2000);
        refundapplyhandle.clickRefundElement();
        refundapplyhandle.clickRefundAlertConfirmElement();
    }

}
