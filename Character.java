package thePath;

public class Character {
	private int room;
	private int hp;
	private int mana;
	private int coins;
	private int potions;
	private int attack;
	private int defense;
	private int defendCharge;
	private boolean map;
	private boolean captainKey;
	private boolean basementKey;
	private boolean tutorial;
	
	Character() {
		room = 0;
		hp = 50;
		mana = 20;
		coins = 0;
		potions = 2;
		attack = 1;
		defense = 1;
		defendCharge = 0;
		map = false;
		captainKey = false;
		basementKey = false;
		tutorial = true;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	public int getHP() {
		return hp;
	}
	public void setHP(int hp) {
		this.hp = hp;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public int getPotions() {
		return potions;
	}
	public void setPotions(int potions) {
		this.potions = potions;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getDefendCharge() {
		return defendCharge;
	}
	public void setDefendCharge(int defendCharge) {
		this.defendCharge = defendCharge;
	}
	public boolean isMap() {
		return map;
	}
	public void setMap(boolean map) {
		this.map = map;
	}
	public boolean isCaptainKey() {
		return captainKey;
	}
	public void setCaptainKey(boolean captainKey) {
		this.captainKey = captainKey;
	}
	public boolean isBasementKey() {
		return basementKey;
	}
	public void setBasementKey(boolean basementKey) {
		this.basementKey = basementKey;
	}
	public boolean isTutorial() {
		return tutorial;
	}
	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	
	
	
	
}
