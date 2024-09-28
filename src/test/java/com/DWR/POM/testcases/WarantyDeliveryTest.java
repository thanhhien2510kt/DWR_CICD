package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class WarantyDeliveryTest extends BaseTest {
    @Test(priority = 1)
    public void addNewWarantyDeliveryReceipt() {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyDeliveryPage();

        //Tạo phiếu xuất hàng bảo hành
        WebUI.waitForPageLoaded();
        getWarantyDeliveryPage().clickAddNewButton();
        getWarantyDeliveryPage().enterDataAddNewWarrantyDeliveryReceipt("Kho AEON");

    }


    @Test (priority = 2)
    public void sendWarantyDeliveryReceipt (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyDeliveryPage();

        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        WebUI.sleep(2);
        getWarantyDeliveryPage().clickIconSend();
    }

}
