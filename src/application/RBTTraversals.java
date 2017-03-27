package application;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RBTTraversals extends Pane {
	RBTree<Integer, String> rbtree = new RBTree<>();
	private double radius = 20;  // defines the radius of the nodes
	
	/***************************************************************************/
	// Code to show the Traversal lists basically first grabs the title that was 
	// sent from the method in GUI which tells us what kind of traversal we are 
	// doing we then set it as a title and put it in the gui
	// once that is done we then create the circles for each node in the tree
	// text is also added to the circle corresponding to its key
	// if it is a NIl node it it given the title NIL
	/***************************************************************************/
	public <T extends Comparable<T>, K> void displayLinks(ArrayList<Node<Integer, String>> list, String tit) {
		this.getChildren().clear();
		Text title = new Text(30, 450, tit);
		title.setFill(Color.RED);
		title.setUnderline(true);
		title.setFont(Font.font("Verdana", 25));

		for (int i = 0; i < list.size(); i++) {
			double width = getWidth() + 50 * i;
			Circle circle = new Circle(width - 790, 480, radius);
			colorSetterV2(list.get(i), circle);
			getChildren().addAll(circle);

			if (list.get(i).key == null) {
				Text txt = new Text(width - 800, 485, "NIL");
				txt.setFill(Color.WHITE);
				getChildren().add(txt);
			} else {
				Text txt = new Text(width - 800, 485, list.get(i).key.toString());
				txt.setFill(Color.WHITE);
				getChildren().add(txt);
			}
		}
		getChildren().add(title);
	}
	
	/***************************************************************************/
	// This code changes the color of the nodes corresponding to their color value
	/***************************************************************************/
	private void colorSetterV2(Node<Integer, String> node, Circle circle) {
		if (node.color == 'B') {
			circle.setFill(Color.BLACK);
			circle.setStroke(Color.RED);
		} else if (node.color == 'R') {
			circle.setFill(Color.RED);
			circle.setStroke(Color.BLACK);
		}
	}
}
