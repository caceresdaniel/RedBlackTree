package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class RBTView extends Pane {

	private RBTree<Integer, String> rbtree = new RBTree<>();
	private double radius = 20;
	private double vGap = 50;

	public RBTView(RBTree<Integer, String> rbtree) {
		this.rbtree = rbtree;
		setStatus("Red Black Tree is empty");
	}

	public void setStatus(String msg) {
		Text txt = new Text(20, 20, msg);
		txt.setFill(Color.WHITE);
		getChildren().add(txt);
	}

	public void displayTree() {
		this.getChildren().clear();
		if (rbtree.getRoot() != null) {
			displayTree(rbtree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
		}
	}

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
		Text txt = new Text(x - 4, y + 4, root.key + "");
		colorSetter(root, circle);
		txt.setFill(Color.WHITE);
		getChildren().addAll(circle, txt);
	}
	
	private void colorSetter(Node<Integer, String> root, Circle circle){
		if(root.color == 'B'){
			circle.setFill(Color.BLACK);
			circle.setStroke(Color.RED);
		} else if(root.color == 'R'){
			circle.setFill(Color.RED);
			circle.setStroke(Color.BLACK);
		}
	}
}