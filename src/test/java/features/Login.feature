Feature: Login Feature

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter the Email and password
    And I click on login button
    Then I should see the home page

  Scenario Outline: login with invalid credentials
    Given I navigate to login page
    When I enter the email as "<Email>" and password as "<Password>"
    And I click on the login button
    Then Error message should appear

    Examples:
      |       Email            |       Password          |
      |    owner@app.com       |       Wrong123          |
      |    Wrong@app.com       |       12345678          |
      |    Wrong@app.com       |       Wrong123          |

