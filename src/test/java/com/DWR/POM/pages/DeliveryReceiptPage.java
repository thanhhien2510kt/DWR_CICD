package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import com.DWR.helpers.SystemHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.DWR.Keywords.WebUI.getWebElement;
import static com.DWR.Keywords.WebUI.sleep;


public class DeliveryReceiptPage extends CommonPage {

    //Element Add
    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");

    private By CDOCheckBox = By.xpath("//label[normalize-space()='CDO']");
    private By CODCheckBox = By.xpath("//label[normalize-space()='COD']");

    private By noDepositCheckBox = By.xpath("//label[@for='deposit_no']");
    private By yesDepositCheckBox = By.xpath("//label[@for='deposit_yes']");

    private By customerCode = By.xpath("//input[@id='CustomerCode']");
    private By customerCodeLable = By.xpath("//label[contains(text(),'Mã thẻ thành viên')]");

    private By customerPhone1 = By.xpath("//input[@id='CustomerPhone']");
    private By customerPhone2 = By.xpath("//input[@id='CustomerPhone2']");
    private By customerName = By.xpath("//input[@id='CustomerName']");
    private By provinceName = By.xpath("//span[contains(text(),'Thành phố/Tỉnh')]");
    private By districtrName = By.xpath("//span[contains(text(),'Quận/Huyện')]");
    private By wardName = By.xpath("//span[contains(text(),'Phường/Xã')]");
    private By customerAddress = By.xpath("//input[@id='CustomerAddress']");


    private By selectDeliveryDate = By.xpath("//div[@class='form-line selectlist']/child::input[@id=\"DeliveryDate\"]");
    private By itemDeliveryDate = By.xpath("//div[@aria-label='" + currentDay() + "']");
    private By billCode = By.xpath("//input[@id='BillCode']");
    private By numberProduct = By.xpath("//input[@id='NumberProduct']");

    private By selectSKU = By.xpath("//span[normalize-space()='Chọn mã sản phẩm']");
    private By SearchSKU = By.xpath("//input[@placeholder='Nhập từ khóa tìm kiếm']");
    private By itemSKU = By.xpath("//span[@title='02478333']");

    private By quayHang = By.xpath("//tbody//th[4]/input");
    private By nganhHang = By.xpath("//tbody//th[5]/input");
    private By quanity = By.xpath("//tbody//th[6]/input");
    private By price = By.xpath("//tbody//th[7]/input");
    private By discount = By.xpath("//tbody//th[8]/input");
    private By chooseFileButton = By.xpath("(//label[contains(text(),'Đính kèm receipt và hình ảnh quà tặng kèm theo')]/parent::div)/following-sibling::div//input[@id='file']");

    private By savebutton = By.xpath("//button[contains(text(),'Lưu')]");

    private By headerDeliveryReceipt = By.xpath("//h2[normalize-space()='Danh Sách Phiếu Giao Hàng']");

    //Element Search
    private By searchCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchCode = By.xpath("//input[@id='Code']");
    private By searchType = By.xpath("(//div/label[text()='Loại phiếu']/parent::div)/following-sibling::div//span[@role='combobox']");
    private By searchDepositStatus = By.xpath("(//div/label[text()='Trạng thái phiếu cọc']/parent::div)/following-sibling::div//span[@role='combobox']");

    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    private By deliveryReceiptCode = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[3]");

    private By iconSendOfFirstItem = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Send']");
    private By buttonYes = By.xpath("//button[contains(text(),'Đồng ý')]");

    private By iconApproveOfFirstItem = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Approve']");
    private By ApproveConfirmButton = By.xpath("//button[@id='btnApprove']");

    private By iconPrintOfFirstItem = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Print']");

    private By iconCallBackOfFirstItem = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Callback']");
    private By callBackConfirmButton = By.xpath("//button[@id='btnCallBack']");

    private By chooseStatus = By.xpath("//select[@id='choose_status']");

    private By toastMessage = By.xpath("//div[@id='toast-container']//button[normalize-space()='×']");


    //Hàm xử lý cho trang DeliveryReceiptPage

