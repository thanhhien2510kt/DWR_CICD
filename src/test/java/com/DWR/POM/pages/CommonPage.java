package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private DeliveryReceiptPage deliveryReceiptPage;
    private DepositReceiptPage depositReceiptPage;

    public LoginPage getLoginPage() {
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if(dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public DeliveryReceiptPage getDeliveryReceiptPage() {
        if(deliveryReceiptPage == null){
            deliveryReceiptPage = new DeliveryReceiptPage;
        }
        return deliveryReceiptPage;
    }

    public DepositReceiptPage getDepositReceiptPage() {
        if(depositReceiptPage == null){
            depositReceiptPage = new DepositReceipt();
        }
        return depositReceiptPage;
    }

    //hàm xây dựng
    public CommonPage (){

    }

    public By menuDWR = By.xpath("//button[normalize-space()='DWR']");
    public By menuDeliveryInfo = By.xpath("//span[normalize-space()='Thông tin giao hàng']");
    public By menuDeliveryReceiptPage = By.xpath("//a[normalize-space()='Phiếu giao hàng']");
    public By menuDepositReceipt = By.xpath("//a[contains(text(),'Phiếu thu tiền cọc')]");
    //public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    //public By iconNotification = By.xpath("//a[contains(@class,'notifications-icon')]");

    public DeliveryReceiptPage clickMenuDeliveryInfo(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDeliveryInfo,5);
        WebUI.clickElement(menuDeliveryReceiptPage,5);
        return new DeliveryReceiptPage();
    }

    public depositReceiptPage clickDepositReceiptPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDepositReceipt,5);

        return new depositReceiptPage();
    }

    public DashboardPage clickMenuDWR(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDWR,5);

        return new DashboardPage();
    }
}
