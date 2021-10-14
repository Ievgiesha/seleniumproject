package com.herokuapp.theinternet.alertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertsTests extends TestUtilities {
    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on JS Alert Link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        //Click JS Prompt Button
        alertsPage.openJSPrompt();

        // Get Alert Text
        String alertMessage = alertsPage.getAlertText();

        //Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, It's Ievgeniia here.");

        //Get result text
        String result = alertsPage.getResultText();

        //Verification
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt' ");

        //Result text is expected
        Assert.assertTrue(result.equals("You entered: Hello Alert, It's Ievgeniia here."),
                " Result message is not expected. \nShould be: 'It's Ievgeniia here.'");


    }
}
