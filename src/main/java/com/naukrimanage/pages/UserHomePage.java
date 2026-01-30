package com.naukrimanage.pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserHomePage extends AbstarctMainPage{

    public UserHomePage(WebDriver driver, int waitSeconds) {
        super(driver, waitSeconds);
    }

    By profileImage = By.xpath("//img[@alt=\"naukri user profile img\"]");
    By profileUpdateButton = By.cssSelector("a.nI-gNb-info__sub-link");

    public void openUserProfile()
    {
        driver.findElement(profileImage).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(naukriDrawerXpath)));

        driver.findElement(profileUpdateButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"nk-user-img\"]")));
    }
    
}
