@Smoke @Regression
Feature: Login features

  Background: go to login page
    When user click on a link text button "Login"

  @loginStory1
  Scenario: sign in with admin credential
    When user login with username "supervisor" and "tek_supervisor" as password
    Then user click on a visible text button "Sign In"
    #Then user wait for 1 second
    Then validate user is navigated to "Customer Service Portal"


