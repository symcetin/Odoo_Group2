package com.odoo.step_definitions;

import com.odoo.utilities.BrowserUtilities;
import com.odoo.utilities.ConfigurationReader;
import com.odoo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        System.out.println(":::: Starting test automation ::::");
        System.out.println("Browser type :: " + ConfigurationReader.getProperty("browser"));
        System.out.println("Environment :: " + ConfigurationReader.getProperty("URL"));
        System.out.println("Test scenario :: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image, "image/png", scenario.getName());
        }

        BrowserUtilities.wait(4);
        Driver.closeDriver();
    }
}
