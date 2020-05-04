package com.odoo.pages;

import com.odoo.utilities.BrowserUtilities;
import com.odoo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver= Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,20);

    public PageBase(){
        PageFactory.initElements(driver,this);
    }

    /**
     * This method will navigate to user specified module
     * @param module user will enter module name. Case Sensitive!!
     */
    public void navigateTo(String module) {
        BrowserUtilities.waitForPageToLoad(10);
        String path="(//span[contains(text(),'"+module+"')])[1]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path)))).click();
        BrowserUtilities.wait(2);
    }


}
