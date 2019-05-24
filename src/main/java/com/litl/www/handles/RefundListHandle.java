package com.litl.www.handles;

import com.litl.www.base.DriverBase;
import com.litl.www.pages.RefundApplyPage;
import com.litl.www.pages.RefundListPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundListHandle {
    private DriverBase driver;
    private RefundListPage refundlistpage;
    public RefundListHandle(DriverBase driver){
        this.driver = driver;
        refundlistpage = new RefundListPage(driver);
    }

    /**
     * 点击fmis平台左侧页面的导航栏elements
     * */
    public void clickItemElements() {
        List<WebElement> elements = refundlistpage.getItemElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款管理")) {
                element.click();
            }
        }
    }

    /**
     * 获取待退款名单按钮element
     * */
    public void clickRefundListElements() {
        List<WebElement> elements = refundlistpage.getRefundListElements();
        for (WebElement element:elements) {
            if (element.getText().equals("待退款名单")) {
                element.click();
            }
        }
    }
    /**
     * 切换右侧页面的iframe
     * */
    public  void switchRightIframeElement(){
        WebElement rightIframeElement = refundlistpage.getRightIframeElement();
        driver.switchIframe(rightIframeElement);
    }
    /**
     * 输入交易号
     * */
    public void sendkeysRequestNosElement(String requestnos){
        refundlistpage.sendkeys(refundlistpage.getRequestNosElement(),requestnos);
    }

    /**
     * 点击查询按钮
     * */
    public void clickSearchbuttonElement(){
        refundlistpage.click(refundlistpage.getSearchbuttonElement());
    }

    /**
     * 点击第一个单选框按钮 勾选下面所有的记录
     * */
    public void clickHeaderChechBoxElement(){
        refundlistpage.click(refundlistpage.getHeaderChechBoxElement());
    }

    /**
     *点击加入批次号按钮
     * */

    public void clickAddBatchBtnElement(){
        refundlistpage.click(refundlistpage.getAddBatchBtnElement());
    }

    /**
     *切换加入批次号iframe
     * */
    public void switchAddBatchIframeElement(){
        WebElement addBatchIframeElement = refundlistpage.getAddBatchIframeElement();
        driver.switchIframe(addBatchIframeElement);
    }

    /**
     * 输入批次号
     * */
    public void sendkeysBatchNoElement(String batchno){
        refundlistpage.sendkeys(refundlistpage.getBatchNoElement(),batchno);
        driver.swtichParentFrame();
    }

    /**
     * 点击批次号的iframe页面确认按钮
     * */
    public void clickAddBatchNoElement(){
        refundlistpage.click(refundlistpage.getAddBatchNoConfirmElement());
    }
}
