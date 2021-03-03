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
	public int getPotions() {
		return hero.getPotions();
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
	public void drinkPotion() {
		if (hero.getPotions() > 0) {
			hero.setPotions(hero.getPotions()-1);
			hero.setHP(hero.getHP() + 10);
		}
	}
	

	public int room(int room, int choice) {

		//waking up
		if (room == 0) {
			if (choice == 0)
				Help.print("You come to consciousness surrounded by darkness, unable to see anything.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			if (choice == 1) {
				Help.print("You summon a power within you and conjure up a ball of light.\n"); //consequence of Action 1 
				hero.setMana(hero.getMana()-1);
				Help.print("You open your eyes and find yourself laying on a stone slab, in the middle of a room. "
						+ "There is a door out of the room as well as a table nearby with a map, dagger, and key upon it.\n");
				hero.setRoom(1); //set to awakening room
				reRoom = 1;
				Help.print(""
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			if (choice == 2) {
				Help.print("You do nothing. This is unlikely to get you anywhere.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			}
		}
		//Awaken Room
		else if (room == 1) {
			if (choice == 1) {
				if (hero.isMap()) {
					if (hero.isTutorial()) {
						Help.print("You insert the key into the door and twist, unlocking the door and swinging it open with a creak."
								+ "Beyond is an emtpy corridor and, stepping into it, you see shadows form, ready to face you.\n");
						//testing combat
						
						hero.setTutorial(false);
						hero.setRoom(2);
						reRoom = 8;
						type = combatStarter(0);
					}
					else {
						Help.print("You leave the room, entering the armory.\n"
							+ "This describes the armory.\n"
							+ "1) Go to the awakening room.\n"
							+ "2) Go to the Barracks.\n");
							if (hero.getAttack() <= 2) Help.print("3) Grab a weapon.\n");
							Help.print("\n");
							reRoom = 2;
							hero.setRoom(2);
					}
					
				}
				else Help.print("You try to leave but find the door locked.\n"
						+ "1) Leave through the door\n"
						+ "2) Take the items from the table.\n"
						+ "\n");
			}
			else if (choice == 2) {
				if (!(hero.isMap())) {
					hero.setAttack(2);
					Help.print("You take the items from the table.\n"
							+ "1) Leave to the Armory\n"
							+ "\n");
					hero.setMap(true);
				}
			}
		}
		//armory
		else if (room == 2) {
			if (choice == 1) {
				Help.print("You return to the awakening room.\n"
						+ "There isn't much here that's new. There is the stone table, the empty table, and thedoor you entered through.\n"
						+ "1) Leave to the Armory\n"
						+ "\n");
				reRoom = 1;
				hero.setRoom(1);
			}
			else if (choice == 2) {
				Help.print("You exit the armory through the door.\n");
				hero.setRoom(3);
				
				
				int y = combatCheck();
				if (y > 0) {
					type = combatStarter(y);
					reRoom = 8;
				}
				else {
					reRoom = 3;
					Help.print("Barracks intro.\n"
							+ "1) Go to the Armory\n"
							+ "2) Go to the Hallway"
							+ "3) Go to the Shop\n"
							+ "4) Go to the Storage\n"
							+ "\n");
				}
				
				
			}
			else if (choice == 3) {
				if (hero.getAttack() <= 2) {
					Help.print("You decide to abanon your dagger for a more trusty sword.\n"
							+ "1) Go to the Awakening Room.\n"
							+ "2) Go to the Barracks.\n"
							+ "\n");
					hero.setAttack(5);
				}
			}
		}
		//barracks
		else if (room == 3) {
			if (choice == 1) {
				Help.print("You head into the armory.\n");
				hero.setRoom(2);
				int y = combatCheck();
				Help.print("You leave the room, entering the armory.\n"
						+ "This describes the armory.\n"
						+ "1) Go to the awakening room.\n"
						+ "2) Go to the Barracks.\n");
						if (hero.getAttack() <= 2) Help.print("3) Grab a weapon.\n");
						Help.print("\n");
				reRoom = 2;
			}
			else if (choice == 2) {
				Help.print("You head into the hallway.\n");

			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
			}
		}
		//shop
		else if (room == 4) {
			if (choice == 1) {

			}
			else if (choice == 2) {
				
			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
			}
		}
		//storage
		else if (room == 5) {
			if (choice == 1) {

			}
			else if (choice == 2) {
				
			}
			else if (choice == 3) {
				
			}
			else if (choice == 4) {
				
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
				Help.print("You push on.\n"
						+ "\n");
				hero = new Character();
				reRoom = 0;
				Help.print("You come to consciousness surrounded by darkness, unable to see anything.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			}
			else if (choice == 2) {
				reRoom = 101;
				Help.print("And then the darkness takes you.\n");
			}
		}
		
		
		
		
		
		//combat- your turn
		else if (room == 8) {
			int result = 0;
			if (conflict.isInit()) result = conflict.fight(hero, choice, conflict.getFoeType());
			else result = conflict.fight(hero, choice, type);
			if (result == 0) {
				Help.print("You have been slain.\n"
						+ "1) Try Again\n"
						+ "2) Give up\n"
						+ "\n");
				reRoom = 100;
			}
			else if (result == 1) {
				reRoom = 8;
			}
			else if (result == 2) {
				combatEnder();
			}
			else if (result == 3) {
				reRoom = 8;
			}
			
		}
		
		return reRoom;
		
	}
	public int combatCheck() {
		int check = (int)(Math.random()*3);
		if (check == 0) {
			
		}
		else if (check == 1) {
			
		}
		else if (check == 2) {
			
		}
		
		return check;
	}
	
	
	public int combatStarter(int seed) {
		if (seed == 0) {
			Help.print("You are fighting a shade.\n");
		}
		else if (seed == 1) {
			Help.print("You are fighting a skeleton.\n");
		}
		else if (seed == 2) {
			Help.print("You are fighting a zombie.\n");
		}
		else if (seed == 3) {
			Help.print("You are fighting the Lord.\n");
		}
		Help.print("What will you do?\n"
				+ "1) Attack\n"
				+ "2) Defend\n"
				+ "3) Use Magic\n"
				+ "\n");
		
		
		return seed;
	}
	public void combatEnder() {
		reRoom = hero.getRoom();
		if (reRoom == 0) {
			
		}
		else if (reRoom == 2) {
			Help.print("This describes the armory.\n"
			+ "1) Go to the awakening room.\n"
			+ "2) Go to the Barracks.\n");
			if (hero.getAttack() <= 2) Help.print("3) Grab a weapon.\n");
			Help.print("\n");
		}
		else if (reRoom == 3) {
			//barracks
			Help.print("Describe barracks post fight\n"
					+ "1) Go to the Armory\n"
					+ "2) Go to the Hallway\n"
					+ "3) Go to the Shop\n"
					+ "4) Go to the Storage\n"
					+ "\n");

		}
		else if (reRoom == 5) {
			//storage
			Help.print("");
		}
		else if (reRoom == 6) {
			//hallway
			Help.print("");
		}
		else if (reRoom == 7) {
			//training room
			Help.print("");
		}
		else if (reRoom == 9) {
			//captain's room
		}
		else if (reRoom == 10) {
			//messhall
		}
	}
	
	
}
