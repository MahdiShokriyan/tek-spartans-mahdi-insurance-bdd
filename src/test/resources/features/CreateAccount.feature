@Regression
Feature: create account features

  Background:
    When user click on a link text button "Create Primary Account"


  Scenario:Navigate to Home page then click on Create Primary Account Button. User should navigate to Create Account form page validate Form Title as Expected
    Then validate that "Create Primary Account Holder" is visible as form title

  @userStory2
  Scenario: On Create primary account holder form fill up the form and click on create Account Button Validate user is in sign up page and email address is as expected
    When the user types "random" into the "Email Address" field
    When the user Choose "Mr." from the "Title / Prefix" list
    When the user types "Stephan" into the "First Name" field
    When the user types "Gucci" into the "Last Name" field
    When the user Choose "Male" from the "Gender" list
    When the user Choose "Single" from the "Marital Status" list
    When the user types "SDET Engineer" into the "Employment Status" field
    When the user types "10/10/1990" into the "Date Of Birth" field
    Then user click on a visible text button "Create Account"
    Then validate user can see the "Sign up your account"
    And email address shows as expected

