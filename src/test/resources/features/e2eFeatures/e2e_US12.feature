@e2e_US12
  Feature: Vice Deans should be able to assign lessons to teachers. (Lesson Program - Lesson Program Assignment)
    @US12_UI
    Scenario: Vice Deans should be able to select a teacher for the lesson.
      Given user navigates to "https://managementonschools.com/"
      And user clicks on login link
      And user enters username "Agent07"
      And user enters password "11111111eW"
      And user clicks on login button
      When the Education Term Management page loads up
      Then Vice Dean click on Lesson Program
      Then Vice Dean scroll down until see Lesson Program Assignment
      And Vice Dean  tick to choose lesson
      And Vice Dean should scroll down until see the Choose Teacher
      Then Vice Dean click on Choose Teacher
      And Vice Dean select teacher
      Then Vice Dean click on submit button
      And Vice Dean should see Lesson added to Teacher

    @US12_API @Api_viceDean
      Scenario: Validate Lesson added to Teacher
      Given send GET request to lesson programs with getAllAssigned
      Then validate that teacher is assign to lesson
