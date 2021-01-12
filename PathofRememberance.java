import java.util.*;


public class PathofRememberance {
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
					Printer.println("Testing good.");
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
				else Printer.println("Invalid choice. Try again.");
		}
		
		Printer.println("With the orb of light in your hand, you are able to see the rest of the room clearly. You lay upon a stone table, dressed in plain clothing and a cloak, in the center of this small room which is little more than four walls, floor, and roof all stone. There is a wooden table against one wall and upon it are serveral items. There is a door as well. You cannot remember anything... perhaps the answers are elsewhere.");
		Printer.println("");
		boolean room1 = true;
		boolean key1 = false;
		while (room1 == true) {
			try {
				Printer.println("1) Investigate the table.");
				Printer.println("2) Leave through northern, wooden door.");
				Printer.print("> ");
				choice = input.nextInt();
				Printer.println("");
				if (choice == 1) {
					if (key1 == false) {
						Printer.println("You find upon the table a dagger, a key, a map and a page that seems ripped from a book. You take the key, dagger, and map.");
					}
					else Printer.println("You return to the table and find the page upon the table still.");
					boolean invest = true;
					while (invest == true) {
						Printer.println("1) Read the page.");
						Printer.println("2) Leave the table.");
						Printer.print("> ");
						choice = input.nextInt();
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take the pages and begin to read: ");
							Printer.println("\"It presses upon us presently, as constant as ever. We shall not escape this, but all hope is not lost. We place our faith in our greatest warrior to deliever us from this.\"");
							Printer.println("The rest of the page has been smeared and torn, rendering it illegiable.");
						}
						else if (choice == 2) {
							invest = false;
						}
						else Printer.println("Invalid choice. Try again.");
					}
					key1 = true;
				}
				else if (choice == 2) {
					if (key1 == true) room1 = false;
					else Printer.println("You attempt to leave through the door but find the handle will not budge: the door is locked.");
				}
				else Printer.println("Invalid choice. Try again!");
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
		createEnemy(first, 2);
		combat(hero, first);
		
		
		if (hero.getHP() > 0) Printer.println("With the shade dealt with, you are able to proceed forward and find yourself in another room."); 
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
				//print info
			}
			else if (hero.getHP() <= 0) {
				Printer.println("You have fallen...");
				Printer.println("1) Rise again.");
				Printer.println("2) Give in to the darkness.");
				Printer.print("> ");
				choice = input.nextInt();
				Printer.println("");
				if (choice == 1) {
					Printer.println("Opening your eyes, you find a simple wooden door before you. You push it open and step out, ready to try again.");
					//reset player stats
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
	
	
	public static int rooms(int room, Player hero) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		if (room == 1) {
			Printer.println("You once again enter the room where you awoke, just as you left it.");
			//fight
			boolean room1 = true;
			while (room1 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate Table");
				Printer.println("2) Leave through north door(Armory)");
				if (hero.getPotions() > 0) Printer.println("3) Drink a potion");
				Printer.print("> ");
				choice = input.nextInt();
				Printer.println("");
				if (choice == 1) {
					Printer.println("You return to the table and find the page upon the table still.");
					boolean invest = true;
					while (invest == true) {
						Printer.println("1) Read the page.");
						Printer.println("2) Leave the table.");
						Printer.print("> ");
						choice = input.nextInt();
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take the pages and begin to read: ");
							Printer.println("\"It presses upon us presently, as constant as ever. We shall not escape this, but all hope is not lost. We place our faith in our greatest warrior to deliever us from this.\"");
							Printer.println("The rest of the page has been smeared and torn, rendering it illegiable.");
						}
						else if (choice == 2) {
							invest = false;
						}
						else if (choice == 3) {
							if (hero.getPotions() > 0) {
								Printer.println("You chug a potion.");
								int hold = hero.getHP();
								if (hold >= 40) hero.setHP(50);
								else hero.heal(10);
								Printer.println("HP: " + hero.getHP());
							}
						}
						else Printer.println("Invalid choice. Try again.");	
					}
				}
				else if (choice == 2) {
					Printer.println("You leave through the north door, making your way through the hallway back to the armory.");
					room = 2;
					room1 = false;
				}
				else Printer.println("Invalid choice. Try again.");
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
				if (hero.getPotions() > 0) Printer.println("5) Drink a potion");
				Printer.print("> ");
				choice = input.nextInt();
				Printer.println("");
				if (choice == 1) {
					//weapon swappin choiice
					Printer.println("");
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
					if (hero.getPotions() > 0) {
						Printer.println("You chug a potion.");
						int hold = hero.getHP();
						if (hold >= 40) hero.setHP(50);
						else hero.heal(10);
						Printer.println("HP: " + hero.getHP());
					}
				}
				else Printer.println("Invalid option. Try again.");
			}
		}
		else if (room == 3) {
			Printer.println("You enter the East Barracks. There are four doors leading out of this room, one in each direction. The one to the north doesn't seem to stick in your memory as the others here have, as if it does not belong. Bunks fill the room in rows, two sets of bunks two high with a dresser between them, each dresser holding four drawers. The beds are in disarray, there are clothes handing out of unclosed drawers. There are even some stray items upon beds, left out as if people had simply forgotten them.");
		//combat
		boolean room3 = true;
			while (room3 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the room");
				Printer.println("2) Leave through north door(???)");
				Printer.println("3) Leave through east door(Training Room)");
				Printer.println("4) Leave through south door(East Storage)");
				Printer.println("5) Leave through west door(Armory)");
				Printer.print("> ");
				choice = input.nextInt();
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
				else Printer.println("Invalid choice. Try again.");
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
				Printer.print("> ");
				choice = input.nextInt();
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
						choice = input.nextInt();
						Printer.println("");
						if (choice == 1) {
							Printer.println("You take a moment to lay upon your bed, resting your eyes. A sense of peace temporarily overcomes you and you open your eyes feeling refreshed. You rise, reignite your light, and smooth your bed once again completely out of habit.");
							hero.setMana(10);
							//print stats
							Printer.println("");
						}
						else if (choice == 2) {
							Printer.println("");
							invest = false;
						}
						else Printer.println("Invalid choice. Try again.");
					}
					
				}
				else Printer.println("Invalid choice. Try again.");	
		}
	}
		//room 5 east storage
		else if (room == 5) {
			Printer.println("Stepping into the East Storage room, you find a great disarray. Everything once stored here is flung about, the palace ransacked. Racks thrown down, chests burst open, contents strewn about. Cloaks and uniforms are tossed about, which you recognize as the uniforms the husks wear. There is a number of flasks spilled, their contents long ago staining the ground, there are boots, weapons, broken weapons, personal effects, books, and even some rope. ");
			//combat maybe
			boolean room5 = true;
			while (room5 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate");
				Printer.println("2) Leave through the north door(East Barracks)");
				Printer.print("> ");
				choice = input.nextInt();
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
						hero.setWestsernBarracksKey(true);
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
				else Printer.println("Invalid choice. Try again.");
			}
		}
		//room 6 west storage
		else if (room == 6) {
			Printer.println("Stepping into the West Storage room, you find many crates and barrels, clearly a storage for more extended periods of time. One barrle has it's bottom shattered, potatoes spilling out over the floor. A trail of these potatoes leads further into the room, between two large crates.");
			//combat
			boolean room6 = true;
			while (room6 == true && hero.getHP() > 0) {
				Printer.println("1) Follow the trail of potatoes.");
				Printer.println("2) Leave through the north door(West Barracks)");
				Printer.print("> ");
				choice = input.nextInt();
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
						if (hero.getHP() > 15) hero.setHP(15);
						//show increase
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
						choice = input.nextInt();
						Printer.println("");
						if (choice == 1) {
							//squid combat
							hero.setSquid(1);
							squid = false;
						}
						else if (choice == 2) {
							Printer.println("You take your cloak off and offer it to the creature. It is, at first, hesitant but when you show no intention to harm it, it quickly snatches the cloak and wraps it about itself, looking up at you with a new curiosity. As its shiverings subside, the little thing picks up a potato and offers it to you. Deciding it would be rude to refuse, you accept the potato. The two of you sit together and enjoy your meal for a time. Once you are done, you rise and bid the creature farewell, for now.");
							if (hero.getHP() > 15) hero.setHP(15);
							//show health increase
							Printer.println("");
							hero.setSquid(2);
							squid = false;
						}
						else if (choice == 3) {
							Printer.println("You look the pink thing over before turning away, leaving it where it shivers.");
							hero.setSquid(4);
							squid = false;
						}
					}
				}
				else if (choice == 2) {
					Printer.println("You exit via the northern door into what you know is the West Barracks.");
					room = 4;
					room6 = false;
				}
				else Printer.println("Invalid choice try again.");
			}
		}
		//room 7 messhall
		else if (room == 7) {
			Printer.println("You Descend the long set of stairs into the mess hall where some conflict seems to have ensued. Benches and tables are flipped over, arrows sticking out of nearly every surface, telling red stains litter the area. Old food rots upon the ground, discarded, unremebered. There are two doors, one to the south that leads up to the West Barracks and another that leads east to the Main Hall.");
			//combat
			boolean room7 = true;
			while (room7 == true && hero.getHP() > 0) {
				Printer.println("Investigate the room.");
				Printer.println("2) Leave through east doorway(Great Hall)");
				Printer.println("3) Leave through south doorway(West Barracks)");
				Printer.print("> ");
				choice = input.nextInt();
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
				else Printer.println("Invalid choice try again.");
			}
		}
		//room 8 hallway
		else if (room == 8) {
			Printer.println("You enter the great hall. The ceiling is far above here, a godo two stories high and curved. Faded art adorns the ceiling, which many pillars along the side of the room hold up. Great stained glass windows allow the red light from outside to filter in as many shades. Reds, blues, and greens splash across the floor, illumuninating a large symbol in the middle with a covered lump upon it. There is only one door out, back towards the messhall, all the others boarded up and blockaded.");
			//combat
			boolean room8 = true;
			while (room8 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the ceiling.");
				Printer.println("2) Investigate the symbol.");
				Printer.println("3) Leave through west doorway(Messhall)");
				Printer.print("> ");
				choice = input.nextInt();
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
					//edit (dmg should equal sunblade)
					if (hero.getDMG() == 6) {
						Printer.println("As you approach the symbol and the lump, covered by a brown sheet, you realize the symbol is painted in the dark stains you found in the Messhall. It twists and bends, curves, and forms a circle with the lump in the center of it. Tugging the sheet off the lump, you find a body. It is bound by wrists and ankles to the ground, its chest and stomach split. This is not the body of a man. The skin is too pink, the eyes are massive, round, and pure black. There is no mouth or nose, instead a set of tendrils are limp down across its neck, almost looking like a very odd beard. It�s hands and feet bear only three digits each and despite the age of the corpse, having been here some time, it has not decayed nor been picked into. Beneath it, a pool of shadow ripples constantly.");
						Printer.println("From out of the pool, something begins to emerge.");
						//titan combat
						if (hero.getHP() > 0) {
							Printer.println("As you stand there, victorious, the light blade tugs upon your hand, jerking towards the pool.");
							boolean pool = true;
							while (pool = true) {
								Printer.println("1) Plunge the light blade into the pool");
								Printer.println("2) Cover the body and leave.");
								Printer.print("> ");
								choice = input.nextInt();
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
								else Printer.println("Invalid choice. Try again.");
							}
						}
					}
					else {
						Printer.println("As you approach the symbol and the lump, covered by a brown sheet, you realize the symbol is painted in the dark stains you found in the Messhall. It twists and bends, curves, and forms a circle with the lump in the center of it. Tugging the sheet off the lump, you find a body. It is bound by wrists and ankles to the ground, its chest and stomach split. This is not the body of a man. The skin is too pink, the eyes are massive, round, and pure black. There is no mouth or nose, instead a set of tendrils are limp down across its neck, almost looking like a very odd beard. It�s hands and feet bear only three digits each and despite the age of the corpse, having been here some time, it has not decayed nor been picked into. Beneath it, a pool of shadow ripples constantly.");
						Printer.println("From out of the pool, something begins to emerge.");
						//titain combat
						Printer.println("A stillness follows, nothing moving. You pull the sheet back over the body.");
					}
					
				}
				else Printer.println("Invalid choice try again.");
			}
		}
		//room 9 training room
		else if (room == 9) {
			Printer.println("Stepping into the training room, you find a sandy pit with wooden dummies scattered around, some up on stands and others set aside for later, in various states of damage. Sparring weapons lay about the area. There are seats lining the walls of the area.");
			//combat
			boolean room9 = true;
			while (room9 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate the room");
				Printer.println("2) Leave through north doorway(Hallway)");
				Printer.println("3) Leave through west door (East barracks)");
				Printer.print("> ");
				choice = input.nextInt();
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
				else Printer.println("Invalid choice try again.");
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
				choice = input.nextInt();
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
						Printer.println("1) Buy potion(-1 coin each)");
						if (!(hero.isCaptainChamberKey())) {
							Printer.println("2) Buy the Key(-5 coins)");
							Printer.println("3) Leave");
						}
						else Printer.println("2) Leave");
						Printer.print("> ");
						choice = input.nextInt();
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
									int amount = input.nextInt();
									Printer.println("");
									if (hero.getCoins() >= amount && amount > 0) {
										if (amount == 1) {
											Printer.println("You ask for one potion. The figure extends his hand which you grasp. A cold feeling creeps up your arm and you watch a silvery subtstance slip off your arm and up the figure's sleeve. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - amount);
											hero.addPotions(amount);

										}
										else {
											Printer.println("You ask for " + amount + " potions. The figure extends his hand which you grasp. A cold feeling creeps up your arm and you watch a silvery subtstance slip off your arm and up the figure's sleeve. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - amount);
											hero.addPotions(amount);
										}
									}
									else if (hero.getCoins() < amount && amount > 0) {
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
								if (hero.getCoins() >= 5) {
									Printer.println("You point to the key. The figure extends his hand which you grasp. A cold feeling creeps up your arm and you watch a silvery subtstance slip off your arm and up the figure's sleeve. The figure then hands you the key.");
									hero.setCaptainChamberKey(true);
									hero.setCoins(hero.getCoins() - 5);
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
									int amount = input.nextInt();
									Printer.println("");
									if (hero.getCoins() >= amount && amount > 0) {
										if (amount == 1) {
											Printer.println("You ask for one potion. The figure extends his hand which you grasp. A cold feeling creeps up your arm and you watch a silvery subtstance slip off your arm and up the figure's sleeve. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - amount);
											hero.addPotions(amount);
										}
										else {
											Printer.println("You ask for " + amount + " potions. The figure extends his hand which you grasp. A cold feeling creeps up your arm and you watch a silvery subtstance slip off your arm and up the figure's sleeve. The figure then hands you the potion.");
											hero.setCoins(hero.getCoins() - amount);
											hero.addPotions(amount);
										}
									}
									else if (hero.getCoins() < amount && amount > 0) {
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
							else Printer.println("Invalid choice. Try again.");
						}
					}
				}
				else Printer.println("Invalid choice try again.");
			}
		}
		//room 11 minor hallway
		else if (room == 11) {
			Printer.println("You enter a hallway, much like the one leading away from the Awakening room but longer and curving The walls are bare, the floor featureless.");
			//combat
			boolean room11 = true;
			while (room11 == true && hero.getHP() > 0) {
				Printer.println("1) Leave through east door(Captains Chamber's)");
				Printer.println("2) Leave through south door(Training Room)");
				Printer.print("> ");
				choice = input.nextInt();
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
				else Printer.println("Invalid choice. Try again.");
			}
		}
		//room 12 Captains Chamber
		else if (room == 12) {
			Printer.println("You enter the Captain's Chamber. The room is sparse, only a single desk with a chair behind it, cleared. A thick red carpet covers the floor and an empty bookshelf is tucked into the corner.");
			//combat
			boolean room12 = true;
			while (room12 == true && hero.getHP() > 0) {
				Printer.println("1) Investigate");
				Printer.println("2) Leave through west door(Minor Hallway)");
				Printer.print("> ");
				choice = input.nextInt();
				Printer.println("");
				if (choice == 1) {
					//replace with sunblade
					if (hero.getDMG() != 6) {
						boolean puzzle = true;
						Printer.println("You search the room before finding a strange safe tucked behind the desk. It has a six letter combination (six dials with 27 letters each) and scratched into its side is this:");
						Printer.println("\"My love.\"");
						while (puzzle == true) {
							Printer.println("1) Attempt to unlock the safe.");
							Printer.println("2) Leave it for now");
							Printer.print("> ");
							choice = input.nextInt();
							Printer.println("");
							if (choice == 1) {
								Printer.println("Enter your guess for the six letter safe code (type it out and hit enter)");
								Printer.print("> ");
								String guess = input.next();
								String answer = "Olivia";
								if (guess.equalsIgnoreCase(answer) == true) {
									Printer.println("You hear a click and swing the safe open to reveal a shimmering light. You reach in and grab it at which point your own weapon begans to glow with the same light, transforming.");
									//upgrade dmg
									puzzle = false;
								}
								else Printer.println("You enter a guess but the safe does not open.");
							}
							else if (choice == 2) {
								Printer.println("You leave.");
								puzzle = false;
							}
						}
					}
					else Printer.println("You find nothing new in this room, the safe already opened and the contents.");
				}
				else if (choice == 2) {
					Printer.println("You head back into the hallway.");
					room = 11;
					room12 = false;
				}
				else Printer.println("Invalid choice. Try again.");

			}
			
		}
		return room;
	}
		
		

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
						Printer.println("and deals " + foe.getDMG() +" !");
					}
				}
			}
		}
	
		//husk fight
		else if (type == 2) {
			generateEnemy(foe);
			Printer.println("open");
			while (hero.getHP() > 0 && foe.getHP() > 0) {
				//heros turn
				choice = processPlayerTurn(hero, foe);
				//husk turn
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
						foe.setShield(2);
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
		//mutant fight
		else if (type == 3) {
			holder = 3;
		}
		//titan fight
		else if (type == 4) {
			holder = 4;
		}
	}
	
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
						Printer.println("1) ");
						Printer.println("2) ");
						Printer.println("3) ");
						Printer.print("> ");
					}
					catch (InputMismatchException ex) {
						Printer.println("Invalid input, enter an integer (1, 2, etc)");
						input.nextLine();
					}
					
				}
				turn = false;
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
			if (one == 1) foe.setHairColor("transparent");
			else if (one == 2) foe.setHairColor("grey");
			else if (one == 3) foe.setHairColor("ashen");
			else foe.setHairColor("pure white");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (one == 1) foe.setHairLength("waist length");
			else if (one == 2) foe.setHairLength("buzz cut");
			else if (one == 3) foe.setHairLength("shoulder length");
			else {
				foe.setHairLength("shadow");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (one == 1) foe.setClothes("nothing");
			else if (one == 2) foe.setClothes("a see through uniform");
			else if (one == 3) foe.setClothes("a tattered shirt");
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
			if (one == 1) foe.setHairColor("grey");
			else if (one == 2) foe.setHairColor("stark white");
			else foe.setHairColor("red");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (one == 1) foe.setHairLength("short");
			else if (one == 2) foe.setHairLength("long");
			else if (one == 3) foe.setHairLength("tufts of");
			else {
				foe.setHairLength("no");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (one == 1) foe.setClothes("only undergarments");
			else if (one == 2) foe.setClothes("an rusty set of armor");
			else if (one == 3) foe.setClothes("a tattered uniform");
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
			if (one == 1) foe.setHairColor("muddy brown");
			else if (one == 2) foe.setHairColor("blonde");
			else if (one == 3) foe.setHairColor("pitch black");
			else foe.setHairColor("slimey");
			//hair length
			int three = (int)(Math.random()*4+1);
			if (one == 1) foe.setHairLength("strands of");
			else if (one == 2) foe.setHairLength("braided");
			else if (one == 3) foe.setHairLength("shoulder length");
			else {
				foe.setHairLength("tentacle");
				foe.setHairColor("");
			}
			//clothes
			int four = (int)(Math.random()*4+1);
			if (one == 1) foe.setClothes("scraps of metal held onto its body by rope");
			else if (one == 2) foe.setClothes("many animal furs");
			else if (one == 3) foe.setClothes("a dark black robe");
			else foe.setClothes("darkness itself");
		}
	}

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
			foe.setDMG(12);
			foe.setMana(10);
			foe.setShield(2);
		}
	}
}

