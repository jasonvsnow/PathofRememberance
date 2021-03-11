# PathofRememberance

## Synopsis
A mini text based adventure game.

## Motivation
I built this game because I've always enjoyed adventure games, their stories and mysteries, so being able to make some of that myself was exciting and fun.

## How to Run
To run PathofRememberance one needs simply to be able to compile .java files, download the one provided, and run the program. The java files should all be able to access and call each other and the MapImage should be in an accessible folder for Display.java. One running, the rest is pretty self explanatory.

## Code Example
This code is the beginning of the method used to help mainstream the process of a character entering a room and needing the information from it. The following else if statements are in similar make, with a single display message for the appropriate room being entered. A relatively simple bit of code, but which allowed the entire project to remain neat and organized as a result.
```
public void enterRoom() {
	reRoom = hero.getRoom();
	if (reRoom == 1) {
		//Awakening room
		Display.print("\tThe awakening room is as you left it: the obsidian like table in the center, strange runes scrawled upon the floor, now empty desk tucked into the corner.\n"
			+ "1) Go to the armory\n"
			+ "\n");
	}
	else if //further code omitted for brevity's sake
```


## Tests
There are no tests provided for this version of the Path of Remembrance as there were no methods that returned consistently predictable results or any results at all.

## Contributors
PathofRemeberance is an individually driven project, aided and advised on by friends, family, and instructors.

