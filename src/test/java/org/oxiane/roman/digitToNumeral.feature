@digitToNumeral
Feature: The Kata says you should write a function to convert from normal numbers to Roman Numerals: eg
 
Scenario: digitToNumeral - Negative value doesn't exists
Given the negative digit value -1
 When I call digitToNumeral function
 Then it should failed
 
 Scenario: digitToNumeral - One thing The Romans never discovered though was the number zero. Null value doesn't exists.
Given the digit value 0
 When I call digitToNumeral function
 Then it should failed  
 
 Scenario: digitToNumeral - Can exceed 3000.
Given the digit value 3001
 When I call digitToNumeral function
 Then it should failed  
 
  Scenario Outline: digitToNumeral - The Romans wrote numbers using letters - I, V, X, L, C, D, M. 
Given the digit value <digit>
 When I call digitToNumeral function
 Then the roman numeral should be "<roman>"

  Examples: digitToNumeral - defining letters 
    | digit | roman |
 		| 1 		| I 		|
 		| 5 		| V	 		|
 		| 10 		| X 		|
 		| 50 		| L 		|
 		| 100   | C 		|
 		| 500 	| D 		|
 		| 1000 	| M 		|
 		
 	Examples:  digitToNumeral - some expected values 
    | digit | roman 	|
 		| 999 	| CMXCIX  |
 		| 900 	| CM 			|
 		| 90 		| XC 			|
 		| 1990	| MCMXC 	|
 		| 2000  | MM 			|
 		| 8 		| VIII 		|
 		| 2008  | MMVIII	|
 		
 	Examples:  digitToNumeral - specific values (not exceed 3 sames letters)
    | digit | roman 	|
 		| 4 	  | IV      |
 		| 9 	  | IX 			|
 		| 40 		| XL 			|
 		| 90	  | XC 	    |
 		| 400   | CD 			|
 		| 900 	| CM  		|
 		
 		
