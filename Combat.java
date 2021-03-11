package thePath;

/**
 * <h1>Comabt</h1>
 * <p>This class processes combat and essentiall runs the loop made in Game. It holds an enemy object that will be pitted against the player until one perishes. </p>
 * <p>Created: 02/11/2021</p>
 * @author Jason Snow
 */
public class Combat {
	private Enemy foe;
	private int foeType;
	private boolean init;
	int hold;

	/**
	 * This is the no arg constructor for a combat, which sets a blank template.
	 * <pre>Example:
	 * {@code Combat() makes a default Combat object.
	 * }</pre>
	 */
	Combat() {
		foe = new Enemy();
		foeType = 0;
		init = false;
		hold = 1;
	}
	/**
	 * This is the method that handles each round of a fight. First, it checks if combat has already been started. If not, it will generate the proper enemy for that fight and store it.
	 * It then handles the current round of a fight by calling the processPlayerTurn method and returns an end result.
	 * The end result is one of four outcomes which include: the player and enemy both took turns but neither died so combat will continue, the enemy died, the player died, or the player attempted to use magic without sufficient mana and will be given the chance to take their turn again.
	 * One one of the combatants have died, upon that end result the fight is determined to have ended so the next time this method is called it will start a new fight.
	 * <pre>Example:
	 * {@code combat.fight(hero, 1, 1) will return a continue or death. The hero is the character, 
	 * the first 1 is the choice to attack, the second 1 is the type of enemy.
	 * }</pre>
	 * @param hero (Character; the character object that will be fighting the enemy)
	 * @param choice (int; the choice the player has made for their current turn of the fight)
	 * @param type (int; the type of enemy the hero is fighting)
	 * @return (int; the result of the current round of combat (continue, player died, enemy died, player falsely attempted magic)
	 */
	public int fight(Character hero, int choice, int type) {
		if (!init) {
			foeType = type;
			if (type == 0) foe = new Enemy();
			else if (type == 1) foe = new Enemy(1);
			else if (type == 2) foe = new Enemy(2);
			init = true;
		}
		hold = processPlayerTurn(hero, choice);
		if (hold == 0) {
			init = false;
			return 0;
		}
		else if (hold == 1) {
			Display.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 1;
		}
		else if (hold == 2) {
			Display.print("You won!\n");
			hero.setDefense(1);
			if (foe.getReward() > 1) Display.print("You find " + foe.getReward() + " coins on the enemy.\n");
			else Display.print("You find " + foe.getReward() + " coin on the enemy.\n");
			hero.setCoins(hero.getCoins()+foe.getReward());
			init = false;
			return 2;
		}
		else {
			Display.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 3;
		}
		
	}
	/**
	 * This method is called by fight to determine the result of the choice the character made and then call the proccessEnemyTurn method to 
	 * determine the result of the enemys actions (assuming the enemy is alive to take a turn). It then returns one of the four possible end results for each round of a fight.
	 * <pre>Example:
	 * {@code processPlayerTurn(hero, 1) will either return a continue or death, as the character has chosen to attack this turn and may kill the enemy or be killed.
	 * }</pre>
	 * @param hero (Character; the character object in this fight)
	 * @param choice (int; the choice the user made in this round of the fight)
	 * @return (int; the result of the players choices and enemies actions, if any)
	 */
	public int processPlayerTurn(Character hero, int choice) {
		if (choice == 1) {
			int dealt = hero.getAttack()-foe.getDefense();
			if (dealt < 0) dealt = 0;
			Display.print("You attack, dealing " + dealt + " damage!\n");
			foe.setHP(foe.getHP()-dealt);
		}
		if (choice == 2) {
			Display.print("You defend!\n");
			//edit 
			if (hero.getAttack() == 5) hero.setDefense(5);
			else if (hero.getAttack() == 10) hero.setDefense(8);
			else hero.setDefense(3);
			hero.setDefendCharge(4);
		}
		if (choice == 3) {
			if (hero.getMana() >= 2) {
				Display.print("You hold the ball of light in your hand out and it explodes, burning the enemy for 7 damage! The ball then relights. \n");
				foe.setHP(foe.getHP()-7);
				hero.setMana(hero.getMana()-4);
			}
			else {
				Display.print("You don't have enough mana for that!\n");
				Display.print(""
						+ "1) Attack\n"
						+ "2) Defend\n"
						+ "3) Use Magic\n"
						+ "\n");
				return 3;
			}
		}
		
		if (hero.getDefendCharge() > 0) {
			hero.setDefendCharge(hero.getDefendCharge()-1);
		}
		else {
			if (hero.getAttack() == 5) hero.setDefense(2);
			else if (hero.getAttack() == 10) hero.setDefense(5);
			else hero.setDefense(0);
		}
		if (foe.getHP() > 0) {
			processEnemyTurn(hero);	
		}
		else {
			return 2;
		}
		
		
		if (hero.getHP() > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	/**
	 * This method handles the enemies turns. It checks the stored foe type in the combat object and then has the enemy act appropriately, with sometimes random results. It returns nothing as the only thing that needs to be checked after this is the heros health value which is independent of this method.
	 * <pre>Example:
	 * {@code combat.processEnemyTurn(hero) will have the enemy take a turn against the hero and ultimately affect the hero hp value, enemy mana value, or enemy defense value.
	 * }</pre>
	 * @param hero (Character; the character in this fight against the foe being represented by this method)
	 */
	public void processEnemyTurn(Character hero) {
		if (foeType == 0) {
			int dealing = foe.getAttack() - hero.getDefense();
			if (dealing < 0) dealing = 0;
			Display.print("\nThe wretched green thing screams and slashes at you with black claws, dealing " + dealing + " damage.\n");
			hero.setHP(hero.getHP() - dealing);
		}
		else if (foeType == 2) {
			int ran = (int)(Math.random()*3);
			if (ran == 0 && foe.getMana() > 0) {
				Display.print("\nThe creature slams its spikey hand into the ground and beneath you spikes erupt, slamming into you and piercing your defenses, dealing 7 damage to you while also reinforcing the creatures armor.\n");
				foe.setMana(foe.getMana()-1);
				foe.setDefense(foe.getDefense()+1);
				hero.setHP(hero.getHP()-7);
			}
			else {
				int dealing = foe.getAttack() - hero.getDefense();
				if (dealing < 0) dealing = 0;
				Display.print("\nThe creature slashes twice with its claws, dealing " + dealing + " damage.\n");
				
			}
		}
		else if (foeType == 1) {
			int ran = (int)(Math.random()*3);
			if (ran == 0) {
				int dealing = foe.getAttack() - hero.getDefense();
				if (dealing < 0) dealing = 0;
				Display.print("\nThe monster slashes with its sword, dealing " + dealing + " damage.\n");
				hero.setHP(hero.getHP() - dealing);
			}
			else {
				if (foe.getDefense() < 2) {
					foe.setDefense(2);
					Display.print("The creature snarls and more spikes suddenly burst out from its skin, hardening its defense.\n");
				}
				else {
					int dealing = foe.getAttack() - hero.getDefense();
					if (dealing < 0) dealing = 0;
					Display.print("\nThe monster slashes with its sword, dealing " + dealing + " damage.\n");
					hero.setHP(hero.getHP() - dealing);
				}
			}
		}
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
	
}

