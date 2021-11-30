import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E> {
	private LinkedList<E> queue = new LinkedList<E>();

	public void enqueue(E elem) {
		queue.addFirst(elem);
	}

	public E dequeue() {
		return queue.removeLast();
	}

	public E first() {
		return queue.peekLast();
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

	public int size() {
		return queue.size();
	}
	
	public String toString() {
		LinkedList<E> temp = new LinkedList<E>(queue);
		String s = "";
		while(temp.size() > 0) {
			s += temp.removeLast().toString() + " ";
		}
		return s;
	}
}