    public String currentDay() {
        // Lấy ngày hôm nay
        LocalDate ngayHienTai = LocalDate.now();

        // Định dạng ngày theo "dd/MM/yyyy"
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Chuyển đổi và in ra ngày hôm nay theo định dạng "dd/MM/yyyy"
        String currentDay = ngayHienTai.format(dinhDang);

        return currentDay;

    }

    public void clickAddNewButton() {
        WebUI.clickElement(buttonAddNew);
    }

    public void uploadFile (){
        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\TestData\\BOOKING APP.pdf";
        WebUI.setText(chooseFileButton,filePath);
        WebUI.sleep(2);

    }

    public void enterDataAddNewCOD_No() {
        WebUI.zoomConcept("80%","Chrome");
        WebUI.clickElement(CODCheckBox);
        WebUI.clickElement(noDepositCheckBox);
        WebUI.setText(customerCode, "3003228094");
        WebUI.clickElement(customerCodeLable); //blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();

        WebUI.clickElement(customerPhone2);
        WebUI.setText(customerPhone2,"0908081322");

        WebUI.clickElement(customerName);
        WebUI.clearText(customerName);
        WebUI.setText(customerName, "Rosy Dương");

        WebUI.clickElement(selectDeliveryDate);
        sleep(3);
        WebUI.clickElement(itemDeliveryDate);
        sleep(3);

        WebUI.setText(billCode, "HD6512381");
        WebUI.clickElement(numberProduct);
        WebUI.setText(numberProduct, "1");
        sleep(2);

        WebUI.clickElement(selectSKU);
        WebUI.sleep(3);
        WebUI.setText(SearchSKU, "023");
        sleep(2);
        WebUI.pressENTER();
        sleep(5);
        WebUI.setText(quayHang, "A");
        sleep(1);
        WebUI.setText(nganhHang, "FL");
        sleep(1);
        WebUI.setText(quanity, "1");
        sleep(1);
        WebUI.setText(price, "560000");
        sleep(1);
        WebUI.setText(discount, "10");
        sleep(1);

        WebUI.scrollToElement(driverManager.getDriver().findElement(savebutton));
        sleep(2);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed login");


    }

    public void enterDataAddNewCOD_Yes() {
        WebUI.zoomConcept("80%", "Chrome");

        WebUI.clickElement(CODCheckBox);
        WebUI.clickElement(yesDepositCheckBox);
        WebUI.setText(customerCode, "3003228094");
        WebUI.clickElement(customerCodeLable); //blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();

        WebUI.clickElement(customerPhone2);
        WebUI.setText(customerPhone2,"0908081322");

        WebUI.clickElement(customerName);
        WebUI.clearText(customerName);
        WebUI.setText(customerName, "Rosy Dương");

        WebUI.clickElement(selectDeliveryDate);
        sleep(3);
        WebUI.clickElement(itemDeliveryDate);
        sleep(3);

        WebUI.setText(billCode, "HD6512381");
        WebUI.clickElement(numberProduct);
        WebUI.setText(numberProduct, "1");
        sleep(2);


        WebUI.clickElement(selectSKU);
        WebUI.waitForPageLoaded();
        WebUI.setText(SearchSKU, "023");
        sleep(2);
        WebUI.pressENTER();
        sleep(5);
        WebUI.setText(quayHang, "A");
        sleep(1);
        WebUI.setText(nganhHang, "FL");
        sleep(1);
        WebUI.setText(quanity, "1");
        sleep(1);
        WebUI.setText(price, "560000");
        sleep(1);
        WebUI.setText(discount, "10");
        sleep(1);

        WebUI.scrollToElement(driverManager.getDriver().findElement(savebutton));
        sleep(2);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed login");


    }

