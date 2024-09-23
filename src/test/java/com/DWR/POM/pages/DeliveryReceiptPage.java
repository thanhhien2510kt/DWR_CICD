package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import com.DWR.driver.driverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DeliveryReceiptPage extends CommonPage {

    //Element
    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");

    private By CDOCheckBox = By.xpath("//label[normalize-space()='CDO']");
    private By CODCheckBox = By.xpath("//label[normalize-space()='COD']");

    private By noDepositCheckBox = By.xpath("//label[@for='deposit_no']");
    private By yesDepositCheckBox = By.xpath("//label[@for='deposit_yes']");

    private By customerCode = By.xpath("//input[@id='CustomerCode']");
    private By customerCodeLable = By.xpath("//label[contains(text(),'Mã thẻ thành viên')]");

    private By selectDeliveryDate = By.xpath("//div[@class='form-line selectlist']/child::input[@id=\"DeliveryDate\"]");
    private By itemDeliveryDate = By.xpath("//div[@aria-label='"+currentDay()+"']");
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

    private By savebutton = By.xpath("//button[contains(text(),'Lưu')]");

    private By headerDeliveryReceipt = By.xpath("//h2[contains(text(),'Danh Sách Phiếu Giao Hàng')]");


    //Hàm xử lý cho trang DeliveryReceiptPage

    public String currentDay (){
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

    public void enterDataAddNewCOD_No () {

        WebUI.clickElement(CODCheckBox);
        WebUI.clickElement(noDepositCheckBox);
        WebUI.setText(customerCode,"3003228094" );
        WebUI.clickElement(customerCodeLable); //blur chuột ra ngoài để load customercode
        WebUI.waitForPageLoaded();

        WebUI.clickElement(selectDeliveryDate);
        WebUI.sleep(3);
        WebUI.clickElement(itemDeliveryDate);
        WebUI.sleep(3);

        WebUI.setText(billCode,"HD6512381" );
        WebUI.clickElement(numberProduct);
        WebUI.setText(numberProduct,"1" );
        WebUI.sleep(2);
        WebUI.clickElement(selectSKU);
        WebUI.waitForPageLoaded();
        WebUI.setText(SearchSKU,"023" );
        WebUI.sleep(2);
        WebUI.pressENTER();
        WebUI.sleep(2);
        WebUI.setText(quayHang,"A" );
        WebUI.sleep(1);
        WebUI.setText(nganhHang,"FL" );
        WebUI.sleep(1);
        WebUI.setText(quanity,"1" );
        WebUI.sleep(1);
        WebUI.setText(price,"560000" );
        WebUI.sleep(1);
        WebUI.setText(discount,"10" );
        WebUI.sleep(1);

        WebUI.scrollToElement(driverManager.getDriver().findElement(savebutton));
        WebUI.sleep(2);

        WebUI.clickElement(savebutton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerDeliveryReceipt),"Failed login");


    }


}