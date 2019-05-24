package com.litl.www.handles;

import com.litl.www.base.DriverBase;
import com.litl.www.pages.RefundBatchPage;
import com.litl.www.pages.RefundListPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundBatchHandle {
    private DriverBase driver;
    private RefundBatchPage refundbatchpage;
    public RefundBatchHandle(DriverBase driver){
        this.driver = driver;
        refundbatchpage = new RefundBatchPage(driver);
    }

    /**
     * 点击fmis平台左侧页面的导航栏elements
     * */
    public void clickItemElements() {
        List<WebElement> elements = refundbatchpage.getItemElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款管理")) {
                element.click();
            }
        }
    }

    /**
     * 获取退款批次按钮element
     * */
    public void clickRefundBatchElements() {
        List<WebElement> elements = refundbatchpage.getRefundBatchElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款批次")) {
                element.click();
            }
        }
    }
    /**
     * 切换右侧页面的iframe
     * */
    public  void switchRightIframeElement(){
        WebElement rightIframeElement = refundbatchpage.getRightIframeElement();
        driver.switchIframe(rightIframeElement);
    }
    /**
     * 输入批次号
     * */
    public void sendkeysBatchNosElement(String batchno){
        refundbatchpage.sendkeys(refundbatchpage.getBatchNoElement(),batchno);
    }

    /**
     * 点击查询按钮
     * */
    public void clickSearchbuttonElement(){
        refundbatchpage.click(refundbatchpage.getSearchbuttonElement());
    }

    /**
     * 点击提交批次号
     * */
    public void clickRefundListAuditBatchElement(){
        refundbatchpage.click(refundbatchpage.getRefundListAuditBatchElement());
        driver.switchDefaultIframe();
    }

    /**
     *点击提交批次号页面的确认按钮
     * */

    public void clickRefundListAuditBatchConfirmElement(){
        refundbatchpage.click(refundbatchpage.getRefundListAuditBatchConfirmElement());
    }

}
