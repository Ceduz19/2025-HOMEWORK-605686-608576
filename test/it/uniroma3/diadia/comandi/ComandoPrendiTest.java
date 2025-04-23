package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ComandoPrendiTest {

    private ComandoPrendi cmd;
    private Partita partita;

    @BeforeEach
    void setUp() {
        cmd = new ComandoPrendi();
        partita = new Partita(new IOConsole());
    }

    @Test
    void testGetNome() {
        assertEquals("prendi", cmd.getNome());
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
        cmd.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
    }

    @Test
    void testEseguiNoAttrezzo() {
        cmd.setParametro("attrezzo");
        cmd.esegui(partita);

        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("attrezzo"));
    }

    @Test
    void testEsegui() {
        cmd.setParametro("osso");
        cmd.esegui(partita);

        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
    }
}
