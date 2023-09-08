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

  Scenario: TC01

    Given Admin user clicks on menu button
    And Menu list is visible on the left hand side
    When user clicks on "Dean Management" link
    Then asserts that Deans information can be seen
    Then close the application