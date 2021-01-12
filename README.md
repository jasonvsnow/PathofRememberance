# PathofRememberance

## Synopsis
A mini text based adventure fame

## How to Run
To run PathofRememberance one needs simply to be able to compile .java files, download the one provided, and run the program.

## Code Example
This code is a very simply bit bur with simple implementation used throughout. It was an easy bur efficent answer to early issues wirh the program, allowing a map to be easily pulled up at any point with a single line of command.
```
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
```

## Tests
To run the tests, donwload the PathofRememberanceTest file. You'll need an IDE of choice thsr can run java tesrs,to have both files, declare the necessary package (I used finalProject for mine) and the tests are faiely simply run themselves.

## Contributors
PathofRemeberance is an individually driven project.
Helpes by frienda and family.
