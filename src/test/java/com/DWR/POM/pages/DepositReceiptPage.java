package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DepositReceiptPage extends CommonPage {

    // Element Add
    private By buttonAddNew = By.xpath("//span[normalize-space()='Thêm']");

    private By customerCode = By.xpath("//input[@id='code']");
    private By customerCodeLable = By.xpath("//label[contains(text(),'Mã thẻ thành viên')]");

    private By customerName = By.xpath("//input[@id='name']");

    private By deliveryCode = By.xpath("//span[@id='select2-delivery_code-container']");
    private By deliveryCodeSearch = By.xpath("//input[@placeholder='Nhập từ khóa tìm kiếm']");

    private By paymentReason = By.xpath("//textarea[@id='payment_reason']");

    private By cashAmount = By.xpath("//input[@id='cash_money']");
    private By writeInWords = By.xpath("//textarea[@id='cash_written_in_word']");

    private By deliveryDate = By.xpath("//input[@id='DeliveryDate']");
    private By inputAttachment = By.xpath("//input[@id='inputAttachment']");
    private By productLineName = By.xpath("//span[@id='select2-product_line-container']");
    private By provinceName = By.xpath("//span[@id='select2-Province-container']");
    private By districtName = By.xpath("//span[@id='select2-District-container']");
    private By wardName = By.xpath("//span[@id='select2-Ward-container']");
    private By address = By.xpath("//input[@id='address']");
    private By paymentCash = By.xpath("//input[@id='paymentCash']");
    private By paymentCard = By.xpath("//input[@id='paymentCard']");
    private By paymentTransfer = By.xpath("//input[@id='paymentTransfer']");

    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    private By headerDepositReceipt = By.xpath("//h2[contains(text(),'Danh sách phiếu thu tiền cọc')]");

    // search
    private By searchByCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchByStatus = By.xpath("//select[@id='status']");
    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    private By buttonEditOfFistItem = By
            .xpath("//table[@id='deposittable']//tbody[1]/tr[1]/td[10]//button[@title='Edit']");
    private By selectDeliveryCode = By
            .xpath("//label[contains(text(),'Mã phiếu giao hàng')]/following-sibling::div//span[@role='combobox']");
    private By updateButton = By.xpath("//button[contains(text(),'Lưu')]");

    // Hàm xử lý cho trang DepositReceiptPage
    public void clickAddNewButton() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonAddNew);
    }

    public void clickEditButton() {
        WebUI.waitForPageLoaded();
        WebUI.zoomConcept("50%", "Chrome");
        WebUI.clickElement(buttonEditOfFistItem);
    }

    public void linkToDeliveryCode() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(selectDeliveryCode);
        WebUI.sleep(1);
        WebUI.pressENTER();
        WebUI.sleep(1);
        WebUI.scrollToElement(WebUI.getWebElement(updateButton));
        WebUI.sleep(1);
        WebUI.clickElement(updateButton);
        WebUI.sleep(2);
    }

    public void search(String customerName) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(searchByCustomerName);
        WebUI.setText(searchByCustomerName, customerName);
        WebUI.clickElement(searchButton);
    }

    public void enterDataAddNewDeposit(String code) {
        WebUI.zoomConcept("80%", "Chrome");
        WebUI.setText(customerCode, "3003228094");
        WebUI.clickElement(customerCodeLable); // blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();

        WebUI.clickElement(customerName);
        WebUI.clearText(customerName);
        WebUI.setText(customerName, "Rosy Dương");

        WebUI.clickElement(paymentReason);
        WebUI.setText(paymentReason, "Cọc tiền mua hàng");

        WebUI.setText(deliveryDate, "30/12/2026");
        WebUI.pressENTER();

        WebUI.clickElement(deliveryCode);
        WebUI.sleep(2);
        WebUI.clickElement(deliveryCodeSearch);
        WebUI.sleep(2);
        WebUI.setText(deliveryCodeSearch, code);
        WebUI.sleep(2);
        WebUI.pressENTER();
        WebUI.sleep(2);

        WebUI.clickElement(productLineName);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.clickElement(provinceName);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.clickElement(districtName);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.clickElement(wardName);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.setText(address, "123 Ngô Quyền");

        if (!WebUI.checkElementIsChecked(paymentCash)) {
            WebUI.clickElement(paymentCash); // Chọn phương thức tiền mặt
        }

        WebUI.clickElement(cashAmount);
        WebUI.setText(cashAmount, "500000");

        WebUI.scrollToElement(WebUI.getWebElement(saveButton));
        WebUI.sleep(1);
        WebUI.clickElement(saveButton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerDepositReceipt), "Failed Create Deposit Receipt");
    }

    public String getDepositReceiptCodeOfFistItemInTable() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        return WebUI.getElementText(By.xpath("//table[@id='deposittable']/tbody[1]/tr[1]/td[2]"));
    }

    public void searchDepositRecept(String customerName, String status) {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(searchByCustomerName);
        WebUI.setText(searchByCustomerName, customerName);
        WebUI.clickElement(searchByStatus);
        WebUI.clickElement(By.xpath("//select[@id='status']//option[contains(text(),'" + status + "')]"));
        WebUI.clickElement(searchButton);
    }

    public void clickIconCallBack() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("//table[@id='deposittable']/tbody[1]/tr[1]/td[11]//button[@title='Callback']"));
    }

    public void clickYesButton() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("//button[contains(text(),'Đồng ý')]"));
    }

}
