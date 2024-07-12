@SearchHotel
Feature: Verifying Adactin Search Hotel functionality

  Scenario Outline: Verifying Adactin Hotel Search function after selecting all Options
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 2 - Two   | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Search function after selecting only mandatory Options
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting only mandatory Options "<location>", "<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"

    Examples: 
      | userName   | password | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Greens8767 | L4R739   | Sydney   | 2 - Two   | 27/09/2022  | 30/09/2022   | 2 - Two       |

  Scenario Outline: Verifying Adactin Hotel Search function after enter higher Checkin date and lower Checkout date
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the error message after enter higher check-In date and lower check-Out date "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 2 - Two   | 27/09/2023  | 30/09/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Search function without selecting any of the Options
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search without selecting any of the Options
    Then User should verify the error message after perform Search without selecting any of the Options "Please Select a Location"

    Examples: 
      | userName   | password |
      | Greens8767 | L4R739   |
