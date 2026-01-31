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
    By userLocation = By.xpath("//span[@name=\"Location\"]");
    By userExperience = By.xpath("//span[@name=\"Experience\"]/span");
    By userSalary = By.xpath("//span[@name=\"Salary\"]/span[2]");
    By userNoticePeriod = By.xpath("//span[@name=\"notice period\"]");
    By resumeHeadline = By.xpath("//div[@class=\"resumeHeadline\"]/descendant::*[contains(@class, \"prefill\")]/div");
    By keySkills = By.xpath("//div[@class=\"keySkills\"]/descendant::*[contains(@class, \"prefill\")]/span");
    By employmentInformation = By.xpath("//div[@class=\"employment-section\"]/descendant::/*[@class=\"widgetCont\"]/div");
    By postTitle = By.xpath("//div[contains(@class, \"item title\")]/span");
    By companyName = By.xpath("//div[@class=\"title\"]");
    By experienceType = By.xpath("//div[contains(@class, \"item experienceType\")]/span[1]");
    By experienceTime = By.xpath("//div[contains(@class, \"item experienceType\")]/span[3]");
    By employMentDescription = By.xpath("//div[contains(@class, \"emp-desc\")]/div/div");
    By read = By.xpath("//a[@class=\"morelink\"]");
    By ITSkills = By.xpath("//div[@id=\"lazyITSkills\"]/descendant::li[@class=\"collection\"]");
    By userProjects = By.xpath("//div[@class=\"lazyProject\"]/descendant::div[@class=\"row project-list\"]");
    By userProjectsColumns ;//= By.xpath("//div][")
    
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
