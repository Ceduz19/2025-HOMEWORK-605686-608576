package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	@Test
	void testAddAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzoOverDefMax = new Attrezzo("test", Borsa.DEFAULT_PESO_MAX_BORSA+1);
		
		assertFalse(borsa.addAttrezzo(attrezzoOverDefMax));
		
		Attrezzo attrezzo = new Attrezzo("test", 1);
		for (int i = 0; i < 10; i++)
			assertTrue(borsa.addAttrezzo(attrezzo));
		
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testGetPeso() {
		Borsa borsa = new Borsa(17);
		assertEquals(0, borsa.getPeso());
		
		for (int i = 1; i < 5; i++) {
			borsa.addAttrezzo(new Attrezzo("attrezzo" + i, i));
		}
		
		assertEquals(10, borsa.getPeso());
	}
	
	@Test
	void testRemoveAttrezzo() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("test", 1);
		
		assertNull(borsa.removeAttrezzo("test"));
		
		borsa.addAttrezzo(attrezzo);
		assertNotNull(borsa.removeAttrezzo("test"));
	}

}
