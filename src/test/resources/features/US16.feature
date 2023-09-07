@US16
Feature:The Vice Dean should be able to view the messages sent by users.

  Background: Login As Vice Dean
    Given user navigates to "https://managementonschools.com/"
    When click on login link
    And  enter username "Agent07"
    And  enter password "11111111eW"
    And  click on login button

  @US16_TC01
  Scenario: The Vice Dean should be able to see the delete button.
    And click Menu button
    And click Contact Get All button
    Then Verify Delete button is seen

  @US16_TC02
  Scenario:The Vice Dean should be able to view the messages, their authors, emails, sending date and subject information
    And click Menu button
    And click Contact Get All button
    Then verify messages, their authors, emails, sending date and subject information is visible

  @US16_TC03
  Scenario: The Vice Dean should be able to delete messages.
    And click Menu button
    And click Contact Get All button
    And click Delete button
    Then verify message is deleted