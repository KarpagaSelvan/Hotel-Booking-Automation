@SelectHotel
Feature: Verifying Adactin Select Hotel functionality

  Scenario Outline: Verifying Adactin Hotel Select function after select the Hotel
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"
    And User should Select Hotel
    Then User should verify the success message after select the Hotel "Book A Hotel"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 5 - Five  | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Select function without selecting any of the Hotels
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"
    And User should perform Continue without selecting any of the Hotels
    Then User should verify the error message after perform Continue without selecting any of the Hotels "Please Select a Hotel"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 5 - Five  | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         |
