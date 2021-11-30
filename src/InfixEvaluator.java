
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
			} else if(s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
				if(stack.size() == 0 || isHigher(s)) {
					stack.push(s);
				} else {
					while(!isHigher(s) && stack.size() > 0) {
						queue.enqueue(stack.pop());
					}
					stack.push(s);
				}
			} else {
				//TODO
			}
		}
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
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
		if((token.equals("*") || token.equals("/")) && (s.equals("+") || s.equals("-") || s.equals("("))) return true;
		if((token.equals("+") || token.equals("-")) && s.equals("(")) return true;
		return false;
	}
}
