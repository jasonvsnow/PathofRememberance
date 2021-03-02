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
			else if (type == 3) foe = new Enemy(3);
			init = true;
		}
		hold = processPlayerTurn(hero, choice);
		if (hold == 0) {
			init = false;
			return 0;
		}
		else if (hold == 1) {
			Help.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 1;
		}
		else if (hold == 2) {
			Help.print("You won!\n");
			hero.setDefense(1);
			if (foe.getReward() > 1) Help.print("You find " + foe.getReward() + " coins on the enemy.\n");
			else Help.print("You find " + foe.getReward() + " coin on the enemy.\n");
			init = false;
			return 2;
		}
		else {
			Help.print("1) Attack\n"
					+ "2) Defend\n"
					+ "3) Use Magic\n"
					+ "\n");
			return 3;
		}
		
	}
	
	public int processPlayerTurn(Character hero, int choice) {
		if (choice == 1) {
			int dealt = hero.getAttack()-foe.getDefense();
			Help.print("You attack, dealing " + dealt + " damage!\n");
			foe.setHP(foe.getHP()-dealt);
		}
		if (choice == 2) {
			Help.print("You defend!\n");
			hero.setDefense(4);
			hero.setDefendCharge(4);
		}
		if (choice == 3) {
			if (hero.getMana() >= 2) {
				Help.print("For now, magic is just a better attack. You blast the enemy for 5 damage!\n");
				foe.setHP(foe.getHP()-5);
				hero.setMana(hero.getMana()-2);
			}
			else {
				Help.print("You don't have enough mana for that!\n");
				Help.print(""
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
		else hero.setDefense(1);
		if (foe.getHP() > 0) {
			int dealing = foe.getAttack()-hero.getDefense();
			Help.print("The enemy then counter attacks, dealing " + dealing + " damage.\n");
			hero.setHP(hero.getHP()-dealing);
		}
		else return 2;
		
		
		if (hero.getHP() > 0) {
			return 1;
		}
		else return 0;
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

