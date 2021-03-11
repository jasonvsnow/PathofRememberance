package thePath;

/**
 * 
 * @author student
 *
 */
public class Character {
	private int room;
	private int hp;
	private int mana;
	private int coins;
	private int HPpotion;
	private int MNpotion;
	private int attack;
	private int defense;
	private int defendCharge;
	private boolean map;
	private boolean captainKey;
	private boolean tutorial;
	
	/**
	 * 
	 */
	Character() {
		room = 0;
		hp = 50;
		mana = 20;
		coins = 0;
		HPpotion = 2;
		MNpotion = 0;
		attack = 1;
		defense = 0;
		defendCharge = 0;
		map = false;
		captainKey = false;
		tutorial = true;
	}
	/**
	 * 
	 * @return
	 */
	public int getRoom() {
		return room;
	}
	/**
	 * 
	 * @param room
	 */
	public void setRoom(int room) {
		this.room = room;
	}
	/**
	 * 
	 * @return
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * 
	 * @param hp
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}
	/**
	 * 
	 * @return
	 */
	public int getMana() {
		return mana;
	}
	/**
	 * 
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}
	/**
	 * 
	 * @return
	 */
	public int getCoins() {
		return coins;
	}
	/**
	 * 
	 * @param coins
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}
	/**
	 * 
	 * @return
	 */
	public int getHPPotion() {
		return HPpotion;
	}
	/**
	 * 
	 * @param potions
	 */
	public void setHPPotion(int potions) {
		HPpotion = potions;
	}
	/**
	 * 
	 * @return
	 */
	public int getMNPotion() {
		return MNpotion;
	}
	/**
	 * 
	 * @param potions
	 */
	public void setMNPotion(int potions) {
		MNpotion = potions;
	}
	/**
	 * 
	 * @return
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * 
	 * @param attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	/**
	 * 
	 * @return
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * 
	 * @param defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	/**
	 * 
	 * @return
	 */
	public int getDefendCharge() {
		return defendCharge;
	}
	/**
	 * 
	 * @param defendCharge
	 */
	public void setDefendCharge(int defendCharge) {
		this.defendCharge = defendCharge;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isMap() {
		return map;
	}
	/**
	 * 
	 * @param map
	 */
	public void setMap(boolean map) {
		this.map = map;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isCaptainKey() {
		return captainKey;
	}
	/**
	 * 
	 * @param captainKey
	 */
	public void setCaptainKey(boolean captainKey) {
		this.captainKey = captainKey;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isTutorial() {
		return tutorial;
	}
	/**
	 * 
	 * @param tutorial
	 */
	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	
	
	
	
}
