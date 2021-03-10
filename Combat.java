package thePath;

public class Combat {
	private Enemy foe;
	private int foeType;
	private boolean init;
	int hold;

	
	Combat() {
		foe = new Enemy();
		foeType = 0;
		init = false;
		hold = 1;
	}
	
	public int fight(Character hero, int choice, int type) {
		if (!init) {
			foeType = type;
			if (type == 0) foe = new Enemy();
			else if (type == 1) foe = new Enemy(1);
			else if (type == 2) foe = new Enemy(2);
			init = true;
		}
		hold = processPlayerTurn(hero, choice);
		if (hold == 0) {
			init = false;
			return 0;
		}
		else if (hold == 1) {
			Display.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 1;
		}
		else if (hold == 2) {
			Display.print("You won!\n");
			hero.setDefense(1);
			if (foe.getReward() > 1) Display.print("You find " + foe.getReward() + " coins on the enemy.\n");
			else Display.print("You find " + foe.getReward() + " coin on the enemy.\n");
			hero.setCoins(hero.getCoins()+foe.getReward());
			init = false;
			return 2;
		}
		else {
			Display.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 3;
		}
		
	}
	
	public int processPlayerTurn(Character hero, int choice) {
		if (choice == 1) {
			int dealt = hero.getAttack()-foe.getDefense();
			Display.print("You attack, dealing " + dealt + " damage!\n");
			foe.setHP(foe.getHP()-dealt);
		}
		if (choice == 2) {
			Display.print("You defend!\n");
			//edit 
			if (hero.getAttack() == 5) hero.setDefense(5);
			else if (hero.getAttack() == 10) hero.setDefense(8);
			else hero.setDefense(3);
			hero.setDefendCharge(4);
		}
		if (choice == 3) {
			if (hero.getMana() >= 2) {
				Display.print("You hold the ball of light in your hand out and it explodes, burning the enemy for 7 damage! The ball then relights. \n");
				foe.setHP(foe.getHP()-7);
				hero.setMana(hero.getMana()-2);
			}
			else {
				Display.print("You don't have enough mana for that!\n");
				Display.print(""
						+ "1) Attack\n"
						+ "2) Defend\n"
						+ "3) Use Magic\n"
						+ "\n");
				return 3;
			}
		}
		
		if (hero.getDefendCharge() > 0) {
			hero.setDefendCharge(hero.getDefendCharge()-1);
		}
		else {
			if (hero.getAttack() == 5) hero.setDefense(2);
			else if (hero.getAttack() == 10) hero.setDefense(5);
			else hero.setDefense(0);
		}
		if (foe.getHP() > 0) {
			processEnemyTurn(hero, choice);	
		}
		else {
			return 2;
		}
		
		
		if (hero.getHP() > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public void processEnemyTurn(Character hero, int choice) {
		if (foeType == 0) {
			int dealing = foe.getAttack() - hero.getDefense();
			Display.print("\nThe wretched green thing screams and slashes at you with black claws, dealing " + dealing + " damage.\n");
			hero.setHP(hero.getHP() - dealing);
		}
		else if (foeType == 2) {
			int ran = (int)(Math.random()*3);
			if (ran == 0 && foe.getMana() > 0) {
				Display.print("\nThe creature slams its spikey hand into the ground and beneath you spikes erupt, slamming into you and piercing your defenses, dealing 7 damage to you while also reinforcing the creatures armor.\n");
				foe.setMana(foe.getMana()-1);
				foe.setDefense(foe.getDefense()+1);
				hero.setHP(hero.getHP()-7);
			}
			else {
				int dealing = foe.getAttack() - hero.getDefense();
				Display.print("\nThe creature slashes twice with its claws, dealing " + dealing + " damage.\n");
				
			}
		}
		else if (foeType == 1) {
			int ran = (int)(Math.random()*3);
			if (ran == 0) {
				int dealing = foe.getAttack() - hero.getDefense();
				Display.print("\nThe monster slashes with its sword, dealing " + dealing + " damage.\n");
				hero.setHP(hero.getHP() - dealing);
			}
			else {
				if (foe.getDefense() < 2) {
					foe.setDefense(2);
					Display.print("The creature snarls and more spikes suddenly burst out from its skin, hardening its defense.\n");
				}
				else {
					int dealing = foe.getAttack() - hero.getDefense();
					Display.print("\nThe monster slashes with its sword, dealing " + dealing + " damage.\n");
					hero.setHP(hero.getHP() - dealing);
				}
			}
		}
	}
	
	
	
	public boolean isInit() {
		return init;
	}
	public void setInit(boolean init) {
		this.init = init;
	}
	public int getFoeType() {
		return foeType;
	}
	public void setFoeType(int type) {
		foeType = type;
	}
	
	
	
	
	
	
	
}

