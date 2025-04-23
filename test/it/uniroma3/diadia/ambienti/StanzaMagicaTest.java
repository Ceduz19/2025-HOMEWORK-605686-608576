package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaMagicaTest {

    private StanzaMagica stanza;
    private Attrezzo dummy;

    @BeforeEach
    void setUp() {
        stanza = new StanzaMagica("magic");
        dummy = new Attrezzo("test", 0);
    }

    @Test
    void testNoMagica() {
        stanza.addAttrezzo(dummy);
        stanza.addAttrezzo(dummy);
        stanza.addAttrezzo(dummy);

        assertTrue(stanza.hasAttrezzo(dummy.getNome()));
    }

    @Test
    void testMagica() {
        stanza.addAttrezzo(dummy);
        stanza.addAttrezzo(dummy);
        stanza.addAttrezzo(dummy);
        stanza.addAttrezzo(dummy);

        String reversed = new StringBuilder(dummy.getNome()).reverse().toString();
        assertTrue(stanza.hasAttrezzo(reversed));
    }
}
