@BookHotel
Feature: Verifying Adactin Book Hotel functionality

  Scenario Outline: Verifying Adactin Hotel Book function after select all the fields
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"
    And User should Select Hotel
    Then User should verify the success message after select the Hotel "Book A Hotel"
    And User should select all the fields "<firstName>","<lastName>" and "<address>"
      | creditCardNum    | cardType         | expMonth  | expYear | cvvNum |
      | 7200654323419845 | American Express | March     |    2022 |    567 |
      | 8674654323419845 | Master Card      | September |    2022 |    434 |
      | 6535543234198455 | VISA             | July      |    2022 |    980 |
      | 4866543234190985 | Other            | June      |    2022 |    431 |
    Then User should verify the success message after select all the fields "Booking Confirmation"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address        |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 5 - Five  | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         | Karpaga   | Selvan   | Srivilliputtur |

  Scenario Outline: Verifying Adactin Hotel Book function without selecting any of the fields
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Greens8767!"
    And User should perform Search after selecting all the Options "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify the success message after perform Search "Select Hotel"
    And User should Select Hotel
    Then User should verify the success message after select the Hotel "Book A Hotel"
    And User should perform Book Now without selecting any of the fields
    Then User should verify the error message after perform Book Now without selecting any of the fields "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName   | password | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Greens8767 | L4R739   | Sydney   | Hotel Creek | Super Deluxe | 5 - Five  | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         |
