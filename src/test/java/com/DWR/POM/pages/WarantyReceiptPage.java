package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.DWR.Keywords.WebUI.*;

public class WarantyReceiptPage extends CommonPage {
    //Element Add
    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");

    private By storeCode = By.xpath("(//div/label[text()='Mã cửa hàng']/parent::div)/following-sibling::div//span[@role='combobox']");

    private By customerName = By.xpath("//input[@id='customer_name']");
    private By customerAddress = By.xpath("//input[@id='customer_address']");
    private By customerPhone = By.xpath("//input[@id='customer_phone']");
    private By productnumber = By.xpath("//input[@id='number_product']");
    private By billCode = By.xpath("//input[@id='bill_code']");
    private By purchaseOrderCode = By.xpath("//input[@id='purchase_order_code']");

    private By selectSKU = By.xpath("//span[normalize-space()='Chọn mã sản phẩm']");
    private By SearchSKU = By.xpath("//input[@placeholder='Nhập từ khóa tìm kiếm']");
    private By quayHang = By.xpath("//tbody//th[4]/input");
    private By nganhHang = By.xpath("//tbody//th[5]/input");
    private By brand = By.xpath("//tbody//th[6]/input");
    private By form = By.xpath("//tbody//th[7]/input");
    private By seri = By.xpath("//tbody//th[8]/input");
    private By note = By.xpath("//tbody//th[9]/input");
    private By replacementContent = By.xpath("//tbody//th[10]/input");

    private By savebutton = By.xpath("//button[contains(text(),'Lưu')]");
    private By headerWarantyReceipt = By.xpath("//h2[contains(text(),'Danh sách phiếu tiếp nhận bảo hành')]");

    // Element Search
    private By searchCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchStatus = By.xpath("(//label[contains(text(),'Trạng thái phiếu')]//parent::div)//following-sibling::div//span[@role='combobox']");

    private By searchButton = By.xpath("//span[contains(text(),'Tìm kiếm')]");

    //private By iconPrintOfFirstItem = By.xpath("//table[@id='storetable']/tbody[1]/tr[1]/td[8]//button[@title='In phiếu']");
    private By iconPrintOfFirstItem = By.xpath("//tbody/tr[1]/td[8]/div[1]/button[2]");
    private By statusOfFirstItem = By.xpath("//tbody/tr[1]/td[7]");

    private By signButtonOfFirstItem = By.xpath("//table[@id='storetable']/tbody[1]/tr[1]/td[8]//button[@title='Ký online']");
    private By signArea = By.xpath("//canvas[@id='signature-pad']");
    private By saveSign = By.xpath("//button[@id='save-signature']");

    //Hàm xử lý cho trang WarantyReceiptPage
    public void clickAddNewButton() {
        WebUI.clickElement(buttonAddNew);
    }

    public void enterDataAddNewWarrantyReceipt() {
        WebUI.waitForPageLoaded();

        WebUI.clickElement(storeCode);
        WebUI.sleep(1);
        WebUI.pressDOWN();
        WebUI.pressENTER();
        WebUI.sleep(1);

        WebUI.clickElement(customerName);
        WebUI.setText(customerName, "Rosy Dương");
        WebUI.sleep(1);

        WebUI.clickElement(customerAddress);
        WebUI.setText(customerAddress, "54 Lưu Nhân Chú, Tam Kỳ, Quảng Nam");
        WebUI.sleep(1);

        WebUI.clickElement(customerPhone);
        WebUI.setText(customerPhone, "0343177956");
        WebUI.sleep(1);

        WebUI.clickElement(productnumber);
        WebUI.setText(productnumber, "1");
        WebUI.sleep(1);

        WebUI.clickElement(billCode);
        WebUI.setText(billCode, "HD123456789");
        WebUI.sleep(1);

        WebUI.clickElement(purchaseOrderCode);
        WebUI.setText(purchaseOrderCode, "123456789");
        WebUI.sleep(1);

        WebUI.clickElement(selectSKU);
        WebUI.waitForPageLoaded();
        WebUI.setText(SearchSKU, "023");
        sleep(2);
        WebUI.pressENTER();
        sleep(4);
        WebUI.setText(quayHang, "A");
        sleep(1);
        WebUI.setText(nganhHang, "HL");
        sleep(1);
        WebUI.setText(brand, "Dell");
        sleep(1);
        WebUI.setText(form, "Hộp");
        sleep(1);
        WebUI.setText(seri, "123456789");
        sleep(1);
        WebUI.setText(note, "Không");
        sleep(1);
        WebUI.setText(replacementContent, "Pin");


        WebUI.scrollToElement(getWebElement(savebutton));
        WebUI.sleep(1);
        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerWarantyReceipt), "Failed login");


    }

    public void searchWarrantyReceipt (String customerName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(searchCustomerName);
        WebUI.setText(searchCustomerName,customerName);
        WebUI.clickElement(searchStatus);
        WebUI.pressUP();
        WebUI.pressENTER();

        WebUI.clickElement(searchButton);
        WebUI.sleep(2);
    }

    public void sign (){
        WebUI.zoomConcept("70%", "Chrome");
        WebUI.clickElement(signButtonOfFirstItem);
        WebUI.switchToWindow(signArea,saveSign);
        WebUI.sleep(2);
    }

    public void clickIconPrint (){
        WebUI.waitForPageLoaded();
        String MainWindowAfter2 = driverManager.getDriver().getWindowHandle();
        System.out.println("Quay lại cửa sổ thứ 1 tại hàm clickIconPrint: " + MainWindowAfter2);
        sleep(3);
        WebUI.checkElementExist(iconPrintOfFirstItem);
        WebUI.clickElement(iconPrintOfFirstItem);
        WebUI.sleep(3);
        WebUI.pressENTER();
        WebUI.sleep(1);
        WebUI.clickElement(searchButton);
        WebUI.sleep(2);
        WebUI.assertEquals(getElementText(statusOfFirstItem),"Chờ xuất hàng đi bảo hành/ sửa chữa", "Print không thành công");

    }
}
