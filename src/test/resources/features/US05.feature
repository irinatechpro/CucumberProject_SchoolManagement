@US05
Feature: Admins should be able to see and delete Deans

  Background: Login as Admin User

    Given Admin user is on The Managementon Schools website
    And clicks on Login link
    And assserts that the page has Login title
    When enters username "AdminProjectDot"
    And password "Project11+"
    And Admin user clicks on login button
    Then asserts that page has "Admin Management" title

@US05_TC01

  Scenario: TC01_Admin should be able to see Name, Gender, Phone Number, SSN and User Name information of Deans

    Given Admin user clicks on menu button
    And Menu list is visible on the left hand side
    When user clicks on "Dean Management" link
    Then asserts that Deans information can be seen

@US05_TC03

  Scenario: TC03-Admin should be able to update Deans

    Given Admin user clicks on menu button
    And Menu list is visible on the left hand side
    When user clicks on "Dean Management" link
    And goes to Add Dean
    And enters name
    And enters surname
    And enters birthplace
    And clicks on Male for gender
    And enters Date of Birth
    And enters Phone number
    And enters ssn number
    And admin user enters username
    And admin user enters password "Project11++"
    And user clicks on submit
    And user scrolls down to to click last page button
    And user scrolls up to verify the dean created












