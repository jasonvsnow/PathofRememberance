# PathofRememberance

## Synopsis
A mini text based adventure game.

## Motivation
I built this game because I've always enjoyed adventure games, their stories and mysteries, so being able to make some of that myself was exciting and fun.

## How to Run
I built and ran Path of Rememberance in the Eclipse IDE. Files in pathProject were simply in the project folder, those in src where in the src folder, and those in thePath were in thePath package folder. MapImage.png must be accesible to the package the java files are stored in from runtime, the other images must be accesible to the .css file which must be accesible to the java files. 

Once the game is running, it's rather self explanatory. 

## Code Example
This code is the resize method I used to adjust the GUI whenever the player affected it (changed text settings, changed font size settings, adjusted the window size, etc.) as many of these actions affected so many parts it was most practical to create a handler like method which could be called should any adjustment need to be made and thus all adjustments that needed to be made surely would be- as they all were.
```
	public void resize() {
		Double modifier = 40-buttonSize.getValue();
		Double setbtSize = height.get()/modifier;
		if (setbtSize < 13) setbtSize = 13.0;
		if (width.get() == 650) 
			if (setbtSize > 60) setbtSize = 60.0;
		bt1.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		bt2.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		bt3.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		bt4.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		hppot.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		start.setFont(Font.font(text.getFont().getFamily(), setbtSize));
		
		Double mod = 60 - statSize.getValue();
		Double size = width.get()/mod;
		stats.setFont(text.getFont().getFamily(), size);
		
		int testing = 14;
		int holder1 = (int)(height.get()-500)/20;
		int holder2 = (int)(width.get()-650)/30;
		if (holder1 > holder2) testing += holder2;
		else testing += holder1;
		String holderTest = "-fx-font-size: " + testing
				+ "; -fx-font-family: " + text.getFont().getFamily();
		adventureTab.setStyle(holderTest);
		mapTab.setStyle(holderTest);
		settingsTab.setStyle(holderTest);
		
		statSizeSettings.setMinHeight(height.get()/6);
		buttonSizeSettings.setMinHeight(height.get()/6);
		textSizeSettings.setMinHeight(height.get()/6);
		textFontSettings.setMinHeight(height.get()/6);
		textSpeedSettings.setMinHeight(height.get()/6);
		
		statSize.setPrefWidth(400 + ((width.get()-650)/4));
		buttonSize.setPrefWidth(400 + ((width.get()-650)/4));
		textSize.setPrefWidth(400 + ((width.get()-650)/4));
		
		String offset = "-fx-background-position: left 50% top -" + height.get()/8.25 + ";"
				+ "-fx-background-size: " + (100 - ((width.get()-650)/28.4)) + "% 195%;";

		statSizeSettings.setStyle(offset);
		buttonSizeSettings.setStyle(offset);
		textSizeSettings.setStyle(offset);
		textFontSettings.setStyle(offset);
		textSpeedSettings.setStyle(offset);
		
		fontHolder.setMinWidth(width.get()/2.7);
		speedHolder.setMinWidth(width.get()/2.7);
		
		String labeltextSize = "-fx-font-size: " + (12 + ((height.get()-500)/55)) 
				+ "; -fx-font-family: " + text.getFont().getFamily();
		statSizelbl.setStyle(labeltextSize);
		bttnSize.setStyle(labeltextSize);
		txtSize.setStyle(labeltextSize);
		txtFont.setStyle(labeltextSize);
		txtSpeed.setStyle(labeltextSize);
		
		font1.setStyle( "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: Arial");
		font2.setStyle( "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: Comic Sans MS");
		font3.setStyle( "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: Courier");
		font4.setStyle( "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: Times New Roman");
		font5.setStyle( "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: Verdana");
		
		String rdbtStyle = "-fx-font-size: " + (12 + ((height.get()-500)/55))
				+ "; -fx-font-family: " + text.getFont().getFamily();
		slowText.setStyle(rdbtStyle);
		fastText.setStyle(rdbtStyle);
		instantText.setStyle(rdbtStyle);
		
		tabPane.setTabMinHeight(height.get()/15);
		tabPane.setTabMaxHeight(height.get()/15);
		tabPane.setTabMinWidth(width.get()/3.48);
	}
```


## Tests
The test file was made using JUnit4 in Eclipse IDE for Java Developers. To run you'll need both the test and game files accesipble in the same package and a simple run should provide a positive test.

## Contributors
PathofRemeberance is an individually driven project, aided and advised on by friends, family, and instructors.

