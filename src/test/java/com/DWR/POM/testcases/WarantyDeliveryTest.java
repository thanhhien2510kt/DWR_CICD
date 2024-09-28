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

    @Test(priority = 3)
    public void approveFlow (){
        //Login
        getLoginPage().LoginCRM_Excel(3, 3);
        clickWarantyDeliveryPage();

        //G3 phê duyệt lần 1
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickApproveButton_1 ();
        getWarantyDeliveryPage().closeToastMessage();

        //G4 phê duyệt lần 2
        getLoginPage().Logout("G3_FL");
        getLoginPage().LoginCRM_Excel(4, 4);
        clickWarantyDeliveryPage();
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickApproveButton_2 ();
        getWarantyDeliveryPage().closeToastMessage();

        //G4 phê duyệt lần 3
        getLoginPage().Logout("G4_FL");
        getLoginPage().LoginCRM_Excel(12, 12);
        clickWarantyDeliveryPage();
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickApproveButton_3 ();
        getWarantyDeliveryPage().closeToastMessage();

        //G1 in phiếu
        getLoginPage().Logout("G3_MMD");
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyDeliveryPage();
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickIconPrint();

        //G3 MMD nhập kho
        getLoginPage().Logout("G1_FL");
        getLoginPage().LoginCRM_Excel(12, 12);
        clickWarantyDeliveryPage();
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickIconDetail();
        getWarantyDeliveryPage().clickIconWarehose();

        //G1 OP nhập hàng
        getLoginPage().Logout("G3_MMD");
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyDeliveryPage();
        getWarantyDeliveryPage().searchWarrantyDeliveryReceipt("Rosy Dương");
        getWarantyDeliveryPage().clickIconDetail();
        getWarantyDeliveryPage().clickIconWarrantyConfirmation("Failed");

        //check status
        getWarantyDeliveryPage().checkStatusAfterCompletion("Failed");

    }

}
