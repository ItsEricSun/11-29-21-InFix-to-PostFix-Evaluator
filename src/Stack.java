
public interface Stack<E> {
	public abstract void push(E elem);
	public abstract E pop();
	public abstract E peek();
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract String toString();
}
