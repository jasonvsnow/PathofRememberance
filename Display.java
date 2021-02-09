package ch19;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.beans.property.*;

public class Display extends Pane {
	
	public static BorderPane getPane() {
		BorderPane set = new BorderPane();
		HBox statDisplay = new HBox(20);
		HBox userInput = new HBox(20);
		Pane mapDisplay = new Pane();
		Pane text = new Pane();
		
		mapDisplay.setStyle("-fx-border-color: black");
		statDisplay.setStyle("-fx-border-color: black");
		userInput.setStyle("-fx-border-color: black");
		
		userInput.setAlignment(Pos.CENTER);
		statDisplay.setAlignment(Pos.CENTER_LEFT);
		
		TextField holder = new TextField();
		Button enter = new Button("Enter");
		userInput.getChildren().addAll(holder, enter);
		userInput.setPadding(new Insets(10, 10, 10, 10));
		
		Label hp = new Label("HP: ");
		Label health = new Label("Health: ");
		Label potions = new Label("Potions: ");
		statDisplay.getChildren().addAll(hp, health, potions);
		statDisplay.setPadding(new Insets(0, 30, 0, 0));
		
		
		
		set.setTop(statDisplay);
		set.setRight(mapDisplay);
		set.setBottom(userInput);
		set.setCenter(text);
		
		
		
		
		return set;
		
	}
}
