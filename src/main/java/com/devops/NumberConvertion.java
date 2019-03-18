package com.devops;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class NumberConvertion {

	static final Logger logger = Logger.getLogger(NumberConvertion.class);
	protected static final String[] DIGITS = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	protected static final String[] DOUBLE_DIGITS = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "ninteen" };
	protected static final String[] TENS = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninty" };
	protected static final String HUNDREDS = "hundred";
	protected static final String NOT_IN_RANGE = "not in range";
	protected static final String EXIT_PROGRAM = "exit";
	protected Scanner stdin = new Scanner(System.in);
	protected int input=0;

	public static void main(String[] args) {
		NumberConvertion converter = new NumberConvertion();
		if (args.length>0)
			converter.stdio(args[0]);
		else
			converter.stdio("Term");
	}

	public void stdio(String cliip) {
		logger.info("Provide number between 1 to 999 to convert");
		try {
			if (cliip.equals("noTerm")) {
				input=0;
			} else {
				input = stdin.nextInt();
			}
			String verbaloutput = exitcallverification(input);
			if (verbaloutput.equals(EXIT_PROGRAM)) {
				logger.fatal("Exit call received");
			} else {
				logger.info(verbaloutput);
				stdio(cliip);
			}
		} catch (InputMismatchException e) {
			logger.warn("Invalid number");
			stdio(cliip);
		}
	}

	public String exitcallverification(int integer) {
		if (integer == 0) {
			stdin.close();
			return EXIT_PROGRAM;
		} else if (integer > 0) {
			return convert(integer);
		}
		return NOT_IN_RANGE;
	}

	public String convert(int integer) {
		String totaldigits = Integer.toString(integer);
		boolean isacenturian = (integer % 100 == 0);
		boolean isadecadance = (integer % 10 == 0);
		boolean isateen = (integer > 10 && integer < 20);
		switch (totaldigits.length()) {
		case 1:
			return DIGITS[integer - 1];
		case 2:
			if (isadecadance) {
				return TENS[integer / 10 - 1];
			} else if (isateen) {
				return DOUBLE_DIGITS[integer % 10 - 1];
			} else {
				return TENS[integer / 10 - 1] + " " + DIGITS[integer % 10 - 1];
			}
		case 3:
			if (isacenturian) {
				return DIGITS[integer / 100 - 1] + " " + HUNDREDS;
			} else {
				return DIGITS[integer / 100 - 1] + " " + HUNDREDS + " and " + convert(integer % 100);
			}
		default:
			return NOT_IN_RANGE;
		}
	}
}
