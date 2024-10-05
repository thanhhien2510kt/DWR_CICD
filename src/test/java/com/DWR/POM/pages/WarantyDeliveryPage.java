package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.DWR.Keywords.WebUI.getWebElement;
import static com.DWR.Keywords.WebUI.sleep;

public class WarantyDeliveryPage extends CommonPage {
    //Element Add
    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");
    private By inputTypeOfGoods = By.xpath("//input[@id='from_aeon']");
    private By warrantyCode = By.xpath("//span[contains(text(),'Mã phiếu tiếp nhận bảo hành')]");
    private By storeCode = By.xpath("(//label[contains(text(),'Mã cửa hàng')]/parent::div)/following-sibling::div//span[contains(text(),'Chọn store')]");
    private By storeAddress = By.xpath("//input[@id='address']");
    private By shippingDate = By.xpath("//input[@id='shipping_date']");
    private By customerName = By.xpath("//input[@id='customer_name']");
    private By customerID = By.xpath("//input[@id='customer_card_number']");
    private By customerPhone = By.xpath("//input[@id='customer_phone']");
    private By customerLicensePlateNumber = By.xpath("//input[@id='customer_license_plate_number']");
    private By numberProduct = By.xpath("//input[@id='number_product']");

    private By SKU = By.xpath("//tbody//th[2]//span[contains(text(),'Chọn mã sản phẩm')]");
    private By quayHang = By.xpath("//tbody//th[4]/input[@name='prd_counter']");
    private By nganhHang = By.xpath("//tbody//th[5]/input[@name='prd_department']");
    private By quantity = By.xpath("//tbody//th[6]/input[@name='prd_quantity']");
    private By seri = By.xpath("//tbody//th[7]/input[@name='prd_seri']");


    private By saveButton = By.xpath("//button[contains(text(),'Lưu')]");
    private By headerWarantyDeliveryReceipt = By.xpath("//h2[contains(text(),'Danh sách phiếu xuất hàng đi bảo hành')]");

    // Element Search
    private By searchCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchStatus = By.xpath("(//label[contains(text(),'Trạng thái phiếu')]//parent::div)//following-sibling::div//span[@role='combobox']");

    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    //private By iconSendOfFirstItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='Send']");
    private By iconSendOfFirstItem = By.xpath("//tbody/tr[1]/td[11]/div[1]/button[4]/i[1]");

