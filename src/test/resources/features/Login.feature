Feature: Login feature

  Scenario:
    Given I open browser
    And I open Login page
    When I enter email "khrystal.colon@testpro.io"
    And I enter password "t3$t$tudent"
    And I submit
    Then I am logged in