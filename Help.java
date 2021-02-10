package thePath;

import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.beans.*;
import javafx.beans.Observable;

public class Help extends Application {
	private static TextPane text = new TextPane();
	private String held = "";
	private int room = 0;
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int i) {
		room = i;
	}
	
	public static void print(String s) {
		text.addText(s);
	}
	
	public void start(Stage primaryStage) {
		Game game = new Game();
		//input buttons
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		HBox buttonHolder = new HBox(10);
		buttonHolder.getChildren().addAll(bt1, bt2, bt3, bt4);
		buttonHolder.setAlignment(Pos.CENTER);
		
		//stat display
		Label hpLbl = new Label("HP: 50");
		Label manaLbl = new Label("Mana: 20");
		Label coinsLbl = new Label("Coins: 0");
		Label potionsLbl = new Label("Potions: 0");
		Label attackLbl = new Label("Attack: 1");
		Label defenseLbl = new Label("Defense: 0");
		HBox statHolder = new HBox(10);
		statHolder.getChildren().addAll(hpLbl, manaLbl, coinsLbl, potionsLbl, attackLbl, defenseLbl);
		
		
		Button start = new Button("Start");
		
		BorderPane pane = new BorderPane();
		pane.setAlignment(start, Pos.CENTER);
		pane.setTop(statHolder);
		pane.setCenter(text);
		pane.setBottom(start);
		
		Scene scene = new Scene(pane, 515, 300);
		primaryStage.setTitle("Testing Texts");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		text.addText("This is all a test.\n");

		start.setOnAction(e -> {
			pane.setBottom(buttonHolder);
			game.room(0, 0);
		});
		bt1.setOnAction(e -> {
			int hold = game.room(room, 1);
			room = hold;
		});
		bt2.setOnAction(e -> {
			int hold = game.room(room, 2);
			room = hold;
		});
		bt3.setOnAction(e -> {
			int hold = game.room(room, 3);
			room = hold;
		});
		bt4.setOnAction(e -> {
			int hold = game.room(room, 4);
			room = hold;
		});
		
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

class TextPane extends Pane {
	private String s;
	
	TextPane() {
		s = "";
	}
	private void paintText() {
		TextArea text = new TextArea();
		text.setText(s);
		text.setWrapText(true);
		text.setEditable(false);
		text.end();
		getChildren().clear();
		getChildren().add(text);
	}
	public void addText(String s) {
		this.s += s;
		paintText();
	}
	public void addText(char c) {
		this.s += c + "";
		paintText();
	}
}


