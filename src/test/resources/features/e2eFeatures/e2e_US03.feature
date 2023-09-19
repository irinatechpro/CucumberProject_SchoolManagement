git @E2E @US03_Api
Feature: User should be able to send messages from contact page(Api)

  @API
  Scenario: TC_01 Fill out and submit the contact form(PositiveScenario)
    When user sends post request to send message from contact page
    Then validate response data is the same with created user credentials

