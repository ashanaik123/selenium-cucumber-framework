Feature: menu selection

  @menu

  Scenario Outline: hover over menu option
    Given  I'm on the home page "https://www.next.co.uk/"
    When  I hover over on the menu option "<Menu>"
    And click the link "<Menu>"
    Then  I should navigate to the women screen "<PageTitle>"

    Examples:
      | Menu  |PageTitle|
      | WOMEN |Women's Clothing|
      | MEN   |Mens Clothing |
      | BABY  |Baby Clothes |