package com.DWR.Common;

import com.DWR.Listeners.TestListener;
import com.DWR.POM.pages.CommonPage;
import com.DWR.driver.driverManager;
import com.DWR.helpers.CaptureHelper;
import com.DWR.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(TestListener.class)

public class BaseTest extends CommonPage {

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver;
        if(PropertiesHelper.getValue("BROWSER") != null && !PropertiesHelper.getValue("BROWSER").isEmpty()){
            driver = setupDriver(PropertiesHelper.getValue("BROWSER"));

        }else {
            driver = setupDriver(browser);
        }

        driverManager.setDriver(driver); // gán giá trị driver và trong thread local
    }

    public WebDriver setupDriver(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void CloseDriver(){
        driverManager.quit();
    }


}
