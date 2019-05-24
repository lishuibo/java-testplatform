package com.litl.www.pages;

import com.litl.www.base.DriverBase;
import com.litl.www.util.getByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundBatchPage extends BasePage {

    public RefundBatchPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取fmis平台左侧页面的导航栏elements
     * */
    public List<WebElement> getItemElements(){
        return elements(getByLocator.getByLocator("items"));
    }

    /**
     * 获取退款批次按钮element
     * */
    public List<WebElement> getRefundBatchElements(){
        return elements(getByLocator.getByLocator("refundbatch"));
    }
    /**
     * 获取退款批次页面的iframe
     * */
    public WebElement getrefundBatchIframeElement(){
        return element(getByLocator.getByLocator("refundbatch_iframe"));
    }

    /**
     * 获取右侧页面的iframe
     * */
    public WebElement getRightIframeElement(){
        return element(getByLocator.getByLocator("rightiframe"));
    }
    /**
     * 获取批次号
     * */
    public WebElement getBatchNoElement(){
        return element(getByLocator.getByLocator("refundbatch_batchno"));
    }

    /**
     * 获取查询按钮
     * */
    public WebElement getSearchbuttonElement(){
        return element(getByLocator.getByLocator("refundbatch_search_btn"));
    }

    /**
     * 获取提交批次
     * */
    public WebElement getRefundListAuditBatchElement(){
        return element(getByLocator.getByLocator("refundlist_audit_batch"));
    }

    /**
     *获取加入批次号的确认按钮
     * */

    public WebElement getRefundListAuditBatchConfirmElement(){
        return element(getByLocator.getByLocator("refundlist_audit_batch_cofirm"));
    }

}
