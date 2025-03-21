package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GiocatoreTest {

	@Test
	void testSetCfu() {
		Giocatore giocatore = new Giocatore();
		
		assertEquals(giocatore.CFU_INIZIALI, giocatore.getCfu());
		
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}
	
}
