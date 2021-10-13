package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTest() {
        log.info("Starting selectingTwoBoxesTest");

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //Click on checkboxes links
        CheckboxesPage checkboxesPage = welcomePageObject.clickCheckboxesLink();

        //Select all checkboxes
        checkboxesPage.selectAllCheckboxes();

        //Verify all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked!");
    }
}