    private By iconPrintOfFirstItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='In phiếu']");
    private By iconDetailOfFirstItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='Detail']");
    private By iconAprroveOfFirstItem_1 = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='Phê duyệt lần 1']");
    private By iconAprroveOfFirstItem_2 = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='Phê duyệt lần 2']");
    private By iconAprroveOfFirstItem_3 = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[11]//button[@title='Phê duyệt lần 3']");
    private By approveButton = By.xpath("//button[@id='btnApprove']");
    private By toastMessage = By.xpath("//div[@id='toast-container']//button[normalize-space()='×']");
    private By iconWarehose = By.xpath("//i[contains(text(),'warehouse')]");
    private By stockDate = By.xpath("//input[@id='stock_in_date']");
    private By itemStockDate = By.xpath("//span[@aria-label='September 29, 2024']");
    private By iconWarrantySuccessful = By.xpath("//button[@title='Xác nhận sản phẩm đã được bảo hành/sửa chữa']");
    private By iconWarrantyFailed = By.xpath("//button[@title='Xác nhận sản phẩm chưa được bảo hành/sửa chữa']");
    private By deliveryDate = By.xpath("//input[@id='delivery_date']");
    private By itemDeliveryDate_success = By.xpath("//div[contains(@class,'flatpickr-calendar animate')][1]//span[@aria-label='September 29, 2024']");
    private By itemDeliveryDate_fail = By.xpath("//div[contains(@class,'flatpickr-calendar animate')][2]//span[@aria-label='September 29, 2024']");
    private By getStatus_success = By.xpath("//span[normalize-space()='Bảo hành thành công']");
    private By getStatus_fail = By.xpath("//span[normalize-space()='Bảo hành không thành công']");

    //Hàm xử lý cho trang WarantyReceiptPage
    public void clickAddNewButton() {
        WebUI.clickElement(buttonAddNew);
    }

    public void enterDataAddNewWarrantyDeliveryReceipt(String TypeOfGoods) {
        WebUI.waitForPageLoaded();
        WebUI.zoomConcept("80%", "Chrome");

        if(TypeOfGoods == "Kho AEON"){
            WebUI.clickCheckBox(inputTypeOfGoods,By.xpath("//label[normalize-space()='"+TypeOfGoods+"']"));
            WebUI.sleep(1);

            WebUI.clickElement(numberProduct);
            WebUI.setText(numberProduct, "1");
            WebUI.sleep(1);

            WebUI.clickElement(SKU);
            WebUI.sleep(2);
            WebUI.pressENTER();
            WebUI.sleep(3);

            WebUI.clickElement(quayHang);
            WebUI.setText(quayHang, "A");
            WebUI.sleep(1);

            WebUI.clickElement(nganhHang);
            WebUI.setText(nganhHang, "FL");
            WebUI.sleep(1);

            WebUI.clickElement(quantity);
            WebUI.setText(quantity, "1");
            WebUI.sleep(1);

            WebUI.clickElement(seri);
            WebUI.setText(seri, "1234566789");
            WebUI.sleep(1);
        }

        if(TypeOfGoods == "Khách hàng"){
            WebUI.clickElement(warrantyCode);
            WebUI.sleep(2);
            WebUI.pressENTER();

        }
        WebUI.clickElement(storeCode);
        WebUI.sleep(1);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        WebUI.clickElement(storeAddress);
        //WebUI.setText(storeAddress, "30 Đ. Tân Thắng, Sơn Kỳ, Tân Phú, Hồ Chí Minh");
        WebUI.sleep(1);

        WebUI.clickElement(shippingDate);
        WebUI.pressENTER();
        WebUI.sleep(1);

        WebUI.clickElement(customerName);
        WebUI.setText(customerName, "Rosy Dương");
        WebUI.sleep(1);

        WebUI.clickElement(customerID);
        WebUI.setText(customerID, "206066049");
        WebUI.sleep(1);

        WebUI.clickElement(customerPhone);
        WebUI.setText(customerPhone, "0343177955");
        WebUI.sleep(1);

        WebUI.clickElement(customerLicensePlateNumber);
        WebUI.setText(customerLicensePlateNumber, "123456789");
        WebUI.sleep(1);


        WebUI.clickElement(saveButton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerWarantyDeliveryReceipt), "Failed create");


    }

    public void searchWarrantyDeliveryReceipt (String customerName){
        WebUI.waitForPageLoaded();
        WebUI.zoomConcept("80%", "Chrome");
        WebUI.clickElement(searchCustomerName);
        WebUI.setText(searchCustomerName,customerName);
        WebUI.clickElement(searchStatus);
        WebUI.pressUP();
        WebUI.pressENTER();

        WebUI.clickElement(searchButton);
        WebUI.sleep(2);
    }

    public void clickIconSend (){
        WebUI.clickElement(iconSendOfFirstItem);
        WebUI.sleep(1);
        WebUI.clickElement(approveButton);

    }

    public void clickIconDetail (){
        WebUI.clickElement(iconDetailOfFirstItem);
        WebUI.sleep(1);

    }

    public void clickIconWarehose (){
        WebUI.scrollToElement(getWebElement(iconWarehose));
        WebUI.sleep(1);
        WebUI.clickElement(iconWarehose);
        WebUI.sleep(1);
        WebUI.clickElement(stockDate);
        WebUI.clickElement(itemStockDate);
        WebUI.clickElement(approveButton);
        WebUI.sleep(2);

    }

    public void clickIconWarrantyConfirmation (String status){
        if(status == "Successful"){
            WebUI.scrollToElement(getWebElement(iconWarrantySuccessful));
            WebUI.sleep(1);
            WebUI.clickElement(iconWarrantySuccessful);
            WebUI.sleep(1);
            WebUI.clickElement(deliveryDate);
            WebUI.clickElement(itemDeliveryDate_success);
        }else {
            WebUI.scrollToElement(getWebElement(iconWarrantyFailed));
            WebUI.sleep(1);
            WebUI.clickElement(iconWarrantyFailed);
            WebUI.sleep(1);
            WebUI.clickElement(deliveryDate);
            WebUI.clickElement(itemDeliveryDate_fail);
        }

        WebUI.clickElement(approveButton);

    }

    public void checkStatusAfterCompletion (String status){
        WebUI.sleep(1);
        if(status == "Successful"){
            Assert.assertTrue(WebUI.checkElementExist(getStatus_success), getStatus_success+" không tồn tại");
        }else {
            Assert.assertTrue(WebUI.checkElementExist(getStatus_fail), getStatus_fail+" không tồn tại");
        }

    }

    public void clickIconPrint (){
        WebUI.clickElement(iconPrintOfFirstItem);
        WebUI.sleep(1);
        WebUI.clickElement(approveButton);
        WebUI.sleep(2);
        WebUI.pressENTER();
        WebUI.sleep(1);
        WebUI.pressENTER();
        WebUI.sleep(1);
        WebUI.pressLEFT();
        WebUI.pressENTER();


    }



    public void closeToastMessage (){
        WebUI.sleep(1);
        WebUI.waitForElementClickable(toastMessage);
        WebUI.clickElement(toastMessage);
    }

    public void clickApproveButton_1 (){
        WebUI.clickElement(iconAprroveOfFirstItem_1);
        WebUI.sleep(1);
        WebUI.clickElement(approveButton);

    }
    public void clickApproveButton_2 (){
        WebUI.clickElement(iconAprroveOfFirstItem_2);
        WebUI.sleep(1);
        WebUI.clickElement(approveButton);

    }

    public void clickApproveButton_3 (){
        WebUI.clickElement(iconAprroveOfFirstItem_3);
        WebUI.sleep(1);
        WebUI.clickElement(approveButton);

    }
}
