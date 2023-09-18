  @E2E_US11
Feature:Vice Deans should be able to view the lesson schedule and make updates.
  (Lesson Program - Lesson Program List)


  @US11_UI

  Background:
    Given login as vice dean "Agent07" "11111111eW"
    When Management page loads up
    Then click Lesson Program

  @US11_TC01_UI
  Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    Then scroll down until see Lesson Program
    Then verify Lesson, Day, Start Time and Stop Time created are visible

  @US11_TC02_UI
  Scenario:Vice Dean should be able to update from the Lesson Program List.
    And verify update Button exists
    Then scroll down until see Lesson Program
    And verify update Button exists

  @US11_TC03_UI
  Scenario: Vice Dean should be able to delete from the Lesson Program List.
    Then verify Delete button is visible
    Then scroll down until see Lesson Program
    Then verify Delete button is visible


  @API

  @US11_TC01_API
  Scenario: US11_TC01 Vice Dean send get request for viewing lesson Program
    When send get request for viewing lesson Program
    Then  validate that response data includes the lesson program
  @US11_TC03_API
  Scenario: US11_TC03 Vice Dean send delete request for deleting lesson Program
    Given send post request for creating a lesson program
    Then  send delete request for deleting lesson Program

