package org.Utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class EmailListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        org.Utils.EmailSender.sendEmailWithReport(
                "Reports/AutomationTestReport.html",
                "smtp.gmail.com",
                "587",
                "piyushpandey2111@gmail.com",
                "aczr vlbt aegt zopd",
                "piyushpandey3399@gmail.com");
    }
}
