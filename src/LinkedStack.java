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
}
