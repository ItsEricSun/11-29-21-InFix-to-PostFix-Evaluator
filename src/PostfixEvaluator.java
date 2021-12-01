
public class PostfixEvaluator {
	private char ADD = '+';
	private char SUB = '-';
	private char MUL = '*';
	private char DIV = '/';
	private char POW = '^';
	
	LinkedStack<Double> stack;
	
	PostfixEvaluator() {
		stack = new LinkedStack<Double>();
	}
	
	public double evaluate(Queue<String> q) {
		while(!q.isEmpty()) {
			String value = q.dequeue();
			if(!isOperator(value)) {
					stack.push(Double.parseDouble(value));
			} else {
					double op2 = stack.pop();
					double op1 = stack.pop();
					evalSingleOp(value.charAt(0), op1, op2);
			}
		}
			return stack.pop();	
	}
	
	public boolean isOperator(String token) {
		if(token.equals(Character.toString(ADD)) || token.equals(Character.toString(SUB)) || token.equals(Character.toString(MUL)) || token.equals(Character.toString(DIV)) || token.equals(Character.toString(POW))) {
			return true;
		}
		return false;
	}
	
	public double evalSingleOp(char operation, double op1, double op2) {
		if(operation == ADD) {
			double r = op1 + op2;
			stack.push(r);
			return r;
		} else if(operation == SUB) {
			double r = op1 - op2;
			stack.push(r);
			return r;
		} else if(operation == MUL) {
			double r = op1 * op2;
			stack.push(r);
			return r;
		} else if(operation == DIV){
			double r = op1 / op2;
			stack.push(r);
			return r;
		} else {
			double r = Math.pow(op1, op2);
			stack.push(r);
			return r;
		}
		
	}
	
//	public class IncorrectInput extends Exception { 
//	    public IncorrectInput(String errorMessage) {
//	        super(errorMessage);
//	    }
//	}
//	
//	public class NotEnoughOperands extends Exception { 
//	    public NotEnoughOperands(String errorMessage) {
//	        super(errorMessage);
//	    }
//	}
//	
//	public class TooManyOperands extends Exception { 
//	    public TooManyOperands(String errorMessage) {
//	        super(errorMessage);
//	    }
//	}
}
