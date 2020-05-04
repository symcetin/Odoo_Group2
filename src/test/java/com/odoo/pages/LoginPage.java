package com.odoo.pages;

import com.odoo.utilities.BrowserUtilities;
import com.odoo.utilities.ConfigurationReader;
import com.odoo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase{

    @FindBy(className = "navbar-brand")
    private WebElement authorizationLogo;

    @FindBy(id = "login")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(css = "[type='submit']")
    private WebElement login;

    @FindBy (tagName = "p")
    private WebElement warningMessage;

    @FindBy(xpath = "//a[contains(text(),'Reset')]")
    private WebElement resetPasswordBtn;



    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    public WebElement getWarningMessage(){
        BrowserUtilities.wait(2);
        return warningMessage;
    }

    public void loginInvalid(String usernameValue, String passwordValue){
        BrowserUtilities.waitForPageToLoad(20);
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.wait(2);
    }



    /**
     * Choose user type for different user levels
     * @param userType help_desk, marketing, hr
     */
    public void login(String userType, String userPassword){
        BrowserUtilities.waitForPageToLoad(20);
        username.sendKeys(ConfigurationReader.getProperty(userType));
        password.sendKeys(ConfigurationReader.getProperty(userPassword));
        login.click();
        BrowserUtilities.wait(3);
    }

}
