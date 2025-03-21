package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class LabirintoTest {

	@Test
	void testSetStanzaCorrente() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("test");
		
		labirinto.setStanzaCorrente(stanza);
		assertEquals(labirinto.getStanzaCorrente(), stanza);
	}

}
