package thePath;




public class Game {
	private Character hero;
	private Combat conflict;
	private int reRoom;
	private int type;
	
		
	Game() {
		hero = new Character();
		conflict = new Combat();
		reRoom = 0;
		type = 0;
	}
	public int getHP() {
		return hero.getHP();
	}
	public int getMana() {
		return hero.getMana();
	}
	public int getCoins() {
		return hero.getCoins();
	}
	public int getHPpotions() {
		return hero.getHPPotion();
	}
	public int getMNPotions() {
		return hero.getMNPotion();
	}
	public int getAttack() {
		return hero.getAttack();
	}
	public int getDefense() {
		return hero.getDefense();
	}
	public boolean isMap() {
		return hero.isMap();
	}
	public void drinkHPotion() {
		if (hero.getHP() > 0) {
			if (hero.getHPPotion() > 0) {
				if (hero.getHP() < 50) {
					hero.setHPPotion(hero.getHPPotion()-1);
					hero.setHP(hero.getHP() + 10);
					if (hero.getHP() > 50) hero.setHP(50);
				}
				else Display.print("You're already at maximum health! Save that potion for later.\n\n");
			}
			else Display.print("You don't have any health potions to drink.\n\n");
		}
	}
	public void drinkMNPotion() {
		if (hero.getHP() > 0) {
			if (hero.getMNPotion() > 0) {
				if (hero.getMana() < 20) {
					hero.setMNPotion(hero.getMNPotion()-1);
					hero.setMana(hero.getMana() + 5);
					if (hero.getMana() > 20) hero.setMana(20);
				}
				else Display.print("You're already at maximum mana! Save that potion for later.\n\n");
			}
			else Display.print("You don't have any mana potions to drink.\n\n");
		}
	}
	
	

