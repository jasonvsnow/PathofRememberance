package thePath;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.image.*;
import javafx.event.*;


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
	private int room = 0;
	private static BooleanProperty readyForInput = new SimpleBooleanProperty(true);
	private static BooleanProperty bindMap = new SimpleBooleanProperty(true);
	private Game game = new Game();
	private static String speed = "slow";
	private static Timeline printer;
	private static Double buttonSizer = 15.0;
	
	/**
	 * The setMap method is used to allow the Character class to change the observable property bindMap in the Display class
	 * so that the player will be able to access the mapTab who's disable property is bound to the bindMap property.
	 * @param value (Boolean; the new value to set bindMap to)
	 */
	public static void setMap(Boolean value) {
		bindMap.set(value);
	}
	
	/**
	 * This method is used to create the animation that will slowly print out text to avoid a jarring amount of text to suddenly be thrown onto the screen.
	 * The speed of this process can be adjusted slightly. 
	 * <pre>Example:
	 * {@code createTimeline("Hello") will create an animation to print out "Hello" letter by letter, space by space, on a delay until the whole message is displayed. 
	 * Delay varies based on external variable.
	 * }</pre>
	 * @param message (String; the string to display in the text area)
	 * @return timeline (Timeline; the animation to slowly print characters)
	 */
	private static Timeline createTimeline(String message) {
		char[] chars = message.toCharArray();
		Timeline timeline = new Timeline();
		Duration delayBetweenMessages = Duration.seconds(.045);
		if (speed.equalsIgnoreCase("slow")) delayBetweenMessages = Duration.seconds(.045);
		else if (speed.equalsIgnoreCase("fast")) delayBetweenMessages = Duration.seconds(.01);
		
		Duration frame = delayBetweenMessages;
		
		for (int i = 0; i < chars.length; i++) {
			String msg = chars[i] + "";
			timeline.getKeyFrames().add(new KeyFrame(frame, e -> text.appendText(msg)));
			frame = frame.add(delayBetweenMessages);
		}
		timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
            readyForInput.set(newStatus == Animation.Status.RUNNING);
        });
		
		
		return timeline;
	}
	/**
	 * This method prints out the messages it receives. If the text speed is instant, it simple appends the message to the text area. Otherwise, it calls
	 * createTimeline(message) and then plays the resulting timeline it receives back.
	 * <pre>Example:
	 * {@code print("Hello") will either append hello to the text area or call createTimeline("Hello") before playing the resulting animation.
	 * }</pre>
	 * @param message (String; the string to display in the text area)
	 */
	public synchronized static void print(String message) {
		if (speed.equalsIgnoreCase("slow") || speed.equalsIgnoreCase("fast")) {
			printer = createTimeline(message);
			printer.play();
		}
		else {
			text.appendText(message);
		}
		text.end();
	}
	/**
	 * This method is used to update the displayed stats, calling the method of the stored stats object.
	 * <pre>Example:
	 * {@code setStats() will automatically grab the most current stats of the game and update it by 
	 * calling the stats.setStats() method with the proper parameters
	 * }</pre>
	 */
	public void statUpdate() {
		stats.setStats(game.getHP(), game.getMana(), game.getCoins(),game.getAttack(), game.getDefense(), game.getHPpotions(), game.getMNPotions());
	}
	
	/**
	 * The start method which sets up the stage and scene of the JavaFX and handles the events of buttons pressed and other user input. 
	 * @throws FileNotFoundException (allows the map image to be displayed)
	 */
	public void start(Stage primaryStage) throws FileNotFoundException{
		text.setWrapText(true);
		text.setEditable(false);
		text.setFont(Font.font("Times New Roman", 12));
		stats.setAlignment(Pos.CENTER);
		
		//min sizes for window
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(550);
		//250:25
		//550:25
		
		print("You are asleep\n");
		
		//tabPane
		TabPane tabPane = new TabPane();
		
		
		
		//choice buttons
		Button bt1 = new Button("1");
		Button bt2 = new Button("2");
		Button bt3 = new Button("3");
		Button bt4 = new Button("4");
		//box to hold buttons
		HBox choiceButtons = new HBox(10);
		choiceButtons.getChildren().addAll(bt1, bt2, bt3, bt4);
		choiceButtons.setAlignment(Pos.CENTER);
		//disable buttons when printing text
		bt1.disableProperty().bind(readyForInput);
		bt2.disableProperty().bind(readyForInput);
		bt3.disableProperty().bind(readyForInput);
		bt4.disableProperty().bind(readyForInput);
		//potion buttons
		Button hppot = new Button("Drink HP Potion");
		Button mnpot = new Button("Drink Mana Potion");
		hppot.setMinWidth(25);
		
		
		
		//box to hold buttons
		VBox potionBox = new VBox(10);
		potionBox.getChildren().addAll(hppot, mnpot);
		//disable buttons when printing text
		hppot.disableProperty().bind(readyForInput);
		mnpot.disableProperty().bind(readyForInput);
		//Pane for all button holders to be placed
		FlowPane buttonHolder = new FlowPane();
		buttonHolder.getChildren().addAll(choiceButtons, potionBox);
		buttonHolder.setAlignment(Pos.CENTER);
		buttonHolder.setHgap(50);

		//start button
		Button start = new Button("Wake Up");
		
		

		
		
		
		
		//Main Adventure pane
		BorderPane pane = new BorderPane();
		pane.setAlignment(start, Pos.CENTER);
		pane.setTop(null);
		pane.setCenter(text);
		pane.setBottom(start);
		
		//map
		FileInputStream inputstream = new FileInputStream("MapImage.jpg");
		Image image = new Image(inputstream);
		ImageView mapView = new ImageView(image);
		mapView.fitWidthProperty().bind(tabPane.widthProperty());
		mapView.fitHeightProperty().bind(tabPane.heightProperty());
		
		
		//text size
		Slider textSize = new Slider();
		textSize.setPrefHeight(50);
		textSize.setPrefWidth(400);
		textSize.setShowTickLabels(true);
		textSize.setShowTickMarks(true);
		textSize.setMax(20);
		textSize.setMin(12);
		textSize.setMinorTickCount(1);
		textSize.setMajorTickUnit(2);
		textSize.valueProperty().addListener(ov -> {
			text.setFont(Font.font(text.getFont().getFamily(), textSize.getValue()));
		});
		
		
		//text speed
		RadioButton slowText = new RadioButton("Slow Text");
		RadioButton fastText = new RadioButton("Fast Text");
		RadioButton instantText = new RadioButton("Instant Text");
		ToggleGroup speedGroup = new ToggleGroup();
		slowText.setToggleGroup(speedGroup);
		fastText.setToggleGroup(speedGroup);
		instantText.setToggleGroup(speedGroup);
		
		slowText.setSelected(true);
		slowText.setOnAction(e -> {
			speed = "slow";
		});
		fastText.setOnAction(e -> {
			speed = "fast";
		});
		instantText.setOnAction(e -> {
			speed = "instant";
		});
		
		
		//text font
		RadioButton font1 = new RadioButton("Arial");
		RadioButton font2 = new RadioButton("Comic Sans MS");
		RadioButton font3 = new RadioButton("Courier");
		RadioButton font4 = new RadioButton("Times New Roman");
		RadioButton font5 = new RadioButton("Verdana");
		ToggleGroup fontGroup = new ToggleGroup();
		font1.setToggleGroup(fontGroup);
		font2.setToggleGroup(fontGroup);
		font3.setToggleGroup(fontGroup);
		font4.setToggleGroup(fontGroup);
		font5.setToggleGroup(fontGroup);
		font4.setSelected(true);
		font1.setOnAction(e -> {
			text.setFont(Font.font("Arial", text.getFont().getSize()));
		});
		font2.setOnAction(e -> {
			text.setFont(Font.font("Comic Sans MS", text.getFont().getSize()));
		});
		font3.setOnAction(e -> {
			text.setFont(Font.font("Courier", text.getFont().getSize()));
		});
		font4.setOnAction(e -> {
			text.setFont(Font.font("Times New Roman", text.getFont().getSize()));
		});
		font5.setOnAction(e -> {
			text.setFont(Font.font("Verdana", text.getFont().getSize()));
		});
		
		
		//button size
		Slider buttonSize = new Slider();
		buttonSize.setPrefHeight(50);
		buttonSize.setPrefWidth(400);
		buttonSize.setValue(15);
		buttonSize.setShowTickLabels(true);
		buttonSize.setShowTickMarks(true);
		buttonSize.setMax(25);
		buttonSize.setMin(0);			
		buttonSize.setMinorTickCount(1);	
		buttonSize.setMajorTickUnit(5);				
		buttonSize.valueProperty().addListener(ov -> {
			
			
			buttonSizer = buttonSize.getValue();
			Double modifier = 40-buttonSizer;
			Double setbtSize = primaryStage.getHeight()/modifier;
			if (setbtSize < 13) setbtSize = 13.0;
			bt1.setFont(Font.font(setbtSize));
			bt2.setFont(Font.font(setbtSize));
			bt3.setFont(Font.font(setbtSize));
			bt4.setFont(Font.font(setbtSize));
			hppot.setFont(Font.font(setbtSize));
			mnpot.setFont(Font.font(setbtSize));
			start.setFont(Font.font(setbtSize));
		});
		
		
		
		//holder of settings
		VBox settings1 = new VBox(30);
		//button size
		
		HBox buttonSizeSettings = new HBox(5);
		buttonSizeSettings.setAlignment(Pos.CENTER);
		Label bttnSize = new Label("Button Size: ");
		bttnSize.setAlignment(Pos.CENTER_LEFT);
		buttonSizeSettings.getChildren().addAll(bttnSize, buttonSize);	
		settings1.getChildren().add(buttonSizeSettings);
		
		//text size
		HBox textSizeSettings = new HBox(15);
		textSizeSettings.setAlignment(Pos.CENTER);
		Label txtSize = new Label("Text Size: ");
		txtSize.setAlignment(Pos.CENTER_LEFT);
		textSizeSettings.getChildren().addAll(txtSize, textSize);	
		settings1.getChildren().add(textSizeSettings);
		//text font
		HBox textFontSettings = new HBox(10);
		textFontSettings.setAlignment(Pos.CENTER);
		Label txtFont = new Label("Text Font: ");
		txtFont.setAlignment(Pos.CENTER_LEFT);
		FlowPane fontHolder = new FlowPane(10, 10);
		fontHolder.setAlignment(Pos.CENTER);
		fontHolder.getChildren().addAll(font1, font2, font3, font4, font5);
		textFontSettings.getChildren().addAll(txtFont, fontHolder);
		settings1.getChildren().add(textFontSettings);
		//text speed
		HBox textSpeedSettings = new HBox(10);
		textSpeedSettings.setAlignment(Pos.CENTER);
		Label txtSpeed = new Label("Text Speed: ");
		txtSpeed.setAlignment(Pos.CENTER_LEFT);
		FlowPane speedHolder = new FlowPane(10, 10);
		speedHolder.setAlignment(Pos.CENTER);
		speedHolder.getChildren().addAll(slowText, fastText, instantText);
		textSpeedSettings.getChildren().addAll(txtSpeed, speedHolder);
		settings1.getChildren().add(textSpeedSettings);
			
		
		//stack pane to allow fade to black later
		StackPane stacker = new StackPane();
		stacker.getChildren().add(pane);
		//for fading away later
		Rectangle fadeAway = new Rectangle(0, 0, 50, 50);
		fadeAway.setOpacity(0);
		fadeAway.setFill(Color.BLACK);
		FadeTransition ft = new FadeTransition(Duration.millis(5000), fadeAway);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.setCycleCount(1);
		fadeAway.heightProperty().bind(tabPane.heightProperty());
		fadeAway.widthProperty().bind(tabPane.widthProperty());
		
		//set tabs
		Tab adventureTab = new Tab("Adventure");
		adventureTab.setContent(stacker);
		Tab mapTab = new Tab("Map");
		mapTab.setContent(mapView);
		Tab settingsTab = new Tab("Settings");
		settingsTab.setContent(settings1);
		mapTab.setContent(mapView);
		tabPane.getTabs().addAll(adventureTab, mapTab, settingsTab);
		
		
		
		
		//watchers and listeners
		primaryStage.heightProperty().addListener(ov -> {
			Double modifier = 40-buttonSizer;
			Double setbtSize = primaryStage.getHeight()/modifier;
			if (setbtSize < 13) setbtSize = 13.0;
			bt1.setFont(Font.font(setbtSize));
			bt2.setFont(Font.font(setbtSize));
			bt3.setFont(Font.font(setbtSize));
			bt4.setFont(Font.font(setbtSize));
			hppot.setFont(Font.font(setbtSize));
			mnpot.setFont(Font.font(setbtSize));
			start.setFont(Font.font(setbtSize));
		});
		primaryStage.widthProperty().addListener(ov -> {
			Double modifier = 40-buttonSizer;
			Double setbtSize = primaryStage.getHeight()/modifier;
			if (setbtSize < 13) setbtSize = 13.0;
			bt1.setFont(Font.font(setbtSize));
			bt2.setFont(Font.font(setbtSize));
			bt3.setFont(Font.font(setbtSize));
			bt4.setFont(Font.font(setbtSize));
			hppot.setFont(Font.font(setbtSize));
			mnpot.setFont(Font.font(setbtSize));
			start.setFont(Font.font(setbtSize));
		});
		
		
	    
	    
		
		Scene scene = new Scene(tabPane, 700, 500);
		primaryStage.setTitle("The Path of Rememberance");
		primaryStage.setScene(scene);
		primaryStage.show();
	
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		//actions
		start.disableProperty().bind(readyForInput);
		start.setOnAction(e -> {
				pane.setBottom(buttonHolder);
				pane.setTop(stats);
				game = new Game();
				statUpdate();
				game.room(0, 0);
		});
		
		bt1.setOnAction(e -> {
				if (room != 100) {
					room = game.room(room, 1);
					statUpdate();
				}
				else {
					print("You decide to push on. You may be surrounded by darkness, but you realize that is merely because your eyes are closed and you are asleep.\n\n");
					room = 0;
					pane.setTop(null);
					pane.setBottom(start);
					bindMap.setValue(true);
				}
		});
		
		bt2.setOnAction(e -> {
			if (room != 100) {
				room = game.room(room, 2);
				statUpdate();
			}
			else {
				text.clear();
				speed = "slow";
				print("And so, you give into the darkness. You feel its"
						+ " "
						+ "And here we spam a bunch of stuff as a test to see how well this all works but ig the effect is lost with instant text maybe we should remove that tbh.");
				pane.setTop(null);
				pane.setBottom(null);
				tabPane.getTabs().remove(mapTab);
				tabPane.getTabs().remove(settingsTab);
				stacker.getChildren().add(fadeAway);
				ft.play();
				
				
				new Thread(() ->  {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						
					}
					System.exit(0);
				}).start();
				
			}
		});
		
		bt3.setOnAction(e -> {
			room = game.room(room, 3);
			statUpdate();
		});
		
		bt4.setOnAction(e -> {
			room = game.room(room, 4);
			statUpdate();
		});
		
		hppot.setOnAction(e -> {
			
				game.drinkHPotion();
				statUpdate();
				
		});
		
		mnpot.setOnAction(e -> {
			
			game.drinkMNPotion();
			statUpdate();
			
		});
		
		adventureTab.setOnClosed(e -> {
			tabPane.getTabs().add(adventureTab);
		});
		mapTab.setOnClosed(e -> {
			tabPane.getTabs().add(mapTab);
		});
		settingsTab.setOnClosed(e -> {
			tabPane.getTabs().add(settingsTab);
		});
		mapTab.disableProperty().bind(bindMap);


		
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
	private String hpString;
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
