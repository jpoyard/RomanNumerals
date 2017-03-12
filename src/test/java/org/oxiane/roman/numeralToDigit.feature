@numeralToDigit
Feature: Write a function to convert in the other direction, ie numeral to digit

  Scenario Outline: numeralToDigit - The Romans wrote numbers using letters - I, V, X, L, C, D, M.
    Given the roman numeral value "<roman>"
    And the digit value <digit>
    When I call numeralToDigit function
    Then the digit should be <digit>

    Examples: numeralToDigit - defining letters
      | roman | digit |
      | I     |     1 |
      | V     |     5 |
      | X     |    10 |
      | L     |    50 |
      | C     |   100 |
      | D     |   500 |
      | M     |  1000 |

    Examples: numeralToDigit - some expected values
      | roman          | digit |
      | CMXCIX         |   999 |
      | CM             |   900 |
      | XC             |    90 |
      | MCMXC          |  1990 |
      | MM             |  2000 |
      | VIII   				 |     8 |
      | MMVIII 				 |  2008 |
      | MMMDCCCXCIX    |  3899 |

    Examples: numeralToDigit - specific values (not exceed 3 sames letters)
      | roman | digit |
      | IV    |     4 |
      | IX    |     9 |
      | XL    |    40 |
      | XC    |    90 |
      | CD    |   400 |
      | CM    |   900 |
