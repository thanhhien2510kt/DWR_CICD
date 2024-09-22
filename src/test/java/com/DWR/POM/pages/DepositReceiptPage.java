package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProjectPage extends CommonPage {

    //hàm xây dưng
    public ProjectPage(){

    }

    private By headerPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By buttonAddNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By selectCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div//input");
    private By itemCustomerName = By.xpath("//span[@class='text']");

    public void clickAddNewProject (){

        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddNewProject, 5);
    }

    public void checkCustomerDisplayInSelectSection(String customerName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(selectCustomer,5);
        WebUI.sleep(2);
        WebUI.setText(inputSearchCustomer, customerName);
        WebUI.sleep(2);
        String itemCustomer = driverManager.getDriver().findElement(itemCustomerName).getText();
        System.out.println("Customer in select: " + itemCustomer);
        Assert.assertEquals(itemCustomer, customerName, "FAIL, the customer not display in project");
    }

}
