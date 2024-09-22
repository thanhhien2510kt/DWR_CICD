package com.DWR.POM.testcases;

import com.DWR.POM.pages.*;
import com.DWR.Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    CommonPage commonPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProjectPage projectPage;

    @Test
    public void testAddNewCustomer ( ){
        String CUSTOMER_NAME = "Rosy Duong";
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCRM("admin@example.com","123456");
        customerPage = dashboardPage.clickMenuCustomer();

        int totalCustomerBefore = Integer.parseInt(customerPage.getTotalCustomer());
        System.out.println(customerPage.getTotalCustomer());;
        customerPage.clickAddNewButton();
        customerPage.enterDataAddNewCustomer(CUSTOMER_NAME, 1);
        customerPage.checkCustomerInList(CUSTOMER_NAME);

        Assert.assertEquals(customerPage.getTotalCustomer(), String.valueOf(totalCustomerBefore + 1),"FAIL.The total customer not match");
        customerPage.checkCustomerDetail(CUSTOMER_NAME);

        projectPage = customerPage.clickMenuProject();
        projectPage.clickAddNewProject();
        projectPage.checkCustomerDisplayInSelectSection(CUSTOMER_NAME);

    }
}
