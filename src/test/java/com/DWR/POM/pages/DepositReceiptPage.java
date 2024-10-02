package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DepositReceiptPage extends CommonPage{

    //Element Add
    private By buttonAddNew = By.xpath("//span[normalize-space()='Thêm']");

    private By customerCode = By.xpath("//input[@id='code']");
    private By customerCodeLable = By.xpath("//label[contains(text(),'Mã thẻ thành viên')]");

    private By customerName = By.xpath("//input[@id='name']");

    private By deliveryCode = By.xpath("//span[@id='select2-delivery_code-container']");
    private By deliveryCodeSearch = By.xpath("//input[@placeholder='Nhập từ khóa tìm kiếm']");

    private By paymentReason = By.xpath("//textarea[@id='payment_reason']");

    private By cashAmount = By.xpath("//input[@id='cash_money']");
    private By writeInWords = By.xpath("//textarea[@id='cash_written_in_word']");

    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    private By headerDepositReceipt = By.xpath("//h2[contains(text(),'Danh sách phiếu thu tiền cọc')]");

    //search
    private By searchByCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    private By buttonEditOfFistItem = By.xpath("//table[@id='deposittable']//tbody[1]/tr[1]/td[10]//button[@title='Edit']");
    private By selectDeliveryCode = By.xpath("//label[contains(text(),'Mã phiếu giao hàng')]/following-sibling::div//span[@role='combobox']");
    private By updateButton = By.xpath("//button[contains(text(),'Lưu')]");

    //Hàm xử lý cho trang DepositReceiptPage
    public void clickAddNewButton() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddNew);
    }

    public void clickEditButton() {
        WebUI.waitForPageLoaded();
        WebUI.zoomConcept("80%", "Chrome");
        WebUI.clickElement(buttonEditOfFistItem);
    }

    public void linkToDeliveryCode() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(selectDeliveryCode);
        WebUI.sleep(1);
        WebUI.pressENTER();
        WebUI.sleep(1);
        WebUI.clickElement(updateButton);
        WebUI.sleep(2);
    }

    public void search(String customerName) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(searchByCustomerName);
        WebUI.setText(searchByCustomerName, customerName);
        WebUI.clickElement(searchButton);
    }



    public void enterDataAddNewDeposit () {

        WebUI.setText(customerCode,"3003228094" );
        WebUI.clickElement(customerCodeLable); //blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();

        WebUI.clickElement(customerName);
        WebUI.clearText(customerName);
        WebUI.setText(customerName, "Rosy Dương");

        //WebUI.clickElement(deliveryCode);
        //WebUI.setText(deliveryCodeSearch,deliveryNumber);
        //WebUI.pressENTER();
        //WebUI.sleep(1);

        WebUI.clickElement(paymentReason);
        WebUI.setText(paymentReason, "Cọc tiền mua hàng");

        WebUI.clickElement(cashAmount);
        WebUI.setText(cashAmount, "500000");

        //WebUI.clickElement(writeInWords);
        //WebUI.setText(writeInWords, "Năm trăm ngàn đồng chẵn");

        WebUI.clickElement(saveButton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerDepositReceipt),"Failed Create");


    }

}
