package com.DWR.POM.testcases;

import com.DWR.Common.BaseTest;
import com.DWR.Keywords.WebUI;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeliveryReceiptTest extends BaseTest {

    // Hàm tìm kiếm phiếu giao hàng
    public String searchDeliveryReceipt(String typeName) {
        String deliveryReceiptCode;
        switch (typeName) {
            case "CDO":

                // search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("CDO", "Rosy Dương", " ");
                break;

            case "COD_Yes":

                // search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "Yes");
                break;

            case "COD_No":

                // search phiếu vừa tạo
                getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "No");
                break;

        }

        deliveryReceiptCode = getDeliveryReceiptPage().getDeliveryReceiptCodeOfFistItemInTable();

        return deliveryReceiptCode;
    }

    // Hàm tìm kiếm phiếu cọc
    public String searchDepositReceipt() {
        String depositReceiptCode;
        getDepositReceiptPage().searchDepositRecept("Rosy Dương", "Tạo mới");
        depositReceiptCode = getDepositReceiptPage().getDepositReceiptCodeOfFistItemInTable();
        return depositReceiptCode;
    }

    @Test
    public void testAddNewDeliveryReceipt_CDO() {
        // Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // tạo phiếu CDO
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCDO();

    }

    @Test
    public void testAddNewDeliveryReceipt_COD_Yes() {
        // Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // tạo phiếu COD (có cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_Yes();

    }

    @Test
    public void testAddNewDeliveryReceipt_COD_No() {
        // Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // tạo phiếu COD (không cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_No();

    }

    @Test(dependsOnMethods = "testAddNewDeliveryReceipt_CDO")

    public void approveFlow_CDO() {

        // Login G1_FL (Dòng 1 trong Excel)
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // TÌm mã phiếu vừa tạo (không tạo lại phiếu)
        WebUI.sleep(2);
        String code = searchDeliveryReceipt("CDO");
        getDeliveryReceiptPage().searchRecept(code);

        // Click icon send phiếu trên mã phiếu vừa tìm kiếm được
        getDeliveryReceiptPage().clickIconSend();

        // Logout G1_FL , login dòng excel số 4 (G4 OP)
        getLoginPage().Logout("G1_FL");
        getLoginPage().LoginCRM_Excel(4, 4);
        clickDeliveryReceiptPage();

        // Tìm mã phiếu cũ -> G4 OP thao tác duyệt
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // G4 FL click in phiếu đó
        getDeliveryReceiptPage().clickIconPrint();
        WebUI.sleep(3);
        getDeliveryReceiptPage().closePrintDialog();
        WebUI.sleep(5);

        // Logout G4 Op, login MMD, dòng excel số 10
        getLoginPage().Logout("G4_FL");
        getLoginPage().LoginCRM_Excel(9, 9);
        clickDeliveryReceiptPage();

        // Tìm mã cũ và thao tác duyệt
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconCallBack();
        getDeliveryReceiptPage().clickIconCallBack_exportGoods();
        getDeliveryReceiptPage().closeToastMessage();

    }

    @Test(dependsOnMethods = "testAddNewDeliveryReceipt_COD_No")
    // @Parameters({ "type" })
    public void approveFlow_COD_No() {
        // Login G1_FL (Dòng 1 trong Excel)
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // TÌm mã phiếu vừa tạo (không tạo lại phiếu)
        WebUI.sleep(2);
        String code = searchDeliveryReceipt("COD_No");
        getDeliveryReceiptPage().searchRecept(code);

        // Click icon send phiếu trên mã phiếu vừa tìm kiếm được
        getDeliveryReceiptPage().clickIconSend();

        // B1 G2 Cashier duyệt kiểm soát
        getLoginPage().Logout("G1_FL");
        getLoginPage().LoginCRM_Excel(7, 7);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // B2: G4 OP - phê duyệt
        getLoginPage().Logout("G2_Cashier");
        getLoginPage().LoginCRM_Excel(4, 4);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // B3: G4 Op - in đơn
        getDeliveryReceiptPage().clickIconPrint();
        WebUI.sleep(3);
        getDeliveryReceiptPage().closePrintDialog();
        WebUI.sleep(5);

        // B4: G1 MMD - xuất hàng
        getLoginPage().Logout("G4_FL");
        getLoginPage().LoginCRM_Excel(9, 9);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconCallBack();
        getDeliveryReceiptPage().clickIconCallBack_exportGoods();
        getDeliveryReceiptPage().closeToastMessage();

    }

    @Test(dependsOnMethods = "testAddNewDeliveryReceipt_COD_Yes")
    public void approveFlow_COD_Yes() {
        // Login G1_FL (Dòng 1 trong Excel)
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // TÌm mã phiếu vừa tạo (không tạo lại phiếu)
        WebUI.sleep(2);
        String code = searchDeliveryReceipt("COD_Yes");
        getDeliveryReceiptPage().searchRecept(code);

        // Click icon send phiếu trên mã phiếu vừa tìm kiếm được
        getDeliveryReceiptPage().clickIconSend();

        // B1 G2 Cashier tạo phiếu cọc
        getLoginPage().Logout("G1_FL");
        getLoginPage().LoginCRM_Excel(7, 7);
        clickDepositReceiptPage();
        getDepositReceiptPage().clickAddNewButton();
        getDepositReceiptPage().enterDataAddNewDeposit(code);
        // String depositCode =
        // getDepositReceiptPage().getDepositReceiptCodeOfFistItemInTable();

        // B1 G2 Cashier duyệt kiểm soát
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // B2: G4 OP - phê duyệt
        getLoginPage().Logout("G2_Cashier");
        getLoginPage().LoginCRM_Excel(4, 4);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconApprove();

        // B3: G4 Op - in đơn
        getDeliveryReceiptPage().clickIconPrint();
        WebUI.sleep(3);
        getDeliveryReceiptPage().closePrintDialog();
        WebUI.sleep(5);

        // B4: G1 MMD - xuất hàng
        getLoginPage().Logout("G4_FL");
        getLoginPage().LoginCRM_Excel(9, 9);
        clickDeliveryReceiptPage();
        getDeliveryReceiptPage().searchRecept(code);
        getDeliveryReceiptPage().clickIconCallBack();
        getDeliveryReceiptPage().clickIconCallBack_exportGoods();
        getDeliveryReceiptPage().closeToastMessage();

    }

    @Test(dependsOnMethods = "approveFlow_CDO")
    @Parameters({ "type" })
    public void confirmSuccessfullDelivery(String type) {
        // G1 OP hoặc G2 Cashier xác nhận giao hàng thành công
        if (type.equals("CDO")) {
            getLoginPage().LoginCRM_Excel(1, 1);
            clickDeliveryReceiptPage();
            String code = searchDeliveryReceipt(type);
            getDeliveryReceiptPage().searchRecept(code);
            getDeliveryReceiptPage().clickIconCallBack();
            getDeliveryReceiptPage().clickIconCallBack_Confirm();
        } else if (type.equals("COD_No") || type.equals("COD_Yes")) {
            getLoginPage().LoginCRM_Excel(7, 7);
            clickDeliveryReceiptPage();
            String code = searchDeliveryReceipt(type);
            getDeliveryReceiptPage().searchRecept(code);
            getDeliveryReceiptPage().clickIconCallBack();
            getDeliveryReceiptPage().clickIconCallBack_Confirm();
        }
    }

    @Test(dependsOnMethods = "approveFlow_CDO")
    @Parameters({ "type" })
    public void cancellation(String type) {
        // G2 OP - Hủy
        getLoginPage().LoginCRM_Excel(2, 2);
        clickDeliveryReceiptPage();
        String code = searchDeliveryReceipt(type);
        getCancelledDeliveryReceiptPage().searchRecept(code);
        getCancelledDeliveryReceiptPage().clickIconCallBack();
        getCancelledDeliveryReceiptPage().clickIconCallBack_cancelReceipt(type);
        getCancelledDeliveryReceiptPage().closeToastMessage();

        // check status
        String status = getCancelledDeliveryReceiptPage().getStatusOfFistItemInTable();
        Assert.assertTrue(status.contains("Chờ hủy"), "Error! Phiếu không chuyển sang tự hủy");

    }

    @Test
    public void checkCancellationReceipt_8p() {
        testAddNewDeliveryReceipt_COD_No();
        WebUI.sleep(1);

        // compare status after n+8 days = 8 minutes
        WebUI.sleep(480);
        getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "No");
        WebUI.sleep(2);
        String getStatus = getDeliveryReceiptPage().getStatusOfFistItemInTable();

        if (getStatus != "Giao hàng thành công" || getStatus != "Từ chối" || getStatus != "Đã hủy") {
            // Assert.assertTrue(condition, message); condition phải trar về true or false
            Assert.assertTrue(getStatus.contains("Chờ hủy"), "Error! Phiếu không chuyển sang tự hủy");
        }

    }

    @Test
    public void checkCancellationReceipt_4p() {
        // Login
        getLoginPage().LoginCRM_Excel(1, 1);
        clickDeliveryReceiptPage();

        // tạo phiếu COD (không cọc)
        WebUI.sleep(3);
        getDeliveryReceiptPage().clickAddNewButton();
        WebUI.waitForPageLoaded();
        getDeliveryReceiptPage().enterDataAddNewCOD_No();
        WebUI.sleep(1);

        // compare status after n+8 days = 8 minutes
        WebUI.sleep(240);
        getDeliveryReceiptPage().searchRecept("COD", "Rosy Dương", "No");
        WebUI.sleep(2);
        String getStatus = getDeliveryReceiptPage().getStatusOfFistItemInTable();

        if (getStatus != "Giao hàng thành công" || getStatus != "Từ chối" || getStatus != "Đã hủy") {
            // Assert.assertTrue(condition, message); condition phải trar về true or false
            Assert.assertTrue(getStatus.contains("Chờ hủy"), "Error! Phiếu không chuyển sang tự hủy");
        }

    }

    @Test
    public void testt() {

        getLoginPage().LoginCRM_Excel(7, 7);
        clickDepositReceiptPage();
        getDepositReceiptPage().clickAddNewButton();
        getDepositReceiptPage().enterDataAddNewDeposit("190320260000");

    }
}
