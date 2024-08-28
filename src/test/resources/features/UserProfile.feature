@Regression
Feature:User Profile future

  Background: go to login page
    When user click on a link text button "Login"
    When user login with username "supervisor" and "tek_supervisor" as password
    Then user click on a visible text button "Sign In"
    Then user click on profile button

  @UserProfileStory1
  Scenario: login with admin credential and validate the information
    Then validate information in Profile Side Drawer is correct
      | User Type   | CSR        |
      | Full Name   | Supervisor |
      | UserName    | supervisor |
      | Authorities | admin      |

  @UserProfileStory2
  Scenario: login with admin credential and log out and make sure user navigate to home page
    Then user click on a visible text button "Logout"
    Then validate user navigated to home page