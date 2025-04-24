package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBuiaTest {

    private Attrezzo lanterna;
    private StanzaBuia stanza;

    @BeforeEach
    void setUp() {
        lanterna = new Attrezzo("lanterna", 1);
        stanza = new StanzaBuia("stanzaBuia", lanterna.getNome());
    }

    @Test
    void testDescrizioneNoAttrezzo() {
        assertEquals("qui c'è buio pesto", stanza.getDescrizione());
    }

    @Test
    void testDescrizioneAttrezzo() {
        stanza.addAttrezzo(lanterna);
        assertNotEquals("qui c'è buio pesto", stanza.getDescrizione());
    }
}
