package com.DWR.driver;

import org.openqa.selenium.WebDriver;

public class driverManager {
    //khi bạn chạy test song song (parallel test), mỗi thread sẽ có driver riêng biệt → không bị đè lẫn nhau.
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private driverManager() {}

    //driver.get() sẽ trả về WebDriver mà thread đang giữ.
    public static WebDriver getDriver() {
        return driver.get();
    }

    //Khi khởi tạo browser (Chrome, Firefox…), bạn gọi setDriver(driver) để lưu nó vào ThreadLocal.
    public static void setDriver(WebDriver driver) {
        driverManager.driver.set(driver);
    }

    //Hàm static để quit browser và xóa driver khỏi ThreadLocal.
    public static void quit() {
        driverManager.driver.get().quit();
        driver.remove();
    }

}

/*
* driverManager = trung tâm quản lý vòng đời WebDriver trong framework.
* Đảm bảo mỗi test case chạy song song có WebDriver riêng.
* Giúp code test và Page Object chỉ cần gọi driverManager.getDriver() mà không phải tự giữ biến WebDriver.
 */
