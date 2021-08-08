package cx.en.oq.utils;

import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

public class AllureScreenShooter extends ExitCodeListener {
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        AllureHelpers.takeScreenshot();
    }
}
