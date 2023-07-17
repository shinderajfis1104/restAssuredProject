@Pet_Operations
Feature: Tests for Pet Module

	@Get_Pet_By_Status_DropDown
	Scenario Outline: Get Pet By Status
		Given User fetches the pet details by Pet Status "<PetStatus>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		And Pet with name "<PetName>" is found in the list
		Examples:
			| PetStatus| StatusCode |StatusLine| PetName |
			| sold | 200  | OK | Rio_Jagtap |
			| available | 200  | OK | doggie |
			| pending | 200  | OK | TestPet1 |


	@Get_Pet_By_Id
	Scenario Outline: Get Pet By Id
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		And Pet with name "<PetName>" is found
		Examples:
			| Id| StatusCode |StatusLine| PetName |
			| 23 | 200  | OK |Rahul|
			| 7579402596501828000 | 200  | OK | Rio_Jagtap |
			| 120 | 404  | Not Found | doggie |
			| a24 | 404  | Not Found | TestPet1 |


	@Update_Pet_By_Form
	Scenario Outline: Update Pet By Form
		Given User updates the pet details by form with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Pet with name "<PetName>" is found
		And Pet with status "<PetStatus>" is found
		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|
			| 23 |RahulB|sold| 200  | OK                  |
			| 23 ||pending| 200  | OK |
			| 23 |RahulP|| 200  | OK |
			|23 |Rahul|available| 200  | OK |
			| 260 |RahulP|| 404  | Not Found |
			|23w |Rahul|available| 404  | Not Found |

	@Create_Pet
	Scenario Outline: Create Pet
		Given User creates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Pet with name "<PetName>" is found
		And Pet with status "<PetStatus>" is found
		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|PhotoURL|
			| 24 |RahulB|sold| 200  | OK                  |ABC|
			| 19 ||pending| 200  | OK |ABCDEFG                    |
			| 23 |RahulP|| 200  | OK |NICE|
			| 9223372036854775807 |RahulM|| 200  | OK |NICE|



	@Create_Pet_Invalid
	Scenario Outline: Create Pet Invalid
		Given User creates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"

		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|PhotoURL|
			|23q |Rahul|available| 500  | Server Error |PQR|
			| 9223372036854775808 |RahulM|| 500  | Server Error |NICE|


	@Update_Pet
	Scenario Outline: Create Pet
		Given User updates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Pet with name "<PetName>" is found
		And Pet with status "<PetStatus>" is found
		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|PhotoURL|
			| 24 |RahulB|sold| 200  | OK                  |ABCDEF|
			| 19 |RahulW|| 200  | OK |ABCDEFG                    |
			| 23 ||pending| 200  | OK |NICE|


	@Update_Pet_Invalid
	Scenario Outline: Update Pet Invalid
		Given User updates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"

		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|PhotoURL|
			|23q |Rahul|available| 500  | Server Error |PQR|

	@Delete_Pet
	Scenario Outline: Delete Pet
		Given User deletes the pet by Id "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Examples:
			| Id| StatusCode |StatusLine|
			|23| 200  | OK |
			|219| 404  | Not Found |
			|219a| 404  | Not Found |

	@CRUD_Pet @Smoke
	Scenario Outline: CRUD Pet
		Given User creates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Pet with name "<PetName>" is found
		And Pet with status "<PetStatus>" is found
		Given User updates the pet details by form with Pet Id "<Id>" and Pet Name "<PetName2>" and Pet Status "<PetStatus2>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Pet with name "<PetName2>" is found
		And Pet with status "<PetStatus2>" is found
		Given User updates the pet by with Pet Id "<Id>" and Pet Name "<PetName>" and Pet Status "<PetStatus>" and Photo URL "<PhotoURL>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		And Pet with name "<PetName>" is found
		And Pet with status "<PetStatus>" is found
		Given User deletes the pet by Id "<Id>"
		Then Status code is <StatusCode>
		And Status in response body is "<StatusLine>"
		Given User fetches the pet details by Pet Id "<Id>"
		Then Status code is <StatusCode2>
		And Status in response body is "<StatusLine2>"
		Examples:
			| Id|PetName|PetStatus| StatusCode |StatusLine|PhotoURL|PetName2|PetStatus2|StatusCode2 |StatusLine2|
			| 24 |RahulB|sold| 200  | OK|ABC|RahulR|pending|404|Not Found|
