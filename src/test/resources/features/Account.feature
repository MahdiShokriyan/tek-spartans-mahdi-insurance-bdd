@Regression
Feature: Accounts features

  Background: go to login page
    When user click on a link text button "Login"
    When user login with username "supervisor" and "tek_supervisor" as password
    Then user click on a visible text button "Sign In"
    Then user click on a link text button "Accounts"

    @accountStory1
    Scenario: navigate to CSP and verify the rows
      Then validate 5 rows is available