package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;



class PartitaTest {
	Partita partita;
	Labirinto labirinto;
	
	@BeforeEach
	void setUp() {
		partita = new Partita();
		labirinto = partita.getLabirinto();
	}

	@Test
	void testVinta() {
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	void testVintaStanzaSbagliata() {
		assertFalse(partita.vinta());
	}
	
	@Test
	void testVintaNuovaStanza() {
		labirinto.setStanzaCorrente(new Stanza("Stanza"));
		assertFalse(partita.vinta());
	}
}
