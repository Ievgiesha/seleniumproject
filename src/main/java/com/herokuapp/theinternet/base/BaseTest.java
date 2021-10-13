package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;


public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        // Create driver
        log.info("Create driver: " + browser);

        //    main.java.com.herokuapp.theinternet.base.BrowserDriverFactory factory = new main.java.com.herokuapp.theinternet.base.BrowserDriverFactory(browser);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, (org.apache.logging.log4j.Logger) log);
        driver = factory.createDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
       log.info("Close driver");
        // Close browser
        driver.quit();
    }

}