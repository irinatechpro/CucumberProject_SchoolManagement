@US21
Feature: student choose lesson management panel
  Background: Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
  @US21_TC01
  Scenario Outline: Students choose lesson, grades and announcement successfully
    And user clicks on login link
    And user enters name "<username>"
    And user enters valid email address "<password>"
    And user clicks on login button
    Then verify Teacher, Day, Start Time and Stop Time are visible
    And user selects Java and API
    And user clicks on submit button
    Then verify lesson added to student message appear
    Then verify selected courses are visible in lesson program
    Then close the application
    Examples: test_data
      | username    | password |
      | robertsmith | Abc12345 |

  @US21_TC02
  Scenario Outline: Students choose lesson with same day and time
  user clicks on login link
    And user enters name "<username>"
    And user enters valid email address "<password>"
    And user clicks on login button
    Then verify Teacher, Day, Start Time and Stop Time are visible
    And user selects English and Java
    And user clicks on submit button
    Then verify course schedule cannot be selected for the same hour and day
    Then close the application
    Examples: test_data
      | username    | password |
      | robertsmith | Abc12345 |

