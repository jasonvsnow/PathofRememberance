package thePath;

/**
 * <h1>Character</h1>
 * <p>This is the object class that represents the player character, allowing for its data to be stored and shared.</p>
 * <p>Created: 03/11/2021</p>
 * @author student
 *
 */
public class Character {
	private int room;
	private int hp;
	private int coins;
	private int HPpotion;
	private int attack;
	private int defense;
	private int defendBuff;
	private int attackBuff;
	private int defendDebuff;
	private int attackDebuff;
	private boolean map;
	private boolean captainKey;
	private boolean tutorial;
	
	/**
	 * This is the no-arg constructor for a character object and the only constructor as the player character will always start with the same stats.
	 * <pre>Example:
	 * {@code Character() creates the default character object
	 * }</pre>
	 */
	Character() {
		room = 0;
		hp = 40;
		coins = 0;
		HPpotion = 0;
		attack = 1;
		defense = 0;
		defendBuff = 0;
		attackBuff = 0;
		defendDebuff = 0;
		attackDebuff = 0;
		map = false;
		captainKey = false;
		tutorial = true;
	}
	/**
	 * This is the getter method for the room value of the character, which represents which room the character is in  currently.
	 * <pre>Example:
	 * {@code char.getRoom() may return 1-10, 98, 99, 100, or 101
	 * }</pre>
	 * @return room (int; the current room the character is in)
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * This is the setter method for the room value of the character object.
	 * <pre>Example:
	 * {@code char.setRoom(1) will set the room value to 1
	 * }</pre>
	 * @param room (int; the current room the character is in)
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	/**
	 * This is the getter method for the HP value of the character.
	 * <pre>Example:
	 * {@code char.getHP() will return the current HP value, 
	 * which typically is between -11 or 59
	 * }</pre>
	 * @return hp (int; the amount of health the character has)
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * This is the setter method for the HP value of the character.
	 * <pre>Example:
	 * {@code char.setHP(29) will set the HP to 29
	 * }</pre>
	 * @param hp (int; the value to set the health value to)
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}


	/**
	 * This is  the getter method for the coins of the character.
	 * <pre>Example:
	 * {@code char.getCoins() may return 0 or higher, 
	 * as there is no upper limit to the coins set anywhere 
	 * and the character could, hypothetically, gather infinite coins.
	 * }</pre>
	 * @return coins (int; the amount of coins the character has)
	 */
	public int getCoins() {
		return coins;
	}
	/**
	 * This is the setter method for the coins of the character.
	 * <pre>Example:
	 * {@code char.setCoins(8) will set the coin value ot 8
	 * }</pre>
	 * @param coins (int; the number of coins the character will have now)
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}
	/**
	 * This is the getter method for the number of health potions the character has.
	 * <pre>Example:
	 * {@code char.getHPPotion() may return 0 or higher, as there is no upper limit to potions held.
	 * }</pre>
	 * @return HPpotion (int; the number of health potions the character has)
	 */
	public int getHPPotion() {
		return HPpotion;
	}
	/**
	 * This is the setter method for the number of health potions the character has.
	 * <pre>Example:
	 * {@code char.setHPPotion(2) will set number of health potions to 2
	 * }</pre>
	 * @param potions (int; the number of health potions the character will now have)
	 */
	public void setHPPotion(int potions) {
		HPpotion = potions;
	}

	/**
	 * This is the getter method for the attack value of the character, which is the damage they do with an attack.
	 * <pre>Example:
	 * {@code char.getAttack() will return 1, 2, 5, or 10 
	 * }</pre>
	 * @return attack (int; the damage value of the character)
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * This is the setter method for the attack value of the character.
	 * <pre>Example:
	 * {@code char.setAttack(2) will set the attack value to 2
	 * }</pre>
	 * @param attack (int; the current damage value of the character)
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/**
	 * This is the getter method for the characters current defense
	 * <pre>Example:
	 * {@code char.getDefense() will return 0, 2, 3, 5, or 8 
	 * depending on what the character has found or what action was taken in combat.
	 * }</pre>
	 * @return defense (int; the current amount of damage to reduce incoming attacks by)
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * This is the setter method for the characters current defense
	 * <pre>Example:
	 * {@code char.setDefense(3) will set the defense value to 3
	 * }</pre>
	 * @param defense (int; the amount future attacks should be reduced by at the time of setting this value)
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	
	/**
	 * This is the getter method for the defendBuff value of the character, which is a counter used to determine how long a buff has left 
	 * (also used to determine if it is active at all)
	 * <pre>Example:
	 * {@code heor.getDefendBuff() might return 0-3 depending on how many turns the buff has left
	 * }</pre>
	 * @return (int; the current rounds left on the defend buff)
	 */
	public int getDefendBuff() {
		return defendBuff;
	}
	/**
	 * This is the setter method for the defendBuff value.
	 * <pre>Example:
	 * {@code hero.setDefendBuff(3) will set the defendBuff value to 3
	 * }</pre>
	 * @param defendBuff (int; the value to set defendBuff to)
	 */
	public void setDefendBuff(int defendBuff) {
		this.defendBuff = defendBuff;
	}
	
