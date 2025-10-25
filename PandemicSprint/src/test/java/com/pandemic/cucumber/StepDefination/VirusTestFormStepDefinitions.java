package com.pandemic.cucumber.StepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.*;
import com.pandamic.cucumber.Pages.VirusTestFormPage;

public class VirusTestFormStepDefinitions { 

    WebDriver driver = Hooks.driver;
    ExtentTest test = Hooks.test;
    VirusTestFormPage virusTestPage;
    String baseUrl = "http://webapps.tekstac.com/SeleniumApp2/Pandemic/Test.html";

    @Given("the user is on the Virus Test page")
    public void the_user_is_on_virus_test_page() {
        driver.get(baseUrl);
        virusTestPage = new VirusTestFormPage(driver, test);
    }

    @When("the user fills the form with Age60: {string}, Age10: {string}, Living: {string}, Contact: {string}, and Symptoms: {string}")
    public void the_user_fills_form(String age60, String age10, String living, String contact, String symptoms) {
        virusTestPage.setAge60(age60);
        virusTestPage.setAge10(age10);
        virusTestPage.setLiving(living);
        virusTestPage.setContact(contact);
        virusTestPage.setSymptoms(symptoms);
    }

    @When("clicks on submit")
    public void clicks_on_submit() {
        virusTestPage.clickSubmit();
    }

    @Then("the resultant message should be displayed")
    public void resultant_message_should_be_displayed() {
        boolean result = virusTestPage.isResultVisible();
        Assert.assertTrue("Result message not displayed", result);
    }

    @When("the user clicks on submit")
    public void user_clicks_submit_without_input() {
        virusTestPage.clickSubmit();
    }

    @Then("appropriate validation errors should be displayed")
    public void appropriate_validation_errors_should_be_displayed() {
        boolean result = virusTestPage.isValidationVisible();
        Assert.assertTrue("Validation message not displayed",result);
    }
}