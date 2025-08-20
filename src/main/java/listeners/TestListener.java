package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test Failed: " + result.getName());
        // screenshot logic can be added
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🚀 Starting tests...");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Tests finished.");
    }
}
