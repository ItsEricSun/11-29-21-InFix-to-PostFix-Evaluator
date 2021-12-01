import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E> {
	private LinkedList<E> queue = new LinkedList<E>();
	private LinkedStack<E> s1 = new LinkedStack<>();
	private LinkedStack<E> s2 = new LinkedStack<>();
	

	public void enqueue(E elem) {
		if(s1.isEmpty()) {
			s1.push(elem);
		} else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s1.push(elem);
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
//		queue.addFirst(elem);
	}

	public E dequeue() {
		return s1.pop();
//		return queue.removeLast();
	}

	public E first() {
		return s1.peek();
	}

	public boolean isEmpty() {
		return s1.size() == 0;
	}

	public int size() {
		return s1.size();
	}
	
	public String toString() {
		return s1.toString();
//		LinkedList<E> temp = new LinkedList<E>(s1);
//		String s = "";
//		while(temp.size() > 0) {
//			s += temp.pop().toString() + "\n";
//		}
//		return s;
	}
	
}
