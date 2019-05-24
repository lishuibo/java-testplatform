package com.litl.www.pages;

import com.litl.www.base.DriverBase;
import com.litl.www.util.getByLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RefundAduitingPage extends BasePage {

    public RefundAduitingPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取fmis平台左侧页面的导航栏elements
     * */
    public List<WebElement> getItemElements(){
        return elements(getByLocator.getByLocator("items"));
    }

    /**
     * 获取退款审核按钮element
     * */
    public WebElement getRefundAduitingElement(){
        return element(getByLocator.getByLocator("refundaduiting"));
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
        return element(getByLocator.getByLocator("refundaduiting_batchno"));
    }

    /**
     * 获取查询按钮
     * */
    public WebElement getSearchbuttonElement(){
        return element(getByLocator.getByLocator("refundaduiting_searchbutton"));
    }

    /**
     * 获取第一个单选框按钮 勾选下面所有的记录
     * */
    public WebElement getHeaderChechBoxElement(){
        return element(getByLocator.getByLocator("refundaduiting_headercheckbox"));
    }

    /**
     *获取代付按钮
     * */

    public WebElement getWaitfundElement(){
        return element(getByLocator.getByLocator("refundaduiting_waitfund"));
    }

    /**
     *获取代付的消息提示框
     * */
//    public WebElement getWaitfundAlertElement(){
//        return element(getByLocator.getByLocator("waitfundalert"));
//    }


    /**
     *获取代付的消息提示框取消按钮
     * */

    public WebElement getWaitfundAlertDismissElement(){
        return element(getByLocator.getByLocator("refundaduiting_waitfundalertdismiss"));
    }

}
