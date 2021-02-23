package thePath;




public class Game {
	private Character hero;
		
	Game() {
		hero = new Character();
	}
	public int getHP() {
		return hero.getHP();
	}
	

	
	public int room(int room, int choice) {
		int reRoom = room;
		//waking up
		if (room == 0) {
			if (choice == 0)
				Help.print("You come to consciousness and feel yourself lying upon something hard. You are surrounded by darkness, unable to see anything.\n"
						+ "1) Make a light\n"
						+ "2) Do Nothing\n"
						+ "\n");
			if (choice == 1) {
				Help.print("You summon a power within you and conjure up a ball of light.\n"); //consequence of Action 1 
				//add mana take
				reRoom = 1; //set to awakening room
				
				
				Help.print("With the orb of light in your hand, you stand and are able to see the rest of the room clearly. "
						+ "You were laying upon an obsidian slab and nearby there is a wooden table. There is a door.\n"  //intro to awakening room and actions
						+ "1) Leave through the door\n"
						+ "2) Investigate table.\n"
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
					Help.print("You exit the room via the door.\n");
					//consequence of Action 1 
					reRoom = 2;
					Help.print("You enter an armory. "
							+ "Weapons rest upon racks, a table sits in the center with a few plates and cups upon it, and several chairs are about the table. "
							+ "There is a door to the east, a door to the west, and a door to the south. "
							+ "You know where the doors lead thanks to your map.\n"
							+ "1) Return to the awakening room\n"
							+ "2) Grab a weapon"
							+ "3) Hurt ourselves with a wepaon\n"
							+ "\n");
				}
				else Help.print("You try to leave but find the door locked.\n"
						+ "1) Leave through the door\n"
						+ "2) Investigate table.\n"
						+ "\n");
			}
			else if (choice == 2) {
				if (hero.isMap()) {
					Help.print("You already found everything on this table.\n"
							+ "1) Leave through the door\n"
							+ "2) Investigate table.\n"
							+ "\n");
				}
				else {
					Help.print("You look at the table and find a map and key.\n"
							+ "1) Leave through the door\n"
							+ "2) Investigate table.\n"
							+ "\n");
					hero.setMap(true);
				}
			}
		}
		//armory
		else if (room == 2) {
			//choose weapons
			if (choice == 1) {
				Help.print("We go back to hurt ourselves in the other room.\n"
						+ "\n");
				Help.print("We can hurt ourselves in this room.\n"
						+ "1) Hurt ourselves here\n"
						+ "2) Move to the healing room/n/n");
				reRoom = 1;
			}
			else if (choice == 2) {
				Help.print("We heal ourselves.\n"
						+ "1) Go back to other Room\n"
						+ "2) Heal some more\n\n"
						+ "");
				hero.setHP(hero.getHP()-1);
			}
			else if (choice == 3) {
				//leave to Closet
			}
			else if (choice == 4) {
				//leave to Awakening room
			}
		}
		//armory selection
		else if (room == 3) {
			if (choice == 0) {
				//intro
			}
			else if (choice == 1) {
				//sword
			}
			else if (choice == 2) {
				//axe
			}
			else if (choice == 3) {
				//staff
			}
			else if (choice == 4) {
				//leave
			}
			
		}
		//barracks
		else if (room == 4) {
			if (choice == 0) {
				//intro
			}
			else if (choice == 1) {
				//hall way
			}
			else if (choice == 2) {
				//shop
			}
			else if (choice == 3) {
				//closet
			}
			else if (choice == 4) {
				//armory 
			}
		}
		//closet
		else if (room == 5) {
			if (choice == 0) {
				//intro (get basement key)
			}
			else if (choice == 1) {
				//leave
			}
		}
		//shop
		else if (room == 6) {
		
		}
		//shopping
		else if (room == 7) {
			
		}
		
		return reRoom;
		
	}
}
