package com.naukrimanage.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.naukrimanage.utils.GeneralUtils;

public class ProfilePage extends AbstarctMainPage {

    public ProfilePage(WebDriver driver, int waitSeconds) {
        super(driver, waitSeconds);
    }

    By successBox = By.xpath("//div[contains(@class,\"msgBox success\")]");

    By profileImage= By.xpath("//span[@class=\"nk-user-img\"]");
    By CVUpdateInput = By.id("attachCV");

    
    public void updateCV(String cvFilePath)
    {
        System.out.println("Uploading the cv: "+cvFilePath);
        driver.findElement(CVUpdateInput).sendKeys(cvFilePath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successBox));
        System.out.println("CV Updated Successfully");


        String screenshotFile = GeneralUtils.TakeScreenshot(driver);
        System.out.println("Your screenshot has been saved at: "+screenshotFile);
    }
    
}
