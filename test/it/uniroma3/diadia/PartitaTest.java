package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {

	
	
	@Test
	void testVinta() {
		Partita partita = new Partita();
		
		assertFalse(partita.vinta());
		
		Labirinto labirinto = partita.getLabirinto();
		Stanza stanzaVincente = labirinto.getStanzaVincente();
		labirinto.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.vinta());
	}
	
	@Test
	void testIsFinita() {
		
		//check not finished when initialzied
		Partita partita1 = new Partita();
		assertFalse(partita1.isFinita());
		
		//check finished when no more cfu
		Partita partita2 = new Partita();
		Giocatore giocatore2 = partita2.getGiocatore();
		giocatore2.setCfu(0);
		assertTrue(partita2.isFinita());
		
		//check finished when in winning room
		Partita partita3 = new Partita();
		Labirinto labirinto3 = partita3.getLabirinto();
		labirinto3.setStanzaCorrente(labirinto3.getStanzaVincente());
		assertTrue(partita3.isFinita());
		
		//check finished when forced
		Partita partita4 = new Partita();
		partita4.setFinita();
		assertTrue(partita4.isFinita());
	}

}
