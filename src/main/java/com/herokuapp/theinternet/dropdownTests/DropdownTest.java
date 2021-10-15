package com.herokuapp.theinternet.dropdownTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {
    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        //Click on dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Select option 2
        dropdownPage.selectOption(2);

        //verify Option 2 is Selected
        String selectOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectOption.equals("Option 2"), "Option 2 is not selected, instead selected option "
                + selectOption);


    }
}

