Feature: Adding employees

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add employee button

  @smoke
  Scenario: adding employee from add employee page
    And User enters firstname, middlename, and lastname
    And user clicks on save button option
    Then employee added successfully

  @smoke
  Scenario: adding employee from add employee page via feature file
    And user enters first name "Yoooo123" middle name "midsss" and last name "yeaaaa"
    And user clicks on save button option
    Then employee added successfully

  @example
  Scenario Outline: adding employee from add employee page via feature file
    And user enters "<firstName>" "<middleName>" and "<lastName>" in the application
    And user clicks on save button option
    Then employee added successfully

    Examples:
      | firstName | middleName | lastName |
      | Jibreal   | Munz       | Luda     |
      | Testing1  | Test1      | Testsss1 |
      | Testing2  | Test2      | Testsss2 |

  @datatablewithheader
  Scenario: adding multiple employees in a single execution
    When adding multiple employees and verify they are added successfully
      | firstName | middleName | lastName |
      | Jon111    | Al         | David    |
      | Bob344    | B          | Don      |

  @excel
  Scenario: adding the employees from excel file
    When user adds multiple employees from excel file "newEmployees" sheet and verify they are added