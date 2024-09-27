package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.DWR.Keywords.WebUI.getWebElement;
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

    private By checkboxNormal = By.xpath("//input[@id='exchange_return_payment_default']");
    private By normalType = By.xpath("//label[contains(text(),'Bình thường')]");

    private By checkboxSpecial = By.xpath("//input[@id='exchange_return_payment_spec']");
    private By specialType = By.xpath("//label[contains(text(),'Đặc biệt')]");


    private By addButton_invoid = By.xpath("//table[@id='bill_infor_table']/thead/tr/th[7]//i[normalize-space()='add']");
    private By SKU_invoid = By.xpath("//table[@id='bill_infor_table']/tbody/tr/th[1]//span[contains(text(),'Chọn mã sản phẩm')]");
    private By quantity_invoid = By.xpath("//table[@id='bill_infor_table']/tbody/tr/th[3]//input[@name='product_quantity']");
    private By price_invoid = By.xpath("//table[@id='bill_infor_table']/tbody/tr/th[4]//input[@name='product_price']");
    private By seri_invoid = By.xpath("//table[@id='bill_infor_table']/tbody/tr/th[6]//input[@class='product_seri form-control col-date']");

    private By addButton_update = By.xpath("//table[@id='update_info_table']/thead/tr/th[7]//i[normalize-space()='add']");
    private By SKU_update = By.xpath("//table[@id='update_info_table']/tbody/tr/th[1]//span[contains(text(),'Chọn mã sản phẩm')]");
    private By quantity_update = By.xpath("//table[@id='update_info_table']/tbody/tr/th[3]//input[@name='product_quantity']");
    private By price_update = By.xpath("//table[@id='update_info_table']/tbody/tr/th[4]//input[@name='product_price']");
    private By seri_update = By.xpath("//table[@id='update_info_table']/tbody/tr/th[6]//input[@class='product_seri form-control col-date']");


    private By note = By.xpath("//input[@id='note']");

    private By saveButton = By.xpath("//button[contains(text(),'Lưu')]");
    private By headerRefundReceipt = By.xpath("//h2[contains(text(),'Danh sách phiếu đổi trả')]");

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

    public void enterDataAddNewRefundReciept(String type, String situation, String paymentMethodPriorToReturn, String refundMethod, String price_before, String price_after )  {
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

        if (situation == "Normal"){
            WebUI.clickCheckBox(checkboxNormal, normalType);
        }else {
            WebUI.clickCheckBox(checkboxSpecial, specialType);
        }

        WebUI.clickElement(By.xpath("(//label[contains(text(),'Hình thức thanh toán trước đổi/trả')]/parent::div)/following-sibling::div//label[normalize-space()=\""+paymentMethodPriorToReturn+"\"]"));
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("(//label[contains(text(),'Hình thức hoàn tiền')]/parent::div)/following-sibling::div//label[normalize-space()=\""+refundMethod+"\"]"));

        WebUI.scrollToElementOnBottom(saveButton);
        WebUI.sleep(2);


        WebUI.clickElement(addButton_invoid);
        WebUI.sleep(1);

        WebUI.clickElement(SKU_invoid);
        WebUI.sleep(3);
        WebUI.pressENTER();

        WebUI.clickElement(quantity_invoid);
        WebUI.setText(quantity_invoid,"1");

        WebUI.clickElement(price_invoid);
        WebUI.setText(price_invoid,price_before);
        WebUI.sleep(2);

        WebUI.clickElement(seri_invoid);
        WebUI.setText(seri_invoid,"123456789");
        WebUI.sleep(2);

        if(type == "Đổi hàng"){

            WebUI.clickElement(addButton_update);
            WebUI.sleep(1);

            WebUI.clickElement(SKU_update);
            WebUI.sleep(3);
            WebUI.pressENTER();

            WebUI.clickElement(quantity_update);
            WebUI.setText(quantity_update,"1");

            WebUI.clickElement(price_update);
            WebUI.setText(price_update,price_after);
            WebUI.sleep(2);

            WebUI.clickElement(seri_update);
            WebUI.setText(seri_update,"123456789");

        }

        WebUI.scrollToElementOnBottom(saveButton);
        WebUI.sleep(2);

        WebUI.clickElement(note);
        WebUI.setText(note, "Không");

        WebUI.clickElement(saveButton);
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(headerRefundReceipt), "Failed create");


    }

}
