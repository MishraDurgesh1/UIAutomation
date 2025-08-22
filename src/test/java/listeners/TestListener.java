package listeners;

import Page.BaseTest;
import Utils.ReportManager;
import Utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        log.info("🟢 Test Suite Started: {}", context.getName());
        ReportManager.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("🚀 Test Started: {}", result.getName());
        ReportManager.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("✅ Test Passed: {}", result.getName());
        ReportManager.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("❌ Test Failed: {}", result.getName());
        ReportManager.fail(result.getThrowable());

        try {
            String screenshotPath = "test-output/screenshots/" + result.getName() + ".png";
            Utility.screenshot(BaseTest.driver, screenshotPath);
            ReportManager.addScreenshot(screenshotPath);
            log.info("📸 Screenshot captured for failed test: {}", result.getName());
        } catch (Exception e) {
            log.error("⚠️ Error capturing screenshot: {}", e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ Test Skipped: {}", result.getName());
        ReportManager.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("🔴 Test Suite Finished: {}", context.getName());
        ReportManager.flushReports();
    }
}
