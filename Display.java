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
 * <h1>Display</h1>
 * <p>This class handles all the JavaFX functions of this program. In essence, everything the user will see is because of this code, hence the name (which used to be Help, as the bulk of the code was elsewhere).</p>
 * <p>Created: 03/11/2021</p>
 * @author Jason Snow
 *
 */
public class Display extends Application {
	private static TextPane text = new TextPane();
	private static StatPane stats = new StatPane();
	private int room = 0;
	private Game game = new Game();
	private boolean started = false;
	

	/**
	 * This method is used to append text to the text area by calling the text object stored in the Display which is used to display all the text of this text based adventure game to the user.
	 * <pre>Example:
	 * {@code Display.print("Hello.") will add the string "Hello" to the current text area. 
	 * }</pre>
	 * @param s (String; the string to be added to the text are)
	 */
	public static void print(String s) {
		text.addText(s);
	}
	/**
	 * This method is used to update the displayed stats, calling the method of the stored stats object.
	 * <pre>Example:
	 * {@code stats.setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions())
	 * is the most typical use of this method, which gets the information from the game object which gets it from the character object to update the
	 * stats to match the current character stats.
	 * }</pre>
	 * @param hp (int; the current hp value of the character object in the game object)
	 * @param mana (int; the current mana value of the character object in the game object)
	 * @param coins (int; the current number of coins of the character object in the game object) 
	 * @param attack (int; the current attack value of the character object in the game object)
	 * @param defense (int; the current defense value of the character object in the game object)
	 * @param hppotions (int: the current number of health potions of the character object in the game object) 
	 * @param mnpotions (int; the current number of mana potions of the character object in the game object)
	 */
	public void setStats(int hp, int mana, int coins, int attack, int defense, int hppotions, int mnpotions) {
		stats.setStats(hp, mana, coins, attack, defense, hppotions, mnpotions);
	}
	
	/**
	 * The start method which sets up the stage and scene of the JavaFX and handles the events of buttons pressed and other user input. 
	 * @throws FileNotFoundException (allows the map image to be displayed)
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
	 * This methods one and only purpose is to launch the stage and scene and begin the program. 
	 * @param args (default)
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

/**
 * <h1>TextPane</h1>
 * <p>This class makes an object that can be used in the Display class to show the text to the user. Having it as an object allows it to be more easily updated and affect by outside classes, by means of a caller method in Display that just calls a method in this class.</p>
 * <p>Created: 03/11/2021</p>
 * @author Jason Snow
 */
class TextPane extends Pane {
	private String s;
	/**
	 * The no-arg constructor, simply initializes the string value.
	 * <pre>Example:
	 * {@code TextPane() makes a blank textpane object.
	 * }</pre>
	 */
	TextPane() {
		s = "";
	}
	/**
	 * A void method that updates the displayed text so that it will show all appended text.
	 * <pre>Example:
	 * {@code text.paintText() will simply repaint the displayed text area 
	 * to include all added strings to the s value.
	 * }</pre>
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
	 * This method is used to add text the user is intended to see to this text area, adding the text to the area and then calling the paintText method to update the information displayed to the user.
	 * <pre>Example:
	 * {@code text.addText("Hello") will add the string "Hello" to the text area 
	 * before updating the display so the user can see this addition.
	 * }</pre>
	 * @param s (String; the text to be added to the area before update)
	 */
	public void addText(String s) {
		this.s += s;
		paintText();
	}
	/**
	 * This method 
	 * @param c
	 */
}

/**
 * <h1>StatPane</h1>
 * <p>This class is used to make an object for holding an HBox used to display the current stats of the character in the Display stage.</p>
 * <p>Created: 03/11/21</p>
 * @author Jason Snow
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
	 * This is the no-arg constructor to make a default StatPane object.
	 * <pre>Example:
	 * {@code StatPane() will make a default StatPane object.
	 * }</pre>
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
	 * This method will update the displayed stats so that as the stats change that change is show and visible to the user to asses.
	 * <pre>Example:
	 * {@code stats.paintStats() will update the strings and labels
	 *  held in the object so that it will display the proper, current stat.
	 * }</pre>
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
	 * This method is used to update the displayed stats, calling the paintStats method to update them after the information is updated.
	 * <pre>Example:
	 * {@code stats.setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions())
	 * is the most typical use of this method, which gets the information from the game object which gets it from the character object to update the
	 * stats to match the current character stats.
	 * }</pre>
	 * @param hp (int; the current hp value of the character object in the game object)
	 * @param mana (int; the current mana value of the character object in the game object)
	 * @param coins (int; the current number of coins of the character object in the game object) 
	 * @param attack (int; the current attack value of the character object in the game object)
	 * @param defense (int; the current defense value of the character object in the game object)
	 * @param hppotions (int: the current number of health potions of the character object in the game object) 
	 * @param mnpotions (int; the current number of mana potions of the character object in the game object)
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

