package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class DepositReceiptTest extends BaseTest {



    @Test(priority = 1)
    public void AddNewDepositReceipt (){
        getLoginPage().LoginCRM_Excel(1,1);
        //clickDeliveryReceiptPage();
        //getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "Yes");
        //String DeliveryReceiptCode = getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();
        //getLoginPage().Logout("G1_FL");

        //getLoginPage().LoginCRM_Excel(7,7);
        clickDepositReceiptPage();
        getDepositReceiptPage().clickAddNewButton();
        getDepositReceiptPage().enterDataAddNewDeposit();

    }

    @Test(priority = 2)
    public void linkToDeliveryCode (){
        //Login G2_Cashier
        getLoginPage().LoginCRM_Excel(8,8);
        clickDepositReceiptPage();

        //search
        getDepositReceiptPage().search("Rosy Dương");
        WebUI.sleep(2);

        getDepositReceiptPage().clickEditButton();
        getDepositReceiptPage().linkToDeliveryCode();


    }




}
