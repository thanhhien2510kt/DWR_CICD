package com.DWR.POM.testcases;

import com.DWR.POM.pages.LoginPage;
import com.DWR.Common.BaseTest;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

//BaseTest có chứa các annotation TestNG như @BeforeMethod và @AfterMethod.
//TestNG khi chạy test sẽ tự động gọi các method trong class cha (nếu có annotation).

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ExcelHelper excelHelper;

    @Test
    public void testLoginSucess() {
        // getLoginPage() là hàm được kế thừa từ CommonPage (class cha của BaseTest),
        // trả về một LoginPage.
        getLoginPage().LoginCRM_Excel(1, 1);

    }

    @Test
    public void testLoginFailWithEmailInvalid() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx", "LoginFail");

        loginPage.LoginCRM_Fail(
                excelHelper.getCellData("USERNAME", 1),
                excelHelper.getCellData("PASSWORD", 1));

        loginPage.verifyLoginFail("Username/password not correct");
        excelHelper.setCellData("Failed", "STATUS", 2);
    }

    @Test
    public void testLoginFailWithPasswordInvalid() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx", "LoginFail");

        loginPage.LoginCRM_Fail(
                excelHelper.getCellData("USERNAME", 2),
                excelHelper.getCellData("PASSWORD", 2));
        loginPage.verifyLoginFail("Username/password not correct");
        // loginPage.Logout();
        excelHelper.setCellData("Failed", "STATUS", 3);

    }

    @Test
    public void testLoginFailWithPasswordNull() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx", "LoginFail");

        loginPage.LoginCRM_Fail(
                excelHelper.getCellData("USERNAME", 3),
                excelHelper.getCellData("PASSWORD", 3));

        loginPage.verifyLoginFail("Username/password not correct");
        excelHelper.setCellData("Failed", "STATUS", 4);
    }

    @Test
    public void testLoginFailWithEmailNull() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx", "LoginFail");

        loginPage.LoginCRM_Fail(
                excelHelper.getCellData("USERNAME", 4),
                excelHelper.getCellData("PASSWORD", 4));
        loginPage.verifyLoginFail("Username/password not correct");
        excelHelper.setCellData("Failed", "STATUS", 5);
    }
}
