package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DepositReceiptTest extends BaseTest {

    @Test
    @Parameters({ "customer", "status", "Type" })
    public void cancelDeposit(String customer, String status, String Type) {
        // G2 cashier hủy phiếu cọc
        if (Type == "COD_Yes") {
            getLoginPage().LoginCRM_Excel(7, 7);
            getDepositReceiptPage();

            getDepositReceiptPage().searchDepositRecept(customer, status);
            // String code =
            // getDepositReceiptPage().getDepositReceiptCodeOfFistItemInTable();
            getDepositReceiptPage().clickIconCallBack();
            getDepositReceiptPage().clickYesButton();
        }

    }

}
