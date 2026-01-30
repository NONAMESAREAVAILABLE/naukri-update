package com.naukrimanage.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUtils {

    private static String screenshotFile = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"screen.jpg";

    public static String TakeScreenshot(WebDriver driver)
    {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File Output = new File(screenshotFile);

        File parentDir = Output.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // creates all missing dirs
        }

        try {
            Files.copy(screenshot.toPath(), Output.toPath(), REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Screenshot didnot got generated");
            e.printStackTrace();
        }

        return screenshotFile;
    }
}
