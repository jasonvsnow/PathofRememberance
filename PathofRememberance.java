import java.util.*;

/**
 * <h1>PathofRememberance</h1>
 * <p>This is, essentially, the main class. It initiates the game, calls nearly all the other classes at some point, and holds the bulk of code.</p>
 *<p>Created: 1/11/2021</P> 
 * @author Jason Snow
 */
public class PathofRememberance {
	/**
	 * This method is used to move through the game, starting the creation process and then holding the rooms loop.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		//introduction
		
		//print title array
		String[][] title = {
		{" _____      _   _              __   _____                               _                               "},
		{"|  __ \\    | | | |            / _| |  __ \\                             | |                             "},
		{"| |__) |_ _| |_| |__     ___ | |_  | |__) |___ _ __ ___   ___ _ __ ___ | |__  _ __ __ _ _ __   ___ ___ "},
		{"|  ___/ _` | __| '_ \\   / _ \\|  _| |  _  // _ \\ '_ ` _ \\ / _ \\ '_ ` _ \\| '_ \\| '__/ _` | '_ \\ / __/ _ \\"},
		{"| |  | (_| | |_| | | | | (_) | |   | | \\ \\  __/ | | | | |  __/ | | | | | |_) | | | (_| | | | | (_|  __/"},
		{"|_|   \\__,_|\\__|_| |_|  \\___/|_|   |_|  \\_\\___|_| |_| |_|\\___|_| |_| |_|_.__/|_|  \\__,_|_| |_|\\___\\___|"},
		};
		Printer.printArray(title);
		Printer.println("");
		Printer.println("");
		int choice = 0;
		Player hero = new Player();
		
		Printer.println("You come to conciousness and feel yourself lying upon something hard. You are surrounded by darkness, unable to see anything.");
		Printer.println("");
		boolean dark = true;
		while (dark == true) {
				Printer.println("1) Make a light(Mana -1)");
				Printer.println("2) Do nothing.");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You summon a power within and a small ball of light appears in your hand, illuminating the room.");
					hero.takeMana(1);
					Printer.println(hero.statString());
					Printer.println("");
					dark = false;
				}
				else if (choice == 2) {
					Printer.println("You lay there, doing nothing. It's unlikely this will get you anywhere.");
				}
				else Printer.println("Invalid Input. Try again.");
		}
		
		Printer.println("With the orb of light in your hand, you stand and are able to see the rest of the room clearly."
				+ " You were laying upon a slab of dark, reflective material, in which you see yourself.");
		boolean appearance = true;
		while (appearance) {
			boolean height = true;
			while (height) {
				Printer.println("You first see you are: ");
				Printer.println("1) Tall");
				Printer.println("2) Medium");
				Printer.println("3) Short");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				if (choice == 1) {
					hero.setHeight("tall");
					height = false;
				}
				else if (choice == 2) {
					hero.setHeight("medium");
					height = false;
				}
				else if (choice == 3) {
					hero.setHeight("short");
					height = false;
				}
				else {
					Printer.println("Invalid input. Try again.");
				}
			}
			boolean color = true;
			while (color) {
				Printer.println("You notice your skin is: ");
				Printer.println("1) Pale");
				Printer.println("2) Medium");
				Printer.println("3) Dark");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				if (choice == 1) {
					hero.setColor("pale");
					color = false;
				}
				else if (choice == 2) {
					hero.setColor("medium");
					color = false;
				}
				else if (choice == 3) {
					hero.setColor("dark");
					color = false;
				}
				else {
					Printer.println("Invalid input. Try again.");
				}
			}
			boolean haircolor = true;
			while (haircolor) {
				Printer.println("You then look at your hair which is: ");
				Printer.println("1) Red");
				Printer.println("2) Brown");
				Printer.println("3) Blonde");
				Printer.println("4) Black");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				if (choice == 1) {
					hero.setHairColor("red");
					haircolor = false;
				}
				else if (choice == 2) {
					hero.setHairColor("brown");
					haircolor = false;
				}
				else if (choice == 3) {
					hero.setHairColor("blonde");
					haircolor = false;
				}
				else if (choice == 4) {
					hero.setHairColor("black");
					haircolor = false;
				}
				else {
					Printer.println("Invalid input. Try again.");
				}
			}
			boolean hairheight = true;
			while (hairheight) {
				Printer.println("You hair is: ");
				Printer.println("1) short");
				Printer.println("2) long");
				Printer.println("3) I have none");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				if (choice == 1) {
					hero.setHairLength("short");
					hairheight = false;
				}
				else if (choice == 2) {
					hero.setHairLength("long");
					hairheight = false;
				}
				else if (choice == 3) {
					hero.setHairLength("no");
					hero.setHairColor("");
					hairheight = false;
				}
				else {
					Printer.println("Invalid input. Try again.");
				}
			}
			boolean clothe = true;
			while (clothe) {
				Printer.println("You are weaing: ");
				Printer.println("1) A simple dress");
				Printer.println("2) A plain shirt and pants");
				Printer.println("3) A uniform");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				if (choice == 1) {
					hero.setClothes("a simple dress");
					Printer.println(" and a cloak.");
					clothe = false;
				}
				else if (choice == 2) {
					hero.setClothes("a plain shirt and pants");
					Printer.println(" and a cloak.");
					clothe = false;
				}
				else if (choice == 3) {
					hero.setClothes("a uniform");
					Printer.println(" and a cloak.");
					clothe = false;
				}
				else {
					Printer.println("Invalid input. Try again.");
				}
			}
			Printer.println("So, you are " + hero.toString() + " Correct?");
			Printer.println("1) No, I want to change something.");
			Printer.println("2) Yes, that is who I am.");
			Printer.print("> ");
			try {
				choice = input.nextInt();
				Printer.println("");
			}
			catch (InputMismatchException ex) {
				Printer.println("");
				input.nextLine();
			}
			if (choice == 1) Printer.println("");
			else if (choice == 2) appearance = false;
			else Printer.println("Invalid Input.Try again.");
		}
				
		Printer.println("Done inspecting yourself, you turn back to the room which is little more than four walls, floor, and roof all stone."
				+ "There is a wooden table against one wall and upon it are several items. "
				+ "There is a door as well. You cannot remember anything... perhaps the answers are elsewhere.");
		Printer.println("");
		boolean room1 = true;
		boolean key1 = false;
		while (room1 == true) {
			try {
				Printer.println("1) Investigate the table.");
				Printer.println("2) Leave through northern, wooden door.");
				Printer.println("3) Inspect yourself in the slab again.");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				} 
				Printer.println("");
				if (choice == 1) {
					if (key1 == false) {
						Printer.println("You find upon the table a dagger, a key, a map and a page that seems ripped from a book. You take the key, dagger, and map.");
						mapPrinter();
						Printer.println("");
					}
					else Printer.println("You return to the table and find the page upon the table still.");
					boolean invest = true;
					while (invest == true) {
						Printer.println("1) Read the page.");
						Printer.println("2) Leave the table.");
						Printer.print("> ");
						try {
							choice = input.nextInt();
						}
						catch (InputMismatchException ex) {
							Printer.println("");
							input.nextLine();
						} 
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take the pages and begin to read: ");
							Printer.println("\"It presses upon us presently, as constant as ever. We shall not escape this, but all hope is not lost. We place our faith in our greatest warrior to deliever us from this.\"");
							Printer.println("The rest of the page has been smeared and torn, rendering it illegiable.");
						}
						else if (choice == 2) {
							invest = false;
						}
						else Printer.println("Invalid Input. Try again.");
					}
					key1 = true;
				}
				else if (choice == 2) {
					if (key1 == true) room1 = false;
					else Printer.println("You attempt to leave through the door but find the handle will not budge: the door is locked.");
				}
				else if (choice == 3) {
					Printer.println("You look at the reflective slab once more and see yourself: " + hero.toString());
				}
				else Printer.println("Invalid Input. Try again!");
			}
			catch (InputMismatchException ex) {
				Printer.println("Invalid input, enter an integer (1, 2, etc)");
				input.nextLine();
			}
		}
		choice = 0;
		Printer.println("Using the key you found upon the table, you unlock the door and swing it open with a rusty creak. Beyond there is a stone tunnel similar to the room you just came from. As you enter it, you see something move in the darkness." );
		Printer.println("");

		Enemy first = new Enemy();
		createEnemy(first, 1);
		combat(hero, first);
		Printer.println("Damage: " + hero.getDMG());
		
		if (hero.getHP() > 0) Printer.println("With the whisp dealt with, you are able to proceed forward and find yourself in another room."); 
		Printer.println("");
		hero.setRoom(2);
		int room = 2;
		boolean playing = true;
		while (playing == true) {
			while (room != 15 && hero.getHP() > 0) {
				room = rooms(room, hero);
				
			}
			if (hero.getHP() > 0 && room == 15) {
				Printer.println("To be continued...");
				System.out.printf("");
				playing = false;
				Printer.println(hero.statString());
			}
			else if (hero.getHP() <= 0) {
				Printer.println("You have fallen...");
				Printer.println("1) Rise again.");
				Printer.println("2) Give in to the darkness.");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				} 
				Printer.println("");
				if (choice == 1) {
					Printer.println("Opening your eyes, you find a simple wooden door before you. You push it open and step out, ready to try again.");
					hero.setHP(35);
					hero.setDMG(5);
					hero.setMana(10);
					hero.setShield(0);
					hero.setCoins(hero.getCoins()/2);
					hero.setPotions(hero.getPotions()/2);
					hero.setDefendCharge(0);
					hero.setCaptainChamberKey(false);
					room = 2;
					playing = true;
				}
				else if (choice == 2) {
					Printer.println("You exhale one final time and close your eyes, letting the darkness take you.");
					playing = false;
					Printer.println("");
					Printer.println("Thank you for playing.");
				}
				else Printer.println("Invalid choce. Try again.");
			}
		}
	}
	/**
	 * This method represented the are a player could explore and would take the player object and a room number. It would run that player through that room and return a number based on what the player chose. That nummber would lead to a new room.
	 * <pre>Eaxample:
	 * {@code rooms(2, hero) might return 3, 4, or 1 as those are the three rooms you can access from room 2
	 * }</pre>
	 * @param room (int; the room the method will run the player through)
	 * @param hero (object; the player object that holds the player data)
	 * @return room (int; the next room to run the player through)
	 * @throws InterruptedException (allows the Printer class to function)
	 */
	public static int rooms(int room, Player hero) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		if (room == 1) {
			Printer.println("You once again enter the room where you awoke, just as you left it.");
		
			Enemy awaken = new Enemy();
			createEnemy(awaken, 1);
			combat(hero, awaken);
			
			boolean room1 = true;
			while (room1 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate Table");
				Printer.println("2) Leave through north door(Armory)");
				Printer.println("3) Inspect yourself in the slab again.");
				Printer.println("4) Look at Map");
				if (hero.getPotions() > 0) Printer.println("5) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You return to the table and find the page upon the table still.");
					boolean invest = true;
					while (invest == true) {
						Printer.println("1) Read the page.");
						Printer.println("2) Leave the table.");
						Printer.print("> ");
						try {
							choice = input.nextInt();
						}
						catch (InputMismatchException ex) {
							Printer.println("");
							input.nextLine();
						}
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take the pages and begin to read: ");
							Printer.println("\"It presses upon us presently, as constant as ever. We shall not escape this, but all hope is not lost. We place our faith in our greatest warrior to deliever us from this.\"");
							Printer.println("The rest of the page has been smeared and torn, rendering it illegiable.");
						}
						else if (choice == 2) {
							invest = false;
						}
						else Printer.println("Invalid Input. Try again.");	
					}
				}
				else if (choice == 2) {
					Printer.println("You leave through the north door, making your way through the hallway back to the armory.");
					room = 2;
					room1 = false;
				}
				else if (choice == 4) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 5) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else if (choice == 3) {
					Printer.println("You look at the reflective slab once more and see yourself: " + hero.toString());
				}
				else Printer.println("Invalid Input. Try again.");
			}
			
		}
		else if (room == 2) {
			Printer.println("You enter an armory. Weapons rest upon racks, a table sits in the center with a few plates and cups upon it, and several chairs are about the table. There is a door to the east, a door to the west, and a door to the south. You seem to know where all the doors lead.");
			boolean room2 = true;
			while (room2 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the weapons");
				Printer.println("2) Leave through east door(East Barracks)");
				Printer.println("3) Leave through south door(Awakening)");
				Printer.println("4) Leave through west door(West Barracks)");
				Printer.println("5) Look at Map");
				if (hero.getPotions() > 0) Printer.println("6) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					int test = hero.getDMG();
					if (test == 5) {
						boolean weapons = true;
						while (weapons) {
							Printer.println("You see three weapons before you: ");
							Printer.println("1) A sword and shield");
							Printer.println("2) A battleaxe");
							Printer.println("3) A staff");
							Printer.println("4) Take nothing, you're good with what you have.");
							Printer.println("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							}
							Printer.print("> ");
							if (choice == 1) {
								Printer.println("You take the sword and shield, good for defense and offense both.");
								hero.setShield(2);
								hero.setDMG(8);
								if (hero.getMana() > 10) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 2) {
								Printer.println("You take the battleaxe, lacking in defense but great for desctruction.");
								hero.setShield(0);
								hero.setDMG(12);
								if (hero.getMana() > 10) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 3) {
								Printer.println("You take the staff, subpar for fighitng but great for magic.");
								hero.setShield(0);
								hero.setDMG(4);
								hero.setMana(hero.getMana()*2);
								weapons = false;
							}
							else if (choice == 4) {
								Printer.println("You take nothing.");
								weapons = false;
							}
							else Printer.println("Invalid input. Try again.");
						}
					}
					else if (test == 8) {
						boolean weapons = true;
						while (weapons) {
							Printer.println("You see two weapons before you: ");
							Printer.println("1) A battleaxe");
							Printer.println("2) A staff");
							Printer.println("3) Take nothing, you're good with what you have.");
							Printer.println("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							}
							Printer.print("> ");
							if (choice == 1) {
								Printer.println("You take the battleaxe, lacking in defense but great for desctruction.");
								hero.setShield(0);
								hero.setDMG(12);
								if (hero.getMana() > 10) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 2) {
								Printer.println("You take the staff, subpar for fighitng but great for magic.");
								hero.setShield(0);
								hero.setDMG(4);
								hero.setMana(hero.getMana()*2);
								weapons = false;
							}
							else if (choice == 3) {
								Printer.println("You take nothing.");
								weapons = false;
							}
							else Printer.println("Invalid input. Try again.");
						}
					}
					else if (test == 12) {
						boolean weapons = true;
						while (weapons) {
							Printer.println("You see two weapons before you: ");
							Printer.println("1) A sword and shield");
							Printer.println("2) A staff");
							Printer.println("3) Take nothing, you're good with what you have.");
							Printer.println("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							}
							Printer.print("> ");
							if (choice == 1) {
								Printer.println("You take the sword and shield, good for defense and offense both.");
								hero.setShield(2);
								hero.setDMG(8);
								if (hero.getMana() > 20) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 2) {
								Printer.println("You take the staff, subpar for fighitng but great for magic.");
								hero.setShield(0);
								hero.setDMG(4);
								hero.setMana(hero.getMana()*2);
								weapons = false;
							}
							else if (choice == 3) {
								Printer.println("You take nothing.");
								weapons = false;
							}
							else Printer.println("Invalid input. Try again.");
						}
					}
					else if (test == 4) {
						boolean weapons = true;
						while (weapons) {
							Printer.println("You see three weapons before you: ");
							Printer.println("1) A sword and shield");
							Printer.println("2) A battleaxe");
							Printer.println("3) Take nothing, you're good with what you have.");
							Printer.println("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							}
							Printer.print("> ");
							if (choice == 1) {
								Printer.println("You take the sword and shield, good for defense and offense both.");
								hero.setShield(2);
								hero.setDMG(8);
								if (hero.getMana() > 10) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 2) {
								Printer.println("You take the battleaxe, lacking in defense but great for desctruction.");
								hero.setShield(0);
								hero.setDMG(12);
								if (hero.getMana() > 10) hero.setMana(10);
								weapons = false;
							}
							else if (choice == 3) {
								Printer.println("You take nothing.");
								weapons = false;
							}
							else Printer.println("Invalid input. Try ahain.");
						}
					}
					else if (test == 25) {
						Printer.println("The sun blade you hold is far more powerful than any of the weapons here, you have no need for them.");
					}
					else Printer.println("jason you broke it");
				}
				else if (choice == 2) {
					Printer.println("You exit via the eastern door into what you know is the East Barracks.");
					room = 3;
					room2 = false;
				}
				else if (choice == 3) {
					Printer.println("You exit the armory, returning back down the stone hallway that leads to the room your awoke in.");
					room = 1;
					room2 = false;
				}
				else if (choice == 4) {
					
					if (hero.isWesternBarracksKey()) {
						Printer.println("You exit via the western door into what you know is the western Barracks.");
						room = 4;
						room2 = false;
					}
					else Printer.println("You attempt to leave through the western door but find it locked. You will need a key.");
				}
				else if (choice == 5) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 6) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");
			}
		}
		else if (room == 3) {
			Printer.println("You enter the East Barracks. There are four doors leading out of this room, one in each direction. The one to the north doesn't seem to stick in your memory as the others here have, as if it does not belong. Bunks fill the room in rows, two sets of bunks two high with a dresser between them, each dresser holding four drawers. The beds are in disarray, there are clothes handing out of unclosed drawers. There are even some stray items upon beds, left out as if people had simply forgotten them.");
			Enemy awaken = new Enemy();
			int pop = (int)(Math.random()*2+1);
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room3 = true;
			while (room3 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the room");
				Printer.println("2) Leave through north door(???)");
				Printer.println("3) Leave through east door(Training Room)");
				Printer.println("4) Leave through south door(East Storage)");
				Printer.println("5) Leave through west door(Armory)");
				Printer.println("6) Look at Map");
				if (hero.getPotions() > 0) Printer.println("7) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You rummage through the drawers and beds. You find a few usless items- playing cards, pictues of people you do not reocognize, a pair of glasses- but you also find a diary. The ink is smeared but you find yourself able to read some of the pages.");
					Printer.println("\"I am restless. Many of the men are. This talk of peace, it is a foolish hope that is sure to turn into sour ash in our mouths. The High Ones are blind to this danger and it will be their undoing.\"");
				}
				else if (choice == 2) {
					Printer.println("You approach the mysterious door and push it open, entering the room beyond.");
					room = 10;
					room3 = false;
				}
				else if (choice == 3) {
					Printer.println("You leave through the eastern door, walking down a hallway before entering the Training Room.");
					room = 9;
					room3 = false;
				}
				else if (choice == 4) {
					Printer.println("You open the southern door, stepping into the East Storage Room.");
					room = 5;
					room3 = false;
				}
				else if (choice == 5) {
					Printer.println("You exit through the western door, entering the Armory once again.");
					room = 2;
					room3 = false;
				}
				else if (choice == 6) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 7) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");
			}
		}
		else if (room == 4) {
			Printer.println("You enter the West Barracks. The bunks in this room are lined against the wall, the dressesers between them and in corners. The sheets are neat, the drawers closed, the room orderly. Three doors lead out of this room, one each direction except west. Two things strike you about this room: the first that you recognize the one bunk as your own and the corresponding drawer. The second is that the room is full of light, a dark red glow that comes from a window in the western wall.");
			boolean room4 = true;
			while (room4 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the window");
				Printer.println("2) Investigate your area");
				Printer.println("3) Leave through north door(Messhall)");
				Printer.println("4) Leave through east door(Armory)");
				Printer.println("5) Leave through south door(West Storage)");
				Printer.println("6) Look at Map");
				if (hero.getPotions() > 0) Printer.println("7) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You approach the window, looking out to find a red tinted world. In the distance, tall mountains loom, the red sky blazing behind them. Black clouds blot out much of the sky, yet the red glow manages to permeate everything despite. A forest of dead trees stretches out from the mountains to a stone wall that surrounds the building you look out of. You find you are also upon an upper floor, as looking down reveals the ground some distance away, all dirt with thousands of tracks criss crossing it. You notice dark eyes peer from the shadows up at you, though as soon as you look to them directly they vanish.");
					Printer.println("After some time, you realize there is nothing more to be seen outside the window. As you step away, you notice the paper atop the drawer beneath the window. It is neatly arranged in the center and you pick it up to read it.");
					Printer.println("\"The enemy has arrived in great number, men and woman alike, even their wretched offspring. I grow more uneasy with each passing moment. Something is bound to happen, it is only a matter of time.\"");
				}
				else if (choice == 3) {
					Printer.	println("Opening the northern door, you find a set of stairs leading downwards into more darkness. You leave behind the red light of the Western Barracks to carefully descend the steps and enter the Mess Hall.");
					room = 7;
					room4 = false;
				}
				else if (choice == 4) {
					Printer.println("You exit through the eastern door, entering the Armory once again.");
					room = 2;
					room4 = false;
				}
				else if (choice == 5) {
					Printer.println("You open the southern door, stepping into the West Storage Room.");
					room = 6;
					room4 = false;
				}
				else if (choice == 2) {
					Printer.println("You go to your bunk and look it over. The sheets and blankets bear no wrinkle, the pillow has no impression. Checking the drawer, you find it completely empty.");
					boolean invest = true;
					while (invest == true) {
						Printer.println("1) Rest");
						Printer.println("2) Leave");
						Printer.print("> ");
						try {
							choice = input.nextInt();
						}
						catch (InputMismatchException ex) {
							Printer.println("");
							input.nextLine();
						}
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take a moment to lay upon your bed, resting your eyes. A sense of peace temporarily overcomes you and you open your eyes feeling refreshed. You rise, reignite your light, and smooth your bed once again completely out of habit.");
							if (hero.getDMG() == 4 || hero.getDMG() == 25) hero.setMana(20);
							else hero.setMana(10);
							Printer.println("Mana: "  + hero.getMana());
							Printer.println("");
						}
						else if (choice == 2) {
							Printer.println("");
							invest = false;
						}
						else Printer.println("Invalid Input. Try again.");
					}
					
				}
				else if (choice == 6) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 7) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");	
		}
	}
		//room 5 east storage
		else if (room == 5) {
			Printer.println("Stepping into the East Storage room, you find a great disarray. Everything once stored here is flung about, the palace ransacked. Racks thrown down, chests burst open, contents strewn about. Cloaks and uniforms are tossed about, which you recognize as the uniforms the husks wear. There is a number of flasks spilled, their contents long ago staining the ground, there are boots, weapons, broken weapons, personal effects, books, and even some rope. ");
			Enemy awaken = new Enemy();
			int pop = 1;
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room5 = true;
			while (room5 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate");
				Printer.println("2) Leave through the north door(East Barracks)");
				Printer.println("3) Look at Map");
				if (hero.getPotions() > 0) Printer.println("4) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					if (hero.isWesternBarracksKey()) {
						Printer.println("You poke about the area, pushing aside the junk in a search for something useful. After some time, you find a key buried in the mess. You pocket it for later.");
						Printer.println("You also find a letter buried in the junk which reads: ");
						Printer.println("\"My Love,");
						Printer.println("\"\tSince last I wrote, things have worsened. The men are ever restless of this alliance, I fear many shall not support it. The Outhi have been nothing but pleasant, they have made every sacrifice, and still they meet hostility. As their captain I feel a duty to ease their worries but all my attempts have been for naught. I only pray nothing goes awry before the pact is signed. The men will see then, they will know their folly.");
						Printer.println("\"\tSincerely,");
						Printer.println("\"\tWilhem.\"");
						Printer.println("There is nothing else to be found here.");
						hero.setWesternBarracksKey(true);
					}
					else {
						Printer.print("You rummage through the previously searched area and only find a ");
						int funny = (int)(Math.random() * 5) +1;
						if (funny == 1) {
							Printer.println(" very large dust bunny.");
						}
						else if (funny == 2) {
							Printer.println(" pair of scissors with blood upon them.");
						}
						else if (funny == 3) {
							Printer.println(" piece of paper with gibberish written upon it.");
						}
						else if (funny == 4) {
							Printer.println(" small stuffed dog missing its tail and left eye.");
						}
						else if (funny == 5) {
							Printer.println(" portion of a stained glass window.");
						}
						Printer.println("You also find the letter from before: ");
						Printer.println("\"My Love,");
						Printer.println("\"\tSince last I wrote, things have worsened. The men are ever restless of this alliance, I fear many shall not support it. The Outhi have been nothing but pleasant, they have made every sacrifice, and still they meet hostility. As their captain I feel a duty to ease their worries but all my attempts have been for naught. I only pray nothing goes awry before the pact is signed. The men will see then, they will know their folly.");
						Printer.println("\tBe safe dear Olivia.");
						Printer.println("\"\tSincerely,");
						Printer.println("\"\t Wilhem.\"");
					}
				}   
				else if (choice == 2) {
					Printer.println("You exit via the northern door into what you know is the East Barracks.");
					room = 3;
					room5 = false;
				}
				else if (choice == 3) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 4) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");
			}
		}
		//room 6 west storage
		else if (room == 6) {
			Printer.println("Stepping into the West Storage room, you find many crates and barrels, clearly a storage for more extended periods of time. One barrle has it's bottom shattered, potatoes spilling out over the floor. A trail of these potatoes leads further into the room, between two large crates.");
			Enemy awaken = new Enemy();
			int pop = 1;
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room6 = true;
			while (room6 == true && hero.getHP() > 0) {
				Printer.println("1) Follow the trail of potatoes.");
				Printer.println("2) Leave through the north door(West Barracks)");
				Printer.println("3) Look at Map");
				if (hero.getPotions() > 0) Printer.println("4) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					boolean squid = true;
					if (hero.getSquid() == 0) {
						Printer.println("You follow the trail of potatoes and as you approach the crates hear a faint crunching noise. Reading your weapon, you spring around the corner of the crate!");
						Printer.println("There is a yelp from the creature you have surprised. You see something small, no taller than 3 feet, with pink skin and tattered clothes with face that has no nose nor mouth, instead tentacles hang off the thing's face from beneath its massive, pure black eyes. It holds a potato to its chest with a three fingered, clawed hand, shivering.");
					}
					else if (hero.getSquid() == 1) {
						Printer.println("You follow the trail once more to the place where you slew the wretch. It's body lays crumbled upon the ground, black eyes staring lifeless into the distance.");
						squid = false;
					}
					else if (hero.getSquid() == 2) {
						Printer.println("You follow the trail of potatoes to find the little squid creature sitting there, munching upon a potatoe with your cloak upon it. It gurgles happily upon seeing you and offers you a potato. You take some time to sit and enjoy a potatoe with the little thing. After you finish your small meal, you rise and bid the creature farewell, for now.");
						if (hero.getHP() > 15) hero.setHP(25);
						Printer.println("HP: " + hero.getHP());
						Printer.println("");
						squid = false;
					}
					else if (hero.getSquid() == 3) {
						Printer.println("You follow the trail of potatoes once more and find the shivering creature huddled back in its little crevice, watching your every move.");
					}
					while (squid == true) {
						Printer.println("1) Kill the wretch");
						Printer.println("2) Offer the shivering thing your cloak");
						Printer.println("3) Leave it");
						Printer.print("> ");
						try {
							choice = input.nextInt();
						}
						catch (InputMismatchException ex) {
							Printer.println("");
							input.nextLine();
						} 
						Printer.println("");
						if (choice == 1) {
							Printer.println("With one sure swipe, you cleave the creature's head off- cutting off its terrified whine- letting it crumble to the ground, dead.");
							hero.setSquid(1);
							squid = false;
						}
						else if (choice == 2) {
							Printer.println("You take your cloak off and offer it to the creature. It is, at first, hesitant but when you show no intention to harm it, it quickly snatches the cloak and wraps it about itself, looking up at you with a new curiosity. As its shiverings subside, the little thing picks up a potato and offers it to you. Deciding it would be rude to refuse, you accept the potato. The two of you sit together and enjoy your meal for a time. Once you are done, you rise and bid the creature farewell, for now.");
							if (hero.getHP() > 15) hero.setHP(20);
							Printer.println("HP: " + hero.getHP());
							Printer.println("");
							hero.setSquid(2);
							squid = false;
						}
						else if (choice == 3) {
							Printer.println("You look the pink thing over before turning away, leaving it where it shivers.");
							hero.setSquid(4);
							squid = false;
						}
						else Printer.println("Invalid Input, try again.");
					}
				}
				else if (choice == 2) {
					Printer.println("You exit via the northern door into what you know is the West Barracks.");
					room = 4;
					room6 = false;
				}
				else if (choice == 3) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 4) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input try again.");
			}
		}
		//room 7 messhall
		else if (room == 7) {
			Printer.println("You Descend the long set of stairs into the mess hall where some conflict seems to have ensued. Benches and tables are flipped over, arrows sticking out of nearly every surface, telling red stains litter the area. Old food rots upon the ground, discarded, unremebered. There are two doors, one to the south that leads up to the West Barracks and another that leads east to the Main Hall.");
			Enemy awaken = new Enemy();
			int pop = (int)(Math.random()*2+1);
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room7 = true;
			while (room7 == true && hero.getHP() > 0) {
				Printer.println("Investigate the room.");
				Printer.println("2) Leave through east doorway(Great Hall)");
				Printer.println("3) Leave through south doorway(West Barracks)");
				Printer.println("4) Look at Map");
				if (hero.getPotions() > 0) Printer.println("5) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You rummage through the mess looking for something useful, though the only thing seems to be a torn letter that reads: ");
					Printer.println("The strangers arrived today. They look wrong, their faces hang in many strands. We have decided the leaders cannot be trusted. It shall happen tonight.");
				}
				else if (choice == 2) {
					Printer.println("You exit via the east door, entering the Great Hall.");
					room = 8;
					room7 = false;
				}
				else if (choice == 3) {
					Printer.println("You go through the south door, ascending the set of stairs up to the West Barracks.");
					room = 4;
					room7 = false;
				}
				else if (choice == 4) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 5) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input try again.");
			}
		}
		//room 8 great hall
		else if (room == 8) {
			Printer.println("You enter the great hall. The ceiling is far above here, a godo two stories high and curved. Faded art adorns the ceiling, which many pillars along the side of the room hold up. Great stained glass windows allow the red light from outside to filter in as many shades. Reds, blues, and greens splash across the floor, illumuninating a large symbol in the middle with a covered lump upon it. There is only one door out, back towards the messhall, all the others boarded up and blockaded.");
			Enemy awaken = new Enemy();
			int pop = 3;
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room8 = true;
			while (room8 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the ceiling.");
				Printer.println("2) Investigate the symbol.");
				Printer.println("3) Leave through west doorway(Messhall)");
				Printer.println("4) Look at Map");
				if (hero.getPotions() > 0) Printer.println("5) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("As you look up to the ceiling to study it, you see it depicts a great war. There are men fighting a tendril faced race of great power. The tendril faced beings arrived in the world of men, taking land and things, thus conflict ensued. It rages across the ceiling from the north towards the south, though on the southern end, the ceiling is nearly bare. Only the beginnings of the work has begun and while it is hard to make out what it will become, you can understand there is not a battle depicted here as with so many of the other scenes. It is the end.");
				}
				else if (choice == 3) {
					Printer.println("You leave through the west door towards Messhall.");
					room = 7;
					room8 = false;
				}
				else if (choice == 2) {
					Printer.println("As you approach the symbol and the lump, covered by a brown sheet, you realize the symbol is painted in the dark stains you found in the Messhall. It twists and bends, curves, and forms a circle with the lump in the center of it. Tugging the sheet off the lump, you find a body. It is bound by wrists and ankles to the ground, its chest and stomach split. This is not the body of a man. The skin is too pink, the eyes are massive, round, and pure black. There is no mouth or nose, instead a set of tendrils are limp down across its neck, almost looking like a very odd beard. It's hands and feet bear only three digits each and despite the age of the corpse, having been here some time, it has not decayed nor been picked into. Beneath it, a pool of shadow ripples constantly.");
					if (hero.getDMG() == 25) {
						Printer.println("As you stand there, the light blade tugs upon your hand, jerking towards the pool.");
						boolean pool = true;
						while (pool == true) {
							Printer.println("1) Plunge the light blade into the pool");
							Printer.println("2) Cover the body and leave.");
							Printer.print("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							}
							Printer.println("");
							if (choice == 1) {
								Printer.println("You raise your burning blade of light high and slam it down into the pool before you. A great howling fills the air as the wind kicks up, blowing your hair, buffeting you from all sides. The stained glass windows shatter and the shards are swept up in the gale, slashing across your body, leaving cuts across every inch of your skin. You stagger back, losing grip of the light blade, letting it sink into the pool of darkness which begins to glow, becoming brighter with light by the second.");
								Printer.println("You're suddenly thrown off your feet by a powerful blast of wind. You tumble across the floor, your back slamming against a pillar, pain shooting up through your body. You cry out, your vision becoming fuzzy, having trouble seeing shapes. The only thing you can clearly see is the pool of darkness has become a brilliant pool of light which begins to expand, slowly at first and quickly gaining speed.");
								Printer.println("You cry out as a wave of light and glass sweeps towards you, enveloping you entirely.");
								Printer.println("");
								Printer.println("");
								Printer.println("");
								Printer.reallyprintln("");
								hero.setHP(1);
								Printer.reallyprintln("");
								room = 15;
								pool = false;
								room8 = false;
							}
							else if (choice == 2) {
								Printer.println("A stillness follows, nothing moving. You pull the sheet back over the body.");
								pool = false;
							}
							else Printer.println("Invalid Input. Try again.");
						}
					}
				}
				else if (choice == 4) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 5) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input try again.");
			}
		}
		//room 9 training room
		else if (room == 9) {
			Printer.println("Stepping into the training room, you find a sandy pit with wooden dummies scattered around, some up on stands and others set aside for later, in various states of damage. Sparring weapons lay about the area. There are seats lining the walls of the area.");
			Enemy awaken = new Enemy();
			int pop = 2;
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room9 = true;
			while (room9 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the room");
				Printer.println("2) Leave through north doorway(Hallway)");
				Printer.println("3) Leave through west door (East barracks)");
				Printer.println("4) Look at Map");
				if (hero.getPotions() > 0) Printer.println("5) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 1) {
					Printer.println("You search about the room but find only a small paper sticking up in the sand.");
					Printer.println("\"We do it tonight. The enemy shall not deceive us any longer. Meet in the great hall.");
					Printer.println("\"-X\"");
				}
				else if (choice == 2) {
					Printer.println("You move into the hallway that leads away from the training room.");
					room = 11;
					room9 = false;
				}
				else if (choice == 3) {
					Printer.println("You leave through the east door towards the east barracks.");
					room = 3;
					room9 = false;
				}
				else if (choice == 4) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 5) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input try again.");
			}
		}
		
		//room 10 shop (edit for coins)
		else if (room == 10) {
			Printer.println("As you enter the mysterious room, you find it lit by torches set upon the walls. A large, ornate carpet covers the ground upon which there is a wooden desk. Sitting at the desk is a hooded figure, the only visible feature a hooked nose poking out from beneath the hood along with long, stringy black hair. The figure motions with a boney hand at a chair that has suddenly appeared before the desk. You take a seat and the hooded figure rasps, \"I have some wares for you. Interested?\"");
			Printer.println("Coins: " + hero.getCoins());
			Printer.println("");
			boolean room10 = true;
			while (room10 == true && hero.getHP() > 0) {
				Printer.println("1) Shop");
				Printer.println("2) Leave");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				}
				Printer.println("");
				if (choice == 2) {
					Printer.println("You shake your head and stand, push your chair in, and bid the figure farewell. You walk back out the door into the East Barracks once more.");
					room10 = false;
					room = 3;
				}
				else if (choice == 1) {
					if (!(hero.isCaptainChamberKey())) {
						Printer.println("You nod and the figure sets out a glass bottle full of red liquid and a key.");
						Printer.println("Coins: " + hero.getCoins());
						Printer.println("");
					}
					else Printer.println("The figure sets out the potion again to be displayed.");
					boolean shopping = true;
					while (shopping == true) {
						Printer.println("1) Buy potion(-2 coins each)");
						if (!(hero.isCaptainChamberKey())) {
							Printer.println("2) Buy the Key(-10 coins)");
							Printer.println("3) Leave");
						}
						else Printer.println("2) Leave");
						Printer.print("> ");
						try {
							choice = input.nextInt();
						}
						catch (InputMismatchException ex) {
							Printer.println("");
							input.nextLine();
						} 
						Printer.println("");
						if (!(hero.isCaptainChamberKey())) {
							if (choice == 1) {
								Printer.println("You point to the potion and the figure asks how many you'd like.");
								boolean potion = true;
								while (potion == true) {
									Printer.println("Coins: " + hero.getCoins());
									Printer.println("");
									Printer.println("How many potions would you like to buy?(Enter a number, enter 0 to exit)");
									Printer.print("> ");
									int amount = 0;
									try {
										amount = input.nextInt();
									}
									catch (InputMismatchException ex) {
										Printer.println("");
										input.nextLine();
									} 
									Printer.println("");
									if (hero.getCoins() >= (amount*2) && amount > 0) {
										if (amount == 1) {
											Printer.println("You ask for one potion, sliding over the two coins. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - (amount*2));
											hero.addPotions(amount);

										}
										else {
											Printer.println("You ask for " + amount + " potions, sliding over " + (amount*2) + " coins. The figure then hands you the potions.");
											hero.setCoins(hero.getCoins() - (amount*2));
											hero.addPotions(amount);
										}
									}
									else if (hero.getCoins() < (amount*2) && amount > 0) {
										Printer.println("You do not have enough essence to buy this many potions.");
									}
									else if (amount == 0) {
										Printer.println("You decide you need no more potions.");
										potion = false;
									}
									else Printer.println("Invalid amount, try again.");
								}
							}
							else if (choice == 2) {
								if (hero.getCoins() >= 10) {
									Printer.println("You point to the key and hand over the ten coins. The figure then hands you the key.");
									hero.setCaptainChamberKey(true);
									hero.setCoins(hero.getCoins() - 10);
									Printer.println("Coins: " + hero.getCoins());
									Printer.println("");
								}
								else Printer.println("You point to the key but the figure shakes his head. You do not have enough to buy this.");
							}
							else if (choice == 3) {
								Printer.println("You stand, pushing your chair in, and bid the figure farewell. You walk back out the door into the East Barracks once more.");
								room10 = false;
								shopping = false;
								room = 3;
							}
							else Printer.println("Invalid choce. Try again.");
						}
						else {
							if (choice == 1) {
								Printer.println("You point to the potion and the figure asks how many you'd like.");
								boolean potion = true;
								while (potion == true) {
									Printer.println("Coins: " + hero.getCoins());
									Printer.println("");
									Printer.println("How many potions would you like to buy?(Enter a number, enter 0 to exit)");
									Printer.print("> ");
									int amount = 0;
									try {
										amount = input.nextInt();
									}
									catch (InputMismatchException ex) {
										Printer.println("");
										input.nextLine();
									}
									Printer.println("");
									if (hero.getCoins() >= (amount*2) && amount > 0) {
										if (amount == 1) {
											Printer.println("You ask for one potion, sliding over the two coins. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - (amount*2));
											hero.addPotions(amount);
										}
										else {
											Printer.println("You ask for " + amount + " potions, sliding over " + (amount*2) + " coins. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - (amount*2));
											hero.addPotions(amount);
										}
									}
									else if (hero.getCoins() < (amount*2) && amount > 0) {
										Printer.println("You do not have enough essence to buy this many potions.");
									}
									else if (amount == 0) {
										Printer.println("You decide you need no more potions.");
										potion = false;
									}
									else Printer.println("Invalid amount, try again.");
								}
							}
							else if (choice == 2) {
								Printer.println("You stand, pushing your chair in, and bid the figure farewell. You walk back out the door into the East Barracks once more.");
								room10 = false;
								shopping = false;
								room = 3;
							}
							else Printer.println("Invalid Input. Try again.");
						}
					}
				}
				else Printer.println("Invalid Input try again.");
			}
		}
		//room 11 minor hallway
		else if (room == 11) {
			Printer.println("You enter a hallway, much like the one leading away from the Awakening room but longer and curving The walls are bare, the floor featureless.");
			Enemy awaken = new Enemy();
			int pop = 1;
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room11 = true;
			while (room11 == true && hero.getHP() > 0) {
				Printer.println("1) Leave through east door(Captains Chamber's)");
				Printer.println("2) Leave through south door(Training Room)");
				Printer.println("3) Look at Map");
				if (hero.getPotions() > 0) Printer.println("4) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				} 
				Printer.println("");
				if (choice == 1) {
					if (hero.isCaptainChamberKey()) {
						Printer.println("You enter the Captains's Chambers.");
						room = 12;
						room11 = false;
					}
					else Printer.println("You attempt to enter the Captain's Chambers but find the door locked. You will need a key.");
				}
				else if (choice == 2) {
					Printer.println("You move into the Training Room.");
					room = 9;
					room11 = false;
				}
				else if (choice == 3) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 4) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");
			}
		}
		//room 12 Captains Chamber
		else if (room == 12) {
			Printer.println("You enter the Captain's Chamber. The room is sparse, only a single desk with a chair behind it, cleared. A thick red carpet covers the floor and an empty bookshelf is tucked into the corner.");
			Enemy awaken = new Enemy();
			int pop = (int)(Math.random()*3+1);
			createEnemy(awaken, pop);
			combat(hero, awaken);
			boolean room12 = true;
			while (room12 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate");
				Printer.println("2) Leave through west door(Minor Hallway)");
				Printer.println("3) Look at Map");
				if (hero.getPotions() > 0) Printer.println("4) Drink a potion");
				Printer.print("> ");
				try {
					choice = input.nextInt();
				}
				catch (InputMismatchException ex) {
					Printer.println("");
					input.nextLine();
				} 
				Printer.println("");
				if (choice == 1) {
					if (hero.getDMG() != 25) {
						boolean puzzle = true;
						Printer.println("You search the room before finding a strange safe tucked behind the desk. It has a six letter combination (six dials with 27 letters each) and scratched into its side is this:");
						Printer.println("\"My love.\"");
						while (puzzle == true) {
							Printer.println("1) Attempt to unlock the safe.");
							Printer.println("2) Leave it for now");
							Printer.print("> ");
							try {
								choice = input.nextInt();
							}
							catch (InputMismatchException ex) {
								Printer.println("");
								input.nextLine();
							} 
							Printer.println("");
							if (choice == 1) {
								Printer.println("Enter your guess for the six letter safe code (type it out and hit enter)");
								Printer.print("> ");
								String guess = "";
								try {
									guess = input.next();
								}
								catch (InputMismatchException ex) {
									Printer.println("");
									input.nextLine();
								}
								String answer = "Olivia";
								if (guess.equalsIgnoreCase(answer) == true) {
									Printer.println("You hear a click and swing the safe open to reveal a shimmering light. You reach in and grab it at which point your own weapon begans to glow with the same light, transforming.");
									hero.setDMG(25);
									hero.setShield(2);
									hero.setMana(20);
									puzzle = false;
								}
								else Printer.println("You enter a guess but the safe does not open.");
							}
							else if (choice == 2) {
								Printer.println("You leave.");
								puzzle = false;
							}
							else Printer.println("Invalid Input, try again.");
						}
					}
					else Printer.println("You find nothing new in this room, the safe already opened and the contents.");
				}
				else if (choice == 2) {
					Printer.println("You head back into the hallway.");
					room = 11;
					room12 = false;
				}
				else if (choice == 3) {
					Printer.println("");
					mapPrinter();
					Printer.println("");
				}
				else if (choice == 4) {
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
					}
					else Printer.println("Invalid Input. Try again.");
				}
				else Printer.println("Invalid Input. Try again.");

			}
			
		}
		return room;
	}
	/**
	 * This method stores and prints the map. 
	 * <pre>Example:
	 * {@code mapPrinter() will print out the map so the player may reference it.
	 * }</pre>
	 */
	public static void mapPrinter() {
		String[][] versionFull = {
		{"+---------+ +---------+ +---------+ +---------+ +---------+"},
		{"|Messhall +-+Great    | |Shop     | |Minor    +-+Captain's|"},
		{"|         +-+Hall     | |         | |Hallway  +-+Chambers |"},
		{"+---+ +---+ +---------+ +---+ +---+ +---+ +---+ +---------+"},
		{"+---+ +---+ +---------+ +---+ +---+ +---+ +---+"},
		{"|West     +-+Armory   +-+East     +-+Training |"},
		{"|Barracks +-+         +-+Barracks +-+Room     |"},
		{"+---+ +---+ +---+ +---+ +---+ +---+ +---------+"},
		{"+---+ +---+ +---+ +---+ +---+ +---+"},
		{"|East     | |Awakening| |East     |"},
		{"|Barracks | |Room     | |Storage  |"},
		{"+---------+ +---------+ +---------+"},
		};
		Printer.printArray(versionFull);
	}
	/**
	 * This method runs the player through combat whenever it occurs. It primarily handles the enemy's turns, as another method handles the players.
	 * {@code combat(hero, awaken) will return nothing, as it is a static method, but will have the hero Player object fight the awaken Enemy object.
	 * }</pre>
	 * @param hero (object; the player object that holds the player data)
	 * @param foe (object; the enemy object that holds the enemy data)
	 * @throws InterruptedException (allows the Printer class to function)
	 */
	public static void combat(Player hero, Enemy foe) throws InterruptedException {
		int holder = 0;
		int type = foe.getType();
		int choice = 0;
		//whisp fight 
		if (type == 1) {
			generateEnemy(foe);
			Printer.println("A soft wail fills the air as a whisp stumbles from the shadows towards you. " + foe.toString() + " It pauses to study you a moment before shuffling forward, hands out stretched.");
			while (hero.getHP() > 0 && foe.getHP() > 0) {
				//hero turn
				int useless = processPlayerTurn(hero, foe);
				//whisp turn
				if (foe.getHP() > 0) {
					int huh = (int)(Math.random()*3+1);
					if (huh == 1) Printer.print("The whisp swipes at your chest");
					else if (huh == 2) Printer.print("The whisp grasps at your throat");
					else Printer.print("The whisp tries to grab you in a hug");
					int chance = (int)(Math.random()*20+1);
					if (chance == 1) Printer.println(" but misses entirely!");
					else if (chance == 20) {
						Printer.println(" and deals " + (foe.getDMG()*2) + " damage!");
						hero.takeDMG(foe.getDMG()*2);
					}
					else {
						hero.takeDMG(foe.getDMG());	
						Printer.println(" and deals " + foe.getDMG() +" !");
					}
				}
			}
			Printer.println("You succesfully slay the whisp which fades away to nothing, leaving behind two shiny coins.");
			hero.setCoins(hero.getCoins()+2);
			if (hero.getDefendCharge() > 0) {
				hero.setDefendCharge(0);
				hero.takeSheild(3);
			}
			if (hero.getDMG() == 30) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 9) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 13) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 17) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 10) hero.setDMG(hero.getDMG()-5);
		}
	
		//husk fight
		else if (type == 2) {
			generateEnemy(foe);
			Printer.println("A terrible image crawls out from some hidden crevice towards you, standing with jerky, unnatural movements. " + foe.toString() + "The husk does not pause as it stumbles towards you, ready to harm.");
			while (hero.getHP() > 0 && foe.getHP() > 0) {
				//heros turn
				choice = processPlayerTurn(hero, foe);
				//husk turn
				if (foe.getHP() > 0) {
					if (foe.getDefendCharge() > 0) {
						foe.takeDefendCharge(1);
						if (foe.getDefendCharge() == 0) foe.takeSheild(2);
					}
					if (choice == 1) {
						if (foe.getHP() == 15 || foe.getShield() > 0) {
							int chance = (int)(Math.random()*20+1);
							if (chance == 1 || chance == 2) Printer.println("The husk swipes at you with a fist but misses entirely.");
							else if (chance == 20) {
								Printer.println("The husk lunges with surpring speed and slams right into a weak spot in your defense.");
								hero.takeDMG(foe.getDMG()*2);
							}
							else {
								Printer.println("The husk aimlessly bludgeons you with its fists.");
								hero.takeDMG(foe.getDMG());
							}
						}
						else {
							foe.setDefendCharge(3);
							foe.addShield(2);
							Printer.println("As you lash out at the husk, it tenses up, hardening its skin to better survive your blows.");
						}
					}
					else if (choice == 2) {
						int chance = (int)(Math.random()*20+1);
						if (chance == 1 || chance == 2) Printer.println("The husk fruitlessly bashes its fists against your hardened defense.");
						else {
							Printer.println("The husk uses raw strength to power through your defenses, still getting a hit in.");
							hero.takeDMG(foe.getDMG());
						}
					}
					else if (choice == 3) {
						int chance = (int)(Math.random()*20+1);
						if (chance == 1) Printer.println("The husk is stunned by your impressive display of magic and cannot do anything this turn!");
						else if (chance == 2 || chance == 3) Printer.println("The husk is briefly blinded by your magics and its fist slams into the ground right before you, narrowly missing.");
						else {
							Printer.println("The husk's empty eyes gleam in your magic's light as its fist connects with your stomach.");
							hero.takeDMG(foe.getDMG());
						}
					}
					else {
						Printer.println("The husk swipes its leg aronud in a kick, connecting with your knee.");
						hero.takeDMG(foe.getDMG());
					}
				}
			}
			Printer.println("You succesfully slay the husk which crumbles and turns to dust. You find four coins on the body.");
			hero.setCoins(hero.getCoins()+4);
			if (hero.getDefendCharge() > 0) {
				hero.setDefendCharge(0);
				hero.takeSheild(3);
			}
			if (hero.getDMG() == 30) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 9) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 13) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 17) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 10) hero.setDMG(hero.getDMG()-5);
		}
		//mutant fight
		else if (type == 3) {
			generateEnemy(foe);
			Printer.println("There is a crackling in the air as you enter the room before out of nowhere a creture steps, its many red eyes glowering at you." + foe.toString() + " The mutant crackles with magical energy as it strikes the air with a whip made of acid, preparing for a fight.");
			while (hero.getHP() > 0 && foe.getHP() > 0) {
				//player turn
				choice = processPlayerTurn(hero, foe);
				//mutant turn
				if (foe.getHP() > 0) {
					boolean foeturn = true;
					while (foeturn) {
						int turning = (int)(Math.random()*4+1);
						if (turning == 1) {
							Printer.println("The mutant lashes out with a whip made of acid!");
							hero.takeDMG(foe.getDMG());
							foeturn = false;
						}
						else if (turning == 2) {
							int doagain = (int)(Math.random()*2+1);
							if (doagain == 1) {
								if (foe.getMana() >= 3) {
									Printer.println("The mutant channels magical energy into its acid whip, boosting its power.");
									foe.setDMG(foe.getDMG()+4);
									foe.takeMana(3);
									foeturn = false;
								}
							}
							else {
								if (foe.getShield() < 8 && foe.getMana() >= 4) {
									Printer.println("The mutant hardens it's skin with magic, boosting its defense.");
									foe.setShield(foe.getShield()+3);
									foe.takeMana(4);
									foeturn = false;
								}
							}
						}
						else if (turning == 3) {
							Printer.println("The mutant reaches out towards some unseen source and draws forth magical power, regaining mana.");
							foe.addMana(5);
							foeturn = false;
						}
						else {
							if (foe.getMana() >= 2) {
								Printer.println("The mutant closes its many eyes and bolsters its health.");
								foe.heal(8);
								foe.takeMana(2);
								foeturn = false;
							}
						}
					}
				}
			}
			Printer.println("You succesfully slay the mtuant which howls and explodes into a burst of mana energy, leaving behind a small pouch of coins.");
			hero.setCoins(hero.getCoins()+10);
			if (hero.getDefendCharge() > 0) {
				hero.setDefendCharge(0);
				hero.takeSheild(3);
			}
			if (hero.getDMG() == 30) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 9) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 13) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 17) hero.setDMG(hero.getDMG()-5);
			else if (hero.getDMG() == 10) hero.setDMG(hero.getDMG()-5);
			
			if (hero.getDMG() == 4 || hero.getDMG() == 25) {
				hero.setMana(20);
			}
			else hero.setMana(10);
		}
	}
	/**
	 * This method handles the user's turn in combat, calling a method from the Player object to have them make a selection then processing that selection. It then returns the number of that choice.
	 * <pre>Example:
	 * {@code processPlayerTurn(hero, foe) will return 1, 2, 3, or 4 as those are the options a user can choose. It will also update the data for the objects it received to make these choices.
	 * }</pre>
	 * @param hero (object; the player object that holds the player data)
	 * @param foe (object; the enemy object that holds the enemy data)
	 * @return choice (int; the number of the user's choice)
	 * @throws InterruptedException (allows the Printer class to function)
	 */
	public static int processPlayerTurn(Player hero, Enemy foe) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		if (hero.getDefendCharge() > 0) {
			hero.takeDefendCharge(1);
			if (hero.getDefendCharge() == 0) hero.takeSheild(3);
		}
		int choice = 0;
		boolean turn = true;
		while (turn) {
			choice = hero.turn();
			if (choice == 1) {
				Printer.println("You attack!");
				foe.takeDMG(hero.getDMG());
				turn = false;
			}
			else if (choice == 2) {
				Printer.println("You take a defensive stance.");
				if (hero.getShield() == 0) hero.addShield(3);
				hero.addDefendCharge(2);
				turn = false;
			}
			else if (choice == 3) {
				boolean magic = true;
				while (magic) {
					try {
						Printer.println("Pick Your Magic Choice: ");
						Printer.println("1) Boost Attack (4 mana)");
						Printer.println("2) See Weakness (3 mana)");
						if (hero.getDMG() == 4 || hero.getDMG() == 25 || hero.getDMG() == 9 || hero.getDMG() == 30) Printer.println("3) Light Blast (4 mana)");
						Printer.print("> ");
						int holdMag = 0;
						holdMag = input.nextInt();
						Printer.println("");
						if (holdMag == 1) {
							
							if (hero.getDMG() == 25 || hero.getDMG() == 4 || hero.getDMG() == 8 || hero.getDMG() == 12 || hero.getDMG() == 5) {
								if (hero.getMana() >= 4) {
									Printer.println("You graps your weapon and a surge of light passes down your arms into it, making it more deadly.");
									hero.setDMG(hero.getDMG()+5);
									hero.takeMana(4);
									magic = false;
									turn = false;
								}
								else Printer.println("Insufficent mana!");
								magic = false;
							}
							else Printer.println("You have already boosted your attack this fight!");
							magic = false;
						}
						else if (holdMag == 2) {
							if (hero.getMana() >= 3) {
								Printer.println("You quickly channel magic to your eyes and glimpse at your foe in a new light, learning more of them.");
								Printer.println("Foe Health: " + foe.getHP() + " Foe Damage: " + foe.getDMG() + " Foe Shield: " + foe.getShield() + " Foe Mana: " + foe.getMana());
								magic = false;
							}
							else Printer.println("Insufficient mana!");
							magic = false;
						}
						else if (holdMag == 3) {
							if (hero.getDMG() == 4 || hero.getDMG() == 25 || hero.getDMG() == 9 || hero.getDMG() == 30) {
								if (hero.getMana() >= 4) {
									Printer.println("Falavor");
									foe.takeDMG(10);
									hero.heal(3);
									magic = false;
									turn = false;
								}
								else Printer.println("Insufficent mana!");
								magic = false;
							}
							else Printer.println("Invalid input. Try again.");
						}
						else Printer.println("Invalid input. Try again.");
					}
					catch (InputMismatchException ex) {
						Printer.println("Invalid input, try again.");
						input.nextLine();
					}
				}
			}
			else if (choice == 4) {
				Printer.println("You chug a potion.");
				int hold = hero.getHP();
				if (hold >= 40) hero.setHP(50);
				else hero.heal(10);
			}
		}
		return choice;
	}
	/**
	 * A very simple method that randomly selects pre-made descriptors for enemy objects to create variety.
	 * <pre>Example:
	 * {@code generateEnemy(foe) will edit the data in foe to eventually hold a different description
	 * }</pre>
	 * @param foe (object; the enemy object that holds the enemy data)
	 */
	public static void generateEnemy(Enemy foe) {
		//whisp
		if (foe.getType() == 1) {
			//height
			foe.setHeight("short");
			//color
			int one = (int)(Math.random()*4+1);
			if (one == 1) foe.setColor("shadowy");
			else if (one == 2) foe.setColor("grey");
			else if (one == 3) foe.setColor("ash");
			else foe.setColor("pure white");
			//hair color
			int two = (int)(Math.random()*4+1);
			if (two == 1) foe.setHairColor("transparent");
			else if (two == 2) foe.setHairColor("grey");
			else if (two == 3) foe.setHairColor("ashen");
			else foe.setHairColor("pure white");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (three == 1) foe.setHairLength("waist length");
			else if (three == 2) foe.setHairLength("buzz cut");
			else if (three == 3) foe.setHairLength("shoulder length");
			else {
				foe.setHairLength("shadow");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (four == 1) foe.setClothes("nothing");
			else if (four == 2) foe.setClothes("a see through uniform");
			else if (four == 3) foe.setClothes("a tattered shirt");
			else foe.setClothes("only pants");
		}
		
		//husk
		else if (foe.getType() == 2) {
			//height
			int zero = (int)(Math.random()*3+1);
			if (zero == 1) foe.setHeight("short");
			else if (zero == 2) foe.setHeight("medium");
			else foe.setHeight("tall");
			//color
			int one = (int)(Math.random()*4+1);
			if (one == 1) foe.setColor("puss yellow");
			else if (one == 2) foe.setColor("rotting black");
			else if (one == 3) foe.setColor("sickly green");
			else foe.setColor("pale");
			//hair color
			int two = (int)(Math.random()*4+1);
			if (two == 1) foe.setHairColor("grey");
			else if (two == 2) foe.setHairColor("stark white");
			else foe.setHairColor("red");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (one == 1) foe.setHairLength("short");
			else if (three == 2) foe.setHairLength("long");
			else if (three == 3) foe.setHairLength("tufts of");
			else {
				foe.setHairLength("no");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (four == 1) foe.setClothes("only undergarments");
			else if (four == 2) foe.setClothes("an rusty set of armor");
			else if (four == 3) foe.setClothes("a tattered uniform");
			else foe.setClothes("a jester's costume");
		}
		
		//mutant
		else if (foe.getType() == 3) {
			//height
			int zero = (int)(Math.random()*2+1);
			if (zero == 1) foe.setHeight("medium");
			else foe.setHeight("tall");
			//color
			int one = (int)(Math.random()*4+1);
			if (one == 1) foe.setColor("bright green");
			else if (one == 2) foe.setColor("dark purple");
			else if (one == 3) foe.setColor("marbled");
			else foe.setColor("pure white");
			//hair color
			int two = (int)(Math.random()*4+1);
			if (two == 1) foe.setHairColor("muddy brown");
			else if (two == 2) foe.setHairColor("blonde");
			else if (two == 3) foe.setHairColor("pitch black");
			else foe.setHairColor("slimey");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (three == 1) foe.setHairLength("strands of");
			else if (three == 2) foe.setHairLength("braided");
			else if (three == 3) foe.setHairLength("shoulder length");
			else {
				foe.setHairLength("tentacle");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (four == 1) foe.setClothes("scraps of metal held onto its body by rope");
			else if (four == 2) foe.setClothes("many animal furs");
			else if (four == 3) foe.setClothes("a dark black robe");
			else foe.setClothes("darkness itself");
		}
	}
	/**
	 * This method turns blank slate Enemy objects and turns them into a pre-made type of enemy, so as to allow randomization in other methods that call this one to implement that randomness properly.
	 * <pre>Examples:
	 * {@code createEnemy(foe, 1) will turn the foe Enemy object into the 1 type of enemy (whisps), editing its data to reflect this in combat as well assigning it that type value for later reference.
	 * }</pre>
	 * @param foe (object; the enemy object that holds the enemy data)
	 * @param type (int; the type of enemy to turn foe into)
	 */
	public static void createEnemy(Enemy foe, int type) {
		if (type == 1) {
			foe.setType(1);
			foe.setHP(11);
			foe.setDMG(5);
			foe.setMana(0);
			foe.setShield(0);
		}
		else if (type == 2) {
			foe.setType(2);
			foe.setHP(15);
			foe.setDMG(9);
			foe.setMana(0);
			foe.setShield(1);
		}
		else if (type == 3) {
			foe.setType(3);
			foe.setHP(25);
			foe.setDMG(11);
			foe.setMana(10);
			foe.setShield(2);
		}
	}
}

/**
 * <h1>Printer</h1>
 * <p>This allowed me to print lines with delays (so the text sprawled out instead of jumping onto the screen) as well as print arrays without makign a loop each time.</p>
 * <p>Created: 1/11/2021</p> 
 * @author Jason Snow
 *
 */
class Printer {
	/**
	 * This method prints out two dimensional arrays of Strings.
	 * <pre>Example:
	 * {@code printArray(fullVersion) will print the map (a string array with the reference fullVersion)
	 * }</pre>
	 * @param myArray
	 */
	public static void printArray(String[][] myArray) {
		for (int row = 0; row < myArray.length; row++) {
			for (int column = 0; column < myArray[row].length; column++) {
				System.out.print(myArray[row][column] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 	This method prints out whatever string it receives very very slowly. Used for long delays for dramatic tension. It then moves to the next line.
	 * <pre>Example:
	 * {@code reallyprintln("hello") will print out hello but really slowly. It then moves to the next line.
	 * }</pre>
	 * @param message (String; the String to print really slowly)
	 * @throws InterruptedException (necessary to allow the printing process to be delayed, thus printing gradually instead of all at once)
	 */
	public static void reallyprintln(String message) throws InterruptedException {
		String neato = message; 
		char[] chars = neato.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
			Thread.sleep(200);
		}
		System.out.println("");
	}
	/**
	 * This method prints out whatever string it receives slower than suddenly appearing, but at a fairly rapid rate.
	 * <pre>Example:
	 * {@code print("hello") will print out hello.
	 * }</pre>
	 * @param hold (String; the String to print)
	 * @throws InterruptedException (allows the method to function by allowing delays and breaks)
	 */
	public static void print(String hold) throws InterruptedException {
			String neato = hold;
			char[] chars = neato.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
				Thread.sleep(10);
			}
	}
	/**
	 * This method prints a string slowly then skips to the next line.
	 * <pre>Example:
	 * {@code println("hello") prints hello then skips to the next line.
	 * }</pre>
	 * @param hold (String; the String to print)
	 * @throws InterruptedException (allows the moethod to function)
	 */
	public static void println(String hold) throws InterruptedException {
			String neato = hold;
			char[] chars = neato.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
				Thread.sleep(10);
			}
			System.out.println("");
	}
}
/**
 * <h1>Enemy</h1>
 * <p>This was the class for the Enemy object. It primarily held data.</p>
 * <p>Created: 01/11/2021</p>
 * @author Jason Snow
 *
 */
class Enemy extends Character {
	private int type;
	/**
	 * This method is a no arguement constructor for the enemy type which makes an enemy type the player will not fight (mainly so if it did show up, it would be obvious something was wrong)
	 * <pre>Example:
	 * {@code Enemy() will generate an enemy object with specified data.
	 * }</pre>
	 */
	public Enemy() {
		type = 0;
		setHP(1);
		setDMG(0);
		setMana(0);
		setShield(0);
		setDefendCharge(0);
		setHeight("small");
		setColor("modly");
		setHairColor("");
		setHairLength("no");
		setClothes("nothing");
	}
	/**
	 * This is the accessor method for the enemy type.
	 * <pre>Example:
	 * {@code getType() returns 1, 2, or 3 as those are the three enemy types
	 * }</pre>
	 * @return type (int; the type of enemy this enemy object is)
	 */
	public int getType() {
		return type;
	}
	/**
	 * This method can edit the type of an enemy.
	 * <pre>Example:
	 * {@code setType(1) sets the enemy objects type to 1
	 * }</pre>
	 * @param type (int; the type of enemy to set the object to)
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * <pre>Example:
	 * {@code toString() might return a string like "The small whisp is shadowy, wearing a tattered shirt and has short pure white hair."
	 * }</pre>
	 * @return (String; a descriptive sentence of the enemy object using its stored information)
	 */
	public String toString() {
		String name = "";
		if (type == 1) {
			name = "whisp";
		}
		else if (type == 2) {
			name = "husk";
		}
		else if (type == 3) {
			name = "mutant";
		}
		return "The " + getHeight() + " " + name + " is " + getColor() + ", wearing " + getClothes() + " and has " + getHairColor() + " " + getHairLength() + " hair.";
	}
}
/**
 * <h1>Player</h1>
 * <p>This was the class for the Player object that represented the player character. It primarily held data but also assisted in automating the process for a turn.</p>
 * <p>Created: 01/11/21</p>
 * @author Jason Snow
 *
 */
class Player extends Character {
	private int potions;
	private int coins;
	private int room;
	private boolean westernBarracksKey;
	private boolean captainChamberKey;
	private int squid;
	/**
	 * No arguement constructor for Player objects.
	 * <pre>Example:
	 * {@code Player() constructs a player object
	 * }</pre> 
	 */
	public Player() {
		setHP(35);
		setDMG(5);
		setMana(10);
		setShield(0);
		coins = 0;
		potions = 0;
		setDefendCharge(0);
		setHeight("");
		setColor("");
		setHairColor("");
		setHairLength("");
		setClothes("");
		room = 0;
		westernBarracksKey = false;
		captainChamberKey = false;
		squid = 0;
	}
	/**
	 * An accessor method for a player objects potions.
	 * <pre>Example:
	 * {@code getPotions() might return 0 or 100 depending on how many potions that player object has collected.
	 * }</pre> 
	 * @return (int: the number of potions the player object has)
	 */
	public int getPotions() {
		return potions;
	}
	/**
	 * Sets the number of potions for a player object
	 * <pre>Example:
	 * {@code setPotions(1) sets the number of the player object's potions to 1
	 * }</pre>
	 * @param potions (int; the number of potions to set)
	 */
	public void setPotions(int potions) {
		this.potions = potions;
	}
	/**
	 * Adds potions to player objects
	 * <pre>Example:
	 * {@code addPotions(1) adds 1 potion to the number of potions for that player object
	 * }</pre> 
	 * @param added (int; the number of potions to adds)
	 */
	public void addPotions(int added) {
		potions += added;
	}
	/**
	 * Takes potions from player objects
	 * <pre>Example:
	 * {@code takePotions(1) takes 1 potion from the number of potions that player object has.
	 * }</pre> 
	 * @param taken (int; the number of potions taken)
	 */
	public void takePotions(int taken) {
		potions -= taken;
	}
	/**
	 * Accessor method for the coins data
	 * <pre>Example:
	 * {@code getCoins() might return 0 or 100 coins depending
	 * }</pre> 
	 * @return (int; the number of coins the player object has)
	 */
	public int getCoins() {
		return coins;
	}
	/**
	 * Setter method for the coins data
	 * <pre>Example:
	 * {@code setCoins(1) sets the number of coins for that player object to 1
	 * }</pre>
	 * @param coins (int; the number to set the amount of coins to)
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}	
	/**
	 * Accessor method for the room data
	 * <pre>Example:
	 * {@code getRoom() will return the number of room, from 1-11 possible
	 * }</pre>
	 * @return (int; the room number)
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * Setter mmethod for the room data
	 * <pre>Example:
	 * {@code setRoom(1) sets the room data to 1
	 * }</pre>
	 * @param room (int; what room number to set the room data to)
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	/**
	 * The accessor method for the boolean westernBarracksKey data
	 * <pre>Example:
	 * {@code isWesternBarracksKey() will return true or false
	 * }</pre> 
	 * @return (boolean; whether the Player has the westernBarracksKey or not)
	 */
	public boolean isWesternBarracksKey() {
		return westernBarracksKey;
	}
	/**
	 * The setter method for the westernBarracksKey data
	 * <pre>Example:
	 * {@code setWesternBarracksKey(true) sets the westernBarracksKey to true
	 * }</pre> 
	 * @param key (boolean; whether or not the player object should have the key now)
	 */
	public void setWesternBarracksKey(Boolean key) {
		westernBarracksKey = key;
	}
	/**
	 * The accessor method for the captainChamberKey data
	 * <pre>Example:
	 * {@code isCaptainChamberKey() returns true or false
	 * }</pre>
	 * @return (boolean; whether or not the Player has the captainChamberKey)
	 */
	public boolean isCaptainChamberKey() {
		return captainChamberKey;
	}
	/**
	 * The setter method for the captainChamberKey data
	 * <pre>Example:
	 * {@code setCaptainChamberKey(false) sets the captainChamberKey data to false
	 * }</pre> 
	 * @param key (boolean; whether or not the Player object should have the captainChamberKey or not)
	 */
	public void setCaptainChamberKey(Boolean key) {
		captainChamberKey = key;
	}
	/**
	 * The accessor method for the squid data which represents choices in the squid encounter.
	 * <pre>Example:
	 * {@code getSquid() returns 1-3 as those are choices for the squid encounter
	 * }</pre>
	 * @return (int; the choices made or the lack of choices made in the squid encounter)
	 */
	public int getSquid() {
		return squid;
	}
	/**
	 * The setter method for the squid data
	 * <pre>Example:
	 * {@code setSquid(1) sets the squid data to 1, representing the choice 1
	 * }</pre>
	 * @param squid (int; what choice was made to set squid to)
	 */
	public void setSquid(int squid) {
		this.squid = squid;
	}	
	/**
	 * This makes a string to represent the stats of the player.
	 * <pre>Example:
	 * {@code statString() returns something like "HP: 10 Mana: 8 Coins: 6 Potions: 2"
	 * }</pre> 
	 * @return (String; the string representing the organized data of the Player object)
	 */
	public String statString() {
		String hold = "HP " + getHP() + " Mana: " + getMana() + " Coins: " + coins;
		if (potions > 0) hold = hold + " Potions: " + potions;
		return hold;
	}	
	/**
	 * Turns the data describing the Player object into a coherent string
	 * <pre>Example:
	 * {@code toString() might return "a tall, pale skinned person with long red hair, wearing a simple dress."
	 * }</pre> 
	 * @return (String; the string that describes the Player object)
	 */
	public String toString() {
		String hold = "a " + getHeight() + ", " + getColor() + " skinned person with " + getHairLength() + " " + getHairColor() + " hair, wearing " + getClothes();
		if (squid != 2) hold = hold + " and a cloak.";
		return hold;
	}
	/**
	 * Displays options for the User on their turn in combat, returns the choice.
	 * <pre>Example:
	 * {@code turn() might return 1, 2, 3, or 4 as those are the options in combat
	 * }</pre> 
	 * @return choice (int; the choice made on that turn)
	 * @throws InterruptedException (allows the Printer class to function)
	 */
	public int turn() throws InterruptedException {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		boolean pot = false;
		if (potions > 0) pot = true;
		while (valid == false) {
			Printer.println(statString());
			Printer.println("1: Attack");
			Printer.println("2: Defend");
			Printer.println("3: Use Magic");
			if (pot) {
				Printer.println("4: Potions");
			}
			Printer.print("> ");
			try {
				choice = input.nextInt();
				if (pot) {
					if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
						valid = true;
					}
					else Printer.println("Invalid input. Enter valid choice number");
				}
				else {
					if (choice == 1 || choice == 2 || choice == 3) {
						valid = true;
					}
					else Printer.println("Invalid input. Enter valid choice number");
				}
				
			}
			catch (InputMismatchException ex) {
				Printer.println("Invalid input, you must enter an integer (1, 2, 3, etc.)");
				input.nextLine();
			}
		}
		return choice;
	}
}
/**
 * <h1>Character</h1>
 * <p>This was the superclass for both the Enemy and Player classes, from which they inherited a great deal of data fields and methods.</p>
 * <p>Created: 01/11/2021</P>
 * @author Jason Snow
 *
 */
class Character{
	private int hp;
	private int dmg;
	private int mana;
	private int shield;
	private int defendCharge;
	private String height;
	private String color;
	private String hairColor;
	private String hairLength;
	private String clothes;
	
	/**
	 * No argument constructor for a Character Object
	 * <pre>Example:
	 * {@code Character() constructs a default character object
	 * }</pre>
	 */
	protected Character() {
		hp = 10;
		dmg = 2;
		mana = 0;
		shield = 0;
		height = "short";
		color = "green";
		hairColor = "black";
		hairLength = "short";
		clothes = "raggedy";

	}
	/**
	 * Accessor method for HP data
	 * <pre>Example:
	 * {@code getHP() returns the health value, typically 0 - 50
	 * }</pre>
	 * @return hp (int; current hp of the character object)
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * Setter method for HP data
	 * <pre>Example:
	 * {@code setHP(1) sets character object's HP to 1
	 * }</pre>
	 * @param hp (int; the number to set the hp to)
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}
	/**
	 * Accessor method for dmg data
	 * <pre>Example:
	 * {@code getDMG() returns 4-18 depending on how great the dmg number is
	 * }</pre> 
	 * @return dmg (int; current dmg of the character object)
	 */
	public int getDMG() {
		return dmg;
	}
	/**
	 * Setter method for dmg data
	 * <pre>Example:
	 * {@code setDMG(1) sets the character object's dmg to 1
	 * }</pre> 
	 * @param dmg (int; the number to set the dmg to)
	 */
	public void setDMG(int dmg) {
		this.dmg = dmg;
	}
	/**
	 * Accessor method for mana data
	 * <pre>Example:
	 * {@code getMana() returns 0-20 depending on current mana
	 * }</pre>
	 * @return mana (int; return current mana of object)
	 */
	public int getMana() {
		return mana;
	}
	/**
	 * Setter method for mana data
	 * <pre>Example:
	 * {@code setMana(1) sets the character object's mana to 1
	 * }</pre>
	 * @param mana (int; the number to set the mana to)
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}
	/**
	 * Accessor method for the shield data
	 * <pre>Example:
	 * {@code getShield() returns 0-5 depending on current shield value
	 * }</pre>
	 * @return shield (int; the amount of damage the character object currently shields)
	 */
	public int getShield() {
		return shield;
	}
	/**
	 * Setter method for the shield data
	 * <pre>Example:
	 * {@code setShield(1) sets character object's shield to 1
	 * }</pre>
	 * @param shield (int; number to set the shield to)
	 */
	public void setShield(int shield) {
		this.shield = shield;
	}
	/**
	 * Method to simply add value to the shield data
	 * <pre>Example:
	 * {@code addShield(1) adds 1 to the character object's shield
	 * }</pre>
	 * @param shield (int; the amount to add to the character object's shield)
	 */
	public void addShield(int shield) {
		this.shield += shield;
	}
	/**
	 * Method to take value from the shield data
	 * <pre>Example:
	 * {@code takeShield(1) takes 1 from the character object's shield
	 * }</pre> 
	 * @param shield (int; the amount to take from the character object's shield)
	 */
	public void takeSheild(int shield) {
		this.shield -= shield;
	}
	/**
	 * Accessor method for defendCharge data
	 * <pre>Example:
	 * {@code getDefendCharge() returns 0-3 typically
	 * }</pre> 
	 * @return defendCharge (int; the number of turns a defensive stance has left)
	 */
	public int getDefendCharge() {
		return defendCharge;
	}
	/**
	 * Setter method for defendCharge data
	 * <pre>Example:
	 * {@code setDefendCharge(1) sets defendCharge to 1
	 * }</pre>
	 * @param defendCharge (int; the amount to set defendCharge to)
	 */
	public void setDefendCharge(int defendCharge) {
		this.defendCharge = defendCharge;
	}
	/**
	 * This methods adds to the defendCharge data
	 * <pre>Example:
	 * {@code addDefendCharge(1) adds one to the defendCharge of the player object
	 * }</pre>
	 * @param add (int; how many turns to extends the defendCharge by)
	 */
	public void addDefendCharge(int add) {
		defendCharge += add;
	}
	/**
	 * This method takes from the defendCharge data
	 * <pre>Example:
	 * {@code takeDefendCharge(1) takes 1 from the character object's defendCharge
	 * }</pre>
	 * @param take (int; the amount to reduce the number of turns left on the defensive stance (defendCharge) be)
	 */
	public void takeDefendCharge(int take) {
		defendCharge -= take;
	}
	/**
	 * Accessor method for the character object height
	 * <pre>Example:
	 * {@code getHeight() might return "tall", "short", or "medium", typically
	 * }</pre>
	 * @return height (String; the string describing the height of the character object)
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * Setter method for the character object height
	 * <pre>Example:
	 * {@code setHeight("tall") sets the character object's height to "tall"
	 * }</pre> 
	 * @param height (String; the description of the character objects height)
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * Accessor method for the character object's color
	* <pre>Example:
	 * {@code getColor() might return "green", "pale", "shadowy", or "transparent"
	 * }</pre> 
	 * @return color (String; description of the character objects color)
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Setter method for the character object's color
	 * <pre>Example:
	 * {@code setColor("green") sets the character object's color to green
	 * }</pre>
	 * @param color (String; description of the character objects color)
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Accessor method for the character object's hairColor
	 * <pre>Example:
	 * {@code getHairColor() might return "black", "red", or even "" to represent no hair thus no color
	 * }</pre>
	 * @return hairColor (String; description of the character objects hair color)
	 */
	public String getHairColor() {
		return hairColor;
	}
	/**
	 * Setter method for the character object's hairColor
	 * <pre>Example:
	 * {@code setHairColord("blonde") sets the Character object's hairColor to "blonde"
	 * }</pre> 
	 * @param hairColor (String; description of the character object's hair color)
	 */
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	/**
	 * Getter method for the character object's hairLength
	 * <pre>Example:
	 * {@code getHairLength() might return "long", "short", or "no" to represent no hair
	 * }</pre> 
	 * @return hairLength (String; description of the character objects hair length (is sometimes also used for style if the two can go together))
	 */
	public String getHairLength() {
		return hairLength;
	}
	/**
	 * Setter method for the character objec's hairLength
	 ** <pre>Example:
	 * {@code setHairLength("long") sets the character object's hairLength to "long"
	 * }</pre>
	 * @param hairLength (String; the description for the character objects hair length)
	 */
	public void setHairLength(String hairLength) {
		this.hairLength = hairLength;
	}
	/**
	 * This method edits the HP value by subtracting from it to represent suffering damage. It automatically factors in the current shield and reduces the damage by that much.
	 * <pre>Example:
	 * {@code takeDMG(1) reduces hp by 1. If shield would lower this, the minimum is 0 so the character object takes 0 minimum damage
	 * }</pre>
	 * @param taken (int; the amount of damage to take)
	 */
	public void takeDMG(int taken) {
		int take = (taken-shield);
		if (take < 0) take = 0;
		hp -= take;
	}
	/**
	 * This method edits the HP value by added to represent healing. 
	 * <pre>Example:
	 * {@code heal(1) adds 1 to the HP value
	 * }</pre>
	 * @param healed (int; amount to heal the character object by)
	 */
	public void heal(int healed) {
		hp += healed;
	}
	/**
	 * This method helps manage the mana data, taking away from it when it is spent.
	 * <pre>Example:
	 * {@code takeMana(1) takes 1 from the character object's mana value to represent spent mana
	 * }</pre>
	 * @param taken (int; the amount of mana spent and to be taken)
	 */
	public void takeMana(int taken) {
		mana -= taken;
	}
	/**
	 * This method adds to the mana data to represent gained mana
	 * <pre>Example:
	 * {@code addMana(1) adds 1 to the mana value
	 * }</pre> 
	 * @param add (int; the amount of mana to regain)
	 */
	public void addMana(int add) {
		mana += mana;
	}
	/**
	 * The setter method for clothes for a character object
	 * <pre>Example:
	 * {@code setClothes("a simple dress") sets the character object's clothes to "a simple dress"
	 * }</pre>
	 * @param clothes (String; what to set the description of the character object's clothes to)
	 */
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	/**
	 * The accessor method for the clothes of a character object
	 * <pre>Example:
	 * {@code getClothes() might return "a simple dress", "a plain uniform", or "only pants"
	 * }</pre>
	 * @return clothes (String; the description of the character object's clothes)
	 */
	public String getClothes() {
		return clothes;
	}
}