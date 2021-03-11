package thePath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathTest {

	@Test
	public void getHP() {
		Game test = new Game();
		assertEquals(test.getHP(), 50);
	}
	@Test
	public void getMana() {
		Game test = new Game();
		assertEquals(test.getMana(), 20);
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
	public void getMNPotion() {
		Game test = new Game();
		assertEquals(test.getMNPotions(), 0);
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
		Enemy test = new Enemy();
		assertEquals(test.getAttack(), 6);
	}
	@Test
	public void getEnemyHP() {
		Enemy test = new Enemy();
		assertEquals(test.getHP(), 4);
	}
	@Test
	public void getEnemyDefense() {
		Enemy test = new Enemy();
		assertEquals(test.getDefense(), 0);
	}
	@Test
	public void getEnemyMana() {
		Enemy test = new Enemy();
		assertEquals(test.getMana(), 0);
	}
	@Test
	public void getReward() {
		Enemy test = new Enemy();
		assertEquals(test.getReward(), 1);
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
		assertEquals(test.getHP(), 50);
	}
	@Test
	public void getCharacterMana() {
		Character test = new Character();
		assertEquals(test.getMana(), 20);
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
	public void getCharacterMNPotion() {
		Character test = new Character();
		assertEquals(test.getMNPotion(), 0);
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
	public void getDefendCharge() {
		Character test = new Character();
		assertEquals(test.getMNPotion(), 0);
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

	
	
	
}
