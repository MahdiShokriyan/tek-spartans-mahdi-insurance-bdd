@Regression
Feature: create account features

  Scenario:Navigate to Home page then click on Create Primary Account Button. User should navigate to Create Account form page validate Form Title as Expected
    When user click on a button "Create Primary Account"
    Then validate that "Create Primary Account Holder" is visible as form title