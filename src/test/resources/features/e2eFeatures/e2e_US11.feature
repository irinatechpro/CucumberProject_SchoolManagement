#@E2E
Feature:Vice Deans should be able to view the lesoon schedule and make updates.
  @US11_TC01_API
  Scenario: US11_TC01 Vice Dean send get request for viewing lesson Program
    When send get request for viewing lesson Program
    Then  validate that response data includes the lesson program
  @US11_TC03_API
  Scenario: US11_TC03 Vice Dean send delete request for deleting lesson Program
    Given send post request for creating a lesson program
    Then  send delete request for deleting lesson Program

