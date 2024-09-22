package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import com.DWR.helpers.ExcelHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.sql.DriverManager;
import java.util.List;

import static com.DWR.Keywords.WebUI.*;

public class CustomerPage extends CommonPage {
    private WebUI WebUI;

    public CustomerPage (){

    }

    //Element
    private By newCustomerButton = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomer = By.xpath("//span[normalize-space()='Customers Summary']");
    private By searchCustomer = By.xpath("//div[@id='clients_filter']//input[@placeholder='Search...']");
    private By firstItemCustomer = By.xpath("//tbody/tr[1]/td[3]/a");
    private By company = By.xpath("//input[@id='company']");
    private By vat = By.xpath("//input[@id='vat']");
    private By phone = By.xpath("//input[@id='phonenumber']");
    private By website = By.xpath("//input[@id='website']");
    private By selectGroup = By.xpath("//button[@data-id = 'groups_in[]']");
    private By searchGroup = By.xpath("//button[@data-id = 'groups_in[]']/following-sibling::div//input");
    private By selectlanguage = By.xpath("//button[@data-id='default_language']");
    private By itemVietNam = By.xpath("//span[normalize-space()='Vietnamese']");
    private By address = By.xpath("//textarea[@id='address']");
    private By city = By.xpath("//input[@id='city']");
    private By state = By.xpath("//input[@id='state']");
    private By zip = By.xpath("//input[@id='zip']");
    private By selectCountry = By.xpath("//button[@data-id='country']");
    private By searchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By alertMessage = By.xpath("//span[@class='alert-title']");
    private By totalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    // hàm xử lý cho trang Customer

    public  void clickAddNewButton (){

        clickElement(newCustomerButton,2);
    }

    public String getTotalCustomer (){
        waitForPageLoaded();
        return WebUI.getElementText(totalCustomers);
    }

    public  void selectLanguage ( String languageName){
        clickElement(selectlanguage, 5);
        sleep(2);
        clickElement(By.xpath("//span[normalize-space()='" + languageName + "']"), 5);
    }


    public void enterDataAddNewCustomer (String customerName, int row){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Customer");

        setText(company,excelHelper.getCellData("CUSTOMER_NAME",row));
        setText(vat,excelHelper.getCellData("VAT",row));
        setText(phone,excelHelper.getCellData("PHONE",row));
        setText(website,excelHelper.getCellData("WEBSITE",row));
        clickElement(selectGroup,1);
        setText(searchGroup,"VIP");
        setKeys(searchGroup, Keys.ENTER);
        clickElement(selectGroup,1);
        //clickElement(selectlanguage,1); //tại đây click rồi
        selectLanguage("French"); //đây click cái nữa = tắt

        setText(address,"HN");
        setText(city,"ABC");
        setText(state,"ABC");
        setText(zip,"100000");

        clickElement(selectCountry, 1);
        setText(searchCountry,"vietnam");
        setKeys(searchCountry, Keys.ENTER);
        clickElement(buttonSave,1);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(checkElementExist(alertMessage));
        waitForElementVisible(alertMessage,5);
        Assert.assertEquals(driverManager.getDriver().findElement(alertMessage).getText().trim(),"Customer added successfully.");

    }

    public void searchAndCheckDataInTable (int column ,String data, String columnName){
        waitForPageLoaded();
        setText(searchCustomer, data);
        WebUI.checkDataInTableByColumn_Equals(column, data,columnName);
    }


    public void checkCustomerInList ( String customerName){
        waitForPageLoaded();
        clickElement(menuCustomer, 2);
        setText(searchCustomer, customerName);
        waitForPageLoaded();
        sleep(2);

        //Check customer name display in table
        Assert.assertTrue(checkElementExist(firstItemCustomer),"\uD83D\uDC1E FAIL! The customer not display in table");
        //Assert.assertEquals(driver.findElement(firstItemCustomer).getText(),customerName, " \uD83D\uDC1E FAIL! The customer name not match");

        assertEquals(getElementText(firstItemCustomer), customerName, "\uD83D\uDC1E FAIL! The customer name not match");


    }

    public void checkCustomerDetail (String customerName){

        checkElementExist(firstItemCustomer);
        clickElement(firstItemCustomer, 5);

        //Check customer detail in customer detail page
        assertEquals(getElementAttribute(company,"value"), customerName,"FAIL. the company name not match");
        assertEquals(getElementAttribute(vat,"value"), "10", "FAIL, the vat name not match");
        assertEquals(getElementAttribute(website,"value"), "https://bu3.com", "FAIL, the website name not match" );
        assertEquals(getElementAttribute(phone,"value"), "034178529", "FAIL, the phone name not match");
        assertEquals(getElementAttribute(address,"value"), "HN", " FAIL, the address name not match");
        assertEquals(getElementAttribute(selectGroup,"title"), "VIP","FAIL. The group of customer not match");
        assertEquals(getElementAttribute(selectlanguage,"title"), "French", "FAIL, the language name not match");
    }
}
