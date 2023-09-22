@E2E
Feature: The teacher should be able to create meetings with students feature




  @UI_TC01
  Scenario: The Date, Start Time, Stop Time and Description of the meetings should be visible to the teacher
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "Anna"
    And user enters password "Anna123@"
    And user clicks on login button
    And click menu button
    And click Meet Management button
    And select Student
    And select Date Of Meeting
    And enter Start Time
    And enter Stop Time
    And enter Description of meet
    And click submit button
    And Verify the date is visible
    And Verify the start time is visible
    And Verify the stop time is visible
    And Verify the description is visible

  @API_TC01
  Scenario:

  @DB_TC01
  Scenario Outline: validate created meeting
    Given connect to database
    When get meeting via description "<description>"
    Then validate  description "<description>" date "<date>" start_time "<start_time>"   stop_time "<stop_time>"
    And close the connection
    Examples:
      | description      | date                         | start_time              | stop_time                |
      | rehberlk         | 2023-10-10                   | 08:20:00                | 09:20:00                  |


  @UI_TC02
  Scenario: Teacher can update meet
    And click on edit button
    And update description
    And user click on submit button
    And Verify meet is successfully updated

  @API_TC02
  Scenario:

  @DB_TC02
  Scenario:

  @UI_TC03
  Scenario: Teacher can delete meet
    And click on delete button
    And Verify meet is successfully deleted

  @API
  Scenario:

  @DB_TC03
  Scenario:



