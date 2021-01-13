package finalProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PathofRememberanceTest {

	@Test
	public void getHP() {
		Player test = new Player();
		assertEquals(test.getHP(), 50);
		

	}
	
	@Test
	public void getType() {
		Enemy test = new Enemy();
		assertEquals(test.getType(), 0);
	}
	
	@Test
	public void getSheild() {
		Player test = new Player();
		assertEquals(test.getShield(), 0);
	}
	
	@Test
	public void getCoins() {
		Player test = new Player();
		assertEquals(test.getCoins(), 0);
	}
	
	@Test
	public void getPotions() {
		Player test = new Player();
		assertEquals(test.getPotions(), 0);
	}
	
	@Test
	public void getDefendCharge() {
		Player test = new Player();
		assertEquals(test.getDefendCharge(), 0);
	}
	@Test
	public void getHeight() {
		Player test = new Player();
		assertEquals(test.getHeight(), "");
	}
	@Test
	public void getColor() {
		Player test = new Player();
		assertEquals(test.getColor(), "");
	}
	@Test
	public void getHairColor() {
		Player test = new Player();
		assertEquals(test.getHairColor(), "");
	}
	@Test
	public void getHairLength() {
		Player test = new Player();
		assertEquals(test.getHairLength(), "");
	}
	@Test
	public void getClothes() {
		Player test = new Player();
		assertEquals(test.getClothes(), "");
	}
	@Test
	public void getRoom() {
		Player test = new Player();
		assertEquals(test.getRoom(), 0);
	}
	@Test
	public void isWesternBarracksKey() {
		Player test = new Player();
		assertFalse(test.isWesternBarracksKey());
	}
	@Test
	public void isCaptainChamberKey() {
		Player test = new Player();
		assertFalse(test.isCaptainChamberKey());
	}
	@Test
	public void getSquid() {
		Player test = new Player();
		assertEquals(test.getSquid(), 0);
	}
	@Test
	public void takeDMG() {
		Player test = new Player();
		assertEquals(test.takeDMG(5), 5);
	}
	
	
	

}