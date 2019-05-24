package com.litl.www.handles;

import com.litl.www.base.DriverBase;
import com.litl.www.pages.RefundAduitingPage;
import com.litl.www.pages.RefundApplyPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundApplyHandle {
    private DriverBase driver;
    private RefundApplyPage refundapplypage;
    public RefundApplyHandle(DriverBase driver){
        this.driver = driver;
        refundapplypage = new RefundApplyPage(driver);
    }

    /**
     * 点击fmis平台左侧页面的导航栏elements
     * */
    public void clickItemElements() {
        List<WebElement> elements = refundapplypage.getItemElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款管理")) {
                element.click();
            }
        }
    }

    /**
     * 获取退款申请按钮element
     * */
    public void clickRefundAduitingElements() {
        List<WebElement> elements = refundapplypage.getRefundApplyElements();
        for (WebElement element:elements) {
            if (element.getText().equals("退款申请")) {
                element.click();
            }
        }
    }
    /**
     * 切换右侧页面的iframe
     * */
    public  void switchRightIframeElement(){
        WebElement rightIframeElement = refundapplypage.getRightIframeElement();
        driver.switchIframe(rightIframeElement);
    }
    /**
     * 输入姓名
     * */
    public void sendkeysUserNamesElement(String userNames){
        refundapplypage.sendkeys(refundapplypage.getUserNamesElement(),userNames);
    }

    /**
     * 输入交易号
     * */
    public void sendkeysRequesNosElement(String requestNos){
        refundapplypage.sendkeys(refundapplypage.getRequestNosElement(),requestNos);
    }

    /**
     * 点击查询按钮
     * */
    public void clickSearchbuttonElement(){
        refundapplypage.click(refundapplypage.getSearchbuttonElement());
    }

    /**
     * 点击第一个单选框按钮 勾选下面所有的记录
     * */
    public void clickHeaderChechBoxElement(){
        refundapplypage.click(refundapplypage.getHeaderChechBoxElement());
    }

    /**
     *点击退款申请按钮
     * */

    public void clickRefundElement(){
        refundapplypage.click(refundapplypage.getRefundElement());
    }

    /**
     *点击代付提示框的取消按钮
     * */

    public void clickRefundAlertConfirmElement(){
        refundapplypage.click(refundapplypage.getRefundAlertConfirmElement());
    }

}
