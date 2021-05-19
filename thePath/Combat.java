package thePath;

/**
 * <h1>Comabt</h1>
 * <p>This class processes combat and essentially runs the loop made in Game. It holds an enemy object that will be pitted against the player until one perishes. </p>
 * <p>Created: 02/11/2021</p>
 * @author Jason Snow
 */
public class Combat {
	private Enemy foe;
	private int foeType;
	private boolean init;
	private int result;
	private String textToPrint = "";
	private int decision;
	private boolean magicUsed;
	private int attack;

	/**
	 * This is the no arg constructor for a combat, which sets a blank template.
	 * <pre>Example:
	 * {@code Combat() makes a default Combat object.
	 * }</pre>
	 */
	Combat() {
		foeType = 0;
		init = false;
		result = 1;
		decision = 0;
		magicUsed = false;
	}
	
	
	public int fight(Character hero, int choice, int type) {
		if (type == 0) {
			return tutorial(hero, choice);
		}
		
		/*
		 * 0 = player death
		 * 1 = turn finished
		 * 2 = player was victorious
		 * 3 = player is attacking
		 * 4 = player is using magic
		 * 5 = invalid input
		 */
		
		//check if combat is continuation or new
		if (!init) {
			foeType = type;
			foe = new Enemy(type);
			init = true;
		}
		 //have the player act
		result = processPlayerTurn(hero, choice);
		
		//process the result of a turn
		if (result == 0) {
			//the player has lost and perished
			init = false;
			return 0;
		}
		else if (result == 1) {
			//combat continues
			String activeMagic = "";
			String previous = "";
			if (hero.getDefendBuff() > 0 || hero.getAttackBuff() > 0 || hero.getAttackDebuff() > 0 || hero.getDefendBuff() > 0) {
				activeMagic += "(Active Magic:";
				if (hero.getAttackBuff() > 0) {
					activeMagic += " AttackBuff(" + hero.getAttackBuff() + ")";
					previous = ",";
				}
				if (hero.getDefendBuff() > 0) { 
					activeMagic += previous + " DefendBuff(" + hero.getDefendBuff() + ")";
					previous = ",";
				}
				if (hero.getAttackDebuff() > 0) { 
					activeMagic += previous + " AttackDebuff";
					previous = ",";
				}
				if (hero.getDefendDebuff() > 0)  {
					activeMagic += previous + " DefendDebuff";
				}
				activeMagic += ")";
			}
			toPrint("What will you do?\n"
					+ activeMagic + "\n"
					+ "1) Attack with weapons\n"
					+ "2) Attack with magic(2 hp)\n"
					+ "3) Buff yourself(3 hp)\n"
					+ "4) Debuff enemy(5 hp)\n"
					+ "\n");
			
			return 1;
		}
		else if (result == 2) {
			//player victory
			toPrint("You won!\n");
			if (foe.getReward() > 1) toPrint("You find " + foe.getReward() + " coins on the enemy.\n");
			else toPrint("You find " + foe.getReward() + " coin on the enemy.\n");
			hero.setCoins(hero.getCoins()+foe.getReward());
			init = false;
			
			return 2;
		}
		else if (result == 3) {
			String activeMagic = "";
			String previous = "";
			if (hero.getDefendBuff() > 0 || hero.getAttackBuff() > 0 || hero.getAttackDebuff() > 0 || hero.getDefendBuff() > 0) {
				activeMagic += "(Active Magic:";
				if (hero.getAttackBuff() > 0) {
					activeMagic += " AttackBuff(" + hero.getAttackBuff() + ")";
					previous = ",";
				}
				if (hero.getDefendBuff() > 0) { 
					activeMagic += previous + " DefendBuff(" + hero.getDefendBuff() + ")";
					previous = ",";
				}
				if (hero.getAttackDebuff() > 0) { 
					activeMagic += previous + " AttackDebuff";
					previous = ",";
				}
				if (hero.getDefendDebuff() > 0)  {
					activeMagic += previous + " DefendDebuff";
				}
				activeMagic += ")";
			}
			toPrint("Finish your turn with an attack.\n"
					+ activeMagic + "\n"
					+ "1) Attack with weapons\n"
					+ "2) Attack with magic(2 hp)\n"
					+ "\n");
			return 1;
		}
		else {
			return 5;
		}

		
	}

	
	public int processPlayerTurn(Character hero, int choice) {
		//player choice making has just started, must choose base action
		if (decision == 0) {
			if (choice == 1) {
				//attack
				toPrint("Select attack: \n"
						+ "1) Standard Attack\n"
						+ "2) Quick Attack\n"
						+ "3) Heavy Attack\n"
						+ "4) Cancel\n"
						+ "\n");
				decision = 1; 
				return 5;
			}
			else if (choice == 2) {
				if (hero.getHP() > 2) {
					//attack with magic
					toPrint("You make a basic magic attack.\n");
					hero.setHP(hero.getHP()-2);
					hero.setDefense(hero.getDefense()-1);
					//damage foe
					attack = 4;
				}
				else return 5;
			}
			else if (choice == 3) {
				if (!magicUsed && hero.getHP() > 3) {
					if (hero.getAttackBuff() == 0 || hero.getDefendBuff() == 0) {
						//apply a buff
						String active1 = "";
						String active2 = "";
						if (hero.getAttackBuff() > 0) active1 = "(Active)";
						if (hero.getDefendBuff() > 0) active2 = "(Active)";
						
						toPrint("Select buff: \n"
								+ "1) Buff attack" + active1 + "\n"
								+ "2) Buff defense" + active2 + "\n"
								+ "3) Cancel\n"
								+ "\n");
						decision = 3;
					}
					else {
						toPrint("Both buffs are active.\n\n");
						return 1;
					}
					
				}
				return 5;
			}
			else if (choice == 4) {
				if (!magicUsed && hero.getHP() > 5) {
					if (hero.getAttackDebuff() == 0 || hero.getDefendDebuff() == 0) {
						//apply a debuff
						String active1 = "";
						String active2 = "";
						if (hero.getAttackDebuff() > 0) active1 = "(Active)";
						if (hero.getDefendDebuff() > 0) active2 = "(Active)";
						toPrint("Select debuff: \n"
								+ "1) Debuff attack" + active1 + "\n"
								+ "2) Debuff defense" + active2 + "\n"
								+ "3) Cancel\n"
								+ "\n");
						decision = 4;
					}
					else { 
						toPrint("Both debuffs are active.\n\n");
						return 1;
					}
				}
				return 5;
			}
		}
		
		//player has chosen to attack
		else if (decision == 1) {
			if (choice == 1) {
				//get info
				
				//describe standard attack
				toPrint("You made a basic attack.\n");
				attack = 1;
				decision = 0;
			}
			else if (choice == 2) {
				//get info
				
				//set stats
				hero.setDefense(hero.getDefense()+3);
				
				//describe quick attack
				toPrint("You made a quick attack.\n");
				attack = 2;
				decision = 0;
			}
			else if (choice == 3) {
				//get info
				
				//set stats
				hero.setDefense(hero.getDefense()-2);
				
				//player describe heavy attack
				toPrint("You made a heavy attack.\n");
				attack = 3;
				decision = 0;
			}
			else if (choice == 4) {
				decision = 0;
				if (magicUsed) return 3;
				else return 1;
			}
		}
		//player has chosen to buff themselves
		else if (decision == 3) {
			if (choice == 1) {
				//player has chosen to buff their attack
				if (hero.getAttackBuff() == 0) {
					toPrint("You buffed your attack.\n\n");
					//set stats
					hero.setHP(hero.getHP()-3);
					hero.setAttackBuff(3);
					hero.setAttack(hero.getAttack()+2);
					magicUsed = true;
					decision = 0;
					return 3;
				}
				else {
					toPrint("The attack buff is already active.\n");
					String active1 = "";
					String active2 = "";
					if (hero.getAttackBuff() > 0) active1 = "(Active)";
					if (hero.getDefendBuff() > 0) active2 = "(Active)";
					
					toPrint("Select buff: \n"
							+ "1) Buff attack" + active1 + "\n"
							+ "2) Buff defense" + active2 + "\n"
							+ "3) Cancel\n"
							+ "\n");
					return 5;
				}
			}
			else if (choice == 2) {
				if (hero.getDefendBuff() == 0) {
					//player has chosen to buff their defense
					toPrint("You buffed your defense.\n\n");
					//set stats
					hero.setHP(hero.getHP()-3);
					hero.setDefendBuff(3);
					hero.setDefense(hero.getDefense()+2);
					magicUsed = true;
					decision = 0;
					return 3;
				}
				else {
					toPrint("The defend buff is already active.\n");
					String active1 = "";
					String active2 = "";
					if (hero.getAttackBuff() > 0) active1 = "(Active)";
					if (hero.getDefendBuff() > 0) active2 = "(Active)";
					toPrint("Select buff: \n"
							+ "1) Buff attack" + active1 + "\n"
							+ "2) Buff defense" + active2 + "\n"
							+ "3) Cancel\n"
							+ "\n");
					return 5;
				}
			}
			else if (choice == 3) {
				decision = 0;
				return 1;
			}
			else {
				//invalid input
				return 5;
			}
		}
		//player has chosen to debuff the enemy
		else if (decision == 4) {
			if (choice == 1) {
				if (hero.getAttackDebuff() == 0) {
					//player has chosen to debuff the enemy's attack
					toPrint("You debuffed your enemy's attack.\n\n");
					hero.setHP(hero.getHP()-5);
					hero.setAttackDebuff(1);
					foe.setAttack(foe.getAttack()-2);
					magicUsed = true;
					decision = 0;
					return 3;
				}
				else {
					toPrint("The attack debuff is already active.\n");
					String active1 = "";
					String active2 = "";
					if (hero.getAttackDebuff() > 0) active1 = "(Active)";
					if (hero.getDefendDebuff() > 0) active2 = "(Active)";
					toPrint("Select debuff: \n"
							+ "1) Debuff attack" + active1 + "\n"
							+ "2) Debuff defense" + active2 + "\n"
							+ "3) Cancel\n"
							+ "\n");
					decision = 4;
					return 5;
				}
			}
			else if (choice == 2) {
				if (hero.getDefendDebuff() == 0) {
					//player has chosen to debuff the enemy's defense
					toPrint("You debuffed your enemy's defense.\n\n");
					hero.setHP(hero.getHP()-5);
					hero.setDefendDebuff(1);
					foe.setDefense(foe.getDefense()-2);
					magicUsed = true;
					decision = 0;
					return 3;
				}
				else {
					toPrint("The defense debuff is already active.\n");
					String active1 = "";
					String active2 = "";
					if (hero.getAttackDebuff() > 0) active1 = "(Active)";
					if (hero.getDefendDebuff() > 0) active2 = "(Active)";
					toPrint("Select debuff: \n"
							+ "1) Debuff attack" + active1 + "\n"
							+ "2) Debuff defense" + active2 + "\n"
							+ "3) Cancel\n"
							+ "\n");
					decision = 4;
					return 5;
				}
			}
			else if (choice == 3) {
				decision = 0;
				return 1;
			}
			else {
				//invalid input
				return 5;
			}
		}
		
		//find the result of the enemy turn if alive
		if (foe.getHP() > 0) {
			
			//resolve enemy buffs and debuffs if any
			if (foe.getBuffAttack() > 0) {
				foe.setBuffAttack(foe.getBuffAttack()-1);
				if (foe.getBuffAttack() == 0) {
					toPrint("The enemy attack buff has ended.\n");
					foe.setAttack(foe.getAttack()-2);
				}
			}
			if (foe.getBuffDefense() > 0) {
				foe.setBuffDefense(foe.getBuffDefense()-1);
				if (foe.getBuffDefense() == 0) {
					toPrint("The enemy defense buff has ended.\n");
					foe.setDefense(foe.getDefense()-2);
				}
			}
			if (foe.getDebuffAttack() > 0) {
				foe.setDebuffAttack(foe.getDebuffAttack()-1);
				if (foe.getDebuffAttack() == 0) {
					toPrint("The enemy attack debuff has ended.\n");
					hero.setAttack(hero.getAttack()+2);
				}
			}
			if (foe.getDebuffDefense() > 0) {
				foe.setDebuffDefense(foe.getDebuffDefense()-1);
				if (foe.getDebuffDefense() == 0) {
					toPrint("The enemy defense debuff has ended.\n");
					hero.setDefense(hero.getDefense()+2);
				}
			}
			
			
			
			toPrint(foe.enemyAction(hero, attack));
			toPrint("\n");
		}
		//end combat if foe is defeated
		else {
			if (attack == 2) {
				hero.setDefense(hero.getDefense()-3);
			}
			else if (attack == 3) {
				hero.setDefense(hero.getDefense()+2);
			}
			else if (attack == 4) {
				hero.setDefense(hero.getDefense()+1);
			}
			if (hero.getAttackBuff() > 0) {
				hero.setAttackBuff(0);
				hero.setAttack(hero.getAttack()-2);
			}
			if (hero.getDefendBuff() > 0) {
				hero.setDefendBuff(0);
				hero.setDefense(hero.getDefense()-2);
			}
			hero.setAttackDebuff(0);
			hero.setDefendBuff(0);
			attack = 0;
			magicUsed = false;
			return 2;
		}
		
		//post enemy turn, find out if hero is still alive
		if (hero.getHP() > 0) {
			//hero alive, continue combat
			if (attack == 2) {
				hero.setDefense(hero.getDefense()-3);
			}
			else if (attack == 3) {
				hero.setDefense(hero.getDefense()+2);
			}
			else if (attack == 4) {
				hero.setDefense(hero.getDefense()+1);
			}
			
			
			//resolve expired states (don't forget attack and magic used)
			if (hero.getAttackBuff() > 0) {
				hero.setAttackBuff(hero.getAttackBuff()-1);
				if (hero.getAttackBuff() == 0) {
					toPrint("Your attack buff has ended.\n");
					hero.setAttack(hero.getAttack()-2);
				}
			}
			if (hero.getDefendBuff() > 0) {
				hero.setDefendBuff(hero.getDefendBuff()-1);
				if (hero.getDefendBuff() == 0) {
					toPrint("Your defense buff has ended.\n");
					hero.setDefense(hero.getDefense()-2);
				}
			}
		
			
			attack = 0;
			magicUsed = false;
			return 1;
		}
		else {
			//hero has perished
			attack = 0;
			magicUsed = false;
			return 0;
		}
	}


	public int tutorial(Character hero, int choice) {
		
		
		
		
		
		return 1;
		
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
	/**
	 * This method is used to gather all the text this class will need displayed and store it in a variable until it is needed.
	 * <pre>Example:
	 * {@code toPrint("Hello") will append "Hello" to the variable textToPrint.
	 * }</pre>
	 * @param message (String; message to add to the storage string)
	 */
	public void toPrint(String message) {
		textToPrint += message;
	}
	/**
	 * This method allows other classes to access the storage string in this method to print it. It is the getter.
	 * <pre>Example:
	 * {@code getTextToPrint() returns the textToPrint string
	 * }</pre>
	 * @return textToPrint (String; all the stored messages to print from this class)
	 */
	public String getTextToPrint() {
		return textToPrint;
	}
	/**
	 * This method is used to clear all the stored text. It must be called after getTextToPrint is called or else text will be repeated.
	 * <pre>Example:
	 * {@code clear() will set textToPrint to "", essentially empty.
	 * }</pre>
	 */
	public void clear() {
		textToPrint = "";
	}
	
}

