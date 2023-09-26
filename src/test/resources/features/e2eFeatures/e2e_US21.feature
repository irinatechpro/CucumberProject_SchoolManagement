@E2E @US21_Api
Feature: student choose lesson from management panel(Api)
  Background:Go_to_Homepage
    Given user navigates to "https://managementonschools.com"
    And user clicks on login link
   # Given login as vice dean "vice.y23" "Viceyil123"
    #Then Vice Dean clicks on the Lessons tab
    #And  Vice Dean types the lesson "name" into Lesson name field
    #Then Vice Dean clicks on the Lessons tab
   # And Vice Dean clicks on the Compulsory checkbox
    #Then Vice Dean clicks on the Lessons tab
    #And Vice Dean adds Credit Score
    #And click menu button
    #And click logout button
    #And user clicks on login link
    And user enters username "samcarter"
    And user enters password "Abc12345"
    And user clicks on login button

 @US21_Api @Api_student
  Scenario: Validate chosen lessons on API (PositiveScenario)
    When send post request to select a lesson from lessons page
    Then validate lesson is added to list or error message about double booking
   # Then validate response data is the same with selected courses

  @US21_DB
  Scenario Outline:Validate selected lesson on database
    Given connect to database
    When get selected course via student name "<name>"
    Then validate course lesson title "<lesson_name>" day "<day>" start_time "<start_time>" stop_time "<stop_time>"
    And close the connection
    Examples:
      | lesson_name | day    | start_time | stop_time |
      | Physics     | FRIDAY | 12:00:00   | 13:00:00  |