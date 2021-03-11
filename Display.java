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

/**
 * 
 * @author student
 *
 */
public class Display extends Application {
	private static TextPane text = new TextPane();
	private static StatPane stats = new StatPane();
	private int room = 0;
	private Game game = new Game();
	private boolean started = false;
	
	/**
	 * 
	 * @return
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * 
	 * @param i
	 */
	public void setRoom(int i) {
		room = i;
	}
	/**
	 * 
	 * @param s
	 */
	public static void print(String s) {
		text.addText(s);
	}
	/**
	 * 
	 * @param hp
	 * @param mana
	 * @param coins
	 * @param attack
	 * @param defense
	 * @param hppotions
	 * @param mnpotions
	 */
	public void setStats(int hp, int mana, int coins, int attack, int defense, int hppotions, int mnpotions) {
		stats.setStats(hp, mana, coins, attack, defense, hppotions, mnpotions);
	}
	
	/**
	 * 
	 */
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
		
		Button hppot = new Button("Drink HP Potion");
		hppot.setOnAction(e -> {
			game.drinkHPotion();
			setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
		});
		Button mnpot = new Button("Drink Mana Potion");
		mnpot.setOnAction(e -> {
			game.drinkMNPotion();
			setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
		});
		VBox potionBox = new VBox(10);
		potionBox.getChildren().addAll(hppot, mnpot);
		
		
		FlowPane buttonHolder = new FlowPane();
		buttonHolder.getChildren().addAll(choiceButtons, potionBox);
		buttonHolder.setAlignment(Pos.CENTER);
		buttonHolder.setHgap(50);
		
		
		Button start = new Button("Wake Up");
		
		HBox topTest = new HBox(20);
		
		HBox topVoid = new HBox(50);
		HBox bottomVoid = new HBox(50);
		
		
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
		pane.setTop(topVoid);
		pane.setCenter(text);
		pane.setBottom(start);
		
		
		
		
		FileInputStream inputstream = new FileInputStream("MapImage.jpg");
		Image image = new Image(inputstream);
		HBox t = new HBox();
		ImageView mapView = new ImageView(image);
		mapView.setFitHeight(400);
		mapView.setFitWidth(600);
	

		
		Scene scene = new Scene(pane, 700, 500);
		primaryStage.setTitle("The Path of Rememberance");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		

		text.addText("You are asleep.\n");

		start.setOnAction(e -> {
			pane.setBottom(buttonHolder);
			pane.setTop(topTest);
			game = new Game();
			setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
			game.room(0, 0);
			started = true;
		});
		bt1.setOnAction(e -> {
			if (room != 100) {
				int hold = game.room(room, 1);
				room = hold;
				setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
			}
			else {
				print("You decide to push on. You may be surrounded by darkness, but you realize that is merely because your eyes are closed and you are asleep.\n\n");
				room = 0;
				started = false;
				pane.setTop(topVoid);
				pane.setBottom(start);
			}
		});
		bt2.setOnAction(e -> {
			if (room != 100) {
				int hold = game.room(room, 2);
				room = hold;
				setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
			}
			else {
				print("And so, you give into the darkness.");
				pane.setTop(topVoid);
				pane.setBottom(bottomVoid);
			}
			});
		bt3.setOnAction(e -> {
			int hold = game.room(room, 3);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
			});
		bt4.setOnAction(e -> {
			int hold = game.room(room, 4);
			room = hold;
			setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
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
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

/**
 * 
 * @author student
 *
 */
class TextPane extends Pane {
	private String s;
	/**
	 * 
	 */
	TextPane() {
		s = "";
	}
	/**
	 * 
	 */
	private void paintText() {
		TextArea text = new TextArea();
		text.setText(s);
		text.setWrapText(true);
		text.setEditable(false);
		text.end();
		text.setPrefWidth(700);
		text.setPrefHeight(400);
		getChildren().clear();
		getChildren().add(text);
	}
	/**
	 * 
	 * @param s
	 */
	public void addText(String s) {
		this.s += s;
		paintText();
	}
	/**
	 * 
	 * @param c
	 */
	public void addText(char c) {
		this.s += c + "";
		paintText();
	}
}

/**
 * 
 * @author student
 *
 */
class StatPane extends HBox {
	private String hpString = "test";
	private String manaString;
	private String coinsString;
	private String attackString;
	private String defenseString;
	private String hppotionsString;
	private String mnpotionsString;
	
	/**
	 * 
	 */
	StatPane() {
		hpString = "HP: 50";
		manaString = "Mana: 20";
		coinsString = "Coins: 0";
		attackString = "Attack: 0";
		defenseString = "Defense: 0";
		hppotionsString = "Hp Potions: 0";
		mnpotionsString = "Mana Potions: 0";

	}
	/**
	 * 
	 */
	private void paintStats() {
		Label hpLbl = new Label(hpString);
		Label manaLbl = new Label(manaString);
		Label coinsLbl = new Label(coinsString);
		Label attackLbl = new Label(attackString);
		Label defenseLbl = new Label(defenseString);
		Label hppotionsLbl = new Label(hppotionsString);
		Label mnpotionsLbl = new Label (mnpotionsString);

		setSpacing(10);
		getChildren().clear();
		getChildren().addAll(hpLbl, manaLbl, coinsLbl, attackLbl, defenseLbl, hppotionsLbl, mnpotionsLbl);
	}
	/**
	 * 
	 * @param hp
	 * @param mana
	 * @param coins
	 * @param attack
	 * @param defense
	 * @param hppotions
	 * @param mnpotions
	 */
	public void setStats(int hp, int mana, int coins, int attack, int defense, int hppotions, int mnpotions) {
		hpString = "HP: " + hp;
		manaString = "Mana: " + mana;
		coinsString = "Coins: " + coins;
		attackString = "Attack: " + attack;
		defenseString = "Defense: " + defense;
		hppotionsString = "HP Potions: " + hppotions;
		mnpotionsString = "Mana Potions: " + mnpotions;
		paintStats();
	}
}

