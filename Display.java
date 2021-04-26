package thePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.util.concurrent.locks.*; 
import java.util.concurrent.*; 

/**
 * <h1>Display</h1>
 * <p>This class handles all the JavaFX functions of this program. In essence, everything the user will see is because of this code, hence the name (which used to be Help, as the bulk of the code was elsewhere).</p>
 * <p>Created: 03/11/2021</p>
 * @author Jason Snow
 *
 */
public class Display extends Application {
	private static TextArea text = new TextArea();
	private static StatPane stats = new StatPane();
	private static TextField input = new TextField();
	private int room = 0;
	private static BooleanProperty readyForInput = new SimpleBooleanProperty(false);
	private Game game = new Game();
	private boolean started = false;
	private static Timeline printer;
	private static Lock lock = new ReentrantLock();
	
	
	
	private static Timeline createTimeline(String message) {
		char[] chars = message.toCharArray();
		Timeline timeline = new Timeline();
		Duration delayBetweenMessages = Duration.seconds(.045);
		Duration frame = delayBetweenMessages;
		
		for (int i = 0; i < chars.length; i++) {
			String msg = chars[i] + "";
			timeline.getKeyFrames().add(new KeyFrame(frame, e -> text.appendText(msg)));
			frame = frame.add(delayBetweenMessages);
		}
		text.appendText("\n");
		timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
			readyForInput.set(newStatus != Animation.Status.RUNNING);
		});
		return timeline;
	}
	public synchronized static void print(String message) {
		printer = createTimeline(message);
		printer.play();
	}
	
	public void statUpdate() {
		stats.setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
	}
	
	/**
	 * The start method which sets up the stage and scene of the JavaFX and handles the events of buttons pressed and other user input. 
	 * @throws FileNotFoundException (allows the map image to be displayed)
	 */
	public void start(Stage primaryStage) throws FileNotFoundException{
		text.setWrapText(true);
		
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		HBox choiceButtons = new HBox(10);
		choiceButtons.getChildren().addAll(bt1, bt2, bt3, bt4);
		choiceButtons.setAlignment(Pos.CENTER);
		
		Button hppot = new Button("Drink HP Potion");
		
		Button mnpot = new Button("Drink Mana Potion");
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
		
		topTest.getChildren().addAll(stats);
		
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
		
		print("You are asleep.");
		
		start.setOnAction(e -> {
			if (readyForInput.get()) {
				pane.setBottom(buttonHolder);
				pane.setTop(topTest);
				game = new Game();
				statUpdate();
				game.room(0, 0);
				started = true;
			}
		});
		
		bt1.setOnAction(e -> {
			if (readyForInput.get()) {
				if (room != 100) {
					int hold = game.room(room, 1);
					room = hold;
					statUpdate();
				}
				else {
					print("You decide to push on. You may be surrounded by darkness, but you realize that is merely because your eyes are closed and you are asleep.\n\n");
					room = 0;
					started = false;
					pane.setTop(topVoid);
					pane.setBottom(start);
				}
			}
		});
		
		bt2.setOnAction(e -> {
			if (readyForInput.get()) {
				if (room != 100) {
					int hold = game.room(room, 2);
					room = hold;
					statUpdate();
					}
				else {
					print("And so, you give into the darkness.");
					pane.setTop(topVoid);
					pane.setBottom(bottomVoid);
					}
				}
			});
		
		bt3.setOnAction(e -> {
			if (readyForInput.get()) {
				int hold = game.room(room, 3);
				room = hold;
				statUpdate();
			}
		});
		
		bt4.setOnAction(e -> {
			if (readyForInput.get()) {
				int hold = game.room(room, 4);
				room = hold;
				statUpdate();
			}
		});
		
		hppot.setOnAction(e -> {
			if (readyForInput.get()) {
				game.drinkHPotion();
				statUpdate();
				}
		});
		
		mnpot.setOnAction(e -> {
			if (readyForInput.get()) {
				game.drinkMNPotion();
				statUpdate();
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
