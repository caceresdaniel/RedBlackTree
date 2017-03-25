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

	public void insertButton(Button insertButt, TextField tf, TextField tf2) {
		insertButt.setOnMouseClicked(e -> {
			tf.setPromptText("Key");
			tf2.setPromptText("Value");

			int key = Integer.parseInt(tf.getText());

			String value = tf2.getText();

			System.out.println(key);
			System.out.println(value);

			if (rbtree.keySearch(key, value)) {
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} else {
				rbtree.insert(key, value); // insert the new key to the RB tree
				view.displayTree();
				view.setStatus(key + " has been placed in the tree");
			}
		});
	}

	public void deleteButton(Button delButt, TextField tf, TextField tf2) {
		delButt.setOnMouseClicked(e -> {
			tf.setPromptText("Key");
			tf2.setPromptText("Value");

			int key = Integer.parseInt(tf.getText());
			String value = tf2.getText();

			if (rbtree.keySearch(key, value)) {
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