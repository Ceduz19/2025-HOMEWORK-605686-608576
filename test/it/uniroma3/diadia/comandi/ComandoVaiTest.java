package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComandoVaiTest {

    private ComandoVai cmd;
    private Partita partita;

    @BeforeEach
    void setUp() {
        cmd = new ComandoVai();
        partita = new Partita(new IOConsole());
    }

    @Test
    void testGetNome() {
        assertEquals("vai", cmd.getNome());
    }

    @Test
    void testGetParametro() {
        assertNull(cmd.getParametro());

        cmd.setParametro("set");
        assertEquals("set", cmd.getParametro());
    }

    @Test
    void testSetParametro() {
        cmd.setParametro("test");
        assertEquals("test", cmd.getParametro());
    }

    @Test
    void testEsegui() {
        Stanza next = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("nord");

        cmd.setParametro("nord");
        cmd.esegui(partita);

        assertSame(next, partita.getLabirinto().getStanzaCorrente());
    }
}
