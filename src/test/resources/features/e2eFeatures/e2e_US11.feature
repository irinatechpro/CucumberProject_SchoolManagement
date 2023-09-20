  @E2E_US11
Feature:Vice Deans should be able to view the lesson schedule and make updates.
  (Lesson Program - Lesson Program List)

  @US11_UI

  @US11_TC01_UI

  Scenario: login as vice dean "Agent07" "11111111eW"
    Given login as vice dean "Agent07" "11111111eW"
    When Management page loads up
    Then click Lesson Program

  Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    Then scroll down until see Lesson Program
    Then verify Lesson, Day, Start Time and Stop Time created are visible
  @US11_TC02_UI
  Scenario:Vice Dean should be able to update from the Lesson Program List.
    And verify update Button exists
    Then scroll down until see Lesson Program
    And verify update Button exists
  @US11_TC03_UI
  Scenario: Vice Dean should be able to delete from the Lesson Pgit switch rogram List.
    Then verify Delete button is visible
    Then scroll down until see Lesson Program
    Then verify Delete button is visible

  @API

  @US11_TC01_API
  Scenario: US11_TC01 Vice Dean send get request for viewing lesson Program
  #The created entity should be able to display Lesson, Day, Start Time, and Stop Time.
    When send get request for viewing lesson Program
    #vice dean sends getAll request for lesson program

  @E2E_US11_01
  Scenario: TC01 The created entity should be able to display Lesson, Day, Start Time, and Stop Time.
      When send get request for viewing lesson Program
    # getAll request

    Then  validate that response data includes the lesson program
    # gets the lesson program and assert
  @E2E_US11_02
  Scenario: TC02 They should be able to update from the Lesson Program List.
    Given Vice Dean sends post request for lesson program
    Then Vice Dean update the lesson program and assert
  @E2E_US11_03
  Scenario: TC03 Vice Dean send delete request for deleting lesson Program
    #Deletion should be possible from the Lesson Program List.
    Given send post request for creating a lesson program
    #vice dean sends delete request for lesson program
    Then  send delete request for deleting lesson Program
    #vice dean delete the lesson program from id and assert

