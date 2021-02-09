package ch19;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.beans.property.*;

public class Test extends Application {
	public void start(Stage primaryStage) {
		
		Scene scene = new Scene(Display.getPane(), 600, 500);
		primaryStage.setTitle("Tests");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
