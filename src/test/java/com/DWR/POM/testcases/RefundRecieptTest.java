package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class RefundRecieptTest extends BaseTest {

    @Test
    public void addNewRefundReceipt (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickRefundRecieptPage();

        //Tạo phiếu tiếp nhận
        WebUI.waitForPageLoaded();
        getRefundRecieptPage().clickAddNewButton();
        getRefundRecieptPage().enterDataAddNewRefundReciept("Trả hàng", "Normal");
        WebUI.sleep(5);
    }



}
