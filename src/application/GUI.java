package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
	RBTree<Integer, String> rbtree = new RBTree<>();
	RBTView view = new RBTView(rbtree);

	/***************************************************************************/
	//Most of the GUI code 
	/***************************************************************************/
	@Override
	public void start(Stage primaryStage) {
		try {

			BorderPane bp = new BorderPane();
			bp.getStyleClass().add("pane");

			TextField tf = new TextField();
			tf.getStyleClass().add("textBox");

			TextField tf2 = new TextField();
			tf2.getStyleClass().add("textBox");

			Button insertButt = new Button("Insert");
			insertButt.getStyleClass().add("button");

			Button delButt = new Button("Delete");
			delButt.getStyleClass().add("button");

			Label title = new Label("Red Black Tree");
			title.getStyleClass().add("mainTitle");

			Label lbl = new Label("Enter Values in Corresponding fields: ");
			lbl.getStyleClass().add("label");

			HBox hb1 = new HBox();
			hb1.getStyleClass().add("hbox");
			hb1.getChildren().add(title);

			HBox hb2 = new HBox();
			hb2.getStyleClass().add("hboxV2");

			VBox vb = new VBox();
			vb.getStyleClass().add("vbox");
			vb.getChildren().addAll(hb1, hb2);

			allTheButtons(hb2);

			HBox hb3 = new HBox();
			hb3.getStyleClass().add("hbox");
			hb3.getChildren().addAll(lbl, tf, tf2, insertButt, delButt);

			bp.setTop(vb);
			bp.setCenter(view);
			bp.setBottom(hb3);

			insertButton(insertButt, tf, tf2);
			deleteButton(delButt, tf, tf2);

			Scene sc = new Scene(bp);
			sc.getStylesheets().add("style/styles.css");

			primaryStage.setTitle("LAB 4");
			primaryStage.setScene(sc);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***************************************************************************/
	// Made a seperate method for all the buttons that will be in the top row
	// these buttons handle their respective methods
	/***************************************************************************/
	public void allTheButtons(HBox hb) {

		Button gpaButt = new Button("Find GrandPa");
		gpaButt.getStyleClass().add("button");
		Button uncButt = new Button("Find Uncle");
		uncButt.getStyleClass().add("button");
		Button preButt = new Button("Preorder Traversal");
		preButt.getStyleClass().add("button");
		Button inButt = new Button("Inorder Traversal");
		inButt.getStyleClass().add("button");
		Button postButt = new Button("Postorder Traversal");
		postButt.getStyleClass().add("button");
		Button breButt = new Button("BFS Traversal");
		breButt.getStyleClass().add("button");

		hb.getChildren().addAll(gpaButt, uncButt, preButt, inButt, postButt, breButt);

	}

	/***************************************************************************/
	// seperate method that applies a action handler to the insert button
	// which checks if they key has been used before or not
	// if the key has been used it just displays the red black tree with no changes
	// if the key has not been used the new node is then inserted into the 
	// red black tree
	/***************************************************************************/
	public void insertButton(Button insertButt, TextField tf, TextField tf2) {
		insertButt.setOnMouseClicked(e -> {
			tf.setPromptText("Key");  // adding this so user knows where to enter key and value
			tf2.setPromptText("Value");

			int key = Integer.parseInt(tf.getText());  // grabs the input from the first text field which is the key
			String value = tf2.getText();  //grabs the input for the second text field which is the value

			if (rbtree.keySearch(key)) {
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} else {
				rbtree.insert(key, value); // calls methods to insert the new key to the RB tree
				view.displayTree();  //displays the red black tree 
				view.setStatus(key + " has been placed in the tree");
			}
		});
	}

	/***************************************************************************/
	// Same as previous method but in this case it deletes the key from the 
	// Red black tree
	/***************************************************************************/
	public void deleteButton(Button delButt, TextField tf, TextField tf2) {
		delButt.setOnMouseClicked(e -> {
			tf.setPromptText("Key");
			tf2.setPromptText("Value");

			int key = Integer.parseInt(tf.getText());
			String value = tf2.getText();

			if (rbtree.keySearch(key)) {
				view.displayTree();
				view.setStatus(key + " is not in the tree");
			} else {
				rbtree.deleteNode(); // delete the node corresponding to that
										// key
				view.displayTree();
				view.setStatus(key + " has been deleted from the tree");
			}

		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}