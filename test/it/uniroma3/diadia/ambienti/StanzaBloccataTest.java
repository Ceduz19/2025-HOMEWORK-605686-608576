package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StanzaBloccataTest {

    private static Attrezzo passepartout;
    private static Stanza stanzaAdiacente;
    private static StanzaBloccata stanzaNoDirNoNome;
    private static StanzaBloccata stanzaDirNoNome;
    private static StanzaBloccata stanzaNoDirNome;
    private static StanzaBloccata stanzaDirNome;

    @BeforeAll
    static void setUp() {
        passepartout = new Attrezzo("passepartout", 1);
        stanzaAdiacente = new Stanza("stanzaAdiacente");

        stanzaNoDirNoNome = new StanzaBloccata("stanza", null, null);
        stanzaNoDirNoNome.impostaStanzaAdiacente("nord", stanzaAdiacente);

        stanzaDirNoNome = new StanzaBloccata("stanza", "nord", null);
        stanzaDirNoNome.impostaStanzaAdiacente("nord", stanzaAdiacente);

        stanzaNoDirNome = new StanzaBloccata("stanza", null, passepartout.getNome());
        stanzaNoDirNome.impostaStanzaAdiacente("nord", stanzaAdiacente);

        stanzaDirNome = new StanzaBloccata("stanza", "nord", passepartout.getNome());
        stanzaDirNome.impostaStanzaAdiacente("nord", stanzaAdiacente);
    }

    @Test
    void testNoDirNoNome() {
        assertSame(stanzaAdiacente, stanzaNoDirNoNome.getStanzaAdiacente("nord"));
        assertTrue(stanzaNoDirNoNome.getDescrizione().contains("nord"));
    }

    @Test
    void testDirNoNome() {
        assertSame(stanzaAdiacente, stanzaDirNoNome.getStanzaAdiacente("nord"));
        assertTrue(stanzaDirNoNome.getDescrizione().contains("nord"));
    }

    @Test
    void testNoDirNome() {
        assertSame(stanzaAdiacente, stanzaNoDirNome.getStanzaAdiacente("nord"));
        assertTrue(stanzaNoDirNome.getDescrizione().contains("nord"));
    }

    @Test
    void testDirNomeNoAttrezzo() {
        assertSame(stanzaDirNome, stanzaDirNome.getStanzaAdiacente("nord"));
        assertFalse(stanzaDirNome.getDescrizione().contains("nord"));
    }

    @Test
    void testDirNomeAttrezzo() {
        stanzaDirNome.addAttrezzo(passepartout);
        assertSame(stanzaAdiacente, stanzaDirNome.getStanzaAdiacente("nord"));
        assertTrue(stanzaDirNome.getDescrizione().contains("nord"));
    }
}
