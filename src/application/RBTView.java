package application;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class RBTView extends Pane {

	private RBTree<Integer, String> rbtree = new RBTree<>();
	private double radius = 15;
	private double vGap = 50;

	public RBTView(RBTree<Integer, String> rbtree) {
		this.rbtree = rbtree;
		// setStatus("Red Black Tree is empty");
	}

	public void setStatus(String msg) {
		getChildren().add(new Text(20, 20, msg));
	}

	public void displayTree() {
		this.getChildren().clear();
		if (rbtree.getRoot() != null) {
			displayTree(rbtree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
		}
	}

	private void displayTree(Node<Integer, String> root, double x, double y, double hGap) {
		if (root.left != null) {
			getChildren().add(new Line(x - hGap, y + vGap, x, y));

			displayTree(root.left, x - hGap, y + vGap, hGap / 2);
		}

		if (root.right != null) {
			getChildren().add(new Line(x + hGap, y - vGap, x, y));
			displayTree(root.right, x + hGap, y - vGap, hGap / 2);
		}
		Circle circle = new Circle(x, y, radius);
		circle.getStyleClass().add("circle");
		getChildren().addAll(circle, new Text(x - 4, y + 4, root.key + ""));
	}
}