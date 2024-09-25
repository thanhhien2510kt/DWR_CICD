package com.DWR.POM.pages;

import com.DWR.Constant.ConfigData;
import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import com.DWR.helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.DWR.Constant.ConfigData.URL;

public class LoginPage extends CommonPage {


    //Hàm xây dựng cho từng class page
    public LoginPage (){

    }

    //Khai báo các element dạng đối tương By
    private By inputUsername = By.xpath("//input[@id='Username']");
    private By inputPassword = By.xpath("//input[@id='Password']");
    private By buttonLogin = By.xpath("//button[@id='btnLogin']");
    private By buttonDWR = By.xpath("//button[normalize-space()='DWR']");
    private By errorMessage = By.xpath("//div[@class='toast-message']");
    private By menuDashboard = By.xpath("//img[@src='/assets/images/logo/aeon-logo.png']");
    private By optionLogout = By.xpath("//a[contains(text(),'Đăng xuất')]");

    // Khai báo hàm xử lý
    public void enterUsername (String email){
        WebUI.setText(inputUsername, email);
    }

    public void enterPassword (String password){
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton (){
        WebUI.clickElement(buttonLogin);
    }

    public void clickDWRButton (){
        WebUI.clickElement(buttonDWR);
    }

    public DashboardPage LoginCRM (String username, String password){
        WebUI.openURL(URL);
        WebUI.waitForPageLoaded();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        WebUI.sleep(2);
        clickDWRButton();

        return new DashboardPage();
    }

    public DashboardPage LoginCRM_Excel (int from, int to){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Login");

        WebUI.openURL(URL);
        WebUI.waitForPageLoaded();

        for (int i= from; i <= to; i++ ){
            enterUsername(excelHelper.getCellData("USERNAME", i));
            enterPassword(excelHelper.getCellData("PASSWORD", i));
        }

        clickLoginButton();
        WebUI.sleep(2);
        clickDWRButton();

        return new DashboardPage();
    }


    public DashboardPage LoginCRM_Fail (String username, String password){
        WebUI.openURL(URL);
        WebUI.waitForPageLoaded();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        WebUI.sleep(2);

        return new DashboardPage();
    }

    public void Logout (String username){
        WebUI.waitForElementClickable(By.xpath("//span[normalize-space()='"+ username +"']"));
        WebUI.clickElement(By.xpath("//span[normalize-space()='"+ username +"']"));
        WebUI.clickElement(optionLogout);
        WebUI.sleep(2);
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuDashboard), "FAIL. Cannot redirect to the Dashboard page");
        Assert.assertEquals(driverManager.getDriver().getCurrentUrl(),"http://20.24.110.171/dwr","FAIL. Cannot redirect to the Dashboard page");
    }
    public void verifyLoginFail (String expectedMessage){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(errorMessage), "FAIL. The error message is not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), expectedMessage, "FAIL.The content of the error message does not match. ");
    }

}
