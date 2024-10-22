package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extentreportmanager {

    public static ExtentReports extentreport;

    public static ExtentReports createinstance(String filename, String reportname, String title) {

        ExtentSparkReporter extent = new ExtentSparkReporter(filename);
        extent.config().setReportName(reportname);
        extent.config().setReportName(title);
        extent.config().setTheme(Theme.DARK);
        extentreport = new ExtentReports();
        extentreport.attachReporter(extent);
        return extentreport;
    }

    public static String getReportNameWithTimeStamp(){

        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localdatetime=LocalDateTime.now();
        String formattedtime=dateFormatter.format(localdatetime);
        String reportName="Test Report" + formattedtime+".html";
        return reportName;

    }

    public static void logPassDetails(String log) {

        Setup.ExtentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logfailDetails(String log) {

        Setup.ExtentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void loginfoDetails(String log) {

      Setup.ExtentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logwarningDetails(String log) {

        Setup.ExtentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
}