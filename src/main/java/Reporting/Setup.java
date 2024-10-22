package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {

    public static ExtentReports report;
    public static ThreadLocal<ExtentTest> ExtentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {

        String fileName = Extentreportmanager.getReportNameWithTimeStamp();
        String fullreportpath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        report = Extentreportmanager.createinstance(fullreportpath, "API automation report", "test excution report");

    }

    public void onFinish(ITestContext context) {
        if (report != null)
            report.flush();
    }

    public void onTestStart(ITestResult result) {

        ExtentTest test = report.createTest("Test name=" + result.getMethod().getMethodName());
        ExtentTest.set(test);
    }

}