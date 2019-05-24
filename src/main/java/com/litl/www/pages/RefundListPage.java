package com.litl.www.pages;

import com.litl.www.base.DriverBase;
import com.litl.www.util.getByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundListPage extends BasePage {

    public RefundListPage(DriverBase driver) {
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
    public List<WebElement> getRefundListElements(){
        return elements(getByLocator.getByLocator("refundlist"));
    }
    /**
     * 获取待退款列表页面的iframe
     * */
    public WebElement getrefundlistIframeElement(){
        return element(getByLocator.getByLocator("refundlist_iframe"));
    }

    /**
     * 获取右侧页面的iframe
     * */
    public WebElement getRightIframeElement(){
        return element(getByLocator.getByLocator("rightiframe"));
    }
    /**
     * 获取交易号
     * */
    public WebElement getRequestNosElement(){
        return element(getByLocator.getByLocator("refundlist_requestno"));
    }

    /**
     * 获取查询按钮
     * */
    public WebElement getSearchbuttonElement(){
        return element(getByLocator.getByLocator("refundlist_searchbutton"));
    }

    /**
     * 获取第一个单选框按钮 勾选下面所有的记录
     * */
    public WebElement getHeaderChechBoxElement(){
        return element(getByLocator.getByLocator("refundlist_headercheckbox"));
    }

    /**
     *获取加入批次号按钮
     * */

    public WebElement getAddBatchBtnElement(){
        return element(getByLocator.getByLocator("refundlist_addbatch_btn"));
    }

    /**
     *获取加入批次号的iframe
     * */

    public WebElement getAddBatchIframeElement(){
        return element(getByLocator.getByLocator("refundlist_addbatch_iframe"));
    }

    /**
     *获取批次号
     * */
    public WebElement getBatchNoElement(){
        return element(getByLocator.getByLocator("refundlist_batchno"));
    }

    /**
     *获取批次号提示框的确认按钮
     * */
    public WebElement getAddBatchNoConfirmElement(){
        return element(getByLocator.getByLocator("refundlist_addbatchno_confirm"));
    }
}
