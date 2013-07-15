/*package com.example.calc;


public class ETree {
	Node root;
	Node paratree;
	
	public ETree () {

	}
	public void add (int num) {
		if (root != null) {
			// this will not be the root node
			
		} else {
			// this will be the root node
			
		}
	}
	public void add (char c) {
		if (root != null) {
			// this will not be the root node
			
		} else {
			// this will be the root node
			if (paratree != null) {
				// building a para
			} else {
				if (c = '(') {
					paratree = new Node();
				}
			}
		}
	}
	public double evaluate (Node p) {
		if (p != null) {
			switch (p.operation) {
				case '*':
					return evaluate(p.left) * evaluate(p.right);
				case '/':
					return evaluate(p.left) / evaluate(p.right);
				case '-':
					return evaluate(p.left) - evaluate(p.right);
				case '+':
					return evaluate(p.left) + evaluate(p.right);
				case '^':
					return Math.pow(evaluate(p.left), evaluate(p.right));
				default:
					return p.num;
			}
		} else {
			return 0;
		}
	}
	public void clear () {
		this.root = null;
	}
	
	class Node {
		boolean isNumber, undecided;
		Node left, right, parent;
		double num;
		char operation;
		
		public Node (int num) {
			isNumber = true;
			this.num = (double) num;
			undecided = false;
		}
		public Node (char c) {
			isNumber = false;
			operation = c;
			undecided = false;
		}
		public Node () {
			undecided = true;
			isNumber = false;
		}
	}
}
*/
/*
class ExpressionNode {
	public ExpressionNode(double initNum, char initOpr, ExpressionNode initLeft, ExpressionNode initRight) {
		num = initNum;
		opr = initOpr;
		left = initLeft;
		right = initRight;
	}
	public double getNum()								{ return num; 			}
	public char getOpr()								{ return opr;			}
	public ExpressionNode getLeft()						{ return left; 			}
	public ExpressionNode getRight()					{ return right; 		}
	public void setNum(int theNewNum)					{ num = theNewNum; 		}
	public void setOpr(char theNewOpr)					{ opr = theNewOpr;		}
	public void setLeft(ExpressionNode theNewLeft)		{ left = theNewLeft; 	}
	public void setRight(ExpressionNode theNewRight)	{ right = theNewRight; 	}
	private double num;
	private char opr;
	private ExpressionNode left;
	private ExpressionNode right;

	public String toString() {
		if(opr == ' ') {
			return "" + num;
		} else {
			return "" + opr;
		}
	}
}





class ExpressionTree {
	public ExpressionTree () {
		ExpressionNode n12  = new ExpressionNode(12,' ',null,null);
		ExpressionNode ndiv = new ExpressionNode( 0,'/',n12,n6);

	}

	public double evaluate (ExpressionNode p) {
		if (p != null) {
			switch (p.getOpr()) {
				case '*':
					return evaluate(p.getLeft()) * evaluate(p.getRight());
				case '/':
					return evaluate(p.getLeft()) / evaluate(p.getRight());
				case '-':
					return evaluate(p.getLeft()) - evaluate(p.getRight());
				case '+':
					return evaluate(p.getLeft()) + evaluate(p.getRight());
				case '^':
					return Math.pow(evaluate(p.getLeft()), evaluate(p.getRight()));
				default:
					return p.getNum();
			}
		} else {
			return 0;
		}
	}
}
*/