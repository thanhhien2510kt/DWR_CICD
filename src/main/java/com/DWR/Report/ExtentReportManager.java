package com.DWR.Report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("export/Extentreport/Extentreport.html");
        reporter.config().setReportName("Extent Report | DWR");
        extentReports.attachReporter(reporter);  // extentReports sẽ dùng reporter này để xuất file HTML.
        //Thêm system info (thông tin hiển thị trong phần “System” của báo cáo).
        extentReports.setSystemInfo("Framework Name", "DWR | Delivery Warranty Refund");
        extentReports.setSystemInfo("Author", "Rosy Duong");
        return extentReports;
    }

}


//là nơi cấu hình và quản lý ExtentReports

