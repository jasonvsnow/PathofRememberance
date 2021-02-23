package thePath;

public class Character {
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
	
	Character() {
		hp = 50;
		mana = 10;
		coins = 0;
		potions = 0;
		attack = 1;
		defense = 0;
		defendCharge = 0;
		map = false;
		captainKey = false;
		basementKey = false;
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
	
	
	
	
	
}
