@US21
Feature: student choose lesson management panel
  Background: Go_to_Homepage
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "robertsmith"
    And user enters password "Abc12345"
    And user clicks on login button
  @US21_TC01
  Scenario: Students choose lesson, grades and announcement successfully
    Then verify Teacher, Day, Start Time and Stop Time are visible
    And user selects a lesson
    And user clicks on submit button
    Then verify lesson added to student message appear
    Then verify selected courses are visible in lesson program
    Then close the application


  @US21_TC02
  Scenario: Students choose lesson with same day and time
    Then verify Teacher, Day, Start Time and Stop Time are visible
    And user selects a lesson
    And user clicks on submit button
    Then verify course schedule cannot be selected for the same hour and day
    Then close the application


