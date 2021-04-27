# PathofRememberance

## Synopsis
A mini text based adventure game.

## Motivation
I built this game because I've always enjoyed adventure games, their stories and mysteries, so being able to make some of that myself was exciting and fun.

## How to Run
To run PathofRememberance one needs simply to be able to compile .java files and run javafx, download the one provided, and run the program. The java files should all be able to access and call each other and the MapImage should be in an accessible folder for Display.java. Once running, the rest is pretty self explanatory.

## Code Example
This code is the segement that allowed for text to be displayed at a gradual pace. Instead of, like in past versions, the entire chunk of text being displayed in the same jarring instant, this method will slowly print out one letter at a time to create a more gradual and asthetically pleasing processs. It also has a listener that alters the status of an observable boolean which is used to disable input during the printing animation (to avoid overlapping animations that just make a mess).
```
private static Timeline createTimeline(String message) {
	char[] chars = message.toCharArray();
	Timeline timeline = new Timeline();
	Duration delayBetweenMessages = Duration.seconds(.045);
	if (speed.equalsIgnoreCase("slow")) delayBetweenMessages = Duration.seconds(.045);
	else if (speed.equalsIgnoreCase("fast")) delayBetweenMessages = Duration.seconds(.01);
		
	Duration frame = delayBetweenMessages;
		
	for (int i = 0; i < chars.length; i++) {
		String msg = chars[i] + "";
		timeline.getKeyFrames().add(new KeyFrame(frame, e -> text.appendText(msg)));
		frame = frame.add(delayBetweenMessages);
	}
	timeline.statusProperty().addListener((obs, oldStatus, newStatus) -> {
		readyForInput.set(newStatus == Animation.Status.RUNNING);
        });
	text.appendText("\n");
		
	return timeline;
}
```


## Tests
The test file was made using JUnit4 in Eclipse IDE for Java Developers. To run you'll need both the test and game files accesipble in the same package and a simple run should provide a positive test.

## Contributors
PathofRemeberance is an individually driven project, aided and advised on by friends, family, and instructors.

