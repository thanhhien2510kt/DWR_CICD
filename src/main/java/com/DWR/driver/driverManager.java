package com.DWR.driver;


import org.openqa.selenium.WebDriver;

public class driverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private driverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        driverManager.driver.set(driver);
    }

    public static void quit() {
        driverManager.driver.get().quit();
        driver.remove();
    }
}
