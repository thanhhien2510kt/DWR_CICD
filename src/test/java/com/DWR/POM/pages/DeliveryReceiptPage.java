package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.helpers.SystemHelper;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.DWR.Keywords.WebUI.*;

public class DeliveryReceiptPage extends CommonPage {

    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");
    private By CDOInput = By.id("typeCDO");
    private By CDOLabel = By.xpath("//label[@for='typeCDO']");
    private By CODInput = By.id("typeCOD");
    private By CODLabel = By.xpath("//label[@for='typeCOD']");

    private By noDepositInput = By.id("deposit_no");
    private By noDepositLabel = By.xpath("//label[@for='deposit_no']");
    private By yesDepositInput = By.id("deposit_yes");
    private By yesDepositLabel = By.xpath("//label[@for='deposit_yes']");

    private By storeDropdown = By.id("Store");

    private By customerCodeLable = By.xpath("//label[contains(text(),'Mã thẻ thành viên')]");

    private By customerPhone1 = By.id("CustomerPhone");
    private By customerName = By.id("CustomerName");
    private By provinceName = By.xpath("//span[@id='select2-Province-container']");
    private By provinceDropdown = By.xpath("//li[contains(text(),'Bình Dương')]");
    private By districtrName = By.xpath("//span[@id='select2-District-container']");
    private By wardName = By.xpath("//span[@id='select2-Ward-container']");
    private By customerAddress = By.id("CustomerAddress");

    private By selectDeliveryDate = By.name("DeliveryDate");
    private By deliveryTimeDropdown = By.xpath("//span[@id='select2-DeliveryTime-container']");
    private By billCode = By.id("BillCode");
    private By numberProduct = By.id("NumberProduct");

    private By isInstallationTrue = By.id("IsInstallation_True");
    private By isInstallationFalse = By.id("IsInstallation_False");
    private By isVatTrue = By.id("IsVat_True");
    private By isVatFalse = By.id("IsVat_False");

    private By sapCode = By.id("SAPCode");
    private By numberBag = By.id("NumberBag");
    private By bagPrice = By.id("MoneyBag");
    private By labelBagPrice = By.xpath("//label[contains(text(),'Tiền túi hàng')]");
    private By giftItem = By.id("gift_note");
    private By extraShippingFee = By.id("shipping_price");

    private By selectSKU = By.xpath("//span[contains(@id,'select2-') and contains(.,'Chọn mã sản phẩm')]");
    private By SKUDropdown = By.xpath("//li[normalize-space()='00100014']");
    private By quanity = By.cssSelector("input.product_quantity");
    private By price = By.cssSelector("input.product_price");
    private By discount = By.cssSelector("input.product_discount_price");

    private By chooseFileButton = By.id("file");
    private By savebutton = By.cssSelector("button.bg-aeon");
    private By headerDeliveryReceipt = By.xpath("//h2[normalize-space()='Danh Sách Phiếu Giao Hàng']");

    // Element Search
    private By searchCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchCode = By.xpath("//input[@id='Code']");
    private By searchType = By
            .xpath("(//div/label[text()='Loại phiếu']/parent::div)/following-sibling::div//span[@role='combobox']");
    private By searchDepositStatus = By.xpath(
            "(//div/label[text()='Trạng thái phiếu cọc']/parent::div)/following-sibling::div//span[@role='combobox']");

    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    private By detailButton = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Detail']");

    private By deliveryReceiptCode = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[3]");
    private By deliveryReceiptStatus = By.xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[11]");

    private By iconSendOfFirstItem = By
            .xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Send']");
    private By buttonYes = By.xpath("//button[contains(text(),'Đồng ý')]");

    private By iconApproveOfFirstItem = By
            .xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Approve']");
    private By ApproveConfirmButton = By.xpath("//button[@id='btnApprove']");

    private By iconPrintOfFirstItem = By
            .xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Print']");

    private By iconCallBackOfFirstItem = By
            .xpath("//table[@id='delivery-table']/tbody[1]/tr[1]/td[12]//button[@title='Callback']");
    private By callBackConfirmButton = By.xpath("//button[@id='btnCallBack']");
    private By chooseStatus = By.xpath("//select[@id='choose_status']");

    private By toastMessage = By.xpath("//div[@id='toast-container']//button[normalize-space()='×']");

    // Element in detail page
    private By totalPrice = By.xpath("//input[@id='total_price']");
    private By returnButton = By.xpath("//button[contains(text(),'Quay lại')]");

    // Hàm xử lý cho trang DeliveryReceiptPage

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

    public void uploadFile() {
        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\TestData\\BOOKING APP.pdf";
        WebUI.setText(chooseFileButton, filePath);
        WebUI.sleep(2);

    }

