@US07
Feature: Deans should be able to see the messages sent by users feature

  Background: user goes to school management home page and login as a Dean
  Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "DeanVena"
    And user enters password "DeanVena11"
    And user clicks on login button
    And click Menu button
    And click Contact Get All button

  @US07_TC01
  Scenario: TC01 Deans should be able to see the delete button
  Then verify delete button is seen
  Then close the application


  @US07_TC02
  Scenario: TC02 Deans should be able to view messages, authors, emails,sending dates, and subject information
    Then verify message is seen
    Then verify Name is seen
    Then verify Email is seen
    Then verify Date is seen
    Then verify Subject is seen
    Then close the application

  @US07_TC03
  Scenario: TC03 Dean should be able to delete messages
    Then verify message is deleted
    Then close the application