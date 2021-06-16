Feature: Dashboard tab functionality

  @dashboardtabs
  Scenario: dashboard tab verification
    When user enters valid admin username and login
    And user clicks on login button
    Then admin user is successfully logged in
    Then verify the following tabs on dashboard
      |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|