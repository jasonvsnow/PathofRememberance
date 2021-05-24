package thePath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathTest {
	@Test
	public void getTextToPrint() {
		Combat test = new Combat();
		test.toPrint("Hello");
		assertEquals(test.getTextToPrint(), "Hello");
	}
	@Test
	public void getHP() {
		Game test = new Game();
		assertEquals(test.getHP(), 40);
	}

	@Test
	public void getCoins() {
		Game test = new Game();
		assertEquals(test.getCoins(), 0);
	}
	@Test
	public void getAttack() {
		Game test = new Game();
		assertEquals(test.getAttack(), 1);
	}
	@Test
	public void getDefense() {
		Game test = new Game();
		assertEquals(test.getDefense(), 0);
	}

	@Test
	public void getHPPotions() {
		Game test = new Game();
		assertEquals(test.getHPpotions(), 0);
	}
	@Test
	public void isMap() {
		Game test = new Game();
		assertFalse(test.isMap());
	}
	
	@Test
	public void getEnemyAttack() {
		Enemy test = new Enemy(1);
		assertEquals(test.getAttack(), 8);
	}
	@Test
	public void getEnemyHP() {
		Enemy test = new Enemy(1);
		assertEquals(test.getHP(), 20);
	}
	@Test
	public void getEnemyDefense() {
		Enemy test = new Enemy(1);
		assertEquals(test.getDefense(), 2);
	}

	@Test
	public void getReward() {
		Enemy test = new Enemy(1);
		assertEquals(test.getReward(), 3);
	}
	
	@Test
	public void isInit() {
		Combat test = new Combat();
		assertFalse(test.isInit());
	}
	@Test
	public void getFoeType() {
		Combat test = new Combat();
		assertEquals(test.getFoeType(), 0);
	}
	
	
	@Test
	public void getCharacterHP() {
		Character test = new Character();
		assertEquals(test.getHP(), 40);
	}

	@Test
	public void getCharacterCoins() {
		Character test = new Character();
		assertEquals(test.getCoins(), 0);
	}
	@Test
	public void getCharacterAttack() {
		Character test = new Character();
		assertEquals(test.getAttack(), 1);
	}
	@Test
	public void getCharacterDefense() {
		Character test = new Character();
		assertEquals(test.getDefense(), 0);
	}

	@Test
	public void getCharacterHPPotions() {
		Character test = new Character();
		assertEquals(test.getHPPotion(), 0);
	}
	@Test
	public void isCharacterMap() {
		Character test = new Character();
		assertFalse(test.isMap());
	}
	@Test
	public void getRoom() {
		Character test = new Character();
		assertEquals(test.getRoom(), 0);
	}
	@Test
	public void isCaptainKey() {
		Character test = new Character();
		assertFalse(test.isCaptainKey());
	}
	@Test
	public void isTutorial() {
		Character test = new Character();
		assertTrue(test.isTutorial());
	}
	@Test
	public void getDefendBuff() {
		Character test = new Character();
		assertEquals(test.getDefendBuff(), 0);
	}
	@Test
	public void getAttackBuff() {
		Character test = new Character();
		assertEquals(test.getAttackBuff(), 0);
	}
	
	@Test
	public void getDefendDebbuff() {
		Character test = new Character();
		assertEquals(test.getDefendDebuff(), 0);
	}
	
	@Test
	public void getAttackDebuff() {
		Character test = new Character();
		assertEquals(test.getAttackDebuff(), 0);
	}
	
	@Test
	public void getType() {
		Enemy test = new Enemy(1);
		assertEquals(test.getType(), 1);
	}
	@Test
	public void getBuffAttack() {
		Enemy test = new Enemy(1);
		assertEquals(test.getBuffAttack(), 0);
	}
	@Test
	public void getBuffDefenaw() {
		Enemy test = new Enemy(1);
		assertEquals(test.getBuffDefense(), 0);
	}
	@Test
	public void getDebuffAttack() {
		Enemy test = new Enemy(1);
		assertEquals(test.getDebuffAttack(), 0);
	}
	@Test
	public void getDefbuffDefense() {
		Enemy test = new Enemy(1);
		assertEquals(test.getDebuffDefense(), 0);
	}
	
	
	
	
	
	
}