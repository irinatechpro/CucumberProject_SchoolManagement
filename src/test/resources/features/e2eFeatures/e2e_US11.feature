  @E2E_US11
 # @US11_UI
  Feature:Vice Deans should be able to view the lesson schedule and make updates
    (Lesson Program - Lesson Program List)
    Background:
      Given login as vice dean "Agent07" "11111111eW"
      When Management page loads up
      Then click Lesson Program

    @US11_TC01_UI
    Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created on UI
      Then scroll down until see Lesson Program
      Then verify Lesson, Day, Start Time and Stop Time created are visible

    @US11_TC02_UI
    Scenario:Vice Dean should be able to update from the Lesson Program List on UI
      And verify update Button exists
      Then scroll down until see Lesson Program
      And verify update Button exists

    @US11_TC03_UI
    Scenario: Vice Dean should be able to delete from the Lesson Program List on UI
      Then verify Delete button is visible
      Then scroll down until see Lesson Program
      Then verify Delete button is visible
  @US11_API
    @US11_01_API
    Scenario: TC01 The created entity should be able to display Lesson, Day, Start Time, and Stop Time on API
    When send getAll request for viewing lesson Program
    Then  validate that response data includes the lesson program
    @US11_02_API
    Scenario: TC02 They should be able to update from the Lesson Program List on API
    When Vice Dean sends post request for lesson program
    Then Vice Dean update the lesson program and assert
    @11_03_API
    Scenario: TC03 Vice Dean send delete request for deleting lesson Program on API
    Given send post request for creating a lesson program
    Then  send delete request for deleting lesson Program


