package thePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;


public class Help extends Application {
	private static TextPane text = new TextPane();
	private static StatPane stats = new StatPane();
	private int room = 0;
	private Game game = new Game();
	private boolean started = false;
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int i) {
		room = i;
	}
	public static void print(String s) {
		text.addText(s);
	}
	public void setStats(int hp, int mana, int coins, int potions, int attack, int defense) {
		stats.setStats(hp, mana, coins, potions, attack, defense);
	}
	
	public void start(Stage primaryStage) throws FileNotFoundException{
		//8, 13, 13, 15, 16, 16
		//9, 10, 14, 15, 16, 17
		//input buttons
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		HBox choiceButtons = new HBox(10);
		choiceButtons.getChildren().addAll(bt1, bt2, bt3, bt4);
		choiceButtons.setAlignment(Pos.CENTER);
		
		Button pot = new Button("Drink Potion");
		pot.setOnAction(e -> {
			game.drinkPotion();
			setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		});
		
		
		
		FlowPane buttonHolder = new FlowPane();
		buttonHolder.getChildren().addAll(choiceButtons, pot);
		buttonHolder.setAlignment(Pos.CENTER);
		buttonHolder.setHgap(50);
		
		
		Button start = new Button("Wake Up");
		
		HBox topTest = new HBox(50);
		
		
		RadioButton adventure = new RadioButton("Adventure");
		RadioButton map = new RadioButton("Map");
		adventure.setSelected(true);
		
		ToggleGroup group = new ToggleGroup();
		adventure.setToggleGroup(group);
		map.setToggleGroup(group);
		
		HBox toggle = new HBox(5);
		toggle.getChildren().addAll(adventure, map);
		
		
		topTest.getChildren().addAll(stats, toggle);
		
		BorderPane pane = new BorderPane();
		pane.setAlignment(start, Pos.CENTER);
		pane.setTop(topTest);
		pane.setCenter(text);
		pane.setBottom(start);
		
		
		
		
		FileInputStream inputstream = new FileInputStream("MapImage.png");
		Image image = new Image(inputstream);
		HBox t = new HBox();
		ImageView mapView = new ImageView(image);
		mapView.setFitHeight(280);
		mapView.setFitWidth(580);
		

		
		Scene scene = new Scene(pane, 580, 300);
		primaryStage.setTitle("Testing Texts");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		text.addText("You are asleep.\n");

		start.setOnAction(e -> {
			pane.setBottom(buttonHolder);
			game.room(0, 0);
			started = true;
		});
		bt1.setOnAction(e -> {
			int hold = game.room(room, 1);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		});
		bt2.setOnAction(e -> {
			int hold = game.room(room, 2);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		});
		bt3.setOnAction(e -> {
			int hold = game.room(room, 3);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		});
		bt4.setOnAction(e -> {
			int hold = game.room(room, 4);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(), game.getPotions(), game.getAttack(), game.getDefense());
		});
		
		adventure.setOnAction(e -> {
			if (started) pane.setBottom(buttonHolder);
			else pane.setBottom(start);
			pane.setCenter(text);
		});
		map.setOnAction(e -> {
			if (game.isMap()) {
				pane.setCenter(mapView);
				pane.setBottom(t);
			}
			else {
				print("\n(You don't have the map yet!)\n");
				map.setSelected(false);
				adventure.setSelected(true);
			}
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
		text.setPrefWidth(580);
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

class StatPane extends HBox {
	private String hpString = "test";
	private String manaString;
	private String coinsString;
	private String potionsString;
	private String attackString;
	private String defenseString;
	
	
	StatPane() {
		hpString = "HP: 50";
		manaString = "Mana: 20";
		coinsString = "Coins: 0";
		potionsString = "Potions: 0";
		attackString = "Attack: 1";
		defenseString = "Defense: 1";
	}
	private void paintStats() {
		Label hpLbl = new Label(hpString);
		Label manaLbl = new Label(manaString);
		Label coinsLbl = new Label(coinsString);
		Label potionsLbl = new Label(potionsString);
		Label attackLbl = new Label(attackString);
		Label defenseLbl = new Label(defenseString);
		setSpacing(10);
		getChildren().clear();
		getChildren().addAll(hpLbl, manaLbl, coinsLbl, potionsLbl, attackLbl, defenseLbl);
	}
	public void setStats(int hp, int mana, int coins, int potions, int attack, int defense) {
		hpString = "HP: " + hp;
		manaString = "Mana: " + mana;
		coinsString = "Coins: " + coins;
		potionsString = "Potions: " + potions;
		attackString = "Attack: " + attack;
		defenseString = "Defense: " + defense;
		paintStats();
	}
}

