package application;

public class RBTree<T extends Comparable<T>, K> {
	protected Node<T, K> root;
	private final Node<T, K> NIL = null;

	public Node<T, K> getRoot() {

		return root;
	}

	public RBTree() {

	}

	// insert a new node
	public void insert(T key, K value) {
		Node<T, K> newNode = new Node<T, K>(key, value, 'B');

		BSTInsert(newNode, key);

	}

	public boolean BSTInsert(Node<T, K> newNode, T key) {
		if (root == null) {
			root = newNode;
		} else {
			Node<T, K> parent = root.parent;
			Node<T, K> current = root;
			while (current != null) {
				if (key.compareTo(current.key) < 0) {
					parent = current;
					current = current.left;
				} else if (key.compareTo(current.key) > 0) {
					parent = current;
					current = current.right;
				} else
					return false;
			}
			root.parent = parent;
			if(key.compareTo(parent.key)< 0){
				parent.left = newNode;
			} else{
				parent.right = newNode;
			}
		}
		return true;

	}

	// Finds the grandparent of any given node
	// remember to check for cases where a node might not have a grandparent
	public void findGrandPa(Node<T, K> node) {

	}

	// same as GPA
	public void findUncle() {

	}

	public void leftRotate() {

	}

	public void rightRotate() {

	}

	public void check() {

	}

	public void preorder() {

	}

	public void inorder() {

	}

	public void postorder() {

	}

	public void breadthFirstSearch() {

	}

	public void deleteNode() {
		// this is a filler method for now
	}

	public boolean keySearch(T key, K value) {

		// Node<T, K> newNode = new Node<T, K>(key, value, 'B');
		// Node<T, K> test = new Node<T, K>(key, value, 'R');
		// if ((Integer) key == 5) {
		// root = newNode;
		// }
		// if ((Integer) key == 6) {
		// root.left = test;
		// }
		// System.out.println(root.toString());
		return false;
	}
}