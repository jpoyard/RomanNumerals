@numeralToDigit
Feature: Write a function to convert in the other direction, ie numeral to digit

  Scenario Outline: numeralToDigit - The Romans wrote numbers using letters - I, V, X, L, C, D, M. 
Given the roman numeral value "<roman>"
 When I call numeralToDigit function
 Then the digit should be <digit>

  Examples: numeralToDigit - defining letters 
    | digit | roman |
 		| 1 		| I 		|
 		| 5 		| V	 		|
 		| 10 		| X 		|
 		| 50 		| L 		|
 		| 100   | C 		|
 		| 500 	| D 		|
 		| 1000 	| M 		|
 		
 	Examples: numeralToDigit - some expected values 
    | digit | roman 	|
 		| 999 	| CMXCIX  |
 		| 900 	| CM 			|
 		| 90 		| XC 			|
 		| 1990	| MCMXC 	|
 		| 2000  | MM 			|
 		| 8 		| VIII 		|
 		| 2008  | MMVIII	|
 		
 	Examples: numeralToDigit - specific values (not exceed 3 sames letters)
    | digit | roman 	|
 		| 4 	  | IV      |
 		| 9 	  | IX 			|
 		| 40 		| XL 			|
 		| 90	  | XC 	    |
 		| 400   | CD 			|
 		| 900 	| CM  		|
 		
 		
