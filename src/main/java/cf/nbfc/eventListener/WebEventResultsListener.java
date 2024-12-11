package cf.nbfc.eventListener;


import cf.nbfc.base.BaseClass;
import cf.nbfc.util.ScreenShotUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;


/**
 * @author Raghu Prasad
 */
public class WebEventResultsListener extends BaseClass implements ITestListener {
    public static Logger log = LogManager.getLogger();


    @Override
    public void onTestStart(ITestResult result) {
        log.atInfo().log("On Test Start");
        extentTest=extentReports.startTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.atInfo().log("On Test Success");
        extentTest.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
        extentReports.endTest(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.atError().log("On Test Failure");
        ScreenShotUtil.takePageScreenShot(result.getMethod().getMethodName());
        extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
        extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ScreenShotUtil.takePageScreenShot(result.getMethod().getMethodName())));
        extentReports.endTest(extentTest);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.atInfo().log("On Test Skipped");
        extentTest.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        extentReports.endTest(extentTest);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.atInfo().log("On Test Failed But within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        log.atInfo().log("On Start");
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/test-output/AutomatedTestReport.html", true);
    }

    @Override
    public void onFinish(ITestContext context) {
        log.atInfo().log("On Finish");
        extentReports.flush();

    }

}
