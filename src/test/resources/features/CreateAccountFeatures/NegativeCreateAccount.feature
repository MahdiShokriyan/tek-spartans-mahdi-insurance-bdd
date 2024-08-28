@Smoke
Feature: All Negative tests

  Background:
    When user click on a link text button "Create Primary Account"
    When the user Choose "Mr." from the "Title / Prefix" list
    When the user types "Stephan" into the "First Name" field
    When the user types "Gucci" into the "Last Name" field
    When the user Choose "Male" from the "Gender" list
    When the user Choose "Single" from the "Marital Status" list
    When the user types "SDET Engineer" into the "Employment Status" field

  @userStory3
  Scenario Outline: fill the form with existing email and validate the error message
    When the user types "mahdi.shokriyan@gmail.com" into the "Email Address" field
    When the user types "10/10/1990" into the "Date Of Birth" field
    Then user click on a visible text button "Create Account"
    Then user should see error "<expectedResult>"
    Examples:
      | expectedResult                                        |
      | Account with email mahdi.shokriyan@gmail.com is exist |

  @userStory4
  Scenario Outline: fill the form with age less than 18 and validate the error message
    When the user types "mahdi.shokriyan123@gmail.com" into the "Email Address" field
    When the user types "10/10/2018" into the "Date Of Birth" field
    Then user click on a visible text button "Create Account"
    Then user should see error "<expectedResult>"
    Examples:
      | expectedResult                                  |
      | you must be 18 years or older to create account |