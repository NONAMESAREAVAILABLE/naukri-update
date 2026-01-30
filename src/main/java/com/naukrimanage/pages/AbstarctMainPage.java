package com.naukrimanage.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukrimanage.utils.Configurations;

public class AbstarctMainPage {
    
    Properties properties;
    WebDriver driver;
    WebDriverWait wait;
    String naukriDrawerXpath = "//div[@class=\"drawer-wrapper \"]";

    public AbstarctMainPage(WebDriver driver, int waitSeconds)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        properties =Configurations.properties;
    }
}
