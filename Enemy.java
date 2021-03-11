package thePath;
/**
 * 
 * @author student
 *
 */
public class Enemy {
	private int hp;
	private int mana;
	private int attack;
	private int defense;
	private int reward;
	/**
	 * 
	 */
	Enemy() {
		hp = 4;
		mana = 0;
		attack = 6;
		defense = 0;
		reward = 1;
	}
	/**
	 * 
	 * @param type
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
	public int getReward() {
		return reward;
	}
	/**
	 * 
	 * @param reward
	 */
	public void setReward(int reward) {
		this.reward = reward;
	}
}

