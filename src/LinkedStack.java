import java.util.LinkedList;

public class LinkedStack<E> implements Stack<E> {
	private LinkedList<E> stack = new LinkedList<E>();

	public void push(E elem) {
		stack.addFirst(elem);
	}

	public E pop() {
		return stack.removeFirst();
	}

	public E peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.size() == 0;
	}

	public int size() {
		return stack.size();
	}
	
	public String toString() {
		LinkedList<E> temp = new LinkedList<E>(stack);
		String s = "";
		while(temp.size() > 0) {
			s += temp.pop().toString() + " ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		LinkedStack<Double> stack = new LinkedStack<>();
		stack.push(1.0);
		stack.push(2.0);
		stack.push(3.0);
		System.out.println(stack.toString());
	}
}
