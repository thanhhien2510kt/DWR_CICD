package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class WarantyReceiptTest extends BaseTest {

    @Test
    public void addNewWarantyReceipt() {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //Tạo phiếu tiếp nhận
        WebUI.waitForPageLoaded();
        getWarantyReceiptPage().clickAddNewButton();
        getWarantyReceiptPage().enterDataAddNewWarrantyReceipt();

    }
    @Test
    public void printWarantyReceipt (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //search phiếu
        getWarantyReceiptPage().searchWarrantyReceipt("Rosy Dương");

        // print - đang lỗi
        //getWarantyReceiptPage().clickIconPrint();

    }


}