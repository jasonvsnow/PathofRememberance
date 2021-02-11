package thePath;




public class Game {
	private Character hero;
	private int hp = 50;
		
	Game() {
		hero = new Character();
	}
	public int getHP() {
		return hp;
	}
	
	public int room(int room, int choice) {
		int reRoom = room;
		//waking up
		if (room == 0) {
			if (choice == 0)
				Help.print("It is dark yada yada\n"
						+ "1) Make a light\n"
						+ "\n");
			if (choice == 1) {
				Help.print("You wake up\n"); //consequence of Action 1 
				//add mana take
				reRoom = 1; //set to awakening room
				Help.print("You sit up and look around yada yada\n"  //intro to awakening room and actions
						+ "1) I wanna leave\n"
						+ "\n");
			}
		}
		//Awaken Room
		else if (room == 1) {
			if (choice == 1) {
				Help.print("You've left the empty boring room.\n"); //consequence of Action 1 
				reRoom = 2;
				Help.print("The armory is X\n "   //intro to armory
						+ "1) Hurt ourselves here\n"
						+ "2) Move to the healing room\n"
						+ "\n");
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
				hp -= 1;
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
		//hallway
		else if (room == 8) {
			
		}
		//messhal
		else if (room == 9) {
			
		}
		//captain's chamber
		else if (room == 10) {
			
		}
		//training room
		else if (room == 11) {
			
		}
		//basement 
		else if (room == 12) {
			
		}
		//grand hall
		else if (room == 13) {
			
		}
		//combat starter 
		else if (room == 14) {
			
		}
		
		return reRoom;
		
	}
}
