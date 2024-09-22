package com.DWR.POM.testcases;

import com.DWR.POM.pages.DashboardPage;
import com.DWR.POM.pages.LoginPage;
import com.DWR.Common.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(DashboardTest.class);
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test (priority = 2)
    public void testCheckTotalQuickStatic (){
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCRM("admin@example.com", "123456");

//        dashboardPage = new DashboardPage(driver);
        dashboardPage.checkTotalInvoicesAwaitingPayment("2 / 5");
        dashboardPage.checkTotalConvertedLeads("1 / 3");
        dashboardPage.checkTotalProjectsInProgress("1 / 6");
        dashboardPage.checkTasksNotFinished("7 / 8");

    }

    @Test (priority = 1)
    public  void  testCheckSectionQuickStaticDisplay (){
        loginPage = new LoginPage();
        dashboardPage = loginPage.LoginCRM("admin@example.com", "123456");

        dashboardPage.clickDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatics();

    }

}
