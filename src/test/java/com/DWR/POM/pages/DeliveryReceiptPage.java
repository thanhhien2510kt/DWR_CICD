package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DeliveryReceiptPage extends CommonPage {

    //Element
    private By buttonAddNew = By.xpath("//i[normalize-space()='add']");

    private By CDOCheckBox = By.xpath("//input[@id='typeCDO']");
    private By CODCheckBox = By.xpath("//input[@id='typeCOD']");

    private By noDepositCheckBox = By.xpath("//label[@for='deposit_no']");
    private By yesDepositCheckBox = By.xpath("//label[@for='deposit_yes']");

    private By customerCode = By.xpath("//input[@id='CustomerCode']");
    private By selectDeliveryDate = By.xpath("//input[@id='DeliveryDate']");
    private By itemDeliveryDate = By.xpath("//div[@aria-label='"+currentDay()+"']");
    private By billCode = By.xpath("//input[@id='BillCode']");
    private By numberProduct = By.xpath("//input[@id='NumberProduct']");

    private By selectSKU = By.xpath("//span[normalize-space()='Chọn mã sản phẩm']");
    private By SearchSKU = By.xpath("//input[@placeholder='Nhập từ khóa tìm kiếm']");

    private By quayHang = By.xpath("//tbody//th[4]/input");
    private By nganhHang = By.xpath("//tbody//th[5]/input");
    private By quanity = By.xpath("//tbody//th[6]/input");
    private By price = By.xpath("//tbody//th[7]/input");
    private By discount = By.xpath("//tbody//th[8]/input");

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
        WebUI.clickElement(selectDeliveryDate);
        WebUI.sleep(1);
        WebUI.clickElement(itemDeliveryDate);
        WebUI.setText(billCode,"HD6512381" );
        WebUI.setText(numberProduct,"1" );
        WebUI.clickElement(selectSKU);
        WebUI.sleep(1);
        WebUI.setText(SearchSKU,"02478333" );
        WebUI.setText(quayHang,"A" );
        WebUI.setText(nganhHang,"FL" );
        WebUI.setText(quanity,"1" );
        WebUI.setText(price,"560000" );
        WebUI.setText(discount,"10" );

    }


}