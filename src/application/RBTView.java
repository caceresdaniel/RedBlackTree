package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/***************************************************************************/
//Code to show the actual Red Black Tree and its respective nodes
/***************************************************************************/
public class RBTView extends Pane {

	private RBTree<Integer, String> rbtree = new RBTree<>();
	private double radius = 20;  // defines the radius of the nodes
	private double vGap = 50;  // defines the gap between each node 

	/***************************************************************************/
	// Constructor for the Red black tree gui to be used in the main gui code 
	// to allow it to actually show the red black tree
	/***************************************************************************/
	public RBTView(RBTree<Integer, String> rbtree) {
		this.rbtree = rbtree;
		setStatus("Red Black Tree is empty");
	}

	/***************************************************************************/
	// Method used to set a status message 
	/***************************************************************************/
	public void setStatus(String msg) {
		Text txt = new Text(20, 20, msg);
		txt.setFill(Color.WHITE);
		getChildren().add(txt);
	}

	/***************************************************************************/
	// this displays the red black tree recursively 
	// every time it is ran it clears the pane to allow for updates in the tree 
	/***************************************************************************/
	public void displayTree() {
		this.getChildren().clear();
		if (rbtree.getRoot() != null) {
			displayTree(rbtree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
		}
	}

	/***************************************************************************/
	// this code creates the actual tree, by creating the lines that connect the 
	// the nodes together, and the actual nodes them selves
	/***************************************************************************/
	private void displayTree(Node<Integer, String> root, double x, double y, double hGap) {
		if (root.left != null) {
			Line line = new Line(x - hGap, y + vGap, x, y);
			line.setStroke(Color.WHITE);
			getChildren().add(line);
			displayTree(root.left, x - hGap, y + vGap, hGap / 2);
		}

		if (root.right != null) {
			Line line = new Line(x + hGap, y + vGap, x, y);
			line.setStroke(Color.WHITE);
			getChildren().add(line);
			displayTree(root.right, x + hGap, y + vGap, hGap / 2);
		}

		Circle circle = new Circle(x, y, radius);
		// this code was added to show the NIL nodes
		if (root.equals(rbtree.NIL)) {
			Text txt = new Text(x - 10, y + 4, "NIL");
			colorSetter(root, circle);
			txt.setFill(Color.WHITE);
			getChildren().addAll(circle, txt);
		} else {
			Text txt = new Text(x - 8, y + 4, root.key + "");
			colorSetter(root, circle);
			txt.setFill(Color.WHITE);
			getChildren().addAll(circle, txt);
		}
	}

	/***************************************************************************/
	// This code changes the color of the nodes corresponding to their color value
	/***************************************************************************/
	private void colorSetter(Node<Integer, String> root, Circle circle) {
		if (root.color == 'B') {
			circle.setFill(Color.BLACK);
			circle.setStroke(Color.RED);
		} else if (root.color == 'R') {
			circle.setFill(Color.RED);
			circle.setStroke(Color.BLACK);
		}
	}
}