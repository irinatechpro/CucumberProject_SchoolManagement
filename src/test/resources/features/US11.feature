@US16
Feature:Vice Deans should be able to view the lesoon schedule and make updates.
  (Lesson Program - Lesson Program List)



  Background:go_MS_homepage_and_Login_as_Vice_Dean
    Given user navigates to "https://managementonschools.com/"
    And user login as Vice Dean
  @US01_TC01
  Scenario: Vice Dean should be able to view the Lesson, Day, Start Time and Stop Time created.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
  Then
  And

  @US01_TC02
  Scenario:Vice Dean should be able to update from the Lesson Program List.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
  Then
  And
  And
  @US01_TC03
  Scenario: Vice Dean should be able to delete from the Lesson Program List.
    And click Menu button
    And click Lesson Managment Link
    And click Lesson Program
  Then
  And