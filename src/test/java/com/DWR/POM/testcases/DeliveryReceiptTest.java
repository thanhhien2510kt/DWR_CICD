package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DeliveryReceiptTest extends BaseTest {

    @Test
    public void testAddNewDeliveryReceipt (){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Login");

        for (int i=1; i <= 1; i++ ){
            getLoginPage().LoginCRM(
                    excelHelper.getCellData("USERNAME", i),
                    excelHelper.getCellData("PASSWORD", i)
            );
        }

        clickDeliveryReceiptPage();
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_No();




    }
}
