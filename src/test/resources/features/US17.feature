@US17
Feature: teacher  give Grade to the students
  Background: Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
  @US17_TC01
  Scenario:
    And user clicks on login link
    And user enters name "<username>"
    And user enters valid email address "<password>"
    And user clicks on login button
    Then Verify if the user logged in
    And user selects Java and API
      | username    | password |
      | philips | Philips#5678 |

  @US17_TC02
  Scenario :
    And user chooses lesson
    And user chooses student
    And user choose education term
    Then verify Teacher could choose lesson, student and education term


  @US17_TC03
  Scenario:
    And user enters absentee
    And user enters Midterm exam
    And user enters final exam
    And user enters info note
    Then user clicks on submit button