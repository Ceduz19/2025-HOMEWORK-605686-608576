package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

    private static final FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

    @Test
    void testCostruisciAiuto() {
        Comando cmd = factory.costruisciComando("aiuto");
        assertEquals("aiuto", cmd.getNome());
        assertInstanceOf(ComandoAiuto.class, cmd);
    }

    @Test
    void testCostruisciFine() {
        Comando cmd = factory.costruisciComando("fine");
        assertEquals("fine", cmd.getNome());
        assertInstanceOf(ComandoFine.class, cmd);
    }

    @Test
    void testCostruisciVai() {
        Comando cmd = factory.costruisciComando("vai");
        assertEquals("vai", cmd.getNome());
        assertInstanceOf(ComandoVai.class, cmd);
    }

    @Test
    void testCostruisciPrendi() {
        Comando cmd = factory.costruisciComando("prendi");
        assertEquals("prendi", cmd.getNome());
        assertInstanceOf(ComandoPrendi.class, cmd);
    }

    @Test
    void testCostruisciPosa() {
        Comando cmd = factory.costruisciComando("posa");
        assertEquals("posa", cmd.getNome());
        assertInstanceOf(ComandoPosa.class, cmd);
    }

    @Test
    void testCostruisciGuarda() {
        Comando cmd = factory.costruisciComando("guarda");
        assertEquals("guarda", cmd.getNome());
        assertInstanceOf(ComandoGuarda.class, cmd);
    }

    @Test
    void testCostruisciNonValidoNull() {
        Comando cmd = factory.costruisciComando(null);
        assertInstanceOf(ComandoNonValido.class, cmd);
    }

    @Test
    void testCostruisciNonValido() {
        Comando cmd = factory.costruisciComando("comando sconosciuto");
        assertInstanceOf(ComandoNonValido.class, cmd);
    }
}
