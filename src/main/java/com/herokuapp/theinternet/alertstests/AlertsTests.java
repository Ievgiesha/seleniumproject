package com.herokuapp.theinternet.alertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.annotations.Test;


public class AlertsTests extends TestUtilities {
    @Test
    public void jsAlertTest(){
        log.info("Starting jsAlertTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on JS Alert Link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();


    }
}
