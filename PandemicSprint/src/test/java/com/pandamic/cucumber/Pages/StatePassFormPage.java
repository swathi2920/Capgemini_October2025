package com.pandamic.cucumber.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pandemic.cucumber.Utils.Reports;

import java.time.Duration;

public class StatePassFormPage {

    private WebDriver driver;
    private ExtentTest test;

    @FindBy(id = "nameState")
    private WebElement txtName;

    @FindBy(id = "state")
    private WebElement ddlState;

    @FindBy(id = "Gender_0")
    private WebElement radioMale;

    @FindBy(id = "Gender_1")
    private WebElement radioFemale;

    @FindBy(id = "Gender_2")
    private WebElement radioOther;

    @FindBy(id = "emailState")
    private WebElement txtEmail;

    @FindBy(id = "mobile1state")
    private WebElement txtMobile1;

    @FindBy(id = "mobile2state")
    private WebElement txtMobile2;

    @FindBy(id = "mobile3state")
    private WebElement txtMobile3;

    @FindBy(id = "aadhaarState")
    private WebElement txtAadhaar;

    @FindBy(id = "reasonState")
    private WebElement ddlReason;

    @FindBy(id = "travelBy")
    private WebElement ddlTravelBy;

    @FindBy(id = "textarea")
    private WebElement txtRemarks;

    @FindBy(id = "date")
    private WebElement Statedate;

    @FindBy(id = "statePassSubmit")
    private WebElement btnSubmit;

    
    @FindBy(id = "stateView")
    private WebElement confirmationView;

    @FindBy(xpath = "//label[contains(text(),'Please')]")
    private WebElement validationMessage;

    @FindBy(id = "emailStateError")
    private WebElement invalidEm;

    @FindBy(id = "mobileStateError")  
    private WebElement mobileNumberError;


    public StatePassFormPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        txtName.clear();
        txtName.sendKeys(name);
    }

    public void selectState(String state) {
        new Select(ddlState).selectByVisibleText(state);
    }

    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                radioMale.click();
                break;
            case "female":
                radioFemale.click();
                break;
            case "others":
                radioOther.click();
                break;
        }
    }

    public void enterEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void enterMobile(String m1, String m2, String m3) {
        txtMobile1.clear();
        txtMobile2.clear();
        txtMobile3.clear();
        txtMobile1.sendKeys(m1);
        txtMobile2.sendKeys(m2);
        txtMobile3.sendKeys(m3);
    }

    public void enterAadhaar(String aadhaar) {
        txtAadhaar.clear();
        txtAadhaar.sendKeys(aadhaar);
    }

    public void selectReason(String reason) {
        new Select(ddlReason).selectByVisibleText(reason);
    }

    public void selectTravelBy(String travelBy) {
        new Select(ddlTravelBy).selectByVisibleText(travelBy);
    }

    public void enterDate(String date) {
        Statedate.clear();
        Statedate.sendKeys(date);
    }

    public void enterRemarks(String remarks) {
        txtRemarks.clear();
        txtRemarks.sendKeys(remarks);
    }

    public void clickSubmit() {
        btnSubmit.click();
        Reports.generateReport(driver, test, Status.INFO, "Clicked Submit Button");
    }

   
    public boolean isConfirmationVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(confirmationView));
            Reports.generateReport(driver, test, Status.PASS, "Submitted details are displayed.");
            return confirmationView.isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Submitted details not displayed.");
            return false;
        }
    }

    public boolean isValidationMessageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(validationMessage));
            Reports.generateReport(driver, test, Status.PASS, "Validation message is displayed.");
            return validationMessage.isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Validation message was expected but not found.");
            return false;
        }
    }

    public boolean invalidEmail() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(invalidEm));
            Reports.generateReport(driver, test, Status.PASS, "Email validation message is displayed.");
            return invalidEm.isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Email validation message was expected but not found.");
            return false;
        }
    }

    public boolean isMobileValidationMessageVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(mobileNumberError));
            Reports.generateReport(driver, test, Status.PASS, "Mobile validation message is displayed.");
            return mobileNumberError.isDisplayed();
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Mobile validation message was expected but not found.");
            return false;
        }
    }
}
