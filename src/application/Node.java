package application;

/***************************************************************************/
// Nothing much to say about this class, self explanitory
/***************************************************************************/
public class Node<T extends Comparable<T>, K> {
	protected T key;
	protected K value;
	protected char color;
	protected Node<T, K> left = null;
	protected Node<T, K> right = null;
	protected Node<T, K> parent = null;

	public Node(T key, K value, char color) {
		this.key = key;
		this.value = value;
		this.color = color;
	}

	public T getKey() {
		return key;
	}

	public String toString() {
		return "key is: " + key + " value is: " + value + " color is: " + color;
	}
}