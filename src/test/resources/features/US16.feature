@US16
Feature:The Vice Dean should be able to view the messages sent by users.

  Background: Login As Vice Dean
    Given login as vice dean "Agent07" "11111111eW"
    And click Menu button
    And click Get All button

  @US16_TC01
  Scenario: The Vice Dean should be able to see the delete button.
    Then Verify Delete button is visible

  @US16_TC02
  Scenario:The Vice Dean should be able to view the messages, their authors, emails, sending date and subject information
    Then verify message is visible
    Then verify Name is visible
    Then verify Email is visible
    Then verify Date is visible
    Then verify Subject is visible

  @US16_TC03
  Scenario: The Vice Dean should be able to delete messages.
    Then verify ability to delete messages