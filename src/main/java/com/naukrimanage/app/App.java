package com.naukrimanage.app;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v140.profiler.model.Profile;

import com.naukrimanage.controls.ControlPanel;
import com.naukrimanage.pages.HomePage;
import com.naukrimanage.pages.ProfilePage;
import com.naukrimanage.pages.UserHomePage;
import com.naukrimanage.utils.CVManager;
import com.naukrimanage.utils.Configurations;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        WebDriver driver;

        ControlPanel controls = new ControlPanel();
        controls.startSeleniumSession();
        controls.openBrowser("https://www.naukri.com/");

        driver = controls.getDriver();
        HomePage home = new HomePage(driver, 20);
        home.login();
        
        controls.updateCV();

        controls.closeSession();
    }
}
