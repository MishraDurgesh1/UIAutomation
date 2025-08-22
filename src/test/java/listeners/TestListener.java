package listeners;

import Page.BaseTest;
import Utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info("🚀 Test Started: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("✅ Test Passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("❌ Test Failed: {}", result.getName());

        // Capture screenshot
        try {
            Utility.screenshot(BaseTest.driver,result.getName());
            log.info("📸 Screenshot captured for failed test: {}", result.getName());
        } catch (Exception e) {
            log.error("⚠️ Error capturing screenshot: {}", e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("⚠️ Test Skipped: {}", result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("🟢 Test Suite Started: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("🔴 Test Suite Finished: {}", context.getName());
    }
}
