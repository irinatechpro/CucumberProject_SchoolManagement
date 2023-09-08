@US16
Feature:The Vice Dean should be able to view the messages sent by users.

  Background: Login As Vice Dean
    Given login as vice dean "Agent07" "11111111eW"
    And click Menu button
    And click Contact Get All button


  @US16_TC01
  Scenario: The Vice Dean should be able to see the delete button.
#    And click Menu button
#    And click Contact Get All button
    Then Verify Delete button is visible

  @US16_TC02
  Scenario:The Vice Dean should be able to view the messages, their authors, emails, sending date and subject information
    And click Menu button
    And click Contact Get All button
    Then verify message is seen
    Then verify Name is seen
    Then verify Email is seen
    Then verify Date is seen
    Then verify Subject is seen

  @US16_TC03
  Scenario: The Vice Dean should be able to delete messages.
    And click Menu button
    And click Contact Get All button
    Then verify message is deleted