package org.oxiane.roman;

import java.rmi.UnexpectedException;

/**
 * Hello world!
 *
 */
public class RomanNumerals {
	private static String[] one = { "I", "X", "C", "M" };
	private static String[] five = { "V", "L", "D" };

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

}