	public int room(int room, int choice) {

		//waking up
		if (room == 0) {
			if (choice == 0)
				Display.print("You come to consciousness surrounded by darkness, unable to see anything.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			if (choice == 1) {
				Display.print("You summon a power within you and conjure up a ball of light.\n"); //consequence of Action 1 
				hero.setMana(hero.getMana()-1);
				Display.print("You open your eyes and find yourself laying on a stone slab, in the middle of a room. "
						+ "There is a door out of the room as well as a table nearby with a map, dagger, and key upon it.\n");
				hero.setRoom(1); //set to awakening room
				reRoom = 1;
				Display.print(""
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			if (choice == 2) {
				Display.print("You do nothing. This is unlikely to get you anywhere.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			}
		}
		//Awakening Room
		else if (room == 1) {
			if (choice == 1) {
				if (hero.isMap()) {
					if (hero.isTutorial()) {
						Display.print("You insert the key into the door and twist, unlocking the door and swinging it open with a creak to enter the armory.\n");
						hero.setTutorial(false);
						hero.setRoom(2);
						type = 0;
						combatStarter(type);
					}
					else {
						Display.print("You leave through the door to enter the armory once agian.");
						hero.setRoom(2);
						enterRoom();
					}
					
				}
				else Display.print("You try to leave but find the door locked.\n"
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			else if (choice == 2) {
				if (!(hero.isMap())) {
					hero.setAttack(2);
					Display.print("You take the items from the table.\n"
							+ "1) Go to the armory\n"
							+ "\n");
					hero.setMap(true);
				}
			}
		}
		//armory
		else if (room == 2) {
			if (choice == 1) {
				Display.print("You exit the armory via a sturdy, reinforced wooden door, entering the barracks.\n");
				hero.setRoom(3);
				combatStarter(1);
				type = 1;
			}
			else if (choice == 2) {
				Display.print("You exit the armory through a heavy metal door, entering the awakening room once more.\n");
				hero.setRoom(1);
				enterRoom();
			}
			else if (choice == 3) {
				if (hero.getAttack() <= 2) {
					Display.print("You decide to abanon your dagger for a more trusty sword.\n"
							+ "1) Go to the barracks\n"
							+ "2) Go to the awakening room.\n"
							+ "\n");
					hero.setAttack(5);
					hero.setDefense(2);
				}
			}
		}
		//barracks
		else if (room == 3) {
			if (choice == 1) {
				Display.print("You approach the northern wall which has no visible door as the map might indicate, at least until you step near it- "
						+ "in the center where here are no spikes jutting out- and the stones themselves neatly slide apart to permit you within, light streaming out to greet you.\n");
				hero.setRoom(4);
				enterRoom();
			}
			else if (choice == 2) {
				
				Display.print("The door to the storage is partially broken, the latch failed so that it is left to hang open, needing only a gentle pull to allow entrance and as you step inside it swings closed behind you.\n");
				hero.setRoom(5);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 3) {
				Display.print("The hallway entrance is a very plain and simple door, with no ability to lock or bar it naturally a part of its function. It creaks softly as you open it to step into the hallway.\n");
				hero.setRoom(6);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 4) {
				Display.print("You return to the armory via the heavy sturdy, reinforced door.\n");
				hero.setRoom(2);
				enterRoom();
			}
		}
		//shop
		else if (room == 4) {
			if (choice == 1) {
				if (hero.getCoins() > 0) {
					Display.print("You give the man a gold coin and in exchange receive a single bottle full of red liquid. It probably tastes like strawberries. Hopefully.\n"
							+ "1) Buy a potion of health(1 coin)\n"
							+ "2) Buy a potion of mana.(2 coins)\n");
					if (!hero.isCaptainKey()) {
						Display.print("3) Buy the golden key.(10 coins)\n"
							+ "4) Leave\n"
							+ "\n");
					}
					else Display.print("3) Leave\n"
							+ "\n");
					hero.setHPPotion(hero.getHPPotion()+1);
					hero.setCoins(hero.getCoins()-1);
				}
				else Display.print("You go to grab a coin to offer the man, but find you have none. You'll have to come back later.\n"
						+ "1) Buy a potion of health(1 coin)\n"
						+ "2) Buy a potion of mana.(2 coins)\n");
				if (!hero.isCaptainKey()) {
					Display.print("3) Buy the golden key.(10 coins)\n"
						+ "4) Leave\n"
						+ "\n");
				}
				else Display.print("3) Leave\n"
						+ "\n");
			}
			else if (choice == 2) {
				if (hero.getCoins() > 1) {
					Display.print("You give the man a gold coin and in exchange receive a single bottle full of shimmering light. Probably feels weird to drink.\n"
							+ "1) Buy a potion of health(1 coin)\n"
							+ "2) Buy a potion of mana.(2 coins)\n");
					if (!hero.isCaptainKey()) {
						Display.print("3) Buy the golden key.(10 coins)\n"
							+ "4) Leave\n"
							+ "\n");
					}
					else Display.print("3) Leave\n"
							+ "\n");
					hero.setMNPotion(hero.getMNPotion()+1);
					hero.setCoins(hero.getCoins()-2);
				}
				else Display.print("You go to grab a coin to offer the man, but find you have none. You'll have to come back later.\n"
						+ "1) Buy a potion of health(1 coin)\n"
						+ "2) Buy a potion of mana.(2 coins)\n");
				if (!hero.isCaptainKey()) {
					Display.print("3) Buy the golden key.(10 coins)\n"
						+ "4) Leave\n"
						+ "\n");
				}
				else Display.print("3) Leave\n"
						+ "\n");
			}
			else if (choice == 3) {
				if (hero.isCaptainKey()) {
					//leave
				}
				else {
					if (hero.getCoins() > 9) {
						//buy key
					}
					else {
						//fail to buy key
					}
				}
			}
			else if (choice == 4) {
				if (!hero.isCaptainKey()) {
					//leave
				}
			}
		}
		//storage
		else if (room == 5) {
			if (choice == 1) {
				Display.print("You return to the barracks, pushing aside the busted door.\n");
				hero.setRoom(3);
				type = (int)(Math.random()*3);
				if (type > 0) combatStarter(type);
				else enterRoom();
			}
			else if (choice == 2) {
				Display.print("You find nothing, for now.\n");
			}
		}
		//hallway
		else if (room == 6) {
			if (choice == 1) {

			}
			else if (choice == 2) {
				
			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
			}
		}
		//training room
		else if (room == 7) {
			if (choice == 1) {

			}
			else if (choice == 2) {
				
			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
			}
		}
		//captain's room
		else if (room == 9) {
			if (choice == 1) {

			}
			else if (choice == 2) {
				
			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
			}
		}
		//mess hall
		else if (room == 10) {
			
		}
	
		
		
		
		
		
		else if (room == 100) {
			if (choice == 1) {
				Display.print("You will not give into the darkness! Though it surrounds you now, you realize you are but sleeping.\n\n\n"
						+ "\n");
				hero = new Character();
				reRoom = 0;
				
			}
			else if (choice == 2) {
				reRoom = 101;
				Display.print("And then the darkness takes you.\n");
			}
		}
		
		
		//combat
		else if (room == 8) {
			int result = 0;
			if (conflict.isInit()) result = conflict.fight(hero, choice, conflict.getFoeType());
			else result = conflict.fight(hero, choice, type);
			if (result == 0) {
				Display.print("You have been slain.\n"
						+ "1) Try Again\n"
						+ "2) Give up\n"
						+ "\n");
				reRoom = 100;
			}
			else if (result == 1) {
				reRoom = 8;
			}
			else if (result == 2) {
				enterRoom();
			}
			else if (result == 3) {
				reRoom = 8;
			}
			
		}
		
		return reRoom;
		
	}
	
	public void combatStarter(int seed) {
		reRoom = 8;
		if (seed == 0) {
			Display.print("As you step into the armory, a shriveled little green creature turns to you and howls, lunging at you with murder in its beady red eyes.\n");
		}
		else if (seed == 1) {
			Display.print("A deep groan echoes near you. Turning, you see what looks to be a person wearing some uniform and carrying an old sword."
					+ "However, instead of a face, the shambling person has several spikes jutting out of their skull that appear to be made of obsidian. "
					+ "Similiar spikes protrude from various places on the creatures limbs and torso, all of them shimmeirng in the light as the groaning creature lunges at you, swipping with its sword.\n");
		}
		else if (seed == 2) {
			Display.print("There is a sound like metal scrapping as a nearby spike splits open and out crawls a creature. "
					+ "The creature appears to be a skeleton encased in the same material as the spikes, acting a sort of natural armor and leaving only the joints and skull visible- the skull having the same spikes jutting out of the face as the other monsters had."
					+ "The only noise it makes is the noise of its feet upon the ground as it lunges towards you, bringing a spiked hand forward.\n");
		}
		else if (seed == 3) {
			Display.print("You are fighting the Lord.\n");
		}
		Display.print("What will you do?\n"
				+ "1) Attack\n"
				+ "2) Defend\n"
				+ "3) Use Magic\n"
				+ "\n");
	}
	public void enterRoom() {
		reRoom = hero.getRoom();
		if (reRoom == 1) {
			//Awakening room
			Display.print("\tThe awakening room is as you left it: the obsidian like table in the center, strange runes scrawled upon the floor, now empty desk tucked into the corner.\n"
					+ "1) Go to the armory\n"
					+ "\n");
		}
		else if (reRoom == 2) {
			//armory 
			Display.print("\tThe armory's floor and walls are made of many heavy stone blocks cemented together. "
					+ "Racks and tables alike surely once held a great array of impressive weaponry and armor, though now lay barren or holding only rusting, broken weaponry. \n"
					+ "1) Go to the barracks\n"
					+ "2) Go to the awakening room.\n");
					if (hero.getAttack() <= 2) Display.print("3) Search for better equipment.\n");
					Display.print("\n");	
		}
		else if (reRoom == 3) {
			//barracks
			Display.print("\tThe barracks walls are the same heavy stone, but its floor is wooden boards- boards pierced, shattered, and pushed aside by spikes of various sizes. "
					+ "With diameters ranging from mere inches to three feet and lengths reaching a staggering six feet at times, the spikes mostly jut up from the floor around the edges of the room, but a few pierce in from the north wall as well. "
					+ "The bunks that were once the resting places and storage areas of whoever lived here are pierced, pushed aside, or shattered by the spikes along the edges. Of the four rows of bunks, the two in the center remain mostly untouched, left in a state of disarray- the drawers beneath each that held the clothes and personal effects of the people are either empty or messy, but hold nothing of value.\n"
					+ "1) Go to the shop\n"
					+ "2) Go to the storage.\n"
					+ "3) Go to the hallway.\n"
					+ "4) Go to the armory.\n"
					+ "\n");
		}
		else if (reRoom == 4) {
			//shop
			Display.print("\tAs you step through the entrance made in the wall, you find yourself in a small room that actually holds its own lightning provided by the four braziers that sit in the corners of the room which has wooden log walls, smooth boards upon the floor, and rafters instead of a proper ceiling. "
					+ "A thick, fur carpet covers most of the floor save the edges and upon this is set a large desk, piled with papers, covered in coins, and bearing a set of plain scales. "
					+ "Before the desk a plain wooden chair is set and behind it a much more plush chair holds a cloaked figure. "
					+ "The face of the figure is hidden in the shadows of his hood, but the long, grey beard that spills out over the red cloth he wears moves as he speaks, motioning with a bony hand towards the single chair near you.\n "
					+ "\t\"Please, sit. See my wares.\"\n "
					+ "\tAnd as you sit, he presents all he has to sell to you.\n"
					+ "1) Buy a potion of health(1 coin)\n"
					+ "2) Buy a potion of mana.(2 coins)\n");
			if (!hero.isCaptainKey()) {
				Display.print("3) Buy the golden key.(10 coins)\n"
					+ "4) Leave\n"
					+ "\n");
			}
			else Display.print("3) Leave\n"
					+ "\n");
		}
		else if (reRoom == 5) {
			//storage
			Display.print("\tThe storage room has a single, massive black spike jutting through it up from the floor into the ceiling above. "
					+ "All about the room, various boxes and crates hold old, rotting food; threadbare, moth eaten uniforms; various, aged supplies; and some are simply empty or their contents spilled across the floor. "
					+ "Others are smashed open.\n"
					+ "1) Go to the barracks\n"
					+ "2) Search the room.\n"
					+ "\n");

		}
		else if (reRoom == 6) {
			//hallway
			Display.print("\tThe hallway’s stone floor is broken and shattered by the many spikes jutting throughout it, out of and into walls and floors alike, making navigating it a little difficult.\n"
					+ "1) Go to the barracks\n"
					+ "2) Go to the training room\n"
					+ "3) Go to the mess hall\n"
					+ "2) Go to the captain’s chamber.\n"
					+ "\n");
		}
		else if (reRoom == 7) {
			//training room
			Display.print("\tThe training room holds a pit of sand with an elevated wooden walkway around it. "
					+ "It also seems to be the scene of a battle of the past. "
					+ "Bodies, long since rotted and smelling, lay scattered across the sand and walkway, black blood stains adorning the ground and walls around them. "
					+ "The bodies all wear the uniforms of the creatures with the spikes for faces- though these bodies seem to be normal people themselves, all hold the same weapons as seen in the armory, and there is no sign of the opposition. "
					+ "The door on the other side of the room that should lead to the anteroom is blocked, the path filled with the black, glistening spikes.\n"
					+ "1) Go to the hallway\n"
					+ "2) Investigate the bodies.\n"
					+ "\n");
		}
		else if (reRoom == 9) {
			Display.print("\tAs you enter the captian's chamber, you realize you won.");
			
		}
		else if (reRoom == 10) {
			//mess hall
			Display.print("\tThe mess hall’s floors shift from the stone of the hallway back to the same wood of the barracks. "
					+ "Wooden tables- chipped and dented with use over time- stand at attention in two long rows of two down the longer length of the hall. "
					+ "The room is surprisingly clear and orderly, save the spikes that jut up through the floor- keeping mostly to the center- as if attempting to form a single, larger one- where they only have moved and ruined two tables.\n"
					+ "1) Go to the hallway\n"
					+ "2) Search the room\n"
					+ "\n");
		}
	}	
}
