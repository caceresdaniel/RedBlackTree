package application;

public class RBTree<T extends Comparable<T>, K> {
	protected Node<T, K> root;
	protected final Node<T, K> NIL = new Node<T, K>(null, null, 'B');
	
	/***************************************************************************/
	// Method that returns the root....
	/***************************************************************************/
	public Node<T, K> getRoot() {
		return root;
	}
	
	/***************************************************************************/
	// Empty Constructor
	/***************************************************************************/
	public RBTree() {

	}
	
	/***************************************************************************/
	// Method that is called in the GUI that then calls other methods to insert
	// the node correctly in the Red Black Tree
	/***************************************************************************/
	public void insert(T key, K value) {
		Node<T, K> newNode = new Node<T, K>(key, value, 'R'); // create the new
																// node

		BSTInsert(newNode, key); // calls method to insert the new node into the
									// Red Black Tree

	}

	/***************************************************************************/
	// Binary Search Tree Insert method, this method first checks if the tree 
	// is empty, if the tree is empty it then creates the root node
	// if the tree is not empty it first finds the parent node
	// after finding the parent node it adds the node depening on comparable value
	// of the keys'
	/***************************************************************************/
	public boolean BSTInsert(Node<T, K> newNode, T key) {
		if (root == null) {
			root = newNode;
			root.right = NIL;
			root.left = NIL;
		} else {
			Node<T, K> parent = null;
			Node<T, K> current = root;

			// had to use current.key since we are dealing with RBT's and they
			// have NIl nodes
			while (current.key != null) { // looking for parent
				if (key.compareTo(current.key) < 0 && current != NIL) {
					parent = current;
					current = current.left;

				} else if (key.compareTo(current.key) > 0) {
					parent = current;
					current = current.right;

				} else
					return false; // returns false if the key is a duplicate
			}

			if (key.compareTo(parent.key) < 0) {
				parent.left = newNode; // adding the new right node
				parent.left.left = NIL; // adding the NIL node to left
				parent.left.right = NIL; // adding the NIL node to right
				parent.left.parent = parent; // Setting the parent for the new
												// left node
			} else {
				parent.right = newNode; // adding the new right node
				parent.right.left = NIL; // adding NIL node to left
				parent.right.right = NIL; // adding NIL node to right
				parent.right.parent = parent; // Setting the parent for the new
												// right node
			}
		}
		return true; // returns true if the new node is added

	}
	
	/***************************************************************************/
	// Finds the grandparent of any given node
	// remember to check for cases where a node might not have a grandparent
	/***************************************************************************/
	public void findGrandPa(Node<T, K> node) {

	}
	
	/***************************************************************************/
	// same as GPA
	/***************************************************************************/
	public void findUncle() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void leftRotate() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void rightRotate() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void check() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void preorder() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void inorder() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void postorder() {

	}

	/***************************************************************************/
	/***************************************************************************/
	public void breadthFirstSearch() {

	}

	/***************************************************************************/
	// this is a filler method for now
	/***************************************************************************/
	public void deleteNode() {
		// this is a filler method for now
	}

	/***************************************************************************/
	// Currently just a filler method
	/***************************************************************************/
	public boolean keySearch(T key) {
		return false;
	}
}