package com.naukrimanage.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.naukrimanage.utils.Configurations;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ControlPanel {
    

    protected WebDriver driver;
    Properties properties;

    public void startSeleniumSession() {
        Configurations.loadProperties();
        properties = Configurations.properties;

        String browser = properties.getProperty("browser");

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);

                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                driver = new ChromeDriver(options);
                break;
        
            default:
                System.out.println("Your browser is not supported");
                break;
        }
        
    }

    public WebDriver getDriver()
    {
        return driver;
    }



    public void openBrowser(String url) {
        driver.get(url);
    }

    public void closeSession() {
        driver.quit();
    }
}
