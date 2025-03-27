package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	Giocatore giocatore;
	
	@BeforeEach
	void setUp() {
		giocatore = new Giocatore();
	}
	
	@Test
	void testSetCfuIniziali() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	void testSetCfu() {
		giocatore.setCfu(0);
		assertEquals(0,giocatore.getCfu());
	}
	
	@Test
	void testSetCfuNonImpostati() {
		assertNotEquals(0,giocatore.getCfu());
	}

}
