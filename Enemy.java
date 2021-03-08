package thePath;

public class Enemy {
	private int hp;
	private int mana;
	private int attack;
	private int defense;
	private int reward;
	
	Enemy() {
		hp = 4;
		mana = 0;
		attack = 6;
		defense = 0;
		reward = 1;
	}
	
	Enemy(int type) {
		if (type == 1) {
			hp = 10;
			mana = 0;
			attack = 8;
			defense = 1;
			reward = 2;
		}
		if (type == 2) {
			hp = 20;
			mana = 0;
			attack = 12;
			defense = 1;
			reward = 4;
		}
		if (type == 3) {
			hp = 40;
			mana = 10;
			attack = 16;
			defense = 2;
			reward = 8;
		}
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
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	
}
