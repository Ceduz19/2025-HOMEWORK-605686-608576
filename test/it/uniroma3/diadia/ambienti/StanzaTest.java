package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	@Test
	void testImpostaStanzaAdiacente() {
		Stanza stanza = new Stanza("test");
		Stanza stanzaNord = new Stanza("stanzaNord");
		Stanza stanzaEst = new Stanza("stanzaEst");
		Stanza stanzaSud = new Stanza("stanzaSud");
		Stanza stanzaOvest = new Stanza("stanzaOvest");
		
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		stanza.impostaStanzaAdiacente("est", stanzaEst);
		stanza.impostaStanzaAdiacente("sud", stanzaSud);
		stanza.impostaStanzaAdiacente("ovest", stanzaOvest);
		
		assertEquals(stanzaNord, stanza.getStanzaAdiacente("nord"));
		assertEquals(stanzaEst, stanza.getStanzaAdiacente("est"));
		assertEquals(stanzaSud, stanza.getStanzaAdiacente("sud"));
		assertEquals(stanzaOvest, stanza.getStanzaAdiacente("ovest"));
		
		Stanza dummy = new Stanza("dummy");
		stanza.impostaStanzaAdiacente("dummyDir", dummy);
		assertNull(stanza.getStanzaAdiacente("dummyDir"));
	}
	
	@Test
	void testHasAttrezzo() {
		Stanza stanza = new Stanza("test");
		
		assertFalse(stanza.hasAttrezzo("testAttrezzo"));
		
		Attrezzo attrezzo = new Attrezzo("testAttrezzo", 1);
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("testAttrezzo"));
	}
	
	@Test
	void testAddAttrezzo() {
		Stanza stanza = new Stanza("test");
		Attrezzo attrezzo = new Attrezzo("testAttrezzo", 1);
		
		for (int i = 0; i < 10; i++)
			assertTrue(stanza.addAttrezzo(attrezzo));
		
		assertFalse(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	void testGetAttrezzo() {
		Stanza stanza = new Stanza("test");
		Attrezzo attrezzo = new Attrezzo("testAttrezzo", 1);
		
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("testAttrezzo"));
	}

}
