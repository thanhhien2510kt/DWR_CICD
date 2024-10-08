package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class RefundRecieptTest extends BaseTest {

    @Test
    @Parameters({"type", "term","situation", "paymentMethodPriorToReturn", "refundMethod", "price_before", "price_after"})
    public void addNewRefundReceipt_param (String type, String term, String situation, String paymentMethodPriorToReturn, String refundMethod, String price_before, String price_after) {
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickRefundRecieptPage();

        //Tạo phiếu tiếp nhận
        WebUI.sleep(2);
        getRefundRecieptPage().clickAddNewButton();
        getRefundRecieptPage().enterDataAddNewRefundReciept(
                type,
                term,
                situation,
                paymentMethodPriorToReturn, refundMethod,
                price_before, price_after);
        WebUI.sleep(3);
    }

    @Test
    public void addNewRefundReceipt ()  {
        //Login
        getLoginPage().LoginCRM_Excel(13, 13);
        clickRefundRecieptPage();

        //Tạo phiếu tiếp nhận
        WebUI.sleep(2);
        getRefundRecieptPage().clickAddNewButton();
        getRefundRecieptPage().enterDataAddNewRefundReciept(
                "Đổi hàng",
                "Khác",
                "Normal",
                "COD", "Tiền mặt",
                "1000000", "500000");
        WebUI.sleep(3);
    }

    @Test
    public void workflow (){
        //Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickRefundRecieptPage();

        //search phiếu
        WebUI.sleep(2);
        getRefundRecieptPage().search("Rosy Dương");
        WebUI.sleep(2);

        // get Information : refund payment method, difference amount
        getRefundRecieptPage().clickDetailButton ();
        Map<String, Object> info = getRefundRecieptPage().getInfoFromDetailScreen("a", "b");
        System.out.println(info.get("differentAmount"));
        Object refundPaymentMethod = info.get("refundPaymentMethod");
        String differentAmount_temp1 = (String) info.get("differentAmount");
        String differentAmount_temp2 = differentAmount_temp1.replace(".", "");
        int differentAmount = Integer.parseInt((String) differentAmount_temp2 ) ;
        System.out.println(differentAmount);


        //Send phiếu
        //getRefundRecieptPage().send();
        //getRefundRecieptPage().approve();

        // Duyệt kiểm soát - lỗi tại đây
        if (refundPaymentMethod == "Đặc biệt" && differentAmount <= 1000000 && differentAmount >= 0 ){
            //Login G2 CS
            System.out.println("có ở đây");
            getLoginPage().Logout("G1_FL");
            getLoginPage().LoginCRM_Excel(13, 13);
            clickRefundRecieptPage();
        }

        // Duyệt bổ sung


    }




}
