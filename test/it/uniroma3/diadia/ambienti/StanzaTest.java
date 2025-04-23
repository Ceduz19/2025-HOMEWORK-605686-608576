package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	Stanza stanza;
	Stanza stanzaNord;
	Stanza stanzaSud;
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;
	
	@BeforeEach
	public void setUp() {
		stanza = new Stanza("stanza");
		stanzaNord = new Stanza("stanzaNord");
		stanzaSud = new Stanza("stanzaSud");
		attrezzo1 = new Attrezzo("attrezzo1", 1);
		attrezzo2 = new Attrezzo("attrezzo2", 2);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(attrezzo1));
	}
	
	@Test
	void testAddAttrezzoStanzaPiena() {
		for(int i=0;i<10;i++) {
			stanza.addAttrezzo(new Attrezzo("attrezzzo: "+i,i));
		}
		assertFalse(stanza.addAttrezzo(attrezzo1));
	}
	
	@Test
	void testAddAttrezzoNull() {
		assertFalse(stanza.addAttrezzo(null));
	}
	
	@Test
	void testHasAttrezzo() {
		stanza.addAttrezzo(attrezzo1);
		assertTrue(stanza.hasAttrezzo("attrezzo1"));
	}
	
	@Test
	void testHasAttrezzoNull() {
		assertFalse(stanza.hasAttrezzo("null"));
	}
	
	@Test
	void testHasAttrezzoNonEsistente() {
		assertFalse(stanza.hasAttrezzo("attrezzo3"));
	}
	
	@Test
	void testImpostaStanzaAdiacente() {
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		assertEquals(stanzaNord, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacenteAggiornamentoDirezione() {
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		stanza.impostaStanzaAdiacente("sud", stanzaSud);
		assertNotEquals(stanzaSud, stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiancenteDirezioneNull() {
		stanza.impostaStanzaAdiacente(null, stanzaNord);
		assertNotEquals(stanzaNord, stanza.getStanzaAdiacente(null));
	}

}
