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
	private int step;
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
		step = 0;
		magicUsed = false;
	}
	
	/**
	 * This method is used to start and handle fights. It returns an int to indicate the result of a fight (continue, player death, or enemy death).
	 * It will have lines printed to make clear what is happening.
	 * <pre>Example:
	 * {@code combat.fight(hero, 1, 2) will process the current stage of the current turn of combat for the hero object with choice 1 enemy type 2 
	 * (the enemy type is only used in the first turn of combat to set the enemy, type is stored by combat after)
	 * }</pre>
	 * @param hero (Character; the character object engaged in combat, the user representation)
	 * @param choice (int; the choice the user made for the current stage of the current turn in combat (how to attack, what type of debuff to use, etc.)
	 * @param type (int; the type of enemy to be fought (0-3))
	 * @return result (int; the reuslt of combat (0 = defeat, 2 = victory, else = continuation) 
	 */
	public int fight(Character hero, int choice, int type) {
		if (type == 0) {
			if (hero.isTutorial()) return tutorial(hero, choice);
			else return 2;
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
			if (hero.getDefendBuff() > 0 || hero.getAttackBuff() > 0 || hero.getAttackDebuff() > 0 || hero.getDefendDebuff() > 0) {
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
					+ "2) Attack with magic(3 hp)\n"
					+ "3) Buff yourself(3 hp)\n"
					+ "4) Debuff enemy(5 hp)\n"
					+ "\n");
			
			return 1;
		}
		else if (result == 2) {
			//player victory
			toPrint("You are victorious!\n");
			toPrint("From the place your foe fell, " + foe.getReward() + " ghost-like silver coins float up and drift towards you, fading with a soft whoosh as they touch you.\n");
			hero.setCoins(hero.getCoins()+foe.getReward());
			init = false;
			return 2;
		}
		else if (result == 3) {
			String activeMagic = "";
			String previous = "";
			if (hero.getDefendBuff() > 0 || hero.getAttackBuff() > 0 || hero.getAttackDebuff() > 0 || hero.getDefendDebuff() > 0) {
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
					+ "2) Attack with magic(3 hp)\n"
					+ "\n");
			return 1;
		}
		else {
			return 5;
		}

		
	}

	/**
	 * This method is used to process the player turn. Called by the fight method, it will process the player's choices and calculate the results of them.
	 * Lines are printed to show what is happening and make the player aware of what input is needed.
	 * <pre>Example:
	 * {@code processPlayerTurn(hero, 1) will assess choice 1 for player object hero in the current stage of the current turn and return the result
	 * (the return is still mostly one sides death or continuation, but some continue states print different data from fight)
	 * }</pre>
	 * @param hero (Character; the object representing the player character in this combat)
	 * @param choice (int; the choice the player made in this stage of this current combat)
	 * @return result (int; the result of the fight)
	 */
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
					foe.setHP(foe.getHP()-(hero.getAttack()+2));
					hero.setHP(hero.getHP()-3);
					hero.setDefense(hero.getDefense()-1);
					if (foe.getHP() > 0) {
						toPrint("You sheathe your sword for a moment so you have your hand free. Holding it out towards your opponent, you think of a single word: burn."
								+ " Your opponent ignites into flames for a brief moment, causing them to take " + (hero.getAttack()+2) + " damage, though they quickly fade leaving your enemy burned.\n");
					}
					else {
						toPrint("You sheathe your sword and lunge at your opponent. Using your dagger to open their defenses, you place your hand upon it; "
								+ "your foe bursts into flames, howling as it is consumed by the heat and reduced to ash.\n");
					}
					//damage foe
					attack = 4;
				}
				else {
					toPrint("You cannot kill yourself with magic.\n");
					return 5;
				}
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
						return 5;
					}
					else {
						toPrint("Both buffs are active.\n\n");
						return 1;
					}
					
				}
				toPrint("You cannot kill yourself with magic.\n");
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
						return 5;
					}
					else { 
						toPrint("Both debuffs are active.\n\n");
						return 1;
					}
				}
				toPrint("You cannot kill yourself with magic.\n");
				return 5;
			}
		}
		
		//player has chosen to attack
		else if (decision == 1) {
			if (choice == 1) {
				//get info
				int damage = hero.getAttack()-foe.getDefense();
				if (damage < 0) damage = 0;
				foe.setHP(foe.getHP()-damage);
				if (foe.getHP() > 0) {
					if (damage > 0) toPrint("You slash once with your sword and follow up with your dagger, dealing " + damage + " damage to your foe.\n");
					else toPrint("You attempt to slash with both of your blades, but your foe manages to block the damage from both.\n");
				}
				else {
					if (foe.getType() == 1) {
						toPrint("You bring your sword down upon the zombie's weapon arm, severing it and causing the old blade to fall to the floor. "
								+ "The creature is stunned before your dagger jabs into it and finishes the job; the corpse falls back, little more than a body now.\n");
					}
					else if (foe.getType() == 2) {
						toPrint("You slash with your sword which the creature catches with all four arms, seeming rather satisfied with itself, until you bring your dagger up into the side of its head. "
								+ "The body slowly slumps before crumbling down upon the ground.\n");
					}
					else {
						toPrint("The brute raises its axes to bring a heavy attack down upon you but you interrupt with a slash across the gut, followed by a dagger to the side. "
								+ "The monster is stunned before the marks upon it begin to glow bright; in a flash of green, the figure vanishes.\n");
					}
				}
				attack = 1;
				decision = 0;
			}
			else if (choice == 2) {
				//get info
				int damage = (hero.getAttack()-3)-foe.getDefense();
				if (damage < 0) damage = 0;
				foe.setHP(foe.getHP()-damage); 
				if (foe.getHP() > 0) {
					if (damage > 0) toPrint("Being cautious but quick, you feint with your sword and slash with your dagger to leave a cut across your opponent for " + damage + " damage.\n");
					else toPrint("You attempt to quickly slash your opponent while keeping a defensive guard, but defense of your enemy was too great to pierce with such a weak attack.\n");
				}
				else {
					if (foe.getType() == 1) {
						toPrint("The zombie begins to pull back its arm for yet another attack when you lunge, planting your dagger firmly in its skull; "
								+ "a final growl, confused, escapes it before it stumbles back off your blade and down to the ground.\n");
					}
					else if (foe.getType() == 2) {
						toPrint("You quickly slash with your dagger, cutting across each of the creature's arms. "
								+ "It howls in pain until your thrust your dagger into its howling maw, cutting off the cries permanently.\n");
					}
					else {
						toPrint("Using your smaller size to your advantage, you slide under the monster before you."
								+ " Before it can turn to face you, you slash, cut, and stab with a flurry of blows until it slumps forward and stops moving."
								+ " As it lays there, defeated, the tattoos upon its skin glow until, in a flash of green, the body vanishes.\n");
					}
				}
				//set stats
				hero.setDefense(hero.getDefense()+3);
				attack = 2;
				decision = 0;
			}
			else if (choice == 3) {
				//get info
				int damage = (hero.getAttack()+4)-foe.getDefense();
				if (damage < 0) damage = 0;
				foe.setHP(foe.getHP()-damage); 
				if (foe.getHP() > 0) {
					if (damage > 0) toPrint("You thrust forward with your sword, stabbing into the opponent before you for " + damage + " damage, leaving yourself open as you do.\n");
					else toPrint("You thrust forward without regard for your own defense, but your blade does not manage to pierce the defenses of your foe.\n");
				}
				else {
					if (foe.getType() == 1) {
						toPrint("Giving a shout, you pierce the undead right through the chest, twisting your blade before ripping it out for a deep, devastating cut that leaves the corpse slumped upon the ground."
								+ "\n");
					}
					else if (foe.getType() == 2) {
						toPrint("You bring your blade down in a heavy strike. All four arms reach up to stop it but the sheer force of the attack cuts through them before the blade sinks into the creature's head;"
								+ " the thing goes limp and is a threat no more."
								+ "\n");
					}
					else {
						toPrint("Summoning all of your power and energy, you slash across the monster's leg, causing it to drop to one knee in pain. "
								+ "With the head now in easy reach, it takes only one quick swipe to separate it from the shoulders. "
								+ "The tattoos of your foe's corpse glow before the entire form fades away, vanished into thin air.\n");
					}
				}
				//set stats
				hero.setDefense(hero.getDefense()-2);
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
					toPrint("You grip the hilts of your weapons tight; there is a burning pain and a sizzling noise before your blades glow red, their deadliness increased.\n\n");
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
					toPrint("You cross your blades and convert some of your life into a faint, shimmering red field around you that will aid to defend you.\n\n");
					//set stats
					hero.setHP(hero.getHP()-3);
					hero.setDefendBuff(3);
					hero.setDefense(hero.getDefense()+2);
					magicUsed = true;
					decision = 0;
					return 3;
				}
				else {
					toPrint("The defense buff is already active.\n");
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
					toPrint("You raise your blades and, in unison, red, spectral chains raise up and bind the weapons of your foe, hampering their attacks.\n\n");
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
					toPrint("You summon that power within you and cause a series of runes and shapes to cover your foe, leaving them weak and open to attack.\n\n");
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
					if (foe.getType() == 2) toPrint("The glow upon the creature's claws fades.\n");
					else toPrint("The brute's arms slowly shrink to their proper size, its attacks no longer so deadly.");
					foe.setAttack(foe.getAttack()-2);
				}
			}
			if (foe.getBuffDefense() > 0) {
				foe.setBuffDefense(foe.getBuffDefense()-1);
				if (foe.getBuffDefense() == 0) {
					toPrint("The magical armor upon the monster slowly fades away, leaving it with lowered defense.\n");
					foe.setDefense(foe.getDefense()-2);
				}
			}
			if (foe.getDebuffAttack() > 0) {
				foe.setDebuffAttack(foe.getDebuffAttack()-1);
				if (foe.getDebuffAttack() == 0) {
					toPrint("The ropes that bind your slowly slacken before slipping off and away, your attacks no longer hampered.\n");
					hero.setAttack(hero.getAttack()+2);
				}
			}
			if (foe.getDebuffDefense() > 0) {
				foe.setDebuffDefense(foe.getDebuffDefense()-1);
				if (foe.getDebuffDefense() == 0) {
					toPrint("Your feet suddenly feel lighter and you can move more nimbly to avoid damage, the magic having worn off.\n");
					hero.setDefense(hero.getDefense()+2);
				}
			}
			//reset attack states but not attack
			if (foe.getType() == 1) {
				if (foe.getLastAttack() == 1) foe.setDefense(foe.getDefense()-2);
				else if (foe.getLastAttack() == 2) foe.setDefense(foe.getDefense()+2);
			}
			else if (foe.getType() == 3) {
				if (foe.getLastAttack() == 1) foe.setDefense(foe.getDefense()-3);
				else if (foe.getLastAttack() == 2) foe.setDefense(foe.getDefense()+4);
			}
			else {
				if (hero.getDefendDebuff() > 0) foe.setDefense(2);
				else foe.setDefense(4);
			}
			toPrint(foe.enemyAction(hero, attack));
			toPrint("\n");
		}
		//end combat if foe is defeated
		else {
			hero.setAttack(6);
			hero.setDefense(2);
			hero.setAttackBuff(0);
			hero.setDefendBuff(0);
			hero.setAttackDebuff(0);
			hero.setDefendDebuff(0);
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
					toPrint("You watch the glow of your weapons fade as you feel the magic fueling them dampen and fade.\n");
					hero.setAttack(hero.getAttack()-2);
				}
			}
			if (hero.getDefendBuff() > 0) {
				hero.setDefendBuff(hero.getDefendBuff()-1);
				if (hero.getDefendBuff() == 0) {
					toPrint("The protective field around dims and fades, leaving you with only your standard defenses.\n");
					hero.setDefense(hero.getDefense()-2);
				}
			}
			attack = 0;
			magicUsed = false;
			return 1;
		}
		else {
			//hero has perished
			hero.setAttack(6);
			hero.setDefense(2);
			hero.setAttackDebuff(0);
			hero.setDefendDebuff(0);
			hero.setAttackBuff(0);
			hero.setDefendBuff(0);
			attack = 0;
			magicUsed = false;
			return 0;
		}
	}

	/**
	 * This method is used to handle the tutorial, a unique combat scenario the player encounters when they first play through the game. This can be disabled prior to skip it.
	 * The tutorial mimics a normal combat but limits the players choices to predetermined actions.
	 * @param hero (Character; the object represnting the character as they learn about the game via the tutorial)
	 * @param choice (int; the choice the character made)
	 * @return (int; the result of the player's choice, it will always be a continuation until the last step. The player cannot die in the tutorial)
	 */
	public int tutorial(Character hero, int choice) {
		if (step == 0) {
			if (choice == 3) {
				toPrint("Select buff: \n"
						+ "1) Buff attack\n"
						+ "2) Buff defense\n"
						+ "3) Cancel\n"
						+ "\n");
				toPrint("\n(Good job! Now you can choose a buff to apply, or you can cancel and make a different choice. Let's choose to buff our defense so when the enemy attacks we’re well protected)\n\n");
				step += 1;
				return 1;
			}
			else return 5;
		}
		
		if (step == 1) {
			if (choice == 2) {
				toPrint("You cross your blades and convert some of your life into a faint, shimmering red field around you that will aid to defend you.\n\n");
				hero.setDefense(hero.getDefense()+2);
				hero.setDefendBuff(3);
				hero.setHP(hero.getHP()-3);
				toPrint("Finish your turn with an attack.\n"
						+ "(Active Magic: DefendBuff(3))\n"
						+ "1) Attack with weapons\n"
						+ "2) Attack with magic(3 hp)\n"
						+ "\n");
				toPrint("\n(Awesome! Now, as you see, you lose a little health but your defense has increased. "
						+ "You will also notice you're shown how long you have left with increased defense. As long as the buff or debuff is active, you cannot activate it again- but dont' worry, it only ends before your turn so you can always put it back up if you want.) "
						+ "\n"
						+ "(Your turn still isn't over. You must always make an attack on a turn (you may use one type of magic, but no more than one on a single turn, though magic is not required for a turn))"
						+ "\n"
						+ "\n"
						+ "(Attacking with magic costs life and lowers your defense a little for the enemy's next turn, but it ignores all enemy defense. For now, make a weapon attack)\n"
						+ "\n");
				step += 1;
				return 1;
			}
			else return 5;
		}
	
		else if (step == 2) {
			if (choice == 1) {
				toPrint("Select attack: \n"
						+ "1) Standard Attack\n"
						+ "2) Quick Attack\n"
						+ "3) Heavy Attack\n"
						+ "4) Cancel\n"
						+ "\n");
				toPrint("\n(Great work. You will see you have three kind of weapon attacks; standard attacks do basic damage and don't change your defense. Quick attacks do less damage but increase your defense for the enemy's next turn. Heavy attacks do increased damage but lower your defense for the enemy's next turn.)\n"
						+ "(Since you don't know how hard this thing hits or how tough it is, try hitting it with a standard attack.)\n\n");
				step += 1;
				return 1;
			}
			else return 5;
		}
		else if (step == 3) {
			if (choice == 1) {
				toPrint("You slash with your sword and dagger, cutting into the undead monster before you for 4 damage.\n");
				toPrint("\n(When you attack, you will see how much damage you did (sometimes you might deal no damage if the enemy's defense is high enough). Now that you've attacked, your turn is done and the enemy will take its turn.)\n\n");
				toPrint("The zombie swipes with gnarled, boney  hand, dealing  3 damage to you.\n");
				hero.setHP(hero.getHP()-3);
				toPrint("\n(Now it's your turn again)\n");
				toPrint("What will you do?\n"
						+ "(Active Magic: DefendBuff(2))\n"
						+ "1) Attack with weapons\n"
						+ "2) Attack with magic(3 hp)\n"
						+ "3) Buff yourself(3 hp)\n"
						+ "4) Debuff enemy(5 hp)\n"
						+ "\n");
				toPrint("\n(Since a turn passed, you're that much closer to your defense buff going away. Keep that in mind! For now, lets debuff the enemies defense so we can kill it more quickly (debuffs will not go away unless your enemy uses magic to dispel it, which will cost it life and use up its chance to do magic that turn))\n\n");
				step += 1;
				return 1;
			}
			else return 5;
		}
		//
		else if (step == 4) {
			if (choice == 4) {
				toPrint("Select debuff: \n"
						+ "1) Debuff attack" + "\n"
						+ "2) Debuff defense" +  "\n"
						+ "3) Cancel\n"
						+ "\n");
				step += 1;
				return 1;
			}
			else return 5;
			
		}
		else if (step == 5) {
			if (choice == 2) {
				toPrint("You summon that power within you and cause a series of runes and shapes to cover your foe, leaving them weak and open to attack.\n\n");
				hero.setHP(hero.getHP()-5);
				hero.setDefendDebuff(1);
				hero.setHPPotion(3);
				toPrint("\n(Good job! Now before we finish this weakling off, let's heal with some potions. You can drink as many potions as you want at any time, so stock up on these bad boys. After you're at full health (50) finish this fight with a heavy attack.)\n\n");
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
						+ "2) Attack with magic(3 hp)\n"
						+ "\n");
				step += 1;
				return 1;
			}
			else return 5;
		}
		else if (step == 6) {
			if (choice == 1) {
				if (hero.getHP() != 50) {
					toPrint("\n(Heal up with potions before you finish the fight!)\n\n");
					return 5;
				}
				else {
					toPrint("Select attack: \n"
							+ "1) Standard Attack\n"
							+ "2) Quick Attack\n"
							+ "3) Heavy Attack\n"
							+ "4) Cancel\n"
							+ "\n");
					step += 1;
					return 1;
				}
			}
			else return 5;
		}
		else if (step == 7) {
			if (choice == 3) {
				toPrint("You bring your blade down in a mighty thrust, slicing the zombie clean in two.\n");
				toPrint("You are victorious!\n");
				toPrint("From the place your foe fell, a ghost-like silver coin floats up and drift towards you, fading with a soft whoosh as it touches you.\n");
				hero.setCoins(hero.getCoins()+1);
				toPrint("\n(You did it! Now you know all there is to combat. The message describing the room you were entering will now show and you may continue on with your tale. Good luck and be victorious!)\n\n");
				hero.setTutorial(false);
				hero.setDefendBuff(0);
				hero.setDefendDebuff(0);
				hero.setDefense(2);
				init = false;
				return 2;
			}
			else return 5;
		}
		else {
			return 5;
		}
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

