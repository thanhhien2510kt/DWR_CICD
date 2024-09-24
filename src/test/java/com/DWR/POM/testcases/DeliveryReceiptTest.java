package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DeliveryReceiptTest extends BaseTest {

    @Test
    public void testAddNewDeliveryReceipt_CDO (){
        //Login
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

    public String searchDeliveryReceipt (String typeName) {
        String deliveryReceiptCode;
        switch (typeName) {
            case "CDO":
                testAddNewDeliveryReceipt_CDO();
                //search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "Other");
                break;

            case "COD_Yes":
                testAddNewDeliveryReceipt_COD_Yes();
                //search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "Yes");
                break;

            case "COD_No":
                testAddNewDeliveryReceipt_COD_No();
                //search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "No");
                break;

        }
        deliveryReceiptCode = getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();

        return deliveryReceiptCode;
    }

    @Test
    public void approveFlow (){
        String code = searchDeliveryReceipt("CDO");
        System.out.println(code);

    }





}
