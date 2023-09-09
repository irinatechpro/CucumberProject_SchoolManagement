@US19
Feature: The teacher should be able to create meetings with students feature

  Background: user goes to school management home page and login as a Teacher
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "TeacherKatty"
    And user enters password "TeacherKatty11"
    And user clicks on login button
    And click menu button
    And click Meet Management button

  @US19_TC01
  Scenario: "Choose Students" should be selected
  And select Student from Choose Students DDM
  Then verify Choose Students is selected
    Then close the application

  @US19_TC02
  Scenario: "Start time ve Stop Time" start and end times must be entered
  And enter Start Time for Add Meet
  Then verify Start Time is entered
  And enter Stop Time for Add Meet
  Then verify Stop Time is entered
    Then close the application


  @US19_TC03
  Scenario: Description must be entered
  And enter Description
  Then verify Description is entered
    Then close the application



  Scenario: Date of Meet meeting time can be selected. Past date should not be entered.
  And select Date Of Meet meeting time
  Then verify Date of Meet meeting time is selected
    Then close the application


  @US19_TC05
  Scenario: "Date of Meet" meeting time can be selected. Past date should not be entered.
  And select Student from Choose Students DDM
    And select Date Of Meet meeting time with past date
  And enter Start Time for Add Meet
  And enter Stop Time for Add Meet
  And enter Description
  And click submit button
  Then verify İleri bir tarih olmalı alert is seen
    Then close the application


  @US19_TC06
  Scenario: The teacher should be able to create meetings with students.
    And select Student from Choose Students DDM
    And select Date Of Meet meeting time
    And enter Start Time for Add Meet
    And enter Stop Time for Add Meet
    And enter Description
    And click submit button
    Then verify meeting is not created
    Then close the application
