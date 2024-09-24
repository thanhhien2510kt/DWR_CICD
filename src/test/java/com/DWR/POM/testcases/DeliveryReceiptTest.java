package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DeliveryReceiptTest extends BaseTest {

    @Test
    public void testAddNewDeliveryReceipt_CDO (){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Login");

        for (int i=1; i <= 1; i++ ){
            getLoginPage().LoginCRM(
                    excelHelper.getCellData("USERNAME", i),
                    excelHelper.getCellData("PASSWORD", i)
            );
        }

        clickDeliveryReceiptPage();


        //tạo phiếu CDO
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCDO();

    }

    @Test
    public void testAddNewDeliveryReceipt_COD_Yes (){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Login");

        for (int i=1; i <= 1; i++ ){
            getLoginPage().LoginCRM(
                    excelHelper.getCellData("USERNAME", i),
                    excelHelper.getCellData("PASSWORD", i)
            );
        }

        clickDeliveryReceiptPage();


        //tạo phiếu COD (có cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_Yes();


    }

    @Test
    public void testAddNewDeliveryReceipt_COD_No (){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Login");

        for (int i=1; i <= 1; i++ ){
            getLoginPage().LoginCRM(
                    excelHelper.getCellData("USERNAME", i),
                    excelHelper.getCellData("PASSWORD", i)
            );
        }

        clickDeliveryReceiptPage();

        //tạo phiếu COD (không cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_No();


    }

    @Test
    public void searchDeliveryReceipt_CDO (){
        testAddNewDeliveryReceipt_CDO();

        //search phiếu vừa tạo
        getDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương");

        getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();

    }





}
