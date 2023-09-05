@US11
Feature:The Vice Dean should be able to view the messages sent by users.



  Background:go_MS_homepage_and_Login_as_Vice_Dean
    Given user navigates to "https://managementonschools.com/"
    And user login as Vice Dean
  @US01_TC01
  Scenario: The Vice Dean should be able to see the delete button.
    And click Menu button
    And click Contact Get All button
    And Verify Delete button is seen
    Then
    And

  @US01_TC02
  Scenario:The Vice Dean should be able to view the messages, their authors, emails, sending date and subject information
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
    Then
    And
    And
  @US01_TC03
  Scenario: The Vice Dean should be able to delete messages.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
  Then
  And