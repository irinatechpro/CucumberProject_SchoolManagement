@US11
Feature:Vice Deans should be able to view the lesson schedule and make updates.
  (Lesson Program - Lesson Program List)



  Background: Login As Vice Dean
    Given user navigates to "https://managementonschools.com/"
    When click on login link
    And  enter username "Agent07"
    And  enter password "11111111eW"
    And  click on login button

  @US11_TC01
  Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    And click on Menu button
    And click on Lesson Management Link
    And click Lesson Program
    And select  Lesson
    And choose Day
    And choose Education Term
    And enter Start Time
    And enter Stop Time
    And user clicks Submit button
    Then verify "Created Lesson Program" message is appear
    Then verify Lesson, Day, Start Time and Stop Time created are visible
    Then close the application

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




