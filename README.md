# PathofRememberance

## Synopsis
A mini text based adventure game.

## Motivation
I built this game because I've always enjoyed adventure games, their stories and mysteries, so being able to make some of that myself was exciting and fun.

## How to Run
To run PathofRememberance one needs simply to be able to compile .java files, download the one provided, and run the program. The program will prompt you when input is needed until you enter valid input, so playing the game shouldn't be too hard!

## Code Example
This is the code that, once the user is past the inital 'tutorial' keeps the game running until the player reaches the end or gives up after dying.
```
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
			Printer.println("");
		}
		catch (InputMismatchException ex) {
			Printer.println("");
			input.nextLine();
			choice = 0;
		} 
		if (choice == 1) {
			Printer.println("Opening your eyes, you find a simple wooden door before you. You push it open and step out, ready to try again.");
			hero.setHP(40);
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
		else Printer.println("Invalid choice. Try again.");
	}
}
```

## Tests
The test file was made in Eclipse IDE for Java Developers. To actually run 

## Contributors
PathofRemeberance is an individually driven project, aided and advised on by friends, family, and instructors.
