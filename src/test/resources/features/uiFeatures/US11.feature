@US11
Feature:Vice Deans should be able to view the lesson schedule and make updates.
  (Lesson Program - Lesson Program List)
  Background:
    Given login as vice dean "Agent07" "11111111eW"
    When Management page loads up
    Then click Lesson Program

    When Management page loads up
    Then click Lesson Program

  @US11_TC01
 Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    Then scroll down until see Lesson Program
    Then verify Lesson, Day, Start Time and Stop Time created are visible

  @US11_TC02
  Scenario:Vice Dean should be able to update from the Lesson Program List.
    And verify update Button exists
    Then scroll down until see Lesson Program
    And verify update Button exists

  @US11_TC03
 Scenario: Vice Dean should be able to delete from the Lesson Program List.
    Then verify Delete button is visible
    Then scroll down until see Lesson Program
    Then verify Delete button is visible



