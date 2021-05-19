package thePath;

import java.util.*;
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
	private int lastAttack;

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
			defense = 2;
			reward = 3;
			lastAttack = 0;
		}
		else if (type == 2) {
			hp = 15;
			attack = 5;
			defense = 1;
			reward = 5;
		}
		else if (type == 3) {
			hp = 35;
			attack = 10;
			defense = 4;
			reward = 10;
			
		}
	}
	
	public String enemyAction(Character hero, int attackChoice) {
		String toPrint = "";
		int[] choice = enemyBehavior(hero, attackChoice);
		if (type == 1) {
			if (choice[1] == 1) {
				int damage = attack - hero.getDefense();
				hero.setHP(hero.getHP()-damage);
				toPrint += "Grunt standard attack.";
			}
			else if (choice[1] == 2) {
				//quick attack
			}
			else if (choice[1] == 3) {
				//heavy attack
			}
			
		}
		else if (type == 2) {
			
		}
		else {
			//int[] biggest = {attackDebuff, defenseDebuff, attackBuff, defenseBuff, dispellDefenseDebuff, dispellAttackDebuff};
			if (choice[0] == -1) {
				//no magic
			}
			else if (choice[0] == 0) {
				//attack Debuff
				hero.setAttack(hero.getAttack()-2);
				debuffAttack = 3;
				hp -= 2;
				toPrint += "The elite debuffs your attack.\n";
			}
			else if (choice[0] == 1) {
				//defense Debuff
				hero.setAttack(hero.getAttack()-2);
				debuffAttack = 3;
				hp -= 2;
				toPrint += "The elitre debuffs your defense.\n";
			}
			else if (choice[0] == 2) {
				//attackBuff
				attack += 2;
				buffAttack = 3;
				hp -= 2;
				toPrint += "The elite buffs its attacks.\n";
			}
			else if (choice[0] == 3) {
				//defenseDebuff
				defense += 2;
				buffDefense = 3;
				hp -= 2;
				toPrint += "The elite buffs its defense.\n";
			}
			else if (choice[0] == 4) {
				//dispellDefenseDebuff
				hero.setDefendDebuff(0);
				defense += 2;
				hp -= 2;
				toPrint += "The elite dispells your debuff on its defense.\n";
			}
			else {
				//dispellAttackDebuff
				hero.setAttackDebuff(0);
				attack += 2;
				hp -= 2;
				toPrint += "The elite dispells your debuff on its attack.\n";
			}
			
			
			if (choice[1] == 1) {
				//standard attack
				int damage = attack-hero.getDefense();
				if (damage < 0) damage = 0;
				lastAttack = 1;
				hero.setHP(hero.getHP()-damage);
				toPrint += "The elite slashes, dealing " + damage + " damage.\n";
			}
			else if (choice[1] == 2) {
				//quick attack
				int damage = (attack-6)-hero.getDefense();
				if (damage < 0) damage = 0;
				defense += 3;
				lastAttack = 2;
				hero.setHP(hero.getHP()-damage);
				toPrint += "The elite quick slashes, dealing " + damage + " damage.\n";
			}
			else {
				//heavy attack
				int damage = (attack+5)-hero.getDefense();
				if (damage < 0) damage = 0;
				defense -= 4;
				lastAttack = 3;
				hero.setHP(hero.getHP()-damage);
				toPrint += "The elite heavy slashes, dealing " + damage + " damage.\n";
			}
			
		}
	
		return toPrint;
	}
	
	public int[] enemyBehavior(Character hero, int attackChoice) {
		int[] choice = {0, 0};
		int heavyAttack = 0;
		int standardAttack = 0;
		int quickAttack = 0;
		int defenseDebuff = 0;
		int attackDebuff = 0;
		int defenseBuff = 0;
		int attackBuff = 0;
		int dispellDefenseDebuff = 0;
		int dispellAttackDebuff = 0;
		
		if (type == 1) {
			int spaz = (int)(Math.random()*3)+1;
			choice[1] = spaz;
		}
		else if (type == 2) {
			int spaz = (int)(Math.random()*3)+1;
			choice[1] = spaz;
		}
		else {
			//consider what attack the player just used
			if (attackChoice == 1) {
				//standard attack
				heavyAttack += 1;
				quickAttack += 1;
			}
			else if (attackChoice == 2 ) {
				//quick attack
				standardAttack += 1;
				quickAttack += 1;
			}
			else if (attackChoice == 3){
				//heavy attack
				heavyAttack += 1;
				standardAttack += 1;
			}
			else {
				//magic attack used
				heavyAttack += 1;
			}
			//consider what magic the character has active
			if (hero.getAttackDebuff() > 0) {
				dispellAttackDebuff += 5;
			}
			else dispellAttackDebuff -= 100;
			if (hero.getDefendDebuff() > 0) {
				dispellDefenseDebuff += 5;
			}
			else dispellDefenseDebuff -= 100;
			if (hero.getAttackBuff() > 0) {
				defenseBuff += 1;
				attackDebuff += 1;
				quickAttack += 1;
			}
			if (hero.getDefendBuff() > 0) {
				attackBuff += 1;
				defenseDebuff += 1;
				heavyAttack += 1;
			}
			
			//consider current health
			if (hp <= 10) {
				quickAttack += 1;
				heavyAttack -= 2;
				if (hp > 2) {
					defenseBuff += 1;
					dispellDefenseDebuff += 5;
				}
			}
			else if (hp >= 11 && hp <= 20){
				standardAttack += 2;
				defenseBuff += 1;
				attackBuff += 1;
			}
			else {
				heavyAttack += 1;
				attackBuff += 1;
			}
			
			//consider current defense
			if (defense <= 4) {
				defenseBuff += 1;
				quickAttack += 1;
			}
			else {
				heavyAttack += 1;
			}
			
			//consider current attack
			if (attack <= 10) {
				attackBuff += 1;
				heavyAttack += 1;
			}
			else {
				quickAttack += 1;
				defenseBuff += 1;
			}
			
			//consider buffAttack
			if (buffAttack == 0) {
				//attack buff inactive
				attackBuff += 1;
				standardAttack += 1;
			}
			else {
				attackBuff -= 100;
				heavyAttack += 1;
			}
			//consider buffDefnese
			if (buffDefense == 0) {
				//defense buff inactive
				defenseBuff += 1;
				quickAttack += 1;
			}
			else {
				defenseBuff -= 100;
				heavyAttack += 1;
			}
			//consider debuffDefense
			if (debuffDefense == 0) {
				//debuffDefense inactive
				defenseDebuff += 1;
				quickAttack += 1;
				standardAttack += 1;
			}
			else {
				defenseDebuff -= 100;
				heavyAttack += 1;
			}
			//consider debuffAttack
			if (debuffAttack == 0) {
				//debuffAttack inactive
				attackDebuff += 1;
				quickAttack += 1;
			}
			else {
				attackDebuff -= 100;
				heavyAttack += 1;
				standardAttack += 1;
			}	
			
			
			if (hp <= 2) choice[0] = -1;
			else if (debuffAttack > 1 && debuffDefense > 1 && buffAttack > 1 && buffDefense > 1 && hero.getAttackDebuff() <= 0 && hero.getDefendBuff() <= 0) {
				choice[0] = -1;
			}
			else {
				int max = 0;
				Stack<Integer> equal = new Stack<Integer>();
				int[] biggest = {attackDebuff, defenseDebuff, attackBuff, defenseBuff, dispellDefenseDebuff, dispellAttackDebuff};
				//find max
				for (int i = 0; i < biggest.length; i++) {
					if (biggest[i] > max) {
						max = biggest[i];
					}
				}
				//store all possible choices
				for (int i = 0; i < biggest.length; i++) {
					if (biggest[i] == max) {
						equal.push(i);
					}
				}
				int chosen = 0;
				//pick random among all options
				int random = (int)(Math.random()*equal.size())+1;
				for (int i = 0; i < random; i++) {
					chosen = equal.pop();
				}
				choice[0] = chosen;
			}
			
			int max = 0;
			Stack<Integer> equal = new Stack<Integer>();
			int[] biggest = {standardAttack, quickAttack, heavyAttack};
			//find max
			for (int i = 0; i < biggest.length; i++) {
				if (biggest[i] > max) {
					max = biggest[i];
				}
			}
			//store all possible choices
			for (int i = 0; i < biggest.length; i++) {
				if (biggest[i] == max) {
					equal.push(i);
				}
			}
			int chosen = 0;
			//pick random among all options
			int random = (int)(Math.random()*equal.size())+1;
			for (int i = 0; i < random; i++) {
				chosen = equal.pop();
			}
			choice[1] = chosen;
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
	
	
	
	public void setAttack(int attack) {
		this.attack = attack;
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
	
	public int getBuffAttack() {
		return buffAttack;
	}
	public void setBuffAttack(int buffAttack) {
		this.buffAttack = buffAttack;
	}
	
	public int getBuffDefense() {
		return buffDefense;
	}
	public void setBuffDefense(int buffDefense) {
		this.buffDefense = buffDefense;
	}
	
	public int getDebuffDefense() {
		return debuffDefense;
	}
	public void setDebuffDefense(int debuffDefense) {
		this.debuffDefense = debuffDefense;
	}
	
	public int getDebuffAttack() {
		return debuffAttack;
	}
	public void setDebuffAttack(int debuffAttack) {
		this.debuffAttack = debuffAttack;
	}
	
	public int getLastAttack() {
		return lastAttack;
	}
	public void setLastAttack(int lastAttack) {
		this.lastAttack = lastAttack;
	}
	
}

