package com.example.calc;

/*		File Abstract
 * The Token.java file creates a type that
 * we can use to determine what the operation is
 * or what the number is without having to do 
 * weird type casting all over the place.	
 */

public class Token {

	boolean isOperator;
	double value;
	char operator;
	
	public Token(double val) {
		isOperator = false;
		value = val;
	}
	
	public Token(String str) {
		if (str.length() > 1) {
			isOperator = false;
			value = (double)Integer.parseInt(str);
		} else {
			switch (str.charAt(0)) {
			case '0':
				isOperator = false;
				value = 0.0;
				break;
			case '1':
				isOperator = false;
				value = 1.0;
				break;
			case '2':
				isOperator = false;
				value = 2.0;
				break;
			case '3':
				isOperator = false;
				value = 3.0;
				break;
			case '4':
				isOperator = false;
				value = 4.0;
				break;
			case '5':
				isOperator = false;
				value = 5.0;
				break;
			case '6':
				isOperator = false;
				value = 6.0;
				break;
			case '7':
				isOperator = false;
				value = 7.0;
				break;
			case '8':
				isOperator = false;
				value = 8.0;
				break;
			case '9':
				isOperator = false;
				value = 9.0;
				break;
			case '+':
				isOperator = true;
				operator = '+';
				break;
			case '-':
				isOperator = true;
				operator = '-';
				break;
			case '*':
				isOperator = true;
				operator = '*';
				break;
			case '/':
				isOperator = true;
				operator = '/';
				break;
			case '^':
				isOperator = true;
				operator = '^';
				break;
			default :
				break;
			}
		}
	}
}
