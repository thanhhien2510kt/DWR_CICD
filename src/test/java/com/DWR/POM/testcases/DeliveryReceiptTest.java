package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DeliveryReceiptTest extends BaseTest {

    @Test
    public void testAddNewDeliveryReceipt_CDO (){
        //Login
        getLoginPage().LoginCRM_Excel(1,1);
        clickDeliveryReceiptPage();


        //tạo phiếu CDO
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCDO();

    }

    @Test
    public void testAddNewDeliveryReceipt_COD_Yes (){
        //Login
        getLoginPage().LoginCRM_Excel(1,1);
        clickDeliveryReceiptPage();

        //tạo phiếu COD (có cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_Yes();

        //send phiếu
        String code = getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconSend();

    }


    @Test
    public void testAddNewDeliveryReceipt_COD_No (){
        //Login
        getLoginPage().LoginCRM_Excel(1,1);
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
    public void approveFlow_CDO (){
        String code = searchDeliveryReceipt("CDO");

        //B1: Send phiếu
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconSend();

        // B2: G4 OP - phê duyệt
        getLoginPage().Logout("G1_FL");
        getLoginPage().LoginCRM_Excel(4,4);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // B3: G4 Op - in đơn
        getDeliveryReceiptPage().clickIconPrint();
        WebUI.sleep(3);
        getDeliveryReceiptPage().switchNewWindowToClick();
        WebUI.sleep(5);





    }





}