	/**
	 * This is the getter method for the attackBuff value of the character, which is a counter used to determine how long a buff has left 
	 * (also used to determine if it is active at all)
	 * <pre>Example:
	 * {@code heor.getAttackBuff() might return 0-3 depending on how many turns the buff has left
	 * }</pre>
	 * @return (int; the current rounds left on the attack buff)
	 */
	public int getAttackBuff () {
		return attackBuff;
	}
	/**
	 * This is the setter method for the attackBuff value.
	 * <pre>Example:
	 * {@code hero.setAttackBuff(3) will set the attackBuff value to 3
	 * }</pre>
	 * @param attackBuff (int; the value to set attackBuff to)
	 */
	public void setAttackBuff(int attackBuff) {
		this.attackBuff = attackBuff;
	}
	
	/**
	 * This is the getter method for the defendDebuff value which determines if the defendDebff is active or not
	 * <pre>Example:
	 * {@code hero.getDefendDebuff() might return 0 or 1 (0 is inactive, 1 is active)
	 * }</pre>
	 * @return (int; 1 or 0, if the defendDebuff is active or inactive)
	 */
	public int getDefendDebuff() {
		return defendDebuff;
	}
	/**
	 * This is the setter method for the defendDebuff value
	 * <pre>Example:
	 * {@code hero.setDefendDebuff(1) will set the defendDebuff value to 1
	 * }</pre>
	 * @param defendDebuff (int; the value to set defendDebuff to)
	 */
	public void setDefendDebuff(int defendDebuff) {
		this.defendDebuff = defendDebuff;
	}
	
	/**
	 * This is the getter method for the attackDebuff value which determines if the attackDebuff is active or not
	 * <pre>Example:
	 * {@code hero.getAttackDebuff() might return 0 or 1 (0 is inactive, 1 is active)
	 * }</pre>
	 * @return (int; 1 or 0, if the attackDebuff is active or inactive)
	 */
	public int getAttackDebuff() {
		return attackDebuff;
	}
	/**
	 * This is the setter method for the attackDebuff value
	 * <pre>Example:
	 * {@code hero.setAttackDebuff(1) will set the attackDebuff value to 1
	 * }</pre>
	 * @param attackDebuff (int; the value to set attackDebuff to)
	 */
	public void setAttackDebuff(int attackDebuff) {
		this.attackDebuff = attackDebuff;
	}
	

	/**
	 * This is the getter method for the map value, which acts as a key checker as well as allows the user to access the map.
	 * <pre>Example:
	 * {@code char.isMap() will return true or false
	 * }</pre>
	 * @return map (boolean; whether or not the character has picked up the map)
	 */
	public boolean isMap() {
		return map;
	}
	/**
	 * This is the setter method for the map value. It also calls the setMap method in display to allow access to the map.
	 * <pre>Example:
	 * {@code char.setMap(true) will set the map value to true.
	 * }</pre>
	 * @param map (boolean; whether or not the character now has the map or does not)
	 */
	public void setMap(boolean map) {
		this.map = map;
		Display.setMap(!map);
	}
	/**
	 * This is the getter method for the captainKey value, which indicates if the player has access to the Captain's Chambers.
	 * <pre>Example:
	 * {@code char.isCaptainKey() will return true or false
	 * }</pre>
	 * @return captainKey (boolean; whether the character has access to the Captain's Chambers or not)
	 */
	public boolean isCaptainKey() {
		return captainKey;
	}
	/**
	 * This is the setter method for the captainKey value.
	 * <pre>Example:
	 * {@code char.setCaptainKey(true) will typically set the captainKey value to true
	 * }</pre>
	 * @param captainKey (boolean; determines if the character now has the key to the Captain's Chambers or not)
	 */
	public void setCaptainKey(boolean captainKey) {
		this.captainKey = captainKey;
	}
	/**
	 * This is the getter method for the tutorial value which determines if the player needs to go through the tutorial combat when entering the armory from the awakening room.
	 * <pre>Example:
	 * {@code char.isTutorial() will return true or false
	 * }</pre>
	 * @return tutorial (boolean; whether or not the character is in the tutorial stage/has completed it in the current run)
	 */
	public boolean isTutorial() {
		return tutorial;
	}
	/**
	 * This is the setter method for the tutorial value of the character.
	 * <pre>Example:
	 * {@code char.setTutorial(false) will set the tutorial value to false
	 * }</pre>
	 * @param tutorial (boolean; whether the character will need to go through the tutorial upon entering the armory from the awakening room)
	 */
	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	
}
