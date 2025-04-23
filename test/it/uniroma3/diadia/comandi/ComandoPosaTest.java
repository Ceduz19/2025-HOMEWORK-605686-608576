package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoPosaTest {

    private ComandoPosa cmd;
    private Partita partita;
    private Attrezzo attrezzo;

    @BeforeEach
    void setUp() {
        cmd = new ComandoPosa();
        partita = new Partita(new IOConsole());
        attrezzo = new Attrezzo("test", 2);
    }

    @Test
    void testGetNome() {
        assertEquals("posa", cmd.getNome());
    }

    @Test
    void testGetParametro() {
        assertNull(cmd.getParametro());

        cmd.setParametro("param");
        assertEquals("param", cmd.getParametro());
    }

    @Test
    void testSetParametro() {
        cmd.setParametro("test");
        assertEquals("test", cmd.getParametro());

        cmd.setParametro(null);
        assertNull(cmd.getParametro());
    }

    @Test
    void testEseguiNoParam() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        cmd.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
    }

    @Test
    void testEseguiNoAttrezzo() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        cmd.setParametro("attrezzo");
        cmd.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
    }

    @Test
    void testEsegui() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);

        cmd.setParametro(attrezzo.getNome());
        cmd.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
    }

}
