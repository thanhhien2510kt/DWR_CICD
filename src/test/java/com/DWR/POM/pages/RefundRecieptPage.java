package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.DWR.Keywords.WebUI.sleep;

public class RefundRecieptPage {
    // Element Add
    private By buttonAddNew = By.xpath("//span[contains(text(),'Thêm mới')]");

    private By checkboxExchangeType = By.xpath("//input[@id='exchange_type']");
    private By exchangeType = By.xpath("//label[@for='exchange_type']");
    private By checkboxGoodsreturnType = By.xpath("//input[@id='goodsreturn_type']");
    private By goodsreturnType = By.xpath("//label[@for='goodsreturn_type']");
    private By customerName = By.xpath("//input[@id='customer_name']");
    private By customerPhone = By.xpath("//input[@id='customer_phone']");
    private By deliveryDate = By.xpath("//input[@id='delivery_date']");
    private By itemDeliveryDate = By.xpath("//div[@aria-label='"+currentDay()+"']");
    private By moneyReceive = By.xpath("//input[@id='money_receive']");
    private By boughtDate = By.xpath("//input[@id='bought_date']");
    private By itemBoughtDate = By.xpath("//div[@aria-label='"+currentDay()+"']");
    private By reasonReturn = By.xpath("//textarea[@id='reason_return']");

    // Hàm xử lý cho trang RefundRecieptPage
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

    public void enterDataAddNewRefundReciept(String type, String situation ) {
        WebUI.waitForPageLoaded();

        if (type == "Đổi hàng"){
            WebUI.clickCheckBox(checkboxExchangeType,exchangeType);
        }else {
            WebUI.clickCheckBox(checkboxGoodsreturnType,goodsreturnType);
        }

        WebUI.clickElement(customerName);
        WebUI.setText(customerName,"Rosy Dương");

        WebUI.clickElement(customerPhone);
        WebUI.setText(customerPhone,"0343177955");

        WebUI.clickElement(deliveryDate);
        WebUI.clickElement(itemDeliveryDate);

        WebUI.clickElement(boughtDate);
        WebUI.sleep(1);
        WebUI.pressENTER();
        //WebUI.clickElement(itemBoughtDate);

        WebUI.clickElement(moneyReceive);
        WebUI.setText(moneyReceive,"2000000");


        WebUI.clickElement(reasonReturn);
        WebUI.setText(reasonReturn,"Hàng lỗi");

//        if (type == "Normal"){
//            WebUI.clickCheckBox(exchangeType);
//        }else {
//            WebUI.clickCheckBox(goodsreturnType);
//        }













        //WebUI.clickElement(savebutton);
        //WebUI.waitForPageLoaded();

        //Assert.assertTrue(WebUI.checkElementExist(headerWarantyReceipt), "Failed login");


    }

}
