@US12
  Feature: Vice Deans should be able to assign lessons to teachers. (Lesson Program - Lesson Program Assignment)

    Background: Go_To_Homepage_And_Login_As_Vice_Dean
      Given user navigates to "https://managementonschools.com/"
      And user clicks on login link
      And user enters username "tomVice"
      And user enters password "tomVice1"
      And user clicks on login button

      @US12_TC01
      Scenario: Vice_Dean_should_see_created_lesson
        When the Education Term Management page loads up
        Then Vice Dean click on Lesson Program
        Then Vice Dean scroll down until see Lesson Program Assignment
        And Vice Dean should see the created lesson

        @US12_TC02
        Scenario: Vice Deans should be able to select a teacher for the lesson.
          When the Education Term Management page loads up
          Then Vice Dean click on Lesson Program
          Then Vice Dean scroll down until see Lesson Program Assignment
          And Vice Dean  tick to choose lesson
          And Vice Dean should scroll down until see the Choose Teacher
          Then Vice Dean click on Choose Teacher
          And Vice Dean select teacher
          Then Vice Dean click on submit button
          And Vice Dean should see Lesson added to Teacher


























