package org.oxiane.roman;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class RomanNumerals {
	private static String[] one = new String[]{ "I", "X", "C", "M" };
	private static List<String> oneList = new ArrayList<>(Arrays.asList(one));
	private static String[] five = { "V", "L", "D" };
	private static List<String> fiveList = new ArrayList<>(Arrays.asList(five));

	/**
	 * Convert from normal numbers to Roman Numerals
	 * 
	 * @param number
	 *            the number to convert in Roman numerals format
	 * @return Roman numerals format
	 */
	public String digitToNumeral(Integer digit) {

		if (digit == 0) {
			throw new UnsupportedOperationException("we never discovered though was the number zero.");
		}

		if (digit < 0) {
			throw new UnsupportedOperationException("we never discovered numbers under zero.");
		}

		if (digit > 3000) {
			throw new UnsupportedOperationException("we never use this too large value.");
		}

		return digitToNumeral(0, digit);
	}

	private String digitToNumeral(Integer rank, Integer digit) {
		if (digit == 0) {
			return "";
		}
		String numeral;
		double divider = Math.pow(10, rank);
		double modulo = Math.pow(10, rank + 1);

		Integer rankValue = (int) (digit % modulo);

		switch ((int) (rankValue / divider)) {
		case 0:
			numeral = "";
			break;
		case 1:
			numeral = one[rank];
			break;
		case 2:
			numeral = one[rank] + one[rank];
			break;
		case 3:
			numeral = one[rank] + one[rank] + one[rank];
			break;
		case 4:
			numeral = one[rank] + five[rank];
			break;
		case 5:
			numeral = five[rank];
			break;
		case 6:
			numeral = five[rank] + one[rank];
			break;
		case 7:
			numeral = five[rank] + one[rank] + one[rank];
			break;
		case 8:
			numeral = five[rank] + one[rank] + one[rank] + one[rank];
			break;
		case 9:
			numeral = one[rank] + one[rank + 1];
			break;
		default:
			throw new UnsupportedOperationException("unexpected value");
		}

		return digitToNumeral(rank + 1, digit - rankValue) + numeral;
	}
	
	/**
	 * Convert from Roman Numerals to normal numbers
	 * 
	 * @param number
	 *            the Roman numerals to convert in digit
	 * @return digit value
	 */
	public Integer numeralToDigit(String numeral) {
		return numeralToDigit("", numeral);
	}
	
	public Integer numeralToDigit(String previousNumeral, String numeral) {
		if(numeral.isEmpty()){
			return 0;
		}
		
		String actualNumeral = numeral.substring(0, 1);

		Integer digit;
		int rank = oneList.indexOf(actualNumeral);
		if(rank == -1){
			rank = fiveList.indexOf(actualNumeral);
			String firstNumeralForThisRank = oneList.get(rank);
			if(previousNumeral.equals(firstNumeralForThisRank)){
				// IV = 1 + 3 = 4
				digit = 3;	
			} else {
				digit = 5;
			}			
		} else {
			digit = 1;
			if(rank > 0){
				String firstNumeralForThePreviousRank = oneList.get(rank-1);
				if(previousNumeral.equals(firstNumeralForThePreviousRank)){
					// IX = 1 + 8 = 9
					rank--;
					digit = 8;	
				}
			}
		}
		
		if(rank > -1){
			 digit = digit * (int) Math.pow(10, rank);
		}
		
		return digit + numeralToDigit(actualNumeral, numeral.substring(1));
	}
}
