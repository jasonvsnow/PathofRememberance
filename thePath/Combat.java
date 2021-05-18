package thePath;

/**
 * <h1>Comabt</h1>
 * <p>This class processes combat and essentially runs the loop made in Game. It holds an enemy object that will be pitted against the player until one perishes. </p>
 * <p>Created: 02/11/2021</p>
 * @author Jason Snow
 */
public class Combat {
	private Enemy foe;
	private int foeType;
	private boolean init;
	private int result;
	private String textToPrint = "";
	private int decision;
	private boolean magicUsed;
	//magic choice, attack choice 
	private int[] info = {0, 0};

	/**
	 * This is the no arg constructor for a combat, which sets a blank template.
	 * <pre>Example:
	 * {@code Combat() makes a default Combat object.
	 * }</pre>
	 */
	Combat() {
		foeType = 0;
		init = false;
		result = 1;
		decision = 0;
		magicUsed = false;
	}
	
	
	public int fight(Character hero, int choice, int type) {
		/*
		 * 0 = player death
		 * 1 = turn finished
		 * 2 = player was victorious
		 * 3 = player is attacking
		 * 4 = player is using magic
		 * 5 = invalid input
		 */
		
		//check if combat is continuation or new
		if (!init) {
			foeType = type;
			if (type == 0) foe = new Enemy();
			else foe = new Enemy(type);
			init = true;
		}
		 //have the player act
		result = processPlayerTurn(hero, choice);
		
		//process the result of a turn
		if (result == 0) {
			//the player has lost and perished
			init = false;
			return 0;
		}
		else if (result == 1) {
			//combat continues
			toPrint("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			
			return 1;
		}
		else if (result == 2) {
			//player victory
			toPrint("You won!\n");
			if (hero.getAttack() == 5) hero.setDefense(5);
			else if (hero.getAttack() == 10) hero.setDefense(8);
			else hero.setDefense(3);
			if (foe.getReward() > 1) toPrint("You find " + foe.getReward() + " coins on the enemy.\n");
			else toPrint("You find " + foe.getReward() + " coin on the enemy.\n");
			hero.setCoins(hero.getCoins()+foe.getReward());
			init = false;
			
			return 2;
		}
		else if (result == 3){
			//additional input to complete attack required
			return 3;
		}
		else if (result == 4) {
			//additional input to complete magic required
			return 4;
		}
		else {
			//invalid error, turn incomplete, etc.
			return 5;
		}

		
	}

	
	public int processPlayerTurn(Character hero, int choice) {
		//player choice making has just started, must choose base action
		if (decision == 0) {
			if (choice == 1) {
				//attack
				decision = 1; 
				return 3;
			}
			else if (choice == 2) {
				//attack with magic
			}
			else if (choice == 3) {
				//apply a buff 
				decision = 3;
				return 4;
			}
			else if (choice == 4) {
				//apply a debuff
				decision = 4;
				return 4;
			}
		}
		//player has chosen to attack
		else if (decision == 1) {
			if (choice == 1) {
				//player has chosen to make a standard attack
			}
			else if (choice == 2) {
				//player has chosen to make a quick attack
			}
			else if (choice == 3) {
				//player has chosen to make a heavy attack
			}
			else {
				//invalid input
			}
		}
		//player has chosen to buff themselves
		else if (decision == 3) {
			if (choice == 1) {
				//player has chosen to buff their defense
			}
			else if (choice == 2) {
				//player has chosen to buff their attack
			}

			else {
				//invalid input
			}
		}
		//player has chosen to debuff the enemy
		else if (decision == 4) {
			if (choice == 1) {
				//player has chosen to debuff the enemy's defense
			}
			else if (choice == 2) {
				//player has chosen to debuff the enemy's attack
			}

			else {
				//invalid input
			}
		}
		//reset defense and attack once counters run out
		
		
		
		
		
		
		//find the result of the enemy turn if alive
		if (foe.getHP() > 0) {
			processEnemyTurn(hero);	
		}
		//end combat if foe is defeated
		else {
			return 2;
		}
		
		//post enemy turn, find out if hero is still alive
		if (hero.getHP() > 0) {
			//hero alive, continue combat
			return 1;
		}
		else {
			//hero has perished
			return 0;
		}
	}

	public void processEnemyTurn(Character hero) {
		
		
	}

	
	
	/**
	 * This is the getter method for the init value (short for initiative) which represents whether a fight has started or not.
	 * In truth, the value represents whether or not the current round is a round after the first.
	 * and there are varied actions for the starts of fights vs the remainder of it, so this allows the 
	 * <pre>Example:
	 * {@code combat.isInit() will return true or false
	 * }</pre>
	 * @return init (boolean; whether the current call of this method is a round of combat after the first or not)
	 */
	public boolean isInit() {
		return init;
	}
	/**
	 * This is the setter method for the init value, used to set the value after the first round of a fight starts or after a fight ends.
	 * <pre>Example:
	 * {@code combat.isInit(false) will set the init value to false.
	 * }</pre>
	 * @param init (boolean; whether a started fight is happening or not)
	 */
	public void setInit(boolean init) {
		this.init = init;
	}
	/**
	 * This is the getter method for the current foeType stored in the combat object, typically used to set the same value for a fight after it has begun.
	 * <pre>Example:
	 * {@code combat.getFoeType() might return 0-2
	 * }</pre>
	 * @return foeType (int; the type of foe being fought)
	 */
	public int getFoeType() {
		return foeType;
	}
	/**
	 * This method is used to gather all the text this class will need displayed and store it in a variable until it is needed.
	 * <pre>Example:
	 * {@code toPrint("Hello") will append "Hello" to the variable textToPrint.
	 * }</pre>
	 * @param message (String; message to add to the storage string)
	 */
	public void toPrint(String message) {
		textToPrint += message;
	}
	/**
	 * This method allows other classes to access the storage string in this method to print it. It is the getter.
	 * <pre>Example:
	 * {@code getTextToPrint() returns the textToPrint string
	 * }</pre>
	 * @return textToPrint (String; all the stored messages to print from this class)
	 */
	public String getTextToPrint() {
		return textToPrint;
	}
	/**
	 * This method is used to clear all the stored text. It must be called after getTextToPrint is called or else text will be repeated.
	 * <pre>Example:
	 * {@code clear() will set textToPrint to "", essentially empty.
	 * }</pre>
	 */
	public void clear() {
		textToPrint = "";
	}
	
}

