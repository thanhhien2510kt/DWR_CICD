package com.DWR.POM.pages;

import com.DWR.Keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static com.DWR.Keywords.WebUI.getWebElement;
import static com.DWR.Keywords.WebUI.sleep;

public class RefundRecieptPage {
    // Element Add
    private By buttonAddNew = By.xpath("//span[contains(text(),'Thêm mới')]");

    private By checkboxExchangeType = By.xpath("//input[@id='exchange_type']");
    private By exchangeType = By.xpath("//label[@for='exchange_type']");
    private By checkboxGoodsreturnType = By.xpath("//input[@id='goodsreturn_type']");
    private By goodsreturnType = By.xpath("//label[@for='goodsreturn_type']");
    private By storeCode = By.xpath("(//label[normalize-space()='Mã cửa hàng']/parent::div)/following-sibling::div//span[@role='combobox']");
    private By customerName = By.xpath("//input[@id='customer_name']");
    private By customerPhone = By.xpath("//input[@id='customer_phone']");
    private By invoiceCode = By.xpath("//input[@id='invoice_code']");
    private By boughtDate = By.xpath("//input[@id='bought_date']");
    private By itemBoughtDate = By.xpath("//div[@aria-label='"+currentDay()+"']");
    private By ReturnAndExchangeTerms = By.xpath("//label[contains(text(),'Đổi hàng cùng loại cùng giá')]");
    private By checkboxReturnAndExchangeTerms = By.xpath("//input[@id='returns_same']");
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

    // search
    private By searchCustomerName = By.xpath("//input[@id='customer_name']");
    private By searchStatus = By.xpath("(//label[contains(text(),'Trạng thái phiếu')]/parent::div)/following-sibling::div//span[@role='combobox']");
    private By itemSearchStatus = By.xpath("//input[@id='customer_name']");
    private By searchButton = By.xpath("//i[normalize-space()='search']");

    private By sendIconOfFistItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[10]//button[@title='Gửi xác nhận phiếu']");
    private By confirmButton = By.xpath("//button[@id='btnApprove']");
    private By approveIconOfFistItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[10]//button[@title='Xác nhận phiếu đổi trả']");
    private By detailIconOfFistItem = By.xpath("//table[@id='wd_table']/tbody[1]/tr[1]/td[10]//button[@title='Detail']");
    private By normalCheckbox = By.xpath("(//label[contains(text(),'Trường hợp thanh toán đổi/trả')]/parent::div)/following-sibling::div//input[@id='exchange_return_payment_default']");
    private By normalLabel = By.xpath("//label[contains(text(),'Bình thường')]");
    private By specialCheckbox = By.xpath("(//label[contains(text(),'Trường hợp thanh toán đổi/trả')]/parent::div)/following-sibling::div//input[@id='exchange_return_payment_spec']");
    private By specialLabel = By.xpath("//label[contains(text(),'Đặc biệt')]");
    private By differentvalue = By.xpath("//input[@id='compare_value']");
    private By returnButton = By.xpath("//button[normalize-space()='Quay lại']");

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

    public void search (String customerName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(searchCustomerName);
        WebUI.setText(searchCustomerName,customerName);
        WebUI.sleep(1);
        WebUI.clickElement(searchStatus);
        WebUI.sleep(2);
        WebUI.clickElement(itemSearchStatus);
        WebUI.sleep(2);

        WebUI.clickElement(searchButton);
        WebUI.sleep(2);
    }

    public void clickDetailButton (){
        WebUI.clickElement(detailIconOfFistItem);
        WebUI.sleep(2);
    }

    public Map<String, Object> getInfoFromDetailScreen (String fiel1, String field2){

        Map<String, Object> info = new HashMap<>();

        //get refundPaymentMethod
        Boolean checkNormal = WebUI.checkElementIsChecked(normalCheckbox);
        Boolean checkSpecial = WebUI.checkElementIsChecked(specialCheckbox);

        if (checkSpecial){
            String refundPaymentMethod = WebUI.getElementText(specialLabel);
            info.put("refundPaymentMethod",refundPaymentMethod );
            //System.out.println("Get text: " + WebUI.getElementText(specialLabel));
        }
        if (checkNormal){
            String refundPaymentMethod = WebUI.getElementText(normalLabel);
            info.put("refundPaymentMethod",refundPaymentMethod );
        }

        //get different amount
        WebUI.scrollToElement(getWebElement(returnButton));
        WebUI.sleep(2);
        String differentAmount = WebUI.getElementAttribute(differentvalue, "value");
        info.put("differentAmount", differentAmount);

        WebUI.clickElement(returnButton);
        return info;
    }

    public void send (){
        WebUI.sleep(1);
        WebUI.clickElement(sendIconOfFistItem);
        WebUI.sleep(1);
        WebUI.clickElement(confirmButton);
    }

    public void approve (){
        WebUI.sleep(1);
        WebUI.clickElement(approveIconOfFistItem);
        WebUI.sleep(1);
        WebUI.clickElement(confirmButton);
        WebUI.sleep(3);
    }



    public void enterDataAddNewRefundReciept(String type, String term, String situation, String paymentMethodPriorToReturn, String refundMethod, String price_before, String price_after )  {
        WebUI.waitForPageLoaded();
        WebUI.zoomConcept("70%", "Chrome");

        if (type == "Đổi hàng" ){
            WebUI.clickCheckBox(checkboxExchangeType,exchangeType);
        }else {
            WebUI.clickCheckBox(checkboxGoodsreturnType,goodsreturnType);
        }

        WebUI.clickElement(storeCode);
        WebUI.sleep(2);
        WebUI.pressENTER();

        WebUI.clickElement(customerName);
        WebUI.setText(customerName,"Rosy Dương");

        WebUI.clickElement(customerPhone);
        WebUI.setText(customerPhone,"0343177955");

        WebUI.clickElement(boughtDate);
        WebUI.sleep(1);
        WebUI.pressENTER();
        //WebUI.clickElement(itemBoughtDate);

        WebUI.clickElement(invoiceCode);
        WebUI.setText(invoiceCode,"HD241821321");


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

        if(type == "Đổi hàng" & term == "Đổi hàng cùng loại cùng giá"){
            WebUI.clickCheckBox(checkboxReturnAndExchangeTerms, ReturnAndExchangeTerms );

            WebUI.clickElement(addButton_update);
            WebUI.sleep(1);

            WebUI.clickElement(quantity_update);
            WebUI.setText(quantity_update,"1");
            WebUI.sleep(1);


            WebUI.clickElement(seri_update);
            WebUI.setText(seri_update,"123456789");

        } else if (type == "Đổi hàng" & term == "Đổi hàng khác loại khác giá" ) {
            WebUI.clickCheckBox(
                    By.xpath("//input[@id='returns_difference']"),
                    By.xpath("//label[contains(text(),'"+term+"')]")
                    );

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
        } else if (type == "Đổi hàng" & term == "Khác" ) {
            WebUI.clickCheckBox(
                    By.xpath("//input[@id='returns_other']"),
                    By.xpath("//input[@id='returns_other']/following-sibling::label")
            );
            WebUI.sleep(1);

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
