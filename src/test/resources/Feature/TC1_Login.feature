@Login
Feature: Verifying the Adactin Hotel Login details


  Scenario Outline: Verifying Adactin Hotel Login with valid entries
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"

    Examples: 
      | userName   | password |
      | Greens8767 | L4R739   |

  Scenario Outline: Verifying Adactin Hotel Login using Enter
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>" with Enter key
    Then User should verify after Login success message "Hello Greens8767!"

    Examples: 
      | userName   | password |
      | Greens8767 | L4R739   |

  Scenario Outline: Verifying Adactin Hotel Login using invalid credentials
   Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login with invalid credentials error message "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | userName  | password |
      | Greens123 | G123     |
