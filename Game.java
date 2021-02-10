package thePath;


import java.util.*;

public class Game {
	private Help help;
		
	Game() {	
	}
	
	public int room(int room, int choice) {
		int reRoom = room;
		if (room == 0) {
			if (choice == 0)
				Help.print("You wake up. Congratulations.\n1) Make a light\n2) Do nothing.\n\n");
			if (choice == 1) {
				Help.print("You make a light.\n");
				reRoom = 1;
				room(1, 0);
			}
			else if (choice == 2) {
				Help.print("You do nothing. Silly goose.\n");
				Help.print("1) Make a light\n2) Do nothing.\n\n");
			}
		}
		else if (room == 1) {
			if (choice == 0) {
				Help.print("Now that you're up, it's time to weep.\n1) No thank you I'd like to wake up again\n2) By golly I will weep" +
			"\n3) I have chosen to proceed.\n4) I give up, end this madness.\n\n");
			}
			else if (choice == 1) {
				Help.print("You back to waking up.\n");
				reRoom = 0;
				room(0, 0);
			}
			else if (choice == 2) {
				Help.print("You weep very well.\n");
				Help.print("1) No thank you I'd like to wake up again\n2) By golly I will weep" +
						"\n3) I have chosen to proceed.\n4) I give up, end this madness.\n\n");
			}
			else if (choice == 3) {
				Help.print("I am leaving to the next room now.\n");
				reRoom = 3;
				room(2, 0);
			}
			else if (choice == 4) {
				Help.print("There is nothing more.");
				reRoom = 5;
			}
		}
		else if (room == 2) {
			Help.print("You are in the next room now. I am building it. Please exist for a while longer.\n");
		}
		
		return reRoom;
		
	}
}
