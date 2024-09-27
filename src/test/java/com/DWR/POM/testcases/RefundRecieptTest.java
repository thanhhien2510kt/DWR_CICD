package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RefundRecieptTest extends BaseTest {

    @Test
    @Parameters({"type", "situation", "paymentMethodPriorToReturn", "refundMethod", "price_before", "price_after"})
    public void addNewRefundReceipt_param (String type, String situation, String paymentMethodPriorToReturn, String refundMethod, String price_before, String price_after) {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickRefundRecieptPage();

        //Tạo phiếu tiếp nhận
        WebUI.sleep(2);
        getRefundRecieptPage().clickAddNewButton();
        getRefundRecieptPage().enterDataAddNewRefundReciept(
                type,
                situation,
                paymentMethodPriorToReturn, refundMethod,
                price_before, price_after);
        WebUI.sleep(3);
    }

    @Test
    public void addNewRefundReceipt ()  {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickRefundRecieptPage();

        //Tạo phiếu tiếp nhận
        WebUI.sleep(2);
        getRefundRecieptPage().clickAddNewButton();
        getRefundRecieptPage().enterDataAddNewRefundReciept(
                "Trả hàng",
                "Special",
                "COD", "Tiền mặt",
                "5100000", "1000000");
        WebUI.sleep(3);
    }



}
