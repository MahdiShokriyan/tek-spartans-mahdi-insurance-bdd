@Smoke @Regression
Feature: Login features

  Background: go to login page
    When user click on a link text button "Login"

  @loginStory2
  Scenario Outline: validate sign in with invalid credentials
    When user login with username "<username>" and "<password>" as password
    Then user click on a visible text button "Sign In"
    Then user should see error "<expectedResult>"

    Examples:
      | username       | password      | expectedResult                |
      | invaliduser123 | password@123  | User invaliduser123 not found |
      | mahdishokriyan | wrongpass@123 | Password not matched          |
      | invaliduser123 | wrongpass@123 | User invaliduser123 not found |

