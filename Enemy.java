package thePath;
/**
 * <h1>Enemy</h1>
 * <p>This class makes Enemy objects to be used in combats.</p>
 * <p>Created: 03/11/2021</p>
 * @author Jason Snow
 */
public class Enemy {
	private int hp;
	private int mana;
	private int attack;
	private int defense;
	private int reward;
	/**
	 * This is the no-arg constructor of the enemy object.
	 * <pre>Example:
	 * {@code Enemy() will make a default enemy object
	 * }</pre>
	 */
	Enemy() {
		hp = 4;
		mana = 0;
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
		if (type == 1) {
			hp = 10;
			mana = 0;
			attack = 10;
			defense = 1;
			reward = 3;
		}
		if (type == 2) {
			hp = 18;
			mana = 4;
			attack = 15;
			defense = 3;
			reward = 5;
		}
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
	 * The getter method for the enemy's mana value.
	 * <pre>Example:
	 * {@code foe.getMana() may return 0-5
	 * }</pre>
	 * @return mana (int; the current enemy's mana value)
	 */
	public int getMana() {
		return mana;
	}
	/**
	 * The setter method for the enemy's mana value.
	 * <pre>Example:
	 * {@code foe.setMana(1) sets the enemy's mana value to 1
	 * }</pre>
	 * @param mana (int; the vaulue to set the enemy's mana value to)
	 */
	public void setMana(int mana) {
		this.mana = mana;
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

