Feature: Automation Amazon Application

  Scenario Outline: Test for Mobile Purchase
    Given User clicks on Mobile tab
    When User clicks on brand filter and select "<brand>"
    Then User should be able to see the mobiles of selected "<brand>"
    And User clicks on first mobile and add to cart
    And User clicks on cart icon and proceed to checkout

    Examples:
      | brand   |
      | Samsung |
      | Apple   |
      | OnePlus |