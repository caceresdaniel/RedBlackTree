package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			RBTree<Integer, String> rbtree = new RBTree<>();
			
			BorderPane bp = new BorderPane();
			RBTView view = new RBTView(rbtree);
			bp.setCenter(view);
			
			Scene sc = new Scene(bp,400,400);
			sc.getStylesheets().add("styles/style.css");
			primaryStage.setTitle("Red Black Tree");
			primaryStage.setScene(sc);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}