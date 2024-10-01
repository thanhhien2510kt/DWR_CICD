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
        WebUI.sleep(2);
        getWarantyReceiptPage().clickAddNewButton();
        getWarantyReceiptPage().enterDataAddNewWarrantyReceipt();

    }

    @Test(priority = 2)
    public void sign (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //search phiếu
        getWarantyReceiptPage().searchWarrantyReceipt("Rosy Dương");

        //Ký
        getWarantyReceiptPage().sign();

    }

    @Test(priority = 3)
    public void print (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickWarantyReceiptPage();

        //search phiếu
        getWarantyReceiptPage().searchWarrantyReceipt("Rosy Dương");

        //In
        getWarantyReceiptPage().clickIconPrint();  // lỗi ở đây ạ
    }




}