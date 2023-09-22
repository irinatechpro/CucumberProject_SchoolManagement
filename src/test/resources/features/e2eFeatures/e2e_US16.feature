  @E2E_US16
    Feature: The Vice Dean should be able to view the messages sent by users.
      Background: Login As Vice Dean
  @E2E_US16_01
  Scenario: The Vice Dean should be able to see the delete button.
      When #send get request for viewing lesson Program


    Then # validate that response data includes the lesson program

  @E2E_US16_02
  Scenario: The Vice Dean should be able to view the messages, their authors, emails, sending date and subject information
    When #Vice Dean sends post request for lesson program
    Then #Vice Dean update the lesson program and assert
  @E2E_US16_03
  Scenario: The Vice Dean should be able to delete messages.

    Given #send post request for creating a lesson program

    Then  #send delete request for deleting lesson Program


      @DB_TC01
      Scenario Outline: validate created meeting
        Given connect to database
        When get meeting via description "<description>"
        Then validate  description "<description>" date "<date>" start_time "<start_time>"   stop_time "<stop_time>"
        And close the connection
        Examples:
          | description      | date                         | start_time              | stop_time                |
          | rehberlk         | 2023-10-10                   | 08:20:00                | 09:20:00