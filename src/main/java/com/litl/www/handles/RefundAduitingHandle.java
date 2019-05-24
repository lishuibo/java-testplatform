package com.litl.www.handles;

import com.litl.www.base.DriverBase;
import com.litl.www.pages.RefundAduitingPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundAduitingHandle {
    private DriverBase driver;
    private RefundAduitingPage refundaduitingPage;
    public RefundAduitingHandle(DriverBase driver){
        this.driver = driver;
        refundaduitingPage = new RefundAduitingPage(driver);
    }

    /**
     * 点击fmis平台左侧页面的导航栏elements
     * */
    public void clickItemElements() {
        List<WebElement> elements = refundaduitingPage.getItemElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款审核")) {
                element.click();
            }
        }
    }

    /**
     * 获取退款审核按钮element
     * */
    public void clickRefundAduitingElement() {
        refundaduitingPage.click(refundaduitingPage.getRefundAduitingElement());
    }
    /**
     * 切换右侧页面的iframe
     * */
    public  void switchRightIframeElement(){
        WebElement rightIframeElement = refundaduitingPage.getRightIframeElement();
        driver.switchIframe(rightIframeElement);
    }
    /**
     * 输入批次号
     * */
    public void sendkeysBatchNoElement(String batchNo){
        refundaduitingPage.sendkeys(refundaduitingPage.getBatchNoElement(),batchNo);
    }

    /**
     * 点击查询按钮
     * */
    public void clickSearchbuttonElement(){
        refundaduitingPage.click(refundaduitingPage.getSearchbuttonElement());
    }

    /**
     * 点击第一个单选框按钮 勾选下面所有的记录
     * */
    public void clickHeaderChechBoxElement(){
        refundaduitingPage.click(refundaduitingPage.getHeaderChechBoxElement());
    }

    /**
     *点击代付按钮
     * */

    public void clickWaitfundElement(){
        refundaduitingPage.click(refundaduitingPage.getWaitfundElement());
    }

    /**
     *点击代付提示框的取消按钮
     * */

    public void clickWaitfundAlertDismissElement(){
        refundaduitingPage.click(refundaduitingPage.getWaitfundAlertDismissElement());
    }

}
