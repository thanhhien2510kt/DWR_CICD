package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;

public class GetHTMLLocatorsTest extends BaseTest {
    @Test
    public void getAddNewDepositHTML() {
        // Login
        getLoginPage().LoginCRM_Excel(1, 1);
        
        // Navigate
        getLoginPage().clickDepositReceiptPage();
        WebUI.sleep(2);
        
        // Click Add New
        getDepositReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        WebUI.sleep(3);
        
        // Dump HTML
        String html = driverManager.getDriver().getPageSource();
        try {
            FileWriter writer = new FileWriter("deposit_form.html");
            writer.write(html);
            writer.close();
            System.out.println("HTML dumped to deposit_form.html successfully.");
        } catch (IOException e) {
            System.out.println("Failed to write HTML: " + e.getMessage());
        }
    }
}
