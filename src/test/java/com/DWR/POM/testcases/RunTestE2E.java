package com.DWR.POM.testcases;

import com.DWR.Common.BaseTestE2E;
import com.DWR.POM.pages.DashboardPage;
import com.DWR.POM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunTestE2E extends BaseTestE2E {


    @Test (priority = 1)
    public void testLoginSucess (){
        getLoginPage().LoginCRM("admin@example.com","123456");
        getLoginPage().verifyLoginSuccess();
    }

    @Test (priority = 2)
    public  void  testCheckSectionQuickStaticDisplay (){

        getDashboardPage().clickDashboardOptions();
        getDashboardPage().verifyCheckboxQuickStatics();

    }

    @Test (priority = 3)
    public void testAddNewCustomer ( ){
        String CUSTOMER_NAME = "Rosy Duong";

        getDashboardPage().clickDeliveryReceiptPage();

//        int totalCustomerBefore = Integer.parseInt(getCustomerPage().getTotalCustomer());
//        System.out.println(getCustomerPage().getTotalCustomer());;
//        getCustomerPage().clickAddNewButton();
//        getCustomerPage().enterDataAddNewCustomer(CUSTOMER_NAME, 1);
//        getCustomerPage().checkCustomerInList(CUSTOMER_NAME);
//
//        Assert.assertEquals(getCustomerPage().getTotalCustomer(), String.valueOf(totalCustomerBefore + 1),"FAIL.The total customer not match");
//        getCustomerPage().checkCustomerDetail(CUSTOMER_NAME);
//
//        getCustomerPage().clickMenuProject();
//        getprojectPage().clickAddNewProject();
//        getprojectPage().checkCustomerDisplayInSelectSection(CUSTOMER_NAME);

    }


}
