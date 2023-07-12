@Order_Operations
Feature: Test Add and Delete place of google map

	#@Create_Order
	#Scenario: Create Pet Order
	 #   Given User creates order with parameters id 8 and petId 1422 and quantity 200 shipdate "2023-07-11T14:55:45.754Z" and status "placed" and complete "True"
	  #  Then Status code is 200
	   # And "status" in response body is "OK"

	@Create_Order2
	Scenario Outline: Create Pet Order
		Given User creates order with parameters id <Id> and petId <PetId> and quantity <quantity> shipdate "<ShipDate>" and status "<Status>" and complete "<CompletionStatus>"
		Then Status code is <StatusCode>
		And "status" in response body is "<StatusLine>"
		Examples:
			| Id | PetId | quantity | ShipDate | Status | CompletionStatus |StatusCode|StatusLine|
			| 5 | 1424 | 300 | 2023-07-11T14:55:45.754Z | placed | True | 200 | OK |
			| 8 | 1425 | 500 | 2023-07-12T14:55:45.754Z | pending | False | 200 | OK |

	@Get_Order
	Scenario: Get Pet Order
		Given User fetches the order details by orderId 8
		Then Status code is 200
		And "status" in response body is "OK"

	@Delete_Order
	Scenario: Delete Pet Order
		Given User deletes the order by orderId "8"
		Then Status code is 404
		And "status" in response body is "Not Found"

	@Get_Order2
	Scenario: Get Pet Order2
		Given User fetches the order details by orderId "a"
		Then Status code is 404
		And "status" in response body is "Not Found"