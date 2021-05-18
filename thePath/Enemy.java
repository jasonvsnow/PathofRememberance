package thePath;
/**
 * <h1>Enemy</h1>
 * <p>This class makes Enemy objects to be used in combats.</p>
 * <p>Created: 03/11/2021</p>
 * @author Jason Snow
 */
public class Enemy {
	private int type;
	private int hp;
	private int attack;
	private int defense;
	private int reward;
	private int buffAttack;
	private int buffDefense;
	private int debuffDefense;
	private int debuffAttack;
	/**
	 * This is the no-arg constructor of the enemy object.
	 * <pre>Example:
	 * {@code Enemy() will make a default enemy object
	 * }</pre>
	 */
	Enemy() {
		type = 0;
		hp = 4;
		attack = 6;
		defense = 0;
		reward = 1;
	}
	/**
	 * This is an argument constructor that creates predefined types of enemy objects based on the input.
	 * <pre>Example:
	 * {@code Enemy(1) will make an enemy object of type 1
	 * }</pre>
	 * @param type (int; the type of enemy to construct)
	 */
	Enemy(int type) {
		this.type = type;
		if (type == 1) {
			hp = 20;
			attack = 8;
			defense = 3;
			reward = 3;
		}
		else if (type == 2) {
			hp = 15;
			attack = 12;
			defense = 1;
			reward = 5;
		}
		else if (type == 3) {
			hp = 25;
			attack = 9;
			defense = 4;
			reward = 100;
			
		}
	}
	public String enemyAction(Character hero, int[] info) {
		String toPrint = "";
		String choice = enemyBehavior(hero, info);
		//find action
		if (choice.equalsIgnoreCase("heavy attack")) {
			//assess action for that type and implement results
			if (type == 1) {
				
			}
			else if (type == 2) {
				
			}
			else if (type == 3) {
				
			}
		}
		else if (choice.equalsIgnoreCase("standard attack")) {
	
		}
		
		
		return toPrint;
	}
	
	public String enemyBehavior(Character hero, int[] info) {
		String choice = "";
		int heavyAttack = 0;
		int standardAttack = 0;
		int quickAttack = 0;
		int defenseDebuff = 0;
		int attackDebuff = 0;
		int defenseBuff = 0;
		int attackBuff = 0;
		int dispellDebuff = 0;
	
		
		
		
		
		
		
		if (type == 3) {
			//consider what magic, if any, the player just used
			if (info[0] == 0) {
				//no magic
				heavyAttack += 1;
				standardAttack += 1;
				quickAttack += 1;
			}
			else if (info[0] == 1) {
				//used magic blast, defense and health lowered, took damage
				
				
			}
			//other options later considered by player's active magic
			
			
			
			//consider what attack the player just used
			if (info[1] == 1) {
				//standard attack
			}
			else if (info[1] == 2 ) {
				//quick attack
			}
			else {
				//heavy attack
			}
			
			//consider what magic the character has active
			
			
			
			//consider current health
			
			//consider current defense
			
			//consider current attack
			
			//consider buffAttack
			if (buffAttack == 0) {
				//attack buff inactive
			}
			else {
				
			}
			//consider buffDefnese
			if (buffDefense == 0) {
				//defense buff inactive
			}
			else {
				
			}
			//consider debuffDefense
			if (debuffDefense == 0) {
				//debuffDefense inactive
			}
			else {
				
			}
			//consider debuffAttack
			if (debuffAttack == 0) {
				//debuffAttack inactive
			}
			else {
				
			}	
			//assess priority	
		}
		return choice;
	}
	
	
	/**
	 * The getter method for the enemy's health value.
	 * <pre>Example:
	 * {@code foe.getHP() will return -5 to 18, depending on type and events of combat.
	 * }</pre>
	 * @return hp (int; the current health value of the enemy)
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * The setter method for the enemy's health value.
	 * <pre>Example:
	 * {@code foe.setHP(10) will set the enemy's health value to 10
	 * }</pre>
	 * @param hp (int; the value to set the enemy health to)
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}


	/**
	 * The getter method for the enemy's attack value, how much damage they can do.
	 * <pre>Example:
	 * {@code foe.getAttack() will return 6-15 which represents how much damage an enemy can do.
	 * }</pre>
	 * @return attack (int; the damage an enemy can do in an attack)
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * The getter method for the enemy's defense value, how much damage it absorbs from attacks.
	 * <pre>Example:
	 * {@code foe.getDefense() might return 0-7
	 * }</pre> 
	 * @return defense (int; the current defense value of the enemy)
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * The setter method for the enemy's defense value.
	 * <pre>Example:
	 * {@code foe.setDefense(4) will set the enemies defense to 4
	 * }</pre>
	 * @param defense (int; the value to set the defense to)
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	/**
	 * The getter method for the enemy reward- how much gold the user gets on killing one.
	 * <pre>Example:
	 * {@code foe.getReward() may return 1, 3, or 5)
	 * }</pre>
	 * @return reward (int; the number of coins to give the player for the defeat of the enemy)
	 */
	public int getReward() {
		return reward;
	}
}

