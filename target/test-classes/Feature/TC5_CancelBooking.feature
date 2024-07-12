@CancelBooking
Feature: Verifying Adactin Hotel Cancel Booking functionality

  Scenario Outline: Verifying Adactin Hotel Cancel Booking functionality with generated Order id
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Kunjanmmk!"
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
    And User should Cancel the generated Order id
    Then User should verify the success message after the cancellation of Order id "The booking has been cancelled."

    Examples: 
      | userName  | password   | location | hotels      | roomType     | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address        |
      | Kunjanmmk | Selvah@789 | Sydney   | Hotel Creek | Super Deluxe | 5 - Five  | 27/09/2022  | 30/09/2022   | 2 - Two       | 2 - Two         | Karpaga   | Selvan   | Srivilliputtur |

  Scenario Outline: Verifying Adactin Hotel Cancel Booking functionality with existing Order id
    Given User is on the Adactin page
    When User should perform Login "<userName>", "<password>"
    Then User should verify after Login success message "Hello Kunjanmmk!"
    And User should cancel the existing Order id "<orderId>"
    Then User should verify the success message after the cancellation of Order id "The booking has been cancelled."

    Examples: 
      | userName  | password   | orderId    |
      | Kunjanmmk | Selvah@789 | NEJ9WB55O2 |
