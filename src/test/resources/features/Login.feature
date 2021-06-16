Feature: Login

  @mvn
  Scenario: valid admin login
    When user enters valid admin username and login
    And user clicks on login button
    Then admin user is successfully logged in

  @simpletag
  Scenario: valid ess employee login
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  @regression
  Scenario: login with valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user sees invalid credentials text on login page

  @example
  Scenario Outline: login with multiple data
    When user enters "<username>" and "<password>"
    And user clicks on login button
    And "<firstname>" is successfully logged in
    Examples:
      | username          | password     | firstname |
      | william1236000000 | Syntax12!!!! | William   |
      | Admin             | Hum@nhrm123  | Admin     |

  @error
  Scenario: login with valid username and invalid password
    When user enters valid username and invalid password and verify the error
      | username | password     | errormessage        |
      | Admin    | Human        | Invalid credentials |
      | Admin    | Syntax12!!!! | Invalid credentials |

  @errorvalidation
  Scenario Outline: login with multiple username and password combinations
    When user enters different "<username>" and "<password>" and verify the "<error>" for all the combinations
    Examples:
      | username | password     | error                    |
      | Admin    | Syntax123    | Invalid credentials      |
      | munz     | Hum@nhrm123! | Invalid credentials      |
      | luda     |              | Password cannot be empty |
      |          | pass123      | Username cannot be empty |