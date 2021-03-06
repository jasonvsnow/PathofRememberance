package thePath;



/**
 * <h1>Game</h1>
 * <p>This class takes care of the majority of the game functions, calling other classes and their methods to do so and providing the bulk of the code that makes the game the game itself, hence the name.</p>
 * <p>Created: 03/10/21</p>
 * @author Jason Snow
 *
 */
public class Game {
	private Character hero;
	private Combat conflict;
	private int reRoom;
	private int type;
	private String textToPrint = "";
	
	/**
	 * This is the no-arg constructor for a game object.
	 * <pre>Example:
	 * {@code Game() will make a default Game object
	 * }</pre>
	 */
	Game() {
		hero = new Character();
		conflict = new Combat();
		reRoom = 0;
		type = 0;
	}
	/**
	 * This method is used to set the character object and game to the proper points should the character perish but wish to continue.
	 * <pre>Example:
	 * {@code game.restart() will set hp to 50 then coins and potions to 0, the restart state. 
	 * It will then set reRoom to -1 and make a new combat and set enemy type to 0
	 * }</pre>
	 */
	public void restart() {
		hero.setHP(50);
		hero.setHPPotion(0);
		hero.setCoins(0);
		reRoom = -1;
		conflict = new Combat();
		type = 0;
	}
	
	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for HP.
	 * <pre>Example: 
	 * {@code game.getHP() might typically return 1-50 as all other values are death.
	 * }</pre>
	 * @return (int; the amount of hp the Character object currently has)
	 */
	public int getHP() {
		return hero.getHP();
	}

	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for coins.
	 * <pre>Example: 
	 * {@code game.getCoins() might return 0 or 1000 coins, as there is no limit on the number of coins acquired. 
	 * }</pre>
	 * @return (int; the amount of coins the Character object currently has)
	 */
	public int getCoins() {
		return hero.getCoins();
	}
	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for health potions.
	 * <pre>Example: 
	 * {@code game.getHPpotions() might return 0 or more.
	 * }</pre>
	 * @return (int; the amount of health potions the Character object currently has)
	 */
	public int getHPpotions() {
		return hero.getHPPotion();
	}

	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for attack value.
	 * <pre>Example: 
	 * {@code game.getAttack() might return 0, 1, 5, or 10 as those are the available attack values
	 * }</pre>
	 * @return (int; current attack value of the Character object)
	 */
	public int getAttack() {
		return hero.getAttack();
	}
	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for defense.
	 * <pre>Example: 
	 * {@code game.getHP() might return 0, 1, 3, or 6 as those are the available defense values 
	 * }</pre>
	 * @return (int; current defense value of the Character object)
	 */
	public int getDefense() {
		return hero.getDefense();
	}
	/**
	 * This method allows other classes to use the getter method for the Character object stored in the Game object for map.
	 * <pre>Example: 
	 * {@code game.isMap() returns true or false
	 * }</pre>
	 * @return (boolean; whether the character has the map or not)
	 */
	public boolean isMap() {
		return hero.isMap();
	}
	

	/**
	 * This method is called by the "Drink HP Potion" button and will cause the character to lose 1 health potion and regain 10 health to a maximum of 50 assuming they are not already at 50 and have a potion available.
	 * <pre>Example:
	 * {@code game.drinkHPPotion() will cause the game stored character 
	 * to expend 1 potion and raise hp by 10 to a maximum of 50 assuming the character isn't dead, has a potion, and is not already at 50.
	 * }</pre>
	 */
	public void drinkHPotion() {
		if (hero.getHP() > 0) {
			if (hero.getHPPotion() > 0) {
				if (hero.getHP() < 50) {
					hero.setHPPotion(hero.getHPPotion()-1);
					hero.setHP(hero.getHP() + 10);
					if (hero.getHP() > 50) hero.setHP(50);
					toPrint("You drink a health potion.\n\n");
				}
				else toPrint("You're already at maximum health! Save that potion for later.\n\n");
			}
			else toPrint("You don't have any health potions to drink.\n\n");
		}
		clear();
	}
	
