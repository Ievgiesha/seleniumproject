package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLogInTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        // open main page

//		String url = "http://the-internet.herokuapp.com/";
//		driver.get(url);
//		log.info("Main page is opened.");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // enter username and password
        loginPage.negativeLogIn(username, password);
        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();
        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + message);
    }
}
