@US14
Feature: Vice Dean should be able to see and update teachers.

  Background:
    Given login as vice dean "vice.y23" "Viceyil123"

  @US14_TC01
  Scenario: The Name, Phone Number, SSN, and User Name information of the created teacher should be visible for Vice Dean.
    When Education Term Management page loads up
    Then Vice Dean clicks on Teacher Management menu link
    When the Teacher Information page loads
    Then Vice Dean should see teacher information

  @US14_TC02
  Scenario: Vice Deans should be able to update teacher information in the Teacher List.
    When Education Term Management page loads up
    Then Vice Dean clicks on Teacher Management menu link
    When the Teacher Information page loads
    Then Vice Dean should see teacher information
    And  Vice Dean should be able to update teacher information

