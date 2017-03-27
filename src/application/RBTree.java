package application;

import java.util.ArrayList;
import java.util.Stack;


@SuppressWarnings("serial")
public class RBTree<T extends Comparable<T>, K> extends Stack<Node<T, K>>{
	protected Node<T, K> root;
	protected final Node<T, K> NIL = new Node<T, K>(null, null, 'B');
	
	/***************************************************************************/
	// Method that returns the root....
	/***************************************************************************/
	public Node<T, K> getRoot() {
		return root;
	}
	
	/***************************************************************************/
	// Method that is called in the GUI that then calls other methods to insert
	// the node correctly in the Red Black Tree
	// first creates the new node with the information given
	// it then calls the binary search tree insert method to insert the node
	// and lastly it calls the check method to check if it meets the 
	// proper requirements of a Red Black Tree
	/***************************************************************************/
	public void insert(T key, K value) {
		Node<T, K> newNode = new Node<T, K>(key, value, 'R'); // create the new
																// node
		BSTInsert(newNode, key); // calls method to insert the new node into the
									// Red Black Tree
		check(newNode);
	}

	/***************************************************************************/
	// Binary Search Tree Insert method, this method first checks if the tree 
	// is empty, if the tree is empty it then creates the root node
	// if the tree is not empty it first finds the parent node
	// after finding the parent node it adds the node depening on comparable value
	// of the keys'
	/***************************************************************************/
	private boolean BSTInsert(Node<T, K> newNode, T key) {
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
	// Everytime a node is added the Red Black Tree is checked if it meets
	// the requirements of a RBT, if it does not it is fixed accordingly 
	// with the following cases
	/***************************************************************************/
	private boolean check(Node<T, K> node) {
		Node<T, K> uncle = findUncle(node);
		Node<T, K> grandpa = findGrandPa(node);
		Node<T, K> parent = node.parent;

		// Case 1
		if (node.equals(root)) {
			node.color = 'B';
			return true;
		}

		// Case 2
		if (parent.color == 'B')
			return true;

		// Case 3
		if (parent.color == 'R' && uncle.color == 'R') {
			parent.color = 'B';
			uncle.color = 'B';
			grandpa.color = 'R';
			check(grandpa);
			return true;
		}

		// Case 4
		if (parent.color == 'R' && uncle.color == 'B') {
			if (parent.right.equals(node) && grandpa.left.equals(parent)) {
				leftRotate(parent, node);
				node = parent;
			}
			if (parent.left.equals(node) && grandpa.right.equals(parent)) {
				rightRotate(parent, node);
				node = parent;
			}
		}

		// Case 5
		if (parent.color == 'R' && uncle.color == 'B') {
			if (parent.left.equals(node) && grandpa.left.equals(parent)) {
				parent.color = 'B';
				grandpa.color = 'R';
				rightRotate(grandpa, parent);
			}
			if (parent.right.equals(node.key) && grandpa.right.equals(parent)) {
				parent.color = 'B';
				grandpa.color = 'R';
				leftRotate(grandpa, parent);
			}
		}
		return false;
	}

	/***************************************************************************/
	// does a left rotate depending on the nodes that are passed
	// changes pointer structure to fix the ordering of nodes
	/***************************************************************************/
	private void leftRotate(Node<T, K> root, Node<T, K> pivot) {
		root = pivot.right;
		pivot.right = root.left;  // changing roots left subtree to pivots right subtree
		if (!root.left.equals(NIL)) // if roots left child is not nil parent gets changed to pivot
			root.left.parent = pivot;
		root.parent = pivot.parent;  // changing pivots parent to roots parent
		if (pivot.parent.equals(NIL))
			this.root = root;
		else if (pivot.parent.right.equals(root)) // checking to see if the node is on the right or left side 
			pivot.parent.left = root;  // if its on the right side the left node is now the root 
		else
			pivot.parent.right = root;  // otherwise the node is added to right side since it is on left side
		root.left = pivot; // pivot is now on roots left
		pivot.parent = root;  // changing pivots parent to root
	}

	/***************************************************************************/
	// does a right rotate depending on the nodes that are passed
	// same as above but done for the opposite side
	/***************************************************************************/
	private void rightRotate(Node<T, K> root, Node<T, K> pivot) {
		root = pivot.left;
		pivot.left = root.right;
		if (!root.right.equals(NIL))
			root.right.parent = pivot;
		root.parent = pivot.parent;
		if (pivot.parent.equals(NIL))
			this.root = root;
		else if (pivot.parent.left.equals(root))
			pivot.parent.right = root;
		else
			pivot.parent.left = root;
		root.right = pivot;
		pivot.parent = root;
	}

	/***************************************************************************/
	// Finds the grandparent of any given node by first checking if it has a parent node
	// if it has a parent node then it checks to see if that parent node has a parent node
	// if that checks out then it returns it since the parent of a parent is the 
	// grandpa
	/***************************************************************************/
	private Node<T, K> findGrandPa(Node<T, K> node) {
		if (node.parent != null && node.parent.parent != null)
			return node = node.parent.parent;
		else
			return null;
	}
	
	/***************************************************************************/
	// checks to see if the node has a parent if the node does have a parent then 
	// it checks if that parent has a parent in order to find the grandpa
	// if it does have a grand pa then it checks wether it is the right or left child
	// depending on whatever child it is the uncle is on the other side so that 
	// node is then returned 
	/***************************************************************************/
	private Node<T, K> findUncle(Node<T, K> node) {
		if (node.parent != null && node.parent.parent != null) {
			if (node.parent.parent.left.equals(node.parent))
				return node.parent.parent.right;
			else
				return node.parent.parent.left;
		}
		return null;
	}
	
	/***************************************************************************/
	// preorder traversal of the red black tree checks current left then right
	// using a stack to properly traverse through the tree
	/***************************************************************************/
	public ArrayList<Node<T, K>> preorder() {
		ArrayList<Node<T, K>> preOrderList = new ArrayList<>();
		Node<T, K> current = null;

		if (root != null)
			push(root);
		while (!empty()) {
			current = pop();
			preOrderList.add(current);
			if (current.right != null)
				push(current.right);
			if (current.left != null)
				push(current.left);
		}
		return preOrderList;
	}

	/***************************************************************************/
	// inorder traversal of the red black tree checks left current thenr ight
	// uses a stack to properly traverse the tree
	/***************************************************************************/
	public ArrayList<Node<T, K>> inorder() {
		ArrayList<Node<T, K>> inOrderList = new ArrayList<>();
		Node<T, K> current = root;

		while (!empty() || current != null) {
			if (current != null) {
				push(current);
				current = current.left;
			} else {
				current = pop();
				inOrderList.add(current);
				current = current.right;
			}
		}
		return inOrderList;
	}

	/***************************************************************************/
	// method that does postorder traversal of the RedBlackTree 
	// in the order of left right current, uses a stack and a list of already visited
	// nodes, in order to properly traverse through the tree
	/***************************************************************************/
	public ArrayList<Node<T, K>> postorder() {
		ArrayList<Node<T, K>> postOrderList = new ArrayList<>();
		ArrayList<Node<T, K>> visited = new ArrayList<>();
		Node<T, K> current = root;

		push(root);
		while (!empty()) {
			current = peek();
			if (current.left != null && !visited.contains(current.left))
				push(current.left);
			// the problem here is because of the NIl node, it says its already
			// been visited even though it has not
			else if (current.right != null && !visited.contains(current.right))
				push(current.right);
			else {
				postOrderList.add(current);
				visited.add(current);
				pop();
			}
		}
		return postOrderList;
	}

	/***************************************************************************/
	// BFS of the Red Black Tree using a queue, it adds the root to the que at first
	// then the loop keeps going while the queue is not empty
	// while it is not empty the current then becomes the first node in the queue
	// then it checks if it has a left and right node if it does those are then 
	// added to the queue in order of left then right, after it is added the first node in 
	// the queue is visited and the loop goes again until the queue is empty
	/***************************************************************************/
	public ArrayList<Node<T, K>> breadthFirstSearch() {
		java.util.Queue<Node<T, K>> queue = new java.util.LinkedList<>();
		ArrayList<Node<T, K>> bfsList = new ArrayList<>();
		Node<T, K> current = root;

		queue.offer(current);
		while (!queue.isEmpty()) {
			current = queue.peek();
			if (current.left != null)
				queue.offer(current.left);
			if (current.right != null)
				queue.offer(current.right);
			bfsList.add(queue.remove());
		}
		return bfsList;
	}
}