
public class InfixEvaluator {

	LinkedQueue<String> queue;
	LinkedStack<String> stack;
	
	InfixEvaluator() {
		queue = new LinkedQueue<String>();
		stack = new LinkedStack<String>();
	}
	
	public LinkedQueue<String> toPostfix(String expression) {
		String[] input = expression.split(" ");
		for(int i = 0; i < input.length; i++) {
			String s = input[i];
			if(isNumber(s)) queue.enqueue(s);
			else if(s.equals("(")) {
				stack.push(s);
			} else if(s.equals(")")) {
				while(true) {
					String s2 = stack.pop();
					if(s2.equals("(")) break;
					queue.enqueue(s2);
				}
			} 
			
			
			
		}
		
		
		return queue;
	}
	
	public boolean isNumber(String token) {
		try {
			Double.parseDouble(token);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public boolean isHigher(String token) {
		String s = stack.peek();
		if(token.equals("^") && (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("("))) return true;
		if((token.equals("*") || token.equals("/")) && (s.equals("+") || s.equals("_") || s.equals("("))) return true;
		if((token.equals("+") || token.equals("_")) && s.equals("(")) return true;
		return false;
	}
}
