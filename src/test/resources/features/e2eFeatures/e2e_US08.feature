@E2E @US08_Api
Feature: Vice Deans should be able to create a lesson. (Lessons - Add Lesson)

  Background:
    Given login as vice dean is authorized on api

  @Api_TC01 @Api_viceDean

  @Api_US08_TC01-03 @Api_viceDean
  Scenario: Validate that the lesson names show up (Api)
    Then check lesson names all show up
    And show a specific lesson by name
    And find the lesson by its id