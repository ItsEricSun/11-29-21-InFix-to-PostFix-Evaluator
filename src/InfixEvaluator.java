
public class InfixEvaluator {

	LinkedQueue<String> queue;
	LinkedStack<String> stack;
	
	InfixEvaluator() {
		queue = new LinkedQueue<String>();
		stack = new LinkedStack<String>();
	}
	
	public String toSimp(String ex) throws Exception {
		if(ex.contains("f") || ex.contains("d") || ex.contains("F") || ex.contains("D")) throw new Exception();
		ex = ex.replaceAll(" " , "");
		StringBuilder sb = new StringBuilder(ex);
		int i = sb.length() - 1;
		while(i > -1) {
			try {
				Double.parseDouble("" + sb.charAt(i));
			} catch (NumberFormatException e) {
				sb.insert(i + 1, " ");
				sb.insert(i, " ");
			}
			i--;
		}
		return sb.toString();
	}
	
	public LinkedQueue<String> toPostfix(String expression) throws Exception {
		String ex = toSimp(expression);
		String[] input = ex.split(" ");
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
					while(stack.size() > 0 && !isHigher(s)) {
						queue.enqueue(stack.pop());
					}
					stack.push(s);
				}
			} else {
				throw new Exception();
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
