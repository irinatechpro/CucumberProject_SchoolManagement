@US10
Feature: "Vice Deans should be able to create a lesson schedule.
  (Lesson Program - Add Lesson Program)"

  Background:
    Given login as vice dean "ViceDeanEmilly" "ViceDeanEmilly123"

  @US10_TC01
  Scenario: With Valid Credentials
   And click menu button
   And click Lesson Management
    And click Lesson Program
    And choose Lesson
    And choose education term
And chose day
And choose start time
    And choose stop time
    And user clicks submit button





