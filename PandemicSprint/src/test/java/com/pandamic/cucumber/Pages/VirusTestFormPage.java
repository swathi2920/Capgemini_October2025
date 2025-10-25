package com.pandamic.cucumber.Pages;

import com.pandemic.cucumber.Utils.Reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class VirusTestFormPage { 

    private WebDriver driver;
    private ExtentTest test;

    @FindBy(id = "aboveyes")
    private WebElement age60Yes;

    @FindBy(id = "aboveno")
    private WebElement age60No;

    @FindBy(id = "belowyes")
    private WebElement age10Yes;

    @FindBy(id = "belowno")
    private WebElement age10No;

    @FindBy(id = "livingwith")
    private WebElement livingWith;

    @FindBy(id = "Alone")
    private WebElement Alone;

    @FindBy(id = "Family")
    private WebElement Family;

    @FindBy(id = "contactyes")
    private WebElement contactYes;

    @FindBy(id = "contactno")
    private WebElement contactNo;

    @FindBy(id = "symptom1")
    private WebElement Symptom1;

    @FindBy(id = "symptom2")
    private WebElement Symptom2;

    @FindBy(id = "symptom3")
    private WebElement Symptom3;

    @FindBy(id = "symptom4")
    private WebElement Symptom4;

    @FindBy(id = "symptom5")
    private WebElement Symptom5;

    @FindBy(id = "VirusTest")
    private WebElement btnSubmit;

    @FindBy(id = "testresult")
    private WebElement resultMessage;

    @FindBy(xpath = "//label[contains(text(),'Please')]")
    private WebElement validationMessage;

    public VirusTestFormPage(WebDriver driver, ExtentTest test) { // <-- Constructor name updated
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void setAge60(String value) {
        if ("Yes".equalsIgnoreCase(value)) age60Yes.click();
        else age60No.click();    }

    public void setAge10(String value) {
        if ("Yes".equalsIgnoreCase(value)) age10Yes.click();
        else age10No.click();
    }

    public void setLiving(String value) {
    	Select select=new Select(livingWith);
    	select.selectByVisibleText(value);
    }

    public void setContact(String value) {
        if ("Yes".equalsIgnoreCase(value)) contactYes.click();
        else contactNo.click();
    }

    public void setSymptoms(String symptoms) {
    	String arr[]=symptoms.split(",");
    	for(int i=0;i<arr.length;i++) {
    		if("Feeling tired or week".equalsIgnoreCase(arr[i])) Symptom1.click();
            else if("Persistent cough".equalsIgnoreCase(arr[i])) Symptom2.click();
            else if("Runny nose".equalsIgnoreCase(arr[i])) Symptom3.click();
            else if("Head ache".equalsIgnoreCase(arr[i])) Symptom4.click();
            else if("Loss of taste or smell".equalsIgnoreCase(arr[i])) Symptom5.click();
    	}
    }

    public void clickSubmit() {
        btnSubmit.click();
        Reports.generateReport(driver, test, Status.INFO, "Clicked Submit Button");
    }

    public boolean isResultVisible() {
    	boolean result = false; 
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(resultMessage));
            result = resultMessage.isDisplayed();
        } catch(Exception e) {
           
            e.printStackTrace();
        }

        if (result) Reports.generateReport(driver, test, Status.PASS, "Result message displayed.");
        else Reports.generateReport(driver, test, Status.FAIL, "Result message not displayed.");
        return result;
    }

    public boolean isValidationVisible() {
    	boolean result = false; 
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(validationMessage));
            result = validationMessage.isDisplayed();
        } catch(Exception e) {
            
            e.printStackTrace();
        }

        if (result) Reports.generateReport(driver, test, Status.PASS, "Validation message displayed.");
        else Reports.generateReport(driver, test, Status.FAIL, "Validation message not displayed.");
        return result;
    }
}