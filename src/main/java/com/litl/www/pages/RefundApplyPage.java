package com.litl.www.pages;

import com.litl.www.base.DriverBase;
import com.litl.www.util.getByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundApplyPage extends BasePage {

    public RefundApplyPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取fmis平台左侧页面的导航栏elements
     * */
    public List<WebElement> getItemElements(){
        return elements(getByLocator.getByLocator("items"));
    }

    /**
     * 获取退款申请按钮element
     * */
    public List<WebElement> getRefundApplyElements(){
        return elements(getByLocator.getByLocator("refundapply"));
    }
    /**
     * 获取右侧页面的iframe
     * */
    public WebElement getRightIframeElement(){
        return element(getByLocator.getByLocator("rightiframe"));
    }
    /**
     * 获取姓名
     * */
    public WebElement getUserNamesElement(){
        return element(getByLocator.getByLocator("refundapply_userames"));
    }
    /**
     * 获取交易号
     * */
    public WebElement getRequestNosElement(){
        return element(getByLocator.getByLocator("refundapply_requestnos"));
    }

    /**
     * 获取查询按钮
     * */
    public WebElement getSearchbuttonElement(){
        return element(getByLocator.getByLocator("refundapply_searchbutton"));
    }

    /**
     * 获取第一个单选框按钮 勾选下面所有的记录
     * */
    public WebElement getHeaderChechBoxElement(){
        return element(getByLocator.getByLocator("refundapply_headercheckbox"));
    }

    /**
     *获取退款申请按钮
     * */

    public WebElement getRefundElement(){
        return element(getByLocator.getByLocator("refundapply_refund_btn"));
    }

    /**
     *获取代付的消息提示框确定按钮
     * */

    public WebElement getRefundAlertConfirmElement(){
        return element(getByLocator.getByLocator("refundapply_refund_confirm"));
    }

}
