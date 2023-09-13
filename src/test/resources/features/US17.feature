@US17
Feature: The teacher should be able to give grades to the students

  Background: goto homepage_and_login
     Given user navigates to
     And user clicks on the login link
     And user enters username
     And user enters password
     And user click on login button
  @US17_TC01
  Scenario: The lesson, student and semester should be selectable
    And user chooses the lesson
    And user chooses the student
    And user choose education term
    And user enters Absentee
    And user enters Midterm exam grade
    And user enters final exam grade
    And user enters info note
    And user user clicks on submit button
    Then verify student info added successfully ont the list
