@US11
Feature:Vice Deans should be able to view the lesson schedule and make updates.
  (Lesson Program - Lesson Program List)
  Background: Login As Vice Dean
    Given user navigates to "https://managementonschools.com/"
    When click on login link
    And  enter username "Agent07"
    And  enter password "11111111eW"
    And  click on login button
  @US11_01
  Scenario Outline: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    And click on Menu button
    And click on Lesson Management Link
    And click Lesson Program
    And select lesson type "<lesson type>"
    And select day type "<day type>"
    And select education Term "<education term>"
    And enter Start Time "<start time>"
    And enter Stop Time "<stop time>"
    And user clicks Submit button
    Then assert the alert message containsCreated Lesson Program
    Then verify Lesson, Day, Start Time and Stop Time created are visible
    #Then close the application
    Examples:
  |lesson type|education term  |day type   |start time|stop time|
  |English    |SPRING_SEMESTER |MONDAY      |15:00     |16:00    |

  @US11_TC02
  Scenario:Vice Dean should be able to update from the Lesson Program List.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
    Then verify Update button is visible
    Then verify Lesson Programm List is updated
    Then close the application

  @US11_TC03
  Scenario: Vice Dean should be able to delete from the Lesson Program List.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
    Then verify Delete button is visible
    Then verify Lesson Programm List is updated
    Then close the application




