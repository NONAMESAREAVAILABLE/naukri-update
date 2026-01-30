package com.naukrimanage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstarctMainPage{


    public HomePage(WebDriver driver, int waitSeconds)
    {
        super(driver, waitSeconds);
    }
    
    private By loginDrawerButton = By.xpath("//a[normalize-space()='Login']");
    private By naukriDrawer = By.xpath(naukriDrawerXpath);
    private By enterEmailID = By.xpath("//input[contains(@placeholder,'Email')]");
    private By enterPassword = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[@type='submit']");

    public void openNaukriDrawer() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginDrawerButton));
        loginBtn.click();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(naukriDrawer));
    }

    public void sendEmailAndPassword() {
        openNaukriDrawer();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmailID))
            .sendKeys(properties.getProperty("NaukriEmail"));
    
        driver.findElement(enterPassword)
            .sendKeys(properties.getProperty("NaukriPassword"));
    }
    
    public void login() {
        sendEmailAndPassword();
    
        driver.findElement(loginButton).click();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//img[@alt='naukri user profile img']")
        ));
    }
    


}
