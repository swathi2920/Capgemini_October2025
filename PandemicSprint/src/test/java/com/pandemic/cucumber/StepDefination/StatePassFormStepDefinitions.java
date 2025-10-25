package com.pandemic.cucumber.StepDefination;

import com.pandamic.cucumber.Pages.StatePassFormPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.*;

public class StatePassFormStepDefinitions {

    WebDriver driver = Hooks.driver;
    ExtentTest test = Hooks.test;
    StatePassFormPage statePassPage;
    String baseUrl = "https://webapps.tekstac.com/SeleniumApp2/Pandemic/StatePass.html";

    @Given("the user is on the State Pass page")
    public void user_is_on_state_pass_page() {
        driver.get(baseUrl);
        statePassPage = new StatePassFormPage(driver, test);
    }

    @When("the user enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void the_user_enters_all_details(String name, String state, String gender, String email,
                                            String m1, String m2, String m3, String aadhaar,
                                            String reason, String travelBy, String remarks, String date) {
        statePassPage.enterName(name);
        statePassPage.selectState(state);
        statePassPage.selectGender(gender);
        statePassPage.enterEmail(email);
        statePassPage.enterMobile(m1, m2, m3);
        statePassPage.enterAadhaar(aadhaar);
        statePassPage.selectReason(reason);
        statePassPage.selectTravelBy(travelBy);
        statePassPage.enterRemarks(remarks);
        statePassPage.enterDate(date);
    }

    @When("the user clicks the Submit button")
    public void the_user_clicks_submit_button() {
        statePassPage.clickSubmit();
    }

    @Then("the user should see the submitted details in the confirmation view")
    public void user_should_see_confirmation() {
        boolean result = statePassPage.isConfirmationVisible();
        Assert.assertTrue("Confirmation was not shown", result);
    }

    @When("the user clicks the Submit button without filling the form")
    public void user_submits_without_input() {
        statePassPage.clickSubmit();
    }

    @Then("the user should see a validation message")
    public void user_should_see_validation_message() {
        boolean result = statePassPage.isValidationMessageVisible();
        Assert.assertTrue("Validation message not displayed", result);
    }

    @When("the user enters Invalid Email from Excel File")
    public void user_enters_invalid_email_from_excel() {
        
    }

    @When("the user enters details with invalid email: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_details_with_invalid_email(String name, String state, String gender, String invalidEmail,
                                                           String m1, String m2, String m3, String aadhaar,
                                                           String reason, String travelBy, String remarks, String date) {
        statePassPage.enterName(name);
        statePassPage.selectState(state);
        statePassPage.selectGender(gender);
        statePassPage.enterEmail(invalidEmail);
        statePassPage.enterMobile(m1, m2, m3);
        statePassPage.enterAadhaar(aadhaar);
        statePassPage.selectReason(reason);
        statePassPage.selectTravelBy(travelBy);
        statePassPage.enterRemarks(remarks);
        statePassPage.enterDate(date);
    }

    @Then("the user should see an email validation error")
    public void user_should_see_email_validation_error() {
        boolean result = statePassPage.invalidEmail();
        Assert.assertTrue("Email validation message not displayed", result);
    }

    @When("the user enters valid personal and travel details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_enters_valid_personal_and_travel_details_with_invalid_mobile(
            String name, String state, String gender, String email,
            String invalidMobile1, String invalidMobile2, String invalidMobile3,
            String aadhaar, String reason, String travelBy, String anythingToSay, String date) {

        statePassPage.enterName(name);
        statePassPage.selectState(state);
        statePassPage.selectGender(gender);
        statePassPage.enterEmail(email);
        statePassPage.enterMobile(invalidMobile1, invalidMobile2, invalidMobile3);
        statePassPage.enterAadhaar(aadhaar);
        statePassPage.selectReason(reason);
        statePassPage.selectTravelBy(travelBy);
        statePassPage.enterRemarks(anythingToSay);
        statePassPage.enterDate(date);
    }

    @Then("the user should see a clear validation error message for the mobile field")
    public void the_user_should_see_a_clear_validation_error_message_for_the_mobile_field() {
        boolean result = statePassPage.isMobileValidationMessageVisible();
        Assert.assertTrue("Mobile validation message was not displayed", result);
    }
}
