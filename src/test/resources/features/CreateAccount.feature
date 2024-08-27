@Regression
Feature: create account features

  Background:
    When user click on a link text button "Create Primary Account"


  Scenario:Navigate to Create Account Page and Validate Form Title
    Then validate that "Create Primary Account Holder" is visible as form title

  @userStory2
  Scenario: fill the form on Create primary account page and validate the email and title on sign up page
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

  @userStory3
  Scenario: fill the form with existing email and validate the error message
    When the user types "mahdi.shokriyan@gmail.com" into the "Email Address" field
    When the user Choose "Mr." from the "Title / Prefix" list
    When the user types "Stephan" into the "First Name" field
    When the user types "Gucci" into the "Last Name" field
    When the user Choose "Male" from the "Gender" list
    When the user Choose "Single" from the "Marital Status" list
    When the user types "SDET Engineer" into the "Employment Status" field
    When the user types "10/10/1990" into the "Date Of Birth" field
    Then user click on a visible text button "Create Account"
    Then validate the error message should be "ERROR"

  @userStory5
  Scenario: create account and login and validate name
    When user fill the Create new account form
      | Email Address     | random        |
      | First Name        | Mathias       |
      | Last Name         | Akowano       |
      | Employment Status | SDET Engineer |
      | Date Of Birth     | 02/05/1995    |
    When the user Choose "Mr." from the "Title / Prefix" list
    When the user Choose "Male" from the "Gender" list
    When the user Choose "Single" from the "Marital Status" list






