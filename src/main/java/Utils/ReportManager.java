package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.Date;

@Slf4j
public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    // Initialize ExtentReports
    public static void initReports() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setReportName("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Durgesh Mishra");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Build", "1.0");
        extent.setSystemInfo("Platform", "Windows 11");
        extent.setSystemInfo("Sprint", "Sprint 1");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Version", "112.0.5615.165");
        extent.setSystemInfo("User", "Durgesh Mishra");
    }
    // Create a test node in the report
    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    // Log test status
    public static void pass(String message) {
        if (test != null) test.pass(message);
    }

    public static void fail(String message) {
        if (test != null) test.fail(message);
    }

    public static void fail(Throwable throwable) {
        if (test != null) test.fail(throwable);
    }

    public static void skip(String message) {
        if (test != null) test.skip(message);
    }

    // Attach screenshot
    public static void addScreenshot(String path) {
        if (test != null) {
            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                log.error("⚠️ Error attaching screenshot: {}", e.getMessage());
            }
        }
    }

    // Flush report
    public static void flushReports() {
        if (extent != null) extent.flush();
    }
}
