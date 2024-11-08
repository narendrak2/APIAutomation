
package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Setup implements ITestListener {

    public static ExtentReports report;
    public static String fullreportpath;
    public static ThreadLocal<ExtentTest> ExtentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {

        String fileName = Extentreportmanager.getReportNameWithTimeStamp();
        fullreportpath = System.getProperty("user.dir") + "//reports//" + fileName;
        File reports = new File(fullreportpath);
        if (reports.exists()) {
            reports.delete();
        }
        report = Extentreportmanager.createinstance(fullreportpath, "API automation report", "test excution report");
    }

    public void onFinish(ITestContext context) {
        if (report != null) {
            report.flush();
        }
    }

    public void onTestStart(ITestResult result) {

        ExtentTest test = report.createTest("Test name=" + result.getMethod().getMethodName());
        ExtentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        // not implemented
        ExtentTest test = report.createTest("Test name=" + result.getMethod().getMethodName());
        ExtentTest.set(test);
        ExtentTest status = report.createTest("Status code=" + result.getStatus());
        ExtentTest.set(status);

    }
}