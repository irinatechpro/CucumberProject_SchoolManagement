@US18
Feature: The teacher should be able to view and update the grades given to the student.(Student Info List)

  Background:
    Given logged in as Teacher and viewing student info page

    @US18_TC01
    Scenario: In the Student Info List; Name, Lesson Name, Absentee, Midterm and Final Exam, Note, Info Note and Average information should be visible.
      Then teacher can see student information

    @US18_TC02
    Scenario: The teacher should be able to update the student grade information
      Then teacher clicks the edit button
      And teacher is able to update student grade information

    @US18_TC03
    Scenario: The teacher should be able to delete the grade information.
      Then teacher clicks on the delete button to delete student grade information