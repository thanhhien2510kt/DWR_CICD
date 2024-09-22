package com.DWR.POM.testcases;

import com.DWR.POM.pages.LoginPage;
import com.DWR.Common.BaseTest;
import com.DWR.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ExcelHelper excelHelper;
    @Test
    public void testLoginSucess (){
        loginPage  = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Sheet3");


        for ( int i = 1 ; i <= 3 ; i ++){
            loginPage.LoginCRM(
                    excelHelper.getCellData("EMAIL",i),
                    excelHelper.getCellData("PASSWORD",i)
            );
            loginPage.verifyLoginSuccess();
            loginPage.Logout();
        }
        excelHelper.setCellData("Passed","STATUS", 1);

    }

    @Test
    public void testLoginFailWithEmailInvalid (){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Sheet1");

        loginPage.LoginCRM(
                excelHelper.getCellData("EMAIL",2),
                excelHelper.getCellData("PASSWORD",2)
        );

        loginPage.verifyLoginFail("Invalid email or password");
        excelHelper.setCellData("Failed","STATUS", 2);
    }

    @Test
    public void testLoginFailWithPasswordInvalid (){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Sheet1");


        loginPage.LoginCRM(
                excelHelper.getCellData("EMAIL",3),
                excelHelper.getCellData("PASSWORD",3)
        );
        loginPage.verifyLoginFail("Invalid email or password");
//        loginPage.Logout();
        excelHelper.setCellData("Failed","STATUS", 3);


    }

    @Test
    public void testLoginFailWithPasswordNull (){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Sheet1");

        loginPage.LoginCRM(
                excelHelper.getCellData("EMAIL",4),
                excelHelper.getCellData("PASSWORD",4)
        );

        loginPage.verifyLoginFail("The Password field is required.");
        excelHelper.setCellData("Failed","STATUS", 4);
    }

    @Test
    public void testLoginFailWithEmailNull (){
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/TestData/Login.xlsx","Sheet1");

        loginPage.LoginCRM(
                excelHelper.getCellData("EMAIL",5),
                excelHelper.getCellData("PASSWORD",5)
        );
        loginPage.verifyLoginFail("The Email Address field is required.");
        excelHelper.setCellData("Failed","STATUS", 5);
    }
}
