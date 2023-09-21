@E2E @US09_Api
Feature: Vice Deans should be able to view the lesson list and make updates (Lessons - Lesson List)

  Background:
    Given login as vice dean is authorized on api

  @Api_TC01 @Api_viceDean
  Scenario: Vice Dean should be able to view the Lesson Name, Compulsory and Credit Score created.
    Then create a new lesson
    And view the new lesson created
    And delete the created lesson