package com.pandemic.cucumber.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reports {

  
    public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) {
        if (status.equals(Status.PASS)) {
            test.log(status, stepMessage);
        } else if (status.equals(Status.FAIL)) {
            // Take screenshot if status is FAIL
            String screenshotPath = captureScreenshot(driver, stepMessage);
            try {
                test.log(status, stepMessage,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (WebDriverException e) {
                e.printStackTrace();
                test.log(status, stepMessage + " (Screenshot failed to attach)");
            }
        } else {
            test.log(status, stepMessage); 
        }
    }

    
    public static String captureScreenshot(WebDriver driver, String fileLabel) {
        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        new File(folderPath).mkdirs(); 

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());
        String safeFileName = fileLabel.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(folderPath + safeFileName);

        try {
            FileUtils.copyFile(screenshot, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        return "./screenshots/" + safeFileName;
    }
}
