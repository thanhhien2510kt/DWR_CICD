package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class WarantyReceiptTest extends BaseTest {

    @Test(priority = 1)
    public void addNewWarantyReceipt() {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //Tạo phiếu tiếp nhận
        WebUI.waitForPageLoaded();
        getWarantyReceiptPage().clickAddNewButton();
        getWarantyReceiptPage().enterDataAddNewWarrantyReceipt();

    }

    @Test(priority = 2)
    public void signAndPrint (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //search phiếu
        getWarantyReceiptPage().searchWarrantyReceipt("Rosy Dương");

        //Ký
        getWarantyReceiptPage().sign();

        //In
        getWarantyReceiptPage().clickIconPrint();
    }




}