package thePath;


import java.util.*;

public class Game {
	private Help help;
	private int hp = 50;
		
	Game() {	
	}
	public int getHP() {
		return hp;
	}
	
	public int room(int room, int choice) {
		int reRoom = room;
		//waking up
		if (room == 0) {
			if (choice == 0)
				Help.print("Wale up.\n"
						+ "1) Wake up\n\n");
			if (choice == 1) {
				Help.print("You wake up\n");
				reRoom = 1;
				Help.print("We can hurt ourselves in this room.\n"
						+ "1) Hurt ourselves here\n"
						+ "2) Move to the healing room\n\n");
			}
		}
		//Awaken Room
		else if (room == 1) {
			if (choice == 1) {
				Help.print("We have hurt ourselves.\n");
				hp -= 1;
				Help.print(""
						+ "1) Hurt ourselves here\n"
						+ "2) Move to the healing room\n\n");
			}
			else if (choice == 2) {
				//leave to armory
				Help.print("We are going to the healing room.\n"
						+ "\n"
						+ ""
						+ "We are in the healing room.\n"
						+ "1) Go back to other Room\n"
						+ "2) Heal some more\n\n");
				reRoom = 2;
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
				hp += 1;
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
