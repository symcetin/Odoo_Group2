package com.odoo.step_definitions;

import com.odoo.pages.LoginPage;
import com.odoo.utilities.ConfigurationReader;
import com.odoo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("CRM_1","CRM_password");
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        Assert.assertEquals(Driver.getDriver().getTitle(),title);
    }

    @When("User logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        loginPage.loginInvalid("username","password");
    }

    @Then("User should see error message")
    public void user_should_see_error_message() {
        Assert.assertTrue(loginPage.getWarningMessage().isDisplayed());
    }


}
