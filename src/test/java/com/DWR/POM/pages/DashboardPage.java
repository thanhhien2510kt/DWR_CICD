package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DashboardPage extends CommonPage {

    SoftAssert softAssert = new SoftAssert();

    public  DashboardPage (){

    }

    private By buttonDashboardOption = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By totalInvoicesAwaitingPayment = By.xpath("//span[normalize-space()='Invoices Awaiting Payment']/parent::div/following-sibling::span");
    private By totalConvertedLeads = By.xpath("//span[normalize-space()='Converted Leads']/parent::div/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("//span[normalize-space()='Projects In Progress']/parent::div/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("//span[normalize-space()='Tasks Not Finished']/parent::div/following-sibling::span");
    private By checkbox = By.xpath("//input[@id='widget_option_top_stats']");
    private By sectionQuickStatics = By.xpath("//div[@id='widget-top_stats']");

    public void clickDashboardOptions (){
        WebUI.waitForPageLoaded();
        WebUI.checkElementExist(buttonDashboardOption);
        WebUI.clickElement(buttonDashboardOption);

    }

    public void verifyCheckboxQuickStatics (){
        WebUI.sleep(2);
        softAssert.assertTrue(driverManager.getDriver().findElement(checkbox).isSelected(),"FAIL. The value of check Quick Static is not checked");
        softAssert.assertTrue(driverManager.getDriver().findElement(sectionQuickStatics).isDisplayed(),"FAIL. The value of check Quick Static is not displayed");

    }


    public void checkTotalInvoicesAwaitingPayment ( String value){

        softAssert.assertTrue(WebUI.checkElementExist(totalInvoicesAwaitingPayment),"The section Invoices Awaiting Payment is not display");
        softAssert.assertEquals(driverManager.getDriver().findElement(totalInvoicesAwaitingPayment).getText(), value, "FAIL . The total Invoices Awaiting Payment is not match");

    }
    public void checkTotalConvertedLeads ( String value){
        softAssert.assertTrue(WebUI.checkElementExist(totalConvertedLeads),"The section Invoices Awaiting Payment is not display");
        softAssert.assertEquals(driverManager.getDriver().findElement(totalConvertedLeads).getText(), value, "FAIL . The total Invoices Awaiting Payment is not match");
    }
    public void checkTotalProjectsInProgress (String value){
        softAssert.assertTrue(WebUI.checkElementExist(totalProjectsInProgress),"The section Invoices Awaiting Payment is not display");
        softAssert.assertEquals(driverManager.getDriver().findElement(totalProjectsInProgress).getText(), value, "FAIL . The total Invoices Awaiting Payment is not match");
    }
    public void checkTasksNotFinished (String value){
        softAssert.assertTrue(WebUI.checkElementExist(totalTasksNotFinished),"The section Invoices Awaiting Payment is not display");
        softAssert.assertEquals(driverManager.getDriver().findElement(totalTasksNotFinished).getText(), value, "FAIL . The total Invoices Awaiting Payment is not match");
        softAssert.assertAll();

    }


}