    public void enterDataAddNewCDO() {

        WebUI.zoomConcept("80%", "Chrome");
        WebUI.clickElement(CDOCheckBox);
        //WebUI.setText(customerCode, "3000012570");
        //WebUI.clickElement(customerCodeLable); //blur chuột ra ngoài để load customercode
        //WebUI.waitForPageLoaded();

        WebUI.clickElement(customerPhone1);
        WebUI.setText(customerPhone1,"0908081322");

        WebUI.clickElement(customerPhone2);
        WebUI.setText(customerPhone2,"0908081322");

        WebUI.clickElement(customerName);
        //WebUI.clearText(customerName);
        WebUI.setText(customerName, "Rosy Dương");

        WebUI.clickElement(provinceName);
        sleep(1);
        WebUI.pressENTER();
        sleep(1);

        WebUI.clickElement(districtrName);
        sleep(1);
        WebUI.pressENTER();
        sleep(1);

        WebUI.clickElement(wardName);
        sleep(1);
        WebUI.pressENTER();
        sleep(1);

        WebUI.clickElement(selectDeliveryDate);
        sleep(3);
        WebUI.clickElement(itemDeliveryDate);
        sleep(3);

        WebUI.clickElement(customerAddress);
        WebUI.setText(customerAddress,"123 Ngô Quyền");

        WebUI.setText(billCode, "HD6512381");
        WebUI.clickElement(numberProduct);
        WebUI.setText(numberProduct, "1");
        sleep(2);
        WebUI.clickElement(selectSKU);
        WebUI.waitForPageLoaded();
        WebUI.setText(SearchSKU, "023");
        sleep(2);
        WebUI.pressENTER();
        sleep(5);
        WebUI.setText(quayHang, "A");
        sleep(1);
        WebUI.setText(nganhHang, "FL");
        sleep(1);
        WebUI.setText(quanity, "1");
        sleep(1);
        WebUI.setText(price, "560000");
        sleep(1);
        WebUI.setText(discount, "10");
        sleep(1);

        WebUI.scrollToElement(driverManager.getDriver().findElement(savebutton));
        sleep(2);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed login");


    }

    public void searchRecept(String type, String name, String deposit) {

        sleep(3);
        WebUI.clickElement(searchType);
        sleep(1);
        WebUI.clickElement(By.xpath("//ul/li[normalize-space()='" + type + "']"));
        sleep(1);

        WebUI.clickElement(searchCustomerName);
        WebUI.setText(searchCustomerName, name);

        if (deposit == "Yes") {
            WebUI.clickElement(searchDepositStatus);
            sleep(1);
            WebUI.clickElement(By.xpath("//ul/li[normalize-space()='Có']"));
            sleep(1);
        } else if (deposit == "No") {
            WebUI.clickElement(searchDepositStatus);
            sleep(1);
            WebUI.clickElement(By.xpath("//ul/li[normalize-space()='Không']"));
            sleep(1);
        } else {

        }

        WebUI.clickElement(searchButton);
        sleep(3);

    }

    public void searchRecept(String code) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(searchCode);
        sleep(1);
        WebUI.setText(searchCode, code);
        sleep(1);


        WebUI.clickElement(searchButton);
        sleep(3);

    }

    public String getDeliveryReceiptCodeOfFistItemInTable() {

        String DeliveryReceiptCode = WebUI.getElementText(deliveryReceiptCode);
        return DeliveryReceiptCode;
    }

    public void clickIconSend() {
        WebUI.clickElement(iconSendOfFirstItem);
        sleep(2);
        WebUI.clickElement(buttonYes);
        sleep(5);
    }

    public void clickIconApprove() {
        WebUI.clickElement(iconApproveOfFirstItem);
        sleep(2);
        WebUI.clickElement(ApproveConfirmButton);
        sleep(5);
    }

    public void clickIconPrint() {
        WebUI.clickElement(iconPrintOfFirstItem);
        sleep(2);
        WebUI.clickElement(buttonYes);
        sleep(5);
    }

    public void closePrintDialog() {

        WebUI.pressTAB();
        WebUI.pressENTER();
        WebUI.switchToWindow();

    }

    public void clickIconCallBack (){
        WebUI.clickElement(iconCallBackOfFirstItem);
        WebUI.sleep(2);
    }

    public void clickIconCallBack_exportGoods (){
        WebUI.clickElement(callBackConfirmButton);
        WebUI.sleep(2);
    }

    public void clickIconCallBack_cancelReceipt (){
        WebUI.clickElement(chooseStatus);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.clickElement(callBackConfirmButton);
    }

    public void closeToastMessage (){
        WebUI.sleep(1);
        WebUI.waitForElementClickable(toastMessage);
        WebUI.clickElement(toastMessage);
    }


}