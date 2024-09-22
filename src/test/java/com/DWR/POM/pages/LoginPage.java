package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.DWR.Constant.ConfigData.URL;

public class LoginPage extends CommonPage {


    //Hàm xây dựng cho từng class page
    public LoginPage (){

    }

    //Khai báo các element dạng đối tương By
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,\"alert alert-danger\")]");
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'user-profile')]");
    private By optionLogout = By.xpath("//a[text()='Logout']");

    // Khai báo hàm xử lý
    public void enterEmail (String email){

        WebUI.setText(inputEmail, email);
    }

    public void enterPassword (String password){

        //driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton (){

        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage LoginCRM (String email, String password){
        //driver.get(ConfigData.URL);
        WebUI.openURL(URL);
        WebUI.waitForPageLoaded();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        return new DashboardPage();
    }

    public void Logout (){
        WebUI.clickElement(dropdownProfile);
        WebUI.clickElement(optionLogout);
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuDashboard), "FAIL. Can not direct to Dashboard Page");
        Assert.assertEquals(driverManager.getDriver().getCurrentUrl(),"https://crm.DWR.com/admin/","FAIL. Can not direct to Dashboard Page");
    }
    public void verifyLoginFail (String expectedMessage){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(errorMessage), "FAIL. The error message not display");
        Assert.assertEquals(WebUI.getElementText(errorMessage), expectedMessage, "FAIL.The content of error message is not match ");
    }

}
