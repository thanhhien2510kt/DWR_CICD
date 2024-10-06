package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Test;

public class CancelledDeliveryReceiptTest extends BaseTest {

    @Test
    public void cancellationFlow_CDO (){
        //B5: G2 OP - Hủy CDO
        getLoginPage().LoginCRM_Excel(2,2);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "Other");
        String code = getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();

        getDeliveryReceiptPage().clickDetailButton();
        String totalPrice = getDeliveryReceiptPage().getTotalPriceOfFistItemInTable();
        String handleTotalPrice = totalPrice.replace(".", "");
        int doneTotalPrice = Integer.parseInt(handleTotalPrice);
        System.out.println(doneTotalPrice);
        getDeliveryReceiptPage().clickReturnButton();

        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconCallBack();
        getDeliveryReceiptPage().clickIconCallBack_cancelReceipt();
        getDeliveryReceiptPage().closeToastMessage();

        getLoginPage().Logout("G2_FL");

        //B6: Các cấp G phê duyệt hủy
        if(doneTotalPrice >= 0 & doneTotalPrice <= 1000000){
            getLoginPage().LoginCRM_Excel(2,2);
            clickCancelledDeliveryReceiptPage();
            getCancelledDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "other");
            getCancelledDeliveryReceiptPage().clickIconApprove();
        } else if (doneTotalPrice > 1000000 & doneTotalPrice <= 3000000) {
            getLoginPage().LoginCRM_Excel(3,3);
            clickCancelledDeliveryReceiptPage();
            getCancelledDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "other");
            getCancelledDeliveryReceiptPage().clickIconApprove();
        } else if (doneTotalPrice > 3000000 & doneTotalPrice <= 5000000) {
            getLoginPage().LoginCRM_Excel(4,4);
            clickCancelledDeliveryReceiptPage();
            getCancelledDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "other");
            getCancelledDeliveryReceiptPage().clickIconApprove();
        } else if (doneTotalPrice > 5000000 & doneTotalPrice <= 30000000) {
            getLoginPage().LoginCRM_Excel(5,5);
            clickCancelledDeliveryReceiptPage();
            getCancelledDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "other");
            getCancelledDeliveryReceiptPage().clickIconApprove();
        } else if (doneTotalPrice > 30000000 & doneTotalPrice <= 90000000) {
            getLoginPage().LoginCRM_Excel(6,6);
            clickCancelledDeliveryReceiptPage();
            getCancelledDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", "other");
            getCancelledDeliveryReceiptPage().clickIconApprove();
        }

    }
    
}
