@US08
  Feature: Vice Deans should be able to create a lesson. (Lessons - Add Lesson)

    Background:
      Given login as vice dean "vice.y23" "Viceyil123"

    @US08_TC01
    Scenario: Vice Dean should be able to enter the name of lesson.
      When Education Term Management page loads up
      Then Vice Dean clicks on the Lessons tab
      And  Vice Dean types the lesson "name" into Lesson name field

    @US08_TC02
    Scenario: Vice Dean should be able to mark whether the course is compulsory or not.
      When Education Term Management page loads up
      Then Vice Dean clicks on the Lessons tab
      And Vice Dean clicks on the Compulsory checkbox

    @US08_TC03
    Scenario: Vice Dean should be able to enter the Credit Score.
      When Education Term Management page loads up
      Then Vice Dean clicks on the Lessons tab
      And Vice Dean adds Credit Score