	/**
	 * This runs the majority of the game, aside from combat. This method takes the current room value and the choice value and determines what happens. The choice is given by the button pressed and the room value is stored in game, the character object, as well as Display when it uses this method.
	 * This method essentially moves a character from one room to another and updates those stored values as such so each choice has the proper result for the room the character is in.
	 * <pre>Example:
	 * {@code game.room(0, 1) will return 1, as in room 0 the choice 1 moves you to room 1.
	 * }</pre>
	 * @param room (int; the current room to asses the choice for)
	 * @param choice (int; the choice made for the current room)
	 * @return reRoom (int; a variable stored in the game object, but which keeps the current room the same until changed to be continuously returned).
	 */
	public int room(int room, int choice) {
		//restarting
		if (room == -1) {
			//back to it
			if (choice == 0) {
				toPrint("You open your eyes and find yourself standing in the awakening room once more. "
						+ "You have lost all your potions and coins, yet retain all else you had gathered so far. "
						+ "At least you feel refreshed.\n");
				toPrint(""
						+ "1) Go to the armory\n"
						+ "\n");		
			}
			reRoom = 1;
			hero.setRoom(1);
		}
		//waking up
		if (room == 0) {
			if (choice == 0) {
				toPrint("You come to consciousness surrounded by darkness, unable to see anything.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n");
						if (hero.isTutorial()) toPrint("3) Turn off tutorial\n\n");
						else toPrint("3) Turn on tutorial\n\n");
			}
			else if (choice == 1) {
				toPrint("You take a moment to think of how to make light and, as if in response, tattoos upon your skin begin to glow "
						+ "As they do, however, you feel a slight, burning pain and feel yourself grow a little more damaged, the magic costing some of your life.\n"); //consequence of Action 1 
				
				hero.setHP(hero.getHP()-1);
				toPrint("\tYou open your eyes and find yourself laying on a slab of hard material that appears to be obsidian. "
						+ "The stone walls and floor of the room are covered in scorch marks ash stains. "
						+ "There is a door out of the room as well as a table nearby with a map and key upon it, as well as a sword and dagger; "
						+ "both of which are made of the same material as the table upon which you awoke.\n");
				hero.setRoom(1); //set to awakening room
				reRoom = 1;
				toPrint(""
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			else if (choice == 2) {
				toPrint("You do nothing. This is unlikely to get you anywhere.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n");
						if (hero.isTutorial()) toPrint("3) Turn off tutorial\n"
							+ "\n");
						else toPrint("3) Turn on tutorial\n\n");
			}
			else if (choice == 3) {
				if (hero.isTutorial()) {
					hero.setTutorial(false);
					hero.setHP(50);
					hero.setCoins(1);
					toPrint("Tutorial disabled\n"
							+ "1) Make a light\n"
							+ "2) Do Nothing\n"
							+ "3) Turn on tutorial\n"
							+ "\n");
				}
				else {
					hero.setTutorial(true);
					hero.setHP(40);
					hero.setCoins(0);
					toPrint("Tutorial enabled\n"
							+ "1) Make a light\n"
							+ "2) Do Nothing\n"
							+ "3) Turn off tutorial\n"
							+ "\n");
				}
				
			}
		}
		//Awakening Room
		else if (room == 1) {
			if (choice == 1) {
				if (hero.isMap()) {
					if (hero.isTutorial()) {
						toPrint("You insert the key into the door and twist, unlocking the door and swinging it open with a creak to enter the armory.\n");
						hero.setRoom(2);
						type = 0;
						combatStarter(type);
					}
					else {
						toPrint("You leave through the door to enter the armory once again.");
						hero.setRoom(2);
						enterRoom();
					}
					
				}
				else toPrint("You try to leave but find the door locked.\n"
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			else if (choice == 2) {
				if (!(hero.isMap())) {
					hero.setAttack(6);
					hero.setDefense(2);
					toPrint("You take the items from the table.\n"
							+ "1) Go to the armory\n"
							+ "\n");
					hero.setMap(true);
				}
			}
		}
		//armory
		else if (room == 2) {
			if (choice == 1) {
				toPrint("You exit the armory via a sturdy, reinforced wooden door, entering the barracks.\n");
				hero.setRoom(3);
				combatStarter(1);
				type = 1;
			}
			else if (choice == 2) {
				toPrint("You exit the armory through a heavy metal door, entering the awakening room once more.\n");
				hero.setRoom(1);
				enterRoom();
			}
		}
		//barracks
		else if (room == 3) {
			if (choice == 1) {
				toPrint("You approach the northern wall which has no visible door as the map might indicate, at least until you step near it- "
						+ "in the center where here are no intrusive green growths- and the stones themselves neatly slide apart to permit you within, light streaming out to greet you.\n");
				hero.setRoom(4);
				enterRoom();
			}
			else if (choice == 2) {
				
				toPrint("The door to the storage is partially broken, the latch failed so that it is left to hang open, needing only a gentle pull to allow entrance and as you step inside it swings closed behind you.\n");
				hero.setRoom(5);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 3) {
				toPrint("The hallway entrance is a very plain and simple door, with no ability to lock or bar it naturally a part of its function. It creaks softly as you open it to step into the hallway.\n");
				hero.setRoom(6);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 4) {
				toPrint("You return to the armory via the heavy sturdy, reinforced door.\n");
				hero.setRoom(2);
				enterRoom();
			}
		}
		//shop
		else if (room == 4) {
			if (choice == 1) {
				if (hero.getCoins() >= 2) {
					toPrint("You indicate the health potion and the man smiles. "
							+ "He holds up two fingers and two of the silvery coins you have collected from your foes drift out from you and into his now outstretched palm. "
							+ "He offers you the potion, which you take.\n");
					hero.setCoins(hero.getCoins()-2);
					hero.setHPPotion(hero.getHPPotion()+1);
					toPrint("1) Buy a potion of health(2 coins)\n");
					if (!hero.isCaptainKey()) {
						toPrint("2) Buy the golden key.(10 coins)\n"
							+ "3) Leave\n"
							+ "\n");
					}
					else toPrint("2) Leave\n"
							+ "\n");
				}
				else {
					toPrint("The man shakes his head. You don't have enough coins to buy that ware.\n"	
						+ "1) Buy a potion of health(2 coins)\n");
					if (!hero.isCaptainKey()) {
						toPrint("2) Buy the golden key.(10 coins)\n"
								+ "3) Leave\n"
								+ "\n");
					}
					else toPrint("2) Leave\n"
							+ "\n");;
				}
			}
			else if (choice == 2) {
				if (!hero.isCaptainKey()) {
					if (hero.getCoins() >= 10) {
						toPrint("Indicating the key, the man gives a nod. Snapping his fingers, ten of the silvery coins you have collected leap over and into his palm before he offers you the sole key.\n");
						hero.setCaptainKey(true);
						hero.setCoins(hero.getCoins()-10);
						toPrint("1) Buy a potion of health(2 coins)\n");
						if (!hero.isCaptainKey()) {
							toPrint("2) Buy the golden key.(10 coins)\n"
								+ "3) Leave\n"
								+ "\n");
						}
						else toPrint("2) Leave\n"
								+ "\n");
					}
					else {
						toPrint("The man shakes his head. You don't have enough coins to buy that ware.\n"
							+ "1) Buy a potion of health(2 coins)\n");
						if (!hero.isCaptainKey()) {
							toPrint("2) Buy the golden key.(10 coins)\n"
									+ "3) Leave\n"
									+ "\n");
						}
						else toPrint("2) Leave\n"
								+ "\n");
					}
				}
				else {
					toPrint("You stand, thanking the man for his time, and step back through the wall that parted for you into the barracks. The wall closes behind you with a heavy thunk.\n");
					hero.setRoom(3);
					enterRoom();
				}
				
			}
			else if (choice == 3) {
				if (!hero.isCaptainKey()) {
					toPrint("You stand, thanking the man for his time, and step back through the wall that parted for you into the barracks. The wall closes behind you with a heavy thunk.\n");
					hero.setRoom(3);
					enterRoom();
				}
			}
		}
		//storage
		else if (room == 5) {
			if (choice == 1) {
				toPrint("You return to the barracks, pushing aside the busted door.\n");
				hero.setRoom(3);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 2) {
				toPrint("You find nothing, for now.\n");
			}
		}
		//hallway
		else if (room == 6) {
			if (choice == 1) {
				toPrint("You return to the barracks through the plain door.\n");
				hero.setRoom(3);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 2) {
				toPrint("The training room is separated only by an archway you walk through, having to step over a large, pulsing sack of the green goo taking up much of the space.\n");
				hero.setRoom(7);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 3) {
				toPrint("The messhall door is missing, once there but has been smashed to bits by some force in the past. You step over the rubble to get inside.\n");
				hero.setRoom(10);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 4) {
				if (hero.isCaptainKey()) {
					toPrint("Using the key you got from the shopkeeper, you slide it into the door and with a click hear it unlock. You push the door open and step inside.");
					type = 3;
					combatStarter(type);
				}
				else toPrint("The door is locked. You try the key you got from the awakening room, but to no avail. You need a different key.\n"
						+ "1) Go to the barracks\n"
						+ "2) Go to the training room\n"
						+ "3) Go to the mess hall\n"
						+ "4) Go to the captain's chamber.\n"
						+ "\n");
			}
		}
		//training room
		else if (room == 7) {
			if (choice == 1) {
				toPrint("You return to the hallway, stepping over the sack in the archway.\n");
				hero.setRoom(6);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 2) {
				toPrint("You look over the bodies and find...\n");
				toPrint(""
						+ "1) Go to the hallway\n"
						+ "2) Investigate the bodies.\n"
						+ "\n");
			}
		}
		//captain's room
		else if (room == 9) {
			
		}
		//mess hall
		else if (room == 10) {
			if (choice == 1) {
				toPrint("You return to the hallway, stepping over the rubble of the door that once was.\n");
				hero.setRoom(6);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 2) {
				toPrint("You search the area for some food and find some that is, miraculously, still fresh. "
						+ "The hunger in your belly drives you to throw away a little caution and take the risk of eating it.\n");
				if (hero.getHP() < 25) hero.setHP(25);
				toPrint("1) Go to the hallway\n"
				+ "2) Search the room\n"
				+ "\n");
				
			}
		}
		
		//maybe edit this
		else if (room == 100) {
			if (choice == 1) {
				toPrint("You will not give into the darkness! Though it surrounds you now, you realize you are but sleeping.\n\n\n"
						+ "\n");
				hero = new Character();
				reRoom = 0;
				
			}
			else if (choice == 2) {
				reRoom = 101;
				toPrint("And then the darkness takes you.\n");
			}
		}
		
		
		//combat
		else if (room == 8) {
			int result = 0;
			if (conflict.isInit()) result = conflict.fight(hero, choice, conflict.getFoeType());
			else result = conflict.fight(hero, choice, type);
			toPrint(conflict.getTextToPrint());
			conflict.clear();
			if (result == 0) {
				
				toPrint("You have been slain.\n"
						+ "1) Try Again\n"
						+ "2) Give up\n"
						+ "\n");
				reRoom = 100;
			}
			else if (result == 2) {
				enterRoom();
			}
			else reRoom = 8;

		}
		
		if (!textToPrint.equalsIgnoreCase("")) clear();
		return reRoom;
	}


		
	/**
	 * This method is used when combat begins (typically by entering a room). It will display the opening message as appropriate to the type of enemy being fought and then set the room to room 8, which is the room that handles combat. It then prints the first set of choices for a combat, as the set up of this program requires.
	 * <pre>Example:
	 * {@code combatStarter(2) will set the room to 8 and display the combat beginning message of a type 2 enemy.
	 * }</pre>
	 * @param seed (int; the type of enemy about to be fought and whose message should be displayed before the player action options are displayed)
	 */
	public void combatStarter(int seed) {
		reRoom = 8;
		if (seed == 0) {
			toPrint("A noise sounds nearby and you look to see a rotten, shambling body stumble towards you, skin pale and lifeless, eyes sunken and gone.\n"
					+ "(Combat has started! After an enemy is introduced, the following message will display to show you your combat options)"
				
					+ "\n");
		}
		else if (seed == 1) {
			toPrint("A deep, guttural growl suddenly draws your attention to a shambling corpse wearing tattered, ripped clothing; the body, animated by some unknown force, bears bulbous, glowing green growths across its body. "
					+ "It carries an old, slightly rusted weapon but despite the dilapidated nature, you have no doubt the weapon can do damage."
					+ "\n");
		}
		else if (seed == 2) {
			toPrint("A squelching, wet sound fills the room as you look at one of the green growths protruding from the wall; "
					+ "a hole has opened and something is slowly pushed out, covered in the green slime within the pulsing sack. "
					+ "The creature stands to face you: it is thin and pale, with four arms that each end in vicious, clawed hands. "
					+ "Razor sharp teeth clack together while four glowing green eyes stare you down. "
					+ "You have just enough time to draw your sword before it rushes you with surprising speed."
					+ "\n");
		}
		else if (seed == 3) {
			toPrint("Standing in the center of the room is a massive creature, at least a torso’s length taller than yourself. "
					+ "Four green-skinned arms are rest folded across its chest as it calmly regards you with four beady eyes. "
					+ "It speaks in a deep, booming voice before two hands reach down to grab a pair of axes off its belt; "
					+ "as it does, a series of tattoos suddenly glow upon its body- tattoos rather similar to yours. "
					+ "The creature bellows and charges you, axes swinging." + 
					"\n");
		}
		toPrint("What will you do?\n"
				+ "1) Attack with weapons\n"
				+ "2) Attack with magic(3 hp)\n"
				+ "3) Buff yourself(3 hp)\n"
				+ "4) Debuff enemy(5 hp)\n"
				+ "\n");
		if (seed == 0) toPrint("(As you can see, the magic you can use will cost certain amounts of your life. Let's start off using a buff. Click the \"3\" button to proceed)\n");
	}

	/**
	 * This method is a solution to the issues I encountered with loops in the Display class. Past versions of this game had, essentially, a guarded loop that would continue until the player finished. However, if a loop doesn't close the Display class will never update, it just all freezes up.
	 * As a result, the format requires that any information as a result of a choice (including what options are now available as a result) must be displayed before the next choice can be made. Not super complicated but if two rooms ever led to the same room, both would have to display the same message for entering that room once the player did.
	 * Instead of copy and pasting the same information all over, I made this method so that, once its called, will set the reRoom to the room the character object has stored and print the description method.
	 * This way, at any time the user enters a room and would get the description (be that after combat or simply entering a non-aggressive room) this method is called to display that rooms information for them and set them into that room as far as Display and the room method are concerned.
	 * <pre>Example:
	 * {@code enterRoom() will display one of 9 message strings and then set the return room to the current room value in the character object.
	 * }</pre>
	 */
	public void enterRoom() {
		reRoom = hero.getRoom();
		if (reRoom == 1) {
			//Awakening room
			toPrint("\tThe awakening room is as you left it: the obsidian like table in the center, ash and burn marks all around, now empty desk tucked into the corner.\n"
					+ "1) Go to the armory\n"
					+ "\n");
		}
		else if (reRoom == 2) {
			//armory 
			toPrint("\tThe armory's floor and walls are made of many heavy stone blocks cemented together. "
					+ "Racks and tables alike surely once held a great array of impressive weaponry and armor, though now lay barren or holding only rusting, broken weaponry. \n"
					+ "1) Go to the barracks\n"
					+ "2) Go to the awakening room.\n");
					toPrint("\n");	
		}
		else if (reRoom == 3) {
			//barracks
			toPrint("\tThe barracks walls are the same heavy stone, but its floor is wooden boards through which strange, disgusting green growths have pushed and shoved their way, emerging. "
					+ "They appear like large sack of slime or go, or simply a leather skin stretched over some hidden bone structure. It is alien and disgusting, but you leave it be. "
					+ "The invasive growths mostly seep and spill up from the floor around the edges of the room, but a few pierce in from the north wall as well. "
					+ "The bunks that were once the resting places and storage areas of whoever lived here are pushed aside and even grown over by the material along the edges. "
					+ "Of the four rows of bunks, the two in the center remain mostly untouched, left in a state of disarray- the drawers beneath each that held the clothes and personal effects of the people are either empty or messy, but hold nothing of value.\n"
					+ "1) Go to the shop\n"
					+ "2) Go to the storage.\n"
					+ "3) Go to the hallway.\n"
					+ "4) Go to the armory.\n"
					+ "\n");
		}
		else if (reRoom == 4) {
			//shop
			toPrint("\tAs you step through the entrance made in the wall, you find yourself in a small room that actually holds its own lightning provided by the four braziers that sit in the corners of the room which has wooden log walls, smooth boards upon the floor, and rafters instead of a proper ceiling. "
					+ "A thick, fur carpet covers most of the floor save the edges and upon this is set a large desk, piled with papers, covered in coins, and bearing a set of plain scales. "
					+ "Before the desk a plain wooden chair is set and behind it a much more plush chair holds a cloaked figure. "
					+ "The face of the figure is hidden in the shadows of his hood, but the long, grey beard that spills out over the red cloth he and wears moves as he speaks, motioning with a bony hand towards the single chair near you.\n "
					+ "\t\"Please, sit. See my wares.\"\n "
					+ "\tAnd as you sit, he presents all he has to sell to you.\n"
					+ "1) Buy a potion of health(2 coins)\n");
			if (!hero.isCaptainKey()) {
				toPrint("2) Buy the golden key.(10 coins)\n"
					+ "3) Leave\n"
					+ "\n");
			}
			else toPrint("2) Leave\n"
					+ "\n");
		}
		else if (reRoom == 5) {
			//storage
			toPrint("\tThe storage room has a single, massive green strand jutting through it up from the floor into the ceiling above. "
					+ "All about the room, various boxes and crates hold old, rotting food; threadbare, moth eaten uniforms; various, aged supplies; and some are simply empty or their contents spilled across the floor. "
					+ "Others are smashed open.\n"
					+ "1) Go to the barracks\n"
					+ "2) Search the room.\n"
					+ "\n");

		}
		else if (reRoom == 6) {
			//hallway
			toPrint("\tThe hallway's stone floor is broken and dislocated by the many growths that have forced their way up throughout it, out of and into walls and floors alike, making navigating it a little difficult. "
					+ "As the map said, towards the end where you might be able to move further on, the hallway has caved in and been filled completely by the seemingly every present green material. \n"
					+ "1) Go to the barracks\n"
					+ "2) Go to the training room\n"
					+ "3) Go to the mess hall\n"
					+ "4) Go to the captain's chamber.\n"
					+ "\n");
		}
		else if (reRoom == 7) {
			//training room
			toPrint("\tThe training room holds a pit of sand with an elevated wooden walkway around it. "
					+ "It also seems to be the scene of a battle of the past. "
					+ "Bodies, long since rotted and smelling, lay scattered across the sand and walkway, black blood stains adorning the ground and walls around them. "
					+ "1) Go to the hallway\n"
					+ "2) Investigate the bodies.\n"
					+ "\n");
		}
		else if (reRoom == 9) {
			toPrint("\tAs you enter the captain's chamber, you see a window blocked up by the green material. The well made bed, the cluttered desk, the chest locked in the corner, it all seems to fade away as you gaze upon the window.\n"
					+ "1) Break out the window, escape.\n"
					+ "2) Return to the hallway, remain.\n"
					+ "\n");

			
		}
		else if (reRoom == 10) {
			//mess hall
			toPrint("\tThe mess hall's floors shift from the stone of the hallway back to the same wood of the barracks. "
					+ "Wooden tables- chipped and dented with use over time- stand at attention in two long rows of two down the longer length of the hall. "
					+ "The room is surprisingly clear and orderly, save the few notably large growths that spill up from the floor- keeping mostly to the center- as if attempting to form a single, larger one- where they only have moved and ruined two tables.\n"
					+ "1) Go to the hallway\n"
					+ "2) Search the room\n"
					+ "\n");
		}
	}

	/**
	 * This method is used to gather all the text this class will need displayed and store it in a variable until it is needed.
	 * <pre>Example:
	 * {@code toPrint("Hello") will append "Hello" to the variable textToPrint.
	 * }</pre>
	 * @param message (String; message to add to the storage string)
	 */
	public void toPrint(String message) {
		textToPrint += message;
	}
	/**
	 * This method calls the Display.print() method to print its currently stored string and then resets the string.
	 * <pre>Example:
	 * {@code clear() will call Display.print(textToPrint) followed by setting textToPrint to "", essentially empty.
	 * }</pre>
	 */
	public void clear() {
		Display.print(textToPrint);
		textToPrint = "";
	}
}
