package application;

public class RBTree<T extends Comparable<T>, K> {
	protected Node<T, K> root;
	private final Node<T, K> NIL = null;

	public Node<T, K> getRoot() {
		
		return root;
	}

	public RBTree() {

	}
	//Finds the grandparent of any given node 
	//remember to check for cases where a node might not have a grandparent
	public void findGrandPa() {

	}

	//same as GPA
	public void findUncle() {

	}

	
	public void leftRotate() {

	}

	public void rightRotate() {

	}
	
	//insert a new node
	public void insert() {
		
	}
	
	
	public void BSTInsert() {

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
		
		Node<T, K> newNode = new Node<T, K>(key, value, 'B');
		Node<T, K> test = new Node<T, K>(key, value, 'R');
		if((Integer)key == 5){
		root = newNode;}
		if((Integer)key ==  6){
		root.left = test;}
		return false;
	}
}