    public void enterDataAddNewCOD_No() {
        WebUI.zoomConcept("80%", "Chrome");

        if (!WebUI.checkElementIsChecked(CODInput)) {
            WebUI.clickElement(CODLabel);
        }
        WebUI.sleep(1);
        if (!WebUI.checkElementIsChecked(noDepositInput)) {
            WebUI.clickElement(noDepositLabel);
        }
        WebUI.sleep(2);

        WebUI.setText(customerPhone1, "0908081322");
        WebUI.clickElement(customerCodeLable); // blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.setText(customerName, "Rosy Dương");

        // Chọn Tỉnh/Thành
        WebUI.clickElement(provinceName);
        WebUI.waitForElementVisible(provinceDropdown, 5);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Quận/Huyện
        WebUI.clickElement(districtrName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Phường/Xã
        WebUI.clickElement(wardName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        WebUI.setText(customerAddress, "123 Ngô Quyền");
        WebUI.setText(billCode, "HD6512381");

        // Nhập ngày giao hàng trực tiếp hoặc chọn
        WebUI.setText(selectDeliveryDate, currentDay());
        WebUI.pressENTER();

        // Chọn khung giờ
        WebUI.clickElement(deliveryTimeDropdown);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.setText(sapCode, "SAP123");
        WebUI.clearText(numberBag);
        WebUI.setText(numberBag, "1");
        WebUI.clickElement(labelBagPrice);
        WebUI.clearText(bagPrice);
        WebUI.setText(bagPrice, "2000");
        WebUI.setText(giftItem, "No Gift");

        WebUI.clearText(numberProduct);
        WebUI.setText(numberProduct, "1");
        WebUI.sleep(2); // Đợi bảng render

        // Bảng sản phẩm
        WebUI.clickElement(selectSKU);
        WebUI.waitForElementVisible(SKUDropdown, 5);
        WebUI.pressENTER();
        WebUI.sleep(3);

        // Các thông tin khác nếu có
        WebUI.clearText(quanity);
        WebUI.setText(quanity, "1");
        WebUI.clearText(price);
        WebUI.setText(price, "3000000");
        WebUI.clearText(discount);
        WebUI.setText(discount, "0");

        WebUI.setText(extraShippingFee, "0");

        WebUI.scrollToElement(getWebElement(savebutton));
        WebUI.sleep(1);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();
        WebUI.sleep(4);

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed to save COD receipt without deposit");
    }

    public void enterDataAddNewCOD_Yes() {
        WebUI.zoomConcept("80%", "Chrome");

        if (!WebUI.checkElementIsChecked(CODInput)) {
            WebUI.clickElement(CODLabel);
        }
        WebUI.sleep(1);
        if (!WebUI.checkElementIsChecked(yesDepositInput)) {
            WebUI.clickElement(yesDepositLabel);
        }
        WebUI.sleep(2);

        WebUI.setText(customerPhone1, "0908081322");
        WebUI.clickElement(customerCodeLable); // blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.setText(customerName, "Rosy Dương");

        // Chọn Tỉnh/Thành
        WebUI.clickElement(provinceName);
        WebUI.waitForElementVisible(provinceDropdown, 5);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Quận/Huyện
        WebUI.clickElement(districtrName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Phường/Xã
        WebUI.clickElement(wardName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        WebUI.setText(customerAddress, "123 Ngô Quyền");
        WebUI.setText(billCode, "HD6512381");

        // Nhập ngày giao hàng trực tiếp hoặc chọn
        WebUI.setText(selectDeliveryDate, currentDay());
        WebUI.pressENTER();

        // Chọn khung giờ
        WebUI.clickElement(deliveryTimeDropdown);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.setText(sapCode, "SAP123");
        WebUI.clearText(numberBag);
        WebUI.setText(numberBag, "1");
        WebUI.clickElement(labelBagPrice);
        WebUI.clearText(bagPrice);
        WebUI.setText(bagPrice, "2000");
        WebUI.setText(giftItem, "No Gift");

        WebUI.clearText(numberProduct);
        WebUI.setText(numberProduct, "1");
        WebUI.sleep(2); // Đợi bảng render

        // Bảng sản phẩm
        WebUI.clickElement(selectSKU);
        WebUI.waitForElementVisible(SKUDropdown, 5);
        WebUI.pressENTER();
        WebUI.sleep(3);

        // Các thông tin khác nếu có
        WebUI.clearText(quanity);
        WebUI.setText(quanity, "1");
        WebUI.clearText(price);
        WebUI.setText(price, "3000000");
        WebUI.clearText(discount);
        WebUI.setText(discount, "0");

        WebUI.setText(extraShippingFee, "0");

        WebUI.scrollToElement(getWebElement(savebutton));
        WebUI.sleep(1);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();
        WebUI.sleep(4);

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed to save COD receipt with deposit");
    }

    public void enterDataAddNewCDO() {
        WebUI.zoomConcept("80%", "Chrome");
        if (!WebUI.checkElementIsChecked(CDOInput)) {
            WebUI.clickElement(CDOLabel);
        }
        WebUI.sleep(2);

        WebUI.setText(customerPhone1, "0908081322");
        WebUI.clickElement(customerCodeLable); // blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        WebUI.setText(customerName, "Rosy Dương");

        // Chọn Tỉnh/Thành
        WebUI.clickElement(provinceName);
        WebUI.waitForElementVisible(provinceDropdown, 5);
        // WebUI.sleep(4);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Quận/Huyện
        WebUI.clickElement(districtrName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        // Chọn Phường/Xã
        WebUI.clickElement(wardName);
        WebUI.sleep(3);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(2);

        WebUI.setText(customerAddress, "123 Ngô Quyền");
        WebUI.setText(billCode, "HD6512381");

        // Nhập ngày giao hàng trực tiếp hoặc chọn
        WebUI.setText(selectDeliveryDate, currentDay());
        WebUI.pressENTER();

        // Chọn khung giờ
        WebUI.clickElement(deliveryTimeDropdown);
        WebUI.pressDOWN();
        WebUI.pressENTER();

        WebUI.setText(sapCode, "SAP123");
        WebUI.clearText(numberBag);
        WebUI.setText(numberBag, "1");
        WebUI.clickElement(labelBagPrice);
        WebUI.clearText(bagPrice);
        WebUI.setText(bagPrice, "2000");
        WebUI.setText(giftItem, "No Gift");

        WebUI.clearText(numberProduct);
        WebUI.setText(numberProduct, "1");
        WebUI.sleep(2); // Đợi bảng render

        // Bảng sản phẩm
        WebUI.clickElement(selectSKU);
        WebUI.waitForElementVisible(SKUDropdown, 5);
        WebUI.pressENTER();
        WebUI.sleep(3);

        // Các thông tin khác nếu có
        WebUI.clearText(quanity);
        WebUI.setText(quanity, "1");
        WebUI.clearText(price);
        WebUI.setText(price, "3000000");
        WebUI.clearText(discount);
        WebUI.setText(discount, "0");

        WebUI.setText(extraShippingFee, "0");

        WebUI.scrollToElement(getWebElement(savebutton));
        WebUI.sleep(1);

        uploadFile();

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();
        WebUI.sleep(4);

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt), "Failed to save CDO receipt");
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
        WebUI.zoomConcept("80%", "Chrome");
        WebUI.sleep(1);
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

    public String getStatusOfFistItemInTable() {

        String getStatus = WebUI.getElementText(deliveryReceiptStatus);
        return getStatus;
    }

    public String getTotalPriceOfFistItemInTable() {

        WebUI.scrollToElement(getWebElement(totalPrice));
        WebUI.sleep(1);
        String getStatus = WebUI.getElementAttribute(totalPrice, "value");
        return getStatus;
    }

    public void clickSearchButton() {
        WebUI.clickElement(searchButton);
    }

    public void clickDetailButton() {
        WebUI.clickElement(detailButton);
        WebUI.sleep(2);
    }

    public void clickReturnButton() {
        WebUI.scrollToElement(getWebElement(returnButton));
        WebUI.sleep(1);
        WebUI.clickElement(returnButton);
        WebUI.sleep(2);
    }

    public void clickIconSend() {
        WebUI.clickElement(iconSendOfFirstItem);
        sleep(2);
        WebUI.clickElement(buttonYes);
        sleep(5);
    }

    public void clickIconApprove() {
        WebUI.zoomConcept("50%", "Chrome");
        WebUI.clickElement(iconApproveOfFirstItem);
        sleep(2);
        WebUI.clickElement(ApproveConfirmButton);
        sleep(4);
    }

    public void clickIconPrint() {
        WebUI.zoomConcept("50%", "Chrome");
        WebUI.waitForElementVisible(iconPrintOfFirstItem, 3);
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

    public void clickIconCallBack() {
        WebUI.zoomConcept("50%", "Chrome");
        WebUI.clickElement(iconCallBackOfFirstItem);
        WebUI.sleep(2);
    }

    public void clickIconCallBack_Confirm() {
        WebUI.clickElement(callBackConfirmButton);
        WebUI.sleep(2);
    }

    public void clickIconCallBack_exportGoods() {
        WebUI.clickElement(callBackConfirmButton);
        WebUI.sleep(2);
    }

    public void clickIconCallBack_cancelReceipt() {
        WebUI.clickElement(chooseStatus);
        WebUI.sleep(2);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.clickElement(callBackConfirmButton);
        WebUI.sleep(2);
    }

    public void closeToastMessage() {
        WebUI.sleep(1);
        WebUI.waitForElementClickable(toastMessage);
        WebUI.clickElement(toastMessage);
    }

}