class Printer {
	//for all my array printing needs
	public static void printArray(String[][] myArray) {
		for (int row = 0; row < myArray.length; row++) {
			for (int column = 0; column < myArray[row].length; column++) {
				System.out.print(myArray[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	//for all my array printing needs
	public static void printArray(int[][] myArray) {
		for (int row = 0; row < myArray.length; row++) {
			for (int column = 0; column < myArray[row].length; column++) {
				System.out.print(myArray[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void reallyprintln(String message) throws InterruptedException {
		String neato = message; 
		char[] chars = neato.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
			Thread.sleep(200);
		}
		System.out.println("");
	}


	public static void print(String hold) throws InterruptedException {
			String neato = hold;
			char[] chars = neato.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
				Thread.sleep(10);
			}
	}
	
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


class Enemy extends Character {
	private int type;
	
	public Enemy() {
		type = 4;
		setHP(10);
		setDMG(5);
		setMana(0);
		setShield(0);
		setDefendCharge(0);
		setHeight("massive");
		setColor("metal");
		setHairColor("");
		setHairLength("no");
		setClothes("nothing");
	}
	
	public Enemy(int type, int hp, int dmg, int mana, int shield, String height, String color, String hairColor, String hairLength, String clothes) {
		this.type = type;
		setHP(hp);
		setDMG(dmg);
		setMana(mana);
		setShield(shield);
		setHeight(height);
		setColor(color);
		setHairColor(hairColor);
		setHairLength(hairLength);
		setClothes(clothes);
	}
	
	//getType
	public int getType() {
		return type;
	}
	//setType
	public void setType(int type) {
		this.type = type;
	}
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
		else if (type == 4) {
			name = "titan";
		}
		return "The " + getHeight() + " " + name + " is " + getColor() + ", wearing " + getClothes() + " and has " + getHairColor() + " " + getHairLength() + " hair";
	}
}

class Player extends Character {
	private int foesFaced;
	private int potions;
	private int coins;
	private int room;
	private boolean westernBarracksKey;
	private boolean captainChamberKey;
	private int squid;
	//no arg constructor
	public Player() {
		foesFaced = 0;
		setHP(15);
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
	//getFoesFaced
	public int getFoesFaced() {
		return foesFaced;
	}
	//addFoesFaced
	public void addFoesFaced(int add) {
		foesFaced += add;
	}
	//getPotions 
	public int getPotions() {
		return potions;
	}
	//setPotions
	public void setPotions(int potions) {
		this.potions = potions;
	}
	//addPotions
	public void addPotions(int added) {
		potions += added;
	}
	//takePotions
	public void takePotions(int taken) {
		potions -= taken;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	//getRoom
	public int getRoom() {
		return room;
	}
	//setRoom
	public void setRoom(int room) {
		this.room = room;
	}
	//isWesternBarracksKey
	public boolean isWesternBarracksKey() {
		return westernBarracksKey;
	}
	//setWesternBarracksKey
	public void setWestsernBarracksKey(Boolean key) {
		westernBarracksKey = key;
	}
	
	public boolean isCaptainChamberKey() {
		return captainChamberKey;
	}
	public void setCaptainChamberKey(Boolean key) {
		captainChamberKey = key;
	}
	public int getSquid() {
		return squid;
	}
	public void setSquid(int squid) {
		this.squid = squid;
	}
	
	public String statString() {
		String hold = "HP " + getHP() + " Mana: " + getMana() + " Coins: " + coins;
		if (potions > 0) hold = hold + " Potions: " + potions;
		return hold;
	}
	
	
	
	public int turn() throws InterruptedException {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		boolean pot = false;
		if (potions > 0) pot = true;
		while (valid == false) {
			Printer.print("HP " + getHP() + " Mana: " + getMana() + " Shield: " + getShield());
			if (pot) Printer.println("Potions: " + potions);
			else Printer.println("");
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
	
	//no arg constructor (Default goblin)
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
	//constructor 
	protected Character(int hp, int dmg, int mana, int shield, String height, String color, String hairColor, String hairLength, String clothes) {
		this.hp = hp;
		this.dmg = dmg;
		this.mana = mana;
		this.shield = shield;
		this.height = height;
		this.color = color;
		this.hairColor = hairColor;
		this.hairLength = hairLength;
		this.clothes = clothes;
	}
	//getHp
	public int getHP() {
		return hp;
	}
	//sethp
	public void setHP(int hp) {
		this.hp = hp;
	}
	//getdmg
	public int getDMG() {
		return dmg;
	}
	//setdmg
	public void setDMG(int dmg) {
		this.dmg = dmg;
	}
	//getMana
	public int getMana() {
		return mana;
	}
	//setMana
	public void setMana(int mana) {
		this.mana = mana;
	}
	//getshield
	public int getShield() {
		return shield;
	}
	//setshield
	public void setShield(int shield) {
		this.shield = shield;
	}
	//add shield
	public void addShield(int shield) {
		this.shield += shield;
	}
	//take shield
	public void takeSheild(int shield) {
		this.shield -= shield;
	}
	//getDefendCharge
	public int getDefendCharge() {
		return defendCharge;
	}
	//setDefendCharge
	public void setDefendCharge(int defendCharge) {
		this.defendCharge = defendCharge;
	}
	//addDefendCharge
	public void addDefendCharge(int add) {
		defendCharge += add;
	}
	//takeDefendCharge
	public void takeDefendCharge(int take) {
		defendCharge -= take;
	}
	//get height
	public String getHeight() {
		return height;
	}
	//set height
	public void setHeight(String height) {
		this.height = height;
	}
	//get color
	public String getColor() {
		return color;
	}
	//set color
	public void setColor(String color) {
		this.color = color;
	}
	//get haircolor
	public String getHairColor() {
		return hairColor;
	}
	//set haircolor
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	//get hairlength
	public String getHairLength() {
		return hairLength;
	}
	//set hairlength
	public void setHairLength(String hairLength) {
		this.hairLength = hairLength;
	}
	//lower health
	public void takeDMG(int taken) {
		hp -= (taken-shield);
	}
	//raise health
	public void heal(int healed) {
		hp += healed;
	}
	//lower mana
	public void takeMana(int taken) {
		mana -= taken;
	}
	//raise mana
	public void addMana(int add) {
		mana += mana;
	}
	//setClothes
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public String getClothes() {
		return clothes;
	}
}