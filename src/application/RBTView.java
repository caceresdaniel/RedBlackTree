package application;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class RBTView extends Pane{
	
	private RBTree<Integer, String> rbtree = new RBTree<>();
	private double radius = 15;
	private double vGap = 50;
	
	public RBTView(RBTree<Integer, String> rbtree){
		this.rbtree = rbtree;
		//setStatus("Red Black Tree is empty");
	}
	
	public void setStatus(String msg){
		getChildren().add(new Text(20, 20, msg));
	}
	
	public void displayTree(){
		this.getChildren().clear();
		if(rbtree.getRoot() != null){
			
		}
		
	}
}