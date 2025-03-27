package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	Borsa borsa;
	Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		borsa = new Borsa();
		attrezzo = new Attrezzo("attrezzo",1);
	}

	@Test
	void testAddAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testAddAttrezzoBorsaPiena() {
		for (int i=0;i<10;i++) {
			borsa.addAttrezzo(new Attrezzo("attrezzo"+i,i));
		}
		assertFalse(borsa.hasAttrezzo("nuovoAttrezzo"));
	}
	
	@Test
	void testAddAttrezzoPesoMax() {
		borsa.addAttrezzo(new Attrezzo("attrezzo",20));
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertTrue(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzoNonPresente() {
		assertFalse(borsa.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testHasAttrezzoNull() {
		borsa.addAttrezzo(new Attrezzo("null",5));
		assertTrue(borsa.hasAttrezzo("null"));
	}
}
