@Order_Operations
Feature: Test for Store Module

	@Create_Order
	Scenario Outline: Create Pet Order
		Given User creates order with parameters id "<Id>" and petId "<PetId>" and quantity "<Quantity>" shipdate "<ShipDate>" and status "<Status>" and complete "<CompletionStatus>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the order details by orderId "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Examples:
			| Id | PetId | Quantity | ShipDate | Status | CompletionStatus |StatusCode|StatusLine|
			| 5 | 1424 | 300 | 2023-07-11T14:55:45.754Z | placed | True | 200 | OK |
			| 8 | 1425 | 500 | 2023-07-12T14:55:45.754Z | pending | False | 200 | OK |
			| 15 | 1425 | 500 | 2023-07-12T14:55:45.754Z | sold | False | 200 | OK |

	@Create_Order_Invalid
	Scenario Outline: Create Pet Order Invalid
		Given User creates order with parameters id "<Id>" and petId "<PetId>" and quantity "<Quantity>" shipdate "<ShipDate>" and status "<Status>" and complete "<CompletionStatus>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Examples:
			| Id | PetId | Quantity | ShipDate | Status | CompletionStatus |StatusCode|StatusLine|
			| 15 | 1424 | 300 | 2023-07-11T14:55:45.754Z | placed | True | 200 | OK |
			| 8a | 1425 | 500 | 2023-07-12T14:55:45.754Z | pending | False | 200 | OK |

	@Get_Order
	Scenario Outline: Get Pet Order
		Given User fetches the order details by orderId "<OrderId>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Examples:
			| OrderId | StatusCode | StatusLine |
			|5        |200         |OK          |
			|a        |404         |Not Found   |
			|15        |200         |OK   |


	@Delete_Order
	Scenario Outline: Delete Pet Order
		Given User deletes the order by orderId "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Examples:
			| Id | StatusCode | StatusLine |
			| 4       | 200        | OK         |
			| 5a       | 404        | Not Found         |
			| 15       | 404        | Not Found         |


	@Fetch_Inventory @Smoke
	Scenario Outline: Fetch Inventory
		Given User fetches the inventory
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		And Inventory with Status "<InventoryStatus>" and count <Count> is found
		Examples:
			| StatusCode | StatusLine |InventoryStatus|Count|
			| 200        | OK         |new      |1   |

	@CRUD_Order @Smoke
	Scenario Outline: CRUD Pet Order
		Given User creates order with parameters id "<Id>" and petId "<PetId>" and quantity "<Quantity>" shipdate "<ShipDate>" and status "<Status>" and complete "<CompletionStatus>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the order details by orderId "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User deletes the order by orderId "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the order details by orderId "<Id>"
		Then Status code is <StatusCode2>
		And Status in response body is "<StatusLine2>"
		Examples:
			| Id | PetId | Quantity | ShipDate | Status | CompletionStatus |StatusCode|StatusLine|StatusCode2|StatusLine2|
			| 5 | 1424 | 300 | 2023-07-11T14:55:45.754Z | placed | True | 200 | OK |404                     |Not Found |
