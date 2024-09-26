package com.DWR.Keywords;


import com.DWR.Constant.ConfigData;
import com.DWR.Report.AllureManager;
import com.DWR.Report.ExtentReportManager;
import com.DWR.Report.ExtentTestManager;
import com.DWR.Utils.LogUtils;
import com.DWR.driver.driverManager;
import com.DWR.helpers.CaptureHelper;
import com.DWR.helpers.PropertiesHelper;
import com.DWR.helpers.SystemHelper;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
//import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebUI {


    private static int TIMEOUT_EXPLICIT_WAIT = ConfigData.TIMEOUT_EXPLICIT_WAIT;
    private static double TIMEOUT_STEP = ConfigData.TIMEOUT_STEP;
    private static int TIMEOUT_PAGE_LOAD = ConfigData.TIMEOUT_PAGE_LOAD;

    @Step("Check Data {1} In Table By Column {2}")
    public static void checkDataInTableByColumn_contains(int column, String value, String columnName) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = driverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = driverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            LogUtils.info(value + " - ");
            LogUtils.info(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }

    @Step("Check Data {1} In Table By Column {0}")
    public static void checkDataInTableByColumn_Equals(int column, String value, String columnName) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = driverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        LogUtils.info("Số dòng tìm thấy: " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = driverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            LogUtils.info(value + " - ");
            LogUtils.info(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().equals(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }


    ////


    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void upLoadFileWithRobotClass(By divFileUpload, String filePath) {
        //Click để mở form upload
        WebUI.clickElement(divFileUpload);
        WebUI.sleep(2);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        WebUI.sleep(1);


















        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebUI.sleep(2);

    }

    public static void logConsole(Object message) {
        LogUtils.info(message);
    }

    public static WebElement getWebElement(By by) {
        return driverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getListWebElement(By by) {
        return driverManager.getDriver().findElements(by);
    }

    @Step("Set key: {1} on element {0} ")
    public static void setKeys(By by, Keys keys) {

        getWebElement(by).sendKeys(keys);
        ExtentTestManager.logMessage(Status.PASS, "setKeys_" + by.toString());

        if (PropertiesHelper.getValue("SCREENSHOT_STEP_ALL").equals("true")) {
            CaptureHelper.screenshot(SystemHelper.makeSlug("setKeys_" + by.toString()));  // khi nào chạy tuần tự mới dùng record, chạy parrallel ko record
        }
    }

    @Step("Set text: {1} on element {0} ")
    public static void setText(By by, String value) {
        waitForElementPresent(by);
        sleep(TIMEOUT_STEP);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Set text: " + value + " on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Set text: " + value + " on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP_ALL").equals("true")) {
            CaptureHelper.screenshot(SystemHelper.makeSlug("setText_" + by.toString()));  // khi nào chạy tuần tự mới dùng record, chạy parrallel ko record
        }
    }

    @Step("Clear text on element  {0} ")
    public static void clearText(By by) {
        waitForElementPresent(by);
        sleep(TIMEOUT_STEP);
        getWebElement(by).clear();
        LogUtils.info("Clear text on element " + by);
        ExtentTestManager.logMessage(Status.PASS, "Clear text on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP_ALL").equals("true")) {
            CaptureHelper.screenshot(SystemHelper.makeSlug("ClearText_" + by.toString()));  // khi nào chạy tuần tự mới dùng record, chạy parrallel ko record
        }
    }

    @Step("Check Element {1} Exist ")
    public static boolean checkElementExist(WebDriver driver, By by) {
        List<WebElement> listElement = driverManager.getDriver().findElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("Element " + by + " existing.");
            ExtentTestManager.logMessage(Status.INFO, "Element " + by + " existing.");
            return true;
        } else {
            LogUtils.error("Element " + by + " NOT exist.");
            ExtentTestManager.logMessage(Status.INFO, "Element " + by + " NOT exist.");
            return false;
        }
    }

    @Step("Check Element {0} Exist ")
    public static boolean checkElementExist(By by) {
        sleep(2);
        List<WebElement> listElement = getListWebElement(by);

        if (listElement.size() > 0) {
            LogUtils.info("checkElementExist: " + true + " --- " + by);
            return true;
        } else {
            LogUtils.error("checkElementExist: " + false + " --- " + by);
            return false;
        }
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        driverManager.getDriver().get(url);
        sleep(TIMEOUT_STEP);
        LogUtils.info("Open URL: " + url);
        ExtentTestManager.logMessage(Status.PASS, "Open URL: " + url);
        if (PropertiesHelper.getValue("SCREENSHOT_STEP_ALL").equals("true")) {
            CaptureHelper.screenshot(SystemHelper.makeSlug("OpenURL_" + url));  // khi nào chạy tuần tự mới dùng record, chạy parrallel ko record
            ExtentTestManager.addScreenshot(SystemHelper.makeSlug("OpenURL_" + url));
            AllureManager.saveScreenshotPNG();

        }
    }

    @Step("Click element: {0} ")
    public static void clickElement(By by) {
        waitForElementClickable(by);
        sleep(TIMEOUT_STEP);
        getWebElement(by).click();
        LogUtils.info("Click element: " + by);
        ExtentTestManager.logMessage(Status.PASS, "Click element: " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP_ALL").equals("true")) {
            CaptureHelper.screenshot(SystemHelper.makeSlug("clickElement_" + by.toString()));  // khi nào chạy tuần tự mới dùng record, chạy parrallel ko record
            ExtentTestManager.addScreenshot(SystemHelper.makeSlug("clickElement_" + by.toString()));
            AllureManager.saveScreenshotPNG();
        }
    }

    @Step("Click element: {0} with time out {1} ")
    public static void clickElement(By by, int timeOut) {
        waitForElementVisible(by, timeOut);
        sleep(TIMEOUT_STEP);
        getWebElement(by).click();
        LogUtils.info("Click element: " + by);
        ExtentTestManager.logMessage(Status.PASS, "Click element: " + by);
    }

    @Step("Check Element {0} is checked or not")
    public static Boolean checkElementIsChecked(By by) {
        Boolean isSelected = getWebElement(by).isSelected();
        LogUtils.info("Check Element"+ by +"  is checked or not");
        ExtentTestManager.logMessage(Status.PASS, "Check Element"+ by +"  is checked or not " );
        return isSelected;
    }

    @Step("Click checkbox {0} ")
    public static void clickCheckBox(By by1, By by2) {
        Boolean isSelected =checkElementIsChecked(by1);
        //Nếu chưa được check thì click vào ô check box đó
        if(isSelected == false)
        {
            getWebElement(by2).click();
        }
        LogUtils.info("Click checkbox: " + by2);
        ExtentTestManager.logMessage(Status.PASS, "Click checkbox " + by2);
    }


    @Step("Set text of element {0} ")
    public static String getElementText(By by) {
        waitForElementVisible(by);
        sleep(TIMEOUT_STEP);
        String text = getWebElement(by).getText();
        LogUtils.info("Get text: " + text);
        ExtentTestManager.logMessage(Status.PASS, "Get text: " + text);
        AllureManager.saveTextLog("Get text: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static String getElementAttribute(By by, String attributeName) {
        waitForElementVisible(by);
        sleep(TIMEOUT_STEP);
        String text = getWebElement(by).getAttribute(attributeName);
        LogUtils.info("Get attribute value: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        getWebElement(by).sendKeys(value, key);
        LogUtils.info("Set text: " + value + " on element " + by);
    }

    public static void scrollToElementOnTop(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(element));
    }

    public static void scrollToElementOnBottom(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(element));
    }

    /**
     * Cuộn đén vị trí phần tử chỉ định
     *
     * @param element
     * @param position nếu giá trị true thì cuộn lên trên, nếu giá trị false thì cuộn xuống dưới
     */

    public static void scrollToElement(By element, String position) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(" + position + ");", getWebElement(element));
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    public static boolean moveToElement(By toElement) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.moveToElement(getWebElement(toElement)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            //action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(driverManager.getDriver());
            //Tính từ vị trí click chuột đầu tiên (clickAndHold)
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
            return false;
        }
    }

    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressTAB() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressDOWN() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pressUP() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyRelease(KeyEvent.VK_UP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param by truyền vào đối tượng element dạng By
     * @return Tô màu viền đỏ cho Element trên website
     */
    public static WebElement highLightElement(By by) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (driverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(TIMEOUT_STEP);
        }
        return getWebElement(by);
    }

    public static WebElement highLightElement(By by, String colorName) {
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if (driverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driverManager.getDriver()).executeScript("arguments[0].style.border='3px solid " + colorName + "'", getWebElement(by));
            sleep(TIMEOUT_STEP);
        }
        return getWebElement(by);
    }

    // Hàm assert and verify

    public static boolean verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        LogUtils.info("Verify equals: " + actual + " = " + expected);
        ExtentTestManager.logMessage(Status.PASS, "Verify equals: " + actual + " = " + expected);
        boolean check = actual.equals(expected);
        return check;
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        LogUtils.info("Assert equals: " + actual + " = " + expected);
        ExtentTestManager.logMessage("Assert equals: " + actual + " = " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    public static boolean verifyContains(String actual, String expected) {
        waitForPageLoaded();
        LogUtils.info("Verify contains: " + actual + " and " + expected);
        ExtentTestManager.logMessage(Status.PASS, "Verify contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        return check;
    }

    public static void assertContains(String actual, String expected, String message) {
        waitForPageLoaded();
        LogUtils.info("Assert contains: " + actual + " and " + expected);
        ExtentTestManager.logMessage("Assert contains: " + actual + " and " + expected);
        boolean check = actual.contains(expected);
        Assert.assertTrue(check, message);
    }

    //Wait for Element

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(TIMEOUT_EXPLICIT_WAIT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());

        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(TIMEOUT_EXPLICIT_WAIT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(TIMEOUT_EXPLICIT_WAIT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
        }
    }


    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element ready to click. " + by.toString());
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());

        }
    }


    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(TIMEOUT_PAGE_LOAD), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogUtils.error("FAILED. Timeout waiting for page load.");
                LogUtils.error(error.getMessage());
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }

    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(TIMEOUT_PAGE_LOAD), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogUtils.error("FAILED. Timeout waiting for page load.");
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }

    }

    public static void waitForPageLoaded(int timeout) {
        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(timeout), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                LogUtils.error("FAILED. Timeout waiting for page load.");
                LogUtils.error(error.getMessage());
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }

    }

    public static void switchToWindow() {

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driverManager.getDriver().getWindowHandle();
        System.out.println("Cửa sổ thứ 1: " + MainWindow);

        sleep(2);
        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driverManager.getDriver().getWindowHandles();

        System.out.println("Số Window: " + windows.size());

        //Chuyển hướng đến cửa sổ theo vị trí cụ thể
        String firstWindow = (String) windows.toArray()[0]; //Cửa sổ đầu
        System.out.println("Cửa sổ thứ 1: " + firstWindow);
        String secondWindow = (String) windows.toArray()[1]; //Cửa sổ thứ hai
        System.out.println("Cửa sổ thứ 2: " + secondWindow);
        //String thirdWindow = (String) windows.toArray()[2]; //Cửa sổ thứ ba
        //System.out.println("Cửa sổ thứ 3: " + thirdWindow);

        //Chuyển hướng đến cửa sổ thứ 2
        driverManager.getDriver().switchTo().window(secondWindow);
        sleep(1);
        System.out.println("Đã chuyển đến Tab Window mới");
        System.out.println(driverManager.getDriver().getTitle());
        System.out.println(driverManager.getDriver().getCurrentUrl());
        sleep(1);

        //Tắt cái cửa sổ thứ 2
        driverManager.getDriver().close();

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driverManager.getDriver().switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driverManager.getDriver().getCurrentUrl());

        sleep(1);

    }


}

