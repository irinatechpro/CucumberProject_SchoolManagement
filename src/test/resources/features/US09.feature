@US09
  Feature: Vice Deans should be able to view the lesson list and make updates (Lessons - Lesson List)

    Background:
      Given login as vice dean "vice.y23" "Viceyil123"

    @US09_TC01
    Scenario: Vice Dean should be able to view the Lesson Name, Compulsory and Credit Score created.
      When Education Term Management page loads up
      Then Vice Dean clicks on the Lessons tab
      And  Vice Dean types the lesson "name" into Lesson name field
      And Vice Dean clicks on the Compulsory checkbox
      And Vice Dean adds Credit Score
      And Vice Dean adds lesson to the lesson list
      And Vice Dean checks the created fields

    @US09_TC02
    Scenario:  Vice Dean should be able to delete the lesson.
      When Education Term Management page loads up
      Then Vice Dean clicks on the Lessons tab
      And  Vice Dean types the lesson "name" into Lesson name field
      And Vice Dean clicks on the Compulsory checkbox
      And Vice Dean adds Credit Score
      And Vice Dean adds lesson to the lesson list
      And Vice Dean checks the created fields
      And Vice Dean clicks on the Delete icon to delete Lesson