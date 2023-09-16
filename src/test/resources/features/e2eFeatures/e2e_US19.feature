@E2E @US19
Feature: The teacher should be able to create meetings with students feature

  @UI @US19
  Scenario: The teacher should be able to create meetings with students.
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "TeacherKatty"
    And user enters password "TeacherKatty11"
    And user clicks on login button
    And click menu button
    And click Meet Management button
    And select Student from Choose Students DDM
    And select Date Of Meet meeting time
    And enter Start Time for Add Meet
    And enter Stop Time for Add Meet
    And enter Description
    And click submit button

  @API @US19
  Scenario:

  @DB @US19
  Scenario:
    Given connect to database for DB
    When get student via name
    Then validate student, date of meet, start time, stop time, description is edited

