@Regression
  Feature:
    Background: go to login page
      When user click on a link text button "Login"

    @UserProfileStory1
    Scenario: login with admin credential and validate the information
      When user login with username "supervisor" and "tek_supervisor" as password
      Then user click on a visible text button "Sign In"
      Then user click on profile button and validate the "Supervisor"
