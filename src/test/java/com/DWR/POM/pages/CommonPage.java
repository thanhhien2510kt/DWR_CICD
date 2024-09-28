package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private DeliveryReceiptPage deliveryReceiptPage;
    private DepositReceiptPage depositReceiptPage;
    private WarantyReceiptPage warantyReceiptPage;
    private RefundRecieptPage refundRecieptPage;
    private WarantyDeliveryPage warantyDeliveryPage;

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
            deliveryReceiptPage = new DeliveryReceiptPage();
        }
        return deliveryReceiptPage;
    }

    public DepositReceiptPage getDepositReceiptPage() {
        if(depositReceiptPage == null){
            depositReceiptPage = new DepositReceiptPage();
        }
        return depositReceiptPage;
    }

    public WarantyReceiptPage getWarantyReceiptPage() {
        if(warantyReceiptPage == null){
            warantyReceiptPage = new WarantyReceiptPage();
        }
        return warantyReceiptPage;
    }

    public RefundRecieptPage getRefundRecieptPage() {
        if(refundRecieptPage == null){
            refundRecieptPage = new RefundRecieptPage();
        }
        return refundRecieptPage;
    }

    public WarantyDeliveryPage getWarantyDeliveryPage() {
        if(warantyDeliveryPage == null){
            warantyDeliveryPage = new WarantyDeliveryPage();
        }
        return warantyDeliveryPage;
    }

    //hàm xây dựng
    public CommonPage (){

    }

    public By menuDWR = By.xpath("//button[normalize-space()='DWR']");

    public By menuDeliveryInfo = By.xpath("//span[normalize-space()='Thông tin giao hàng']");
    public By menuDeliveryReceiptPage = By.xpath("//a[normalize-space()='Phiếu giao hàng']");
    public By menuDepositReceipt = By.xpath("//a[contains(text(),'Phiếu thu tiền cọc')]");

    public By menuWarantyInfo = By.xpath("//span[contains(text(),'Thông tin bảo hành')]");
    public By menuWarantyReceipt = By.xpath("//a[contains(text(),'Tiếp nhận bảo hành')]");
    public By menuWarantyDelivery = By.xpath("//a[contains(text(),'Xuất hàng bảo hành')]");

    public By menuRefundInfo = By.xpath("//span[contains(text(),'Thông tin đổi trả')]");
    public By menuRefundReceipt = By.xpath("//a[@href='/dwr/GoodsReturn/index']");

    public DashboardPage clickMenuDWR(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDWR,5);

        return new DashboardPage();
    }

    public DeliveryReceiptPage clickDeliveryReceiptPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDeliveryInfo,3);
        WebUI.clickElement(menuDeliveryReceiptPage,3);
        return new DeliveryReceiptPage();
    }

    public DepositReceiptPage clickDepositReceiptPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDeliveryInfo,3);
        WebUI.clickElement(menuDepositReceipt,3);

        return new DepositReceiptPage();
    }

    public WarantyReceiptPage clickWarantyReceiptPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuWarantyInfo,3);
        WebUI.clickElement(menuWarantyReceipt,3);

        return new WarantyReceiptPage();
    }

    public RefundRecieptPage clickRefundRecieptPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuRefundInfo,3);
        WebUI.clickElement(menuRefundReceipt,3);

        return new RefundRecieptPage();
    }

    public WarantyDeliveryPage clickWarantyDeliveryPage(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuWarantyInfo,3);
        WebUI.clickElement(menuWarantyDelivery,3);

        return new WarantyDeliveryPage();
    }




}
