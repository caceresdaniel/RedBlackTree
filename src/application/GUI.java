package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

			Button insertButt = new Button("Insert");
			Button delButt = new Button("Delete");
			delButt.getStyleClass().add("button");
			insertButt.getStyleClass().add("button");
			Label lbl = new Label("Enter a Key: ");
			lbl.getStyleClass().add("label");

			HBox hb = new HBox();
			hb.getStyleClass().add("hbox");
			hb.getChildren().addAll(lbl, tf, insertButt, delButt);

			bp.setCenter(view);
			bp.setBottom(hb);

			Scene sc = new Scene(bp, 400, 400);
			sc.getStylesheets().add("style/styles.css");

			primaryStage.setTitle("Red Black Tree");
			primaryStage.setScene(sc);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertButton(Button insertButt, TextField tf) {
		insertButt.setOnMouseClicked(e -> {
			int key = Integer.parseInt(tf.getText());

			if (rbtree.keySearch(key)) {
				view.displayTree();
				view.setStatus(key + " is already in the tree");
			} else {
				rbtree.BSTInsert(); // insert the new key to the RB tree
				view.displayTree();
				view.setStatus(key + " has been placed in the tree");
			}
		});
	}

	public void deleteButton(Button delButt, TextField tf) {
		delButt.setOnMouseClicked(e -> {
			int key = Integer.parseInt(tf.getText());

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