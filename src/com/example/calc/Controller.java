package com.example.calc;
/* 		File Abstract
 * The Controller.java I made to control the
 * computing math and outputting the answer, we use
 * a StringBuffer to make append the math expression 
 * together until we try to compute the answer, also 
 * contains all the functions that parse the expression
 * and do the math.
 */

import java.lang.StringBuffer;
import java.util.Stack;

public class Controller {
	OutputDisplay outview;
	StringBuffer str;

	public Controller(OutputDisplay outview) {
		this.outview = outview;
		this.str = new StringBuffer();
	}

	public void add(String s) {
		str.append(s);
	}

	public String compute() {
		outview.top.clearComposingText();
		outview.bot.clearComposingText();
		return doMath(Infix(str.toString().trim().replaceAll(" ", "")));
	}

	public boolean isNumber(char c) {
		String check = "0123456789";
		return check.indexOf((int) c) != -1 ? true : false;
	}

	// takes the postfix string and does math!
	public String doMath(String input) {
		this.str = new StringBuffer(); 			// Clear out the buffer so we can start collecting character for the next expression.
		Stack<Token> left = new Stack<Token>(); // Create a left and right stack of tokens(see Token.java)
		Stack<Token> right = new Stack<Token>();// these are used for the algorithm, I like to think of it like shuffling
												// a deck of cards going from the left side to the right side.
		String[] tokens = input.split(" "); 	// split the the post fix string on spaces to create tokens
												// all elements are either a number or an operation ex. '+', '-', '*' etc.
		for (String tmp : tokens) {
			left.push(new Token(tmp)); 			// push the tokens to the left side
		}
		do {
			while (!left.isEmpty()) {
				Token temp = left.pop(); 				//pop off the first token
				if (temp.isOperator) {  				// see if is a number of operation
					if (left.peek().isOperator) { 		// here it was an operation, check and see what the next one is
						right.push(temp);				// turns out we have two operations in a row, push the first on the 
					} else { 							// right and let the loop iterate
						Token temp2 = left.pop(); 		// the reverse case, the 2nd is a number so we pop it off
						if (!left.peek().isOperator) { 	// check if the next token is an operation,
														// it is a number pop off do the math, push answer to the right
							right.push(new Token(runOperation(temp.operator, 
									temp2.value, left.pop().value)));
						} else {						// wasn't a number, so we got a 'opr', 'num', 'opr' for tokens
							right.push(temp);			// so we just push them onto the right side because
							right.push(temp2);			// we can't do anything with them and let the loop iterate
						}
					}
				} else { 								// turns out the first one we popped was a number
					right.push(temp);					// can't do anything with just one number so push on right
				}										// let the loop iterate
			}
			Token temp = right.pop();					// pop the first right side off
			if (!temp.isOperator && right.isEmpty()) {  // if popping the one token off makes the right empty then that
				return "=" + temp.value;				// is just the computed answer! returning the answer halting the function
			} else {									// otherwise
				left.push(temp);						// push it on the left
				while (!right.isEmpty()) {				// and push all right tokens
					left.push(right.pop());				// back onto the right side
				}
			}
		} while (!left.isEmpty());						// iterate
		return "";
	}

	//does math
	public double runOperation(char opr, double num1, double num2) {
		switch (opr) {
		case '*':
			return num2 * num1;
		case '/':
			return num2 / num1;
		case '-':
			return num2 - num1;
		case '+':
			return num2 + num1;
		case '^':
			return Math.pow(num2, num1);
		default:
			return 0.0;
		}
	}

	public static String Infix(String input) {
		if (input == null)
			return "";
		char[] in = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < in.length; i++) {
			switch (in[i]) {
			case '+':
			case '-':
				while (!stack.empty()
						&& (stack.peek() == '*' || stack.peek() == '/')) {
					out.append(' ');
					out.append(stack.pop());
				}
				out.append(' ');
				stack.push(in[i]);
				break;
			case '*':
			case '/':
				out.append(' ');
				stack.push(in[i]);
				break;
			case '(':
				stack.push(in[i]);
				break;
			case ')':
				while (!stack.empty() && stack.peek() != '(') {
					out.append(' ');
					out.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				out.append(in[i]);
				break;
			}
		}
		while (!stack.isEmpty())
			out.append(' ').append(stack.pop());
		return out.toString();
	}

}
