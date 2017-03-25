package application;

public class RBTree<T extends Comparable<T>, K> {
	protected Node<T, K> root;
	protected final Node<T, K> NIL = new Node<T, K>(null, null , 'B');

	public Node<T, K> getRoot() {

		return root;
	}

	public RBTree() {

	}

	// insert a new node
	public void insert(T key, K value) {
		Node<T, K> newNode = new Node<T, K>(key, value, 'R'); // create the new
																// node

		BSTInsert(newNode, key); // calls method to insert the new node into the
									// Red Black Tree

	}

	public boolean BSTInsert(Node<T, K> newNode, T key) {
		if (root == null) {
			root = newNode;
			root.right = NIL;
			root.left = NIL;
		} else {
			Node<T, K> parent = null;
			Node<T, K> current = root;

			while (current.key != null) { // looking for parent
				if (key.compareTo(current.key) < 0 && current != NIL) {
					parent = current;
					current = current.left;

				} else if (key.compareTo(current.key) > 0 ) {
					parent = current;
					current = current.right;

				} else
					return false; // returns false if the key is a duplicate
			}

			if (key.compareTo(parent.key) < 0) {
				parent.left = newNode; // adding the new right node
				parent.left.left = NIL;
				parent.left.right = NIL;
				parent.left.parent = parent; // Setting the parent for the new
												// left node
			} else {
				parent.right = newNode; // adding the new right node
				parent.right.left = NIL;
				parent.right.right = NIL;
				parent.right.parent = parent; // Setting the parent for the new
												// right node
			}
		}
		return true; // returns true if the new node is added

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