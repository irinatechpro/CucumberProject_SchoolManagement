@E2E @US07
Feature: Deans should be able to see the messages sent by users feature

  @US07_UI
  Scenario: TC02 Deans should be able to view messages, authors, emails,sending dates, and subject information
    Given user navigates to "https://managementonschools.com/"
    And user clicks on login link
    And user enters username "DeanVena"
    And user enters password "DeanVena11"
    And user clicks on login button
    And click menu button
    And click Contact Get All button
    Then verify message is seen
    Then verify Name is seen
    Then verify Email is seen
    Then verify Date is seen
    Then verify Subject is seen
    Then close the application

  @US07_API @Api_dean
  Scenario: TC_01 Deans should be able to see the messages sent by users
    Given send get request for messages
    Then verify message, Name, Email, Date, Subject is seen



