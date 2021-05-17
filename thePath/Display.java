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
import javafx.scene.control.TabPane.TabClosingPolicy;
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
	private static DoubleProperty height = new SimpleDoubleProperty();
	private static DoubleProperty width = new SimpleDoubleProperty();
	private Game game = new Game();
	private static String speed = "slow";
	private static Timeline printer;
	//tab pane 
	private static TabPane tabPane = new TabPane();
	//tabs 
	private static Tab mapTab = new Tab("Map");
	private static Tab adventureTab = new Tab("Adventure");
	private static Tab settingsTab = new Tab("Settings");
	//choice buttons
	private static Button bt1 = new Button("1");
	private static Button bt2 = new Button("2");
	private static Button bt3 = new Button("3");
	private static Button bt4 = new Button("4");
	//potion buttons
	private static Button hppot = new Button("Drink HP Potion");
	private static Button mnpot = new Button("Drink Mana Potion");
	//start button
	private static Button start = new Button("Wake Up");
	//settings
	//sliders
	private static Slider buttonSize = new Slider();
	private static Slider statSize = new Slider();
	private static Slider textSize = new Slider();
	//text speed buttons
	
	private static RadioButton slowText = new RadioButton("Slow Text");
	private static RadioButton fastText = new RadioButton("Fast Text");
	private static RadioButton instantText = new RadioButton("Instant Text");
	//text font buttons
	
	private static RadioButton font1 = new RadioButton("Arial");
	private static RadioButton font2 = new RadioButton("Comic Sans MS");
	private static RadioButton font3 = new RadioButton("Courier");
	private static RadioButton font4 = new RadioButton("Times New Roman");
	private static RadioButton font5 = new RadioButton("Verdana");
	//setting holders (signs)
	private static FlowPane fontHolder = new FlowPane(10, 10);
	private static FlowPane speedHolder = new FlowPane(10, 10);
	private static HBox statSizeSettings = new HBox(20);
	private static HBox buttonSizeSettings = new HBox(5);
	private static HBox textSizeSettings = new HBox(15);
	private static HBox textFontSettings = new HBox(10);
	private static HBox textSpeedSettings = new HBox(10);
	//settings labels
	private static Label statSizelbl = new Label("Stat Size: ");
	private static Label bttnSize = new Label("Button Size: ");
	private static Label txtSize = new Label("Text Size: ");
	private static Label txtFont = new Label("Text Font: ");
	private static Label txtSpeed = new Label("Text Speed: ");
	
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
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		buttonSize.setSnapToTicks(true);
		statSize.setSnapToTicks(true);
		textSize.setSnapToTicks(true);
		
		//min sizes for window
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(650);

		height.bind(primaryStage.heightProperty());
		width.bind(primaryStage.widthProperty());
		
		print("You are asleep\n");
	
		
		
		//box to hold buttons
		HBox choiceButtons = new HBox(10);
		choiceButtons.getChildren().addAll(bt1, bt2, bt3, bt4);
		choiceButtons.setAlignment(Pos.CENTER);
		//disable buttons when printing text
		bt1.disableProperty().bind(readyForInput);
		bt2.disableProperty().bind(readyForInput);
		bt3.disableProperty().bind(readyForInput);
		bt4.disableProperty().bind(readyForInput);
		
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

		
		
		

		
		
		
		
		//Main Adventure pane
		BorderPane pane = new BorderPane();
		pane.setAlignment(start, Pos.CENTER);
		pane.setTop(null);
		pane.setCenter(text);
		pane.setBottom(start);
		
		//map
		FileInputStream inputstream = new FileInputStream("MapImage.png");
		Image map = new Image(inputstream);
		ImageView mapView = new ImageView(map);
		mapView.fitWidthProperty().bind(tabPane.widthProperty());
		mapView.fitHeightProperty().bind(tabPane.heightProperty());
		
		
		
		
		//text size
		textSize.setPrefHeight(50);
		textSize.setPrefWidth(400);
		textSize.setShowTickLabels(false);
		textSize.setShowTickMarks(true);
		textSize.setMax(25);
		textSize.setMin(10);
		textSize.setMinorTickCount(4);
		textSize.setMajorTickUnit(5);
		textSize.valueProperty().addListener(ov -> {
			text.setFont(Font.font(text.getFont().getFamily(), textSize.getValue()));
		});
		textSize.setValue(12);
		
		
		//text speed
		
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
		
		buttonSize.setPrefHeight(50);
		buttonSize.setPrefWidth(400);
		buttonSize.setValue(15);
		buttonSize.setShowTickLabels(false);
		buttonSize.setShowTickMarks(true);
		buttonSize.setMax(25);
		buttonSize.setMin(0);			
		buttonSize.setMinorTickCount(4);	
		buttonSize.setMajorTickUnit(5);		
		buttonSize.valueProperty().addListener(ov -> {
			resize();
		});
		
		statSize.setPrefHeight(50);
		statSize.setPrefWidth(400);
		statSize.setValue(15);
		statSize.setShowTickLabels(false);
		statSize.setShowTickMarks(true);
		statSize.setMax(25);
		statSize.setMin(0);			
		statSize.setMinorTickCount(4);	
		statSize.setMajorTickUnit(5);				
		statSize.valueProperty().addListener(ov -> {
			resize();
		});
		
		
		//holder of settings
		VBox settings1 = new VBox(0);
		//stat size
		statSizeSettings.setAlignment(Pos.CENTER);
		statSizelbl.setId("settingsLabel");
		statSizelbl.setAlignment(Pos.CENTER_LEFT);
		statSizeSettings.getChildren().addAll(statSizelbl, statSize);	
		settings1.getChildren().add(statSizeSettings);
		statSizeSettings.getStyleClass().add("hbox");
		
		//button size
		buttonSizeSettings.setAlignment(Pos.CENTER);
		bttnSize.setId("settingsLabel");
		bttnSize.setAlignment(Pos.CENTER_LEFT);
		buttonSizeSettings.getChildren().addAll(bttnSize, buttonSize);
		settings1.getChildren().add(buttonSizeSettings);
		buttonSizeSettings.getStyleClass().add("hbox");
		
		//text size
		textSizeSettings.setAlignment(Pos.CENTER);
		txtSize.setId("settingsLabel");
		txtSize.setAlignment(Pos.CENTER_LEFT);
		textSizeSettings.getChildren().addAll(txtSize, textSize);	
		settings1.getChildren().add(textSizeSettings);
		textSizeSettings.getStyleClass().add("hbox");
		textSize.setValue(12);
		
		//text font
		textFontSettings.setAlignment(Pos.CENTER);
		
		txtFont.setId("settingsLabel");
		txtFont.setAlignment(Pos.CENTER_LEFT);
		fontHolder.setAlignment(Pos.CENTER);
		fontHolder.getChildren().addAll(font1, font2, font3, font4, font5);
		textFontSettings.getChildren().addAll(txtFont, fontHolder);
		settings1.getChildren().add(textFontSettings);
		textFontSettings.getStyleClass().add("hbox");
		
		//text speed
		textSpeedSettings.setAlignment(Pos.CENTER);
		
		txtSpeed.setId("settingsLabel");
		txtSpeed.setAlignment(Pos.CENTER_LEFT);
		speedHolder.setAlignment(Pos.CENTER);
		speedHolder.getChildren().addAll(slowText, fastText, instantText);
		textSpeedSettings.getChildren().addAll(txtSpeed, speedHolder);
		settings1.getChildren().add(textSpeedSettings);
		textSpeedSettings.getStyleClass().add("hbox");
		
		
		
			
		
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
		
		adventureTab.setContent(stacker);
		mapTab.setContent(mapView);
		mapTab.disableProperty().bind(bindMap);
		settingsTab.setContent(settings1);
		mapTab.setContent(mapView);
		tabPane.getTabs().addAll(adventureTab, mapTab, settingsTab);
		
		
		//watchers and listeners
		primaryStage.heightProperty().addListener(ov -> {
			resize();
		});
		primaryStage.widthProperty().addListener(ov -> {
			resize();
		});
		
		
		Scene scene = new Scene(tabPane, 700, 500);
		primaryStage.setTitle("The Path of Rememberance");
		primaryStage.setScene(scene);
		primaryStage.show();
	
		scene.getStylesheets().add("mystyle.css");
		
		

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
				text.setId("text-area");
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




		
	}
	public void resize() {
		Double modifier = 40-buttonSize.getValue();
		Double setbtSize = height.get()/modifier;
		if (setbtSize < 13) setbtSize = 13.0;
		bt1.setFont(Font.font(setbtSize));
		bt2.setFont(Font.font(setbtSize));
		bt3.setFont(Font.font(setbtSize));
		bt4.setFont(Font.font(setbtSize));
		hppot.setFont(Font.font(setbtSize));
		mnpot.setFont(Font.font(setbtSize));
		start.setFont(Font.font(setbtSize));
		Double mod = 68 - statSize.getValue();
		Double size = width.get()/mod;
		stats.setFont(size);
		
		int testing = 14;
		int holder1 = (int)(height.get()-500)/20;
		int holder2 = (int)(width.get()-650)/30;
		if (holder1 > holder2) testing += holder2;
		else testing += holder1;
		String holderTest = "-fx-font-size: " + testing;
		adventureTab.setStyle(holderTest);
		mapTab.setStyle(holderTest);
		settingsTab.setStyle(holderTest);
		
		statSizeSettings.setMinHeight(height.get()/6);
		buttonSizeSettings.setMinHeight(height.get()/6);
		textSizeSettings.setMinHeight(height.get()/6);
		textFontSettings.setMinHeight(height.get()/6);
		textSpeedSettings.setMinHeight(height.get()/6);
		
		statSize.setPrefWidth(400 + ((width.get()-650)/4));
		buttonSize.setPrefWidth(400 + ((width.get()-650)/4));
		textSize.setPrefWidth(400 + ((width.get()-650)/4));
		
		
		
		
		String offset = "-fx-background-position: left 50% top -" + height.get()/8.25 + ";"
				+ "-fx-background-size: " + (100 - ((width.get()-650)/28.4)) + "% 195%;";

		statSizeSettings.setStyle(offset);
		buttonSizeSettings.setStyle(offset);
		textSizeSettings.setStyle(offset);
		textFontSettings.setStyle(offset);
		textSpeedSettings.setStyle(offset);
		
		String rdbtStyle = "-fx-font-size: " + (12 + ((height.get()-500)/55));
		fontHolder.setMinWidth(width.get()/2.5);
		speedHolder.setMinWidth(width.get()/2.5);
		
		
		String labeltextSize = "-fx-font-size: " + (12 + ((height.get()-500)/55));
		statSizelbl.setStyle(labeltextSize);
		bttnSize.setStyle(labeltextSize);
		txtSize.setStyle(labeltextSize);
		txtFont.setStyle(labeltextSize);
		txtSpeed.setStyle(labeltextSize);
		
		font1.setStyle(rdbtStyle);
		font2.setStyle(rdbtStyle);
		font3.setStyle(rdbtStyle);
		font4.setStyle(rdbtStyle);
		font5.setStyle(rdbtStyle);
		slowText.setStyle(rdbtStyle);
		fastText.setStyle(rdbtStyle);
		instantText.setStyle(rdbtStyle);
		

	
		
		tabPane.setTabMinHeight(height.get()/15);
		tabPane.setTabMaxHeight(height.get()/15);
		tabPane.setTabMinWidth(width.get()/3.48);
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
	private Font size;
	
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
		size = new Font(15);
		

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
		hpLbl.setFont(size);
		hpLbl.setId("statLabel");
		Label manaLbl = new Label(manaString);
		manaLbl.setFont(size);
		manaLbl.setId("statLabel");
		Label coinsLbl = new Label(coinsString);
		coinsLbl.setFont(size);
		coinsLbl.setId("statLabel");
		Label attackLbl = new Label(attackString);
		attackLbl.setFont(size);
		attackLbl.setId("statLabel");
		Label defenseLbl = new Label(defenseString);
		defenseLbl.setFont(size);
		defenseLbl.setId("statLabel");
		Label hppotionsLbl = new Label(hppotionsString);
		hppotionsLbl.setFont(size);
		hppotionsLbl.setId("statLabel");
		Label mnpotionsLbl = new Label (mnpotionsString);
		mnpotionsLbl.setFont(size);
		mnpotionsLbl.setId("statLabel");
		
		
		
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
	public void setFont(Double fontSize) {
		size = new Font(fontSize);
		paintStats();
	}
}
