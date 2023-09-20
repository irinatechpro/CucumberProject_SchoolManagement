  @E2E_US11
    Feature: Vice Deans should be able to view the lesson schedule and make updates.
      (Lesson Program - Lesson Program List)
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

