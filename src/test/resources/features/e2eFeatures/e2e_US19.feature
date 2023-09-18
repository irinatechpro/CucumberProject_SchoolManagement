@E2E @US19
Feature: The teacher should be able to create meetings with students feature

  @UI
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

  @API
  Scenario: The teacher should be able to create meetings with students.
    Given send post request for add meet
    Then verify meet could not created.

  @DB
  Scenario Outline:
    Given connect to database for DB
    When get students
    Then validate studentID "<studentID>", date "<date of meet>", start time "<start time>", stop time "<stop time>", description "<description>" is edited
    Examples:
      | studentID | date of meet | start time | stop time | description |
      |   534     | 2026-09-01   | 10:19:00   | 11:30:00  | Test Results|

