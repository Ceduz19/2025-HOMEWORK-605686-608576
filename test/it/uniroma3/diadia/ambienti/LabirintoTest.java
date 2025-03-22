package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	Labirinto labirinto;
	Stanza stanza;
	Stanza stanza2;
	
	@BeforeEach
	void setUp() {
		labirinto = new Labirinto();
		stanza = new Stanza("stanza");
		stanza2 = new Stanza("stanza2");
	}

	@Test
	void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(stanza);
		assertEquals(stanza,labirinto.getStanzaCorrente());
	}
	
	@Test
	void testSetStanzaCorrenteNull() {
		labirinto.setStanzaCorrente(null);
		assertEquals(null,labirinto.getStanzaCorrente());
	}

	@Test
	void testSetStanzaCorrenteCambioStanza() {
		labirinto.setStanzaCorrente(stanza);
		labirinto.setStanzaCorrente(stanza2);
		assertEquals(stanza2,labirinto.getStanzaCorrente());
	}
}
