package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {

    private static IOSimulator simulatorFastVictory;
    private static IOSimulator simulatorVictory;
    private static IOSimulator simulatorDeath;

    @BeforeAll
    static void setUp() {
        simulatorFastVictory = new IOSimulator("vai nord");
        simulatorVictory = new IOSimulator(
                "vai est", //aula N11
                "vai est", //laboratorio
                "guarda",
                "vai est", //atrio
                "vai nord" //biblioteca
        );
        simulatorDeath = new IOSimulator(50,
                "guarda",
                "prendi osso",
                "vai sud", //aula N10
                "prendi lanterna",
                "posa osso",
                "vai ovest", //laboratorio
                "vai ovest", //aula N11
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest",
                "vai ovest" //spostato 20 volte, no CFU
        );
    }

    @Test
    void simulaVittoriaVeloce() {
        DiaDia diaDia = new DiaDia(simulatorFastVictory);
        diaDia.gioca();

        assertTrue(diaDia.getPartita().vinta());
    }

    @Test
    void simulaVittoria() {
        DiaDia diaDia = new DiaDia(simulatorVictory);
        diaDia.gioca();

        //for (String s : ((IOSimulator) diaDia.getPartita().getIo()).getMessaggi())
        //    System.out.println(s);

        assertTrue(diaDia.getPartita().vinta());
    }

    @Test
    void simulaMorte() {
        DiaDia diaDia = new DiaDia(simulatorDeath);
        diaDia.gioca();

        /*for (String s : ((IOSimulator) diaDia.getPartita().getIo()).getMessaggi()) {
            if (s == null) break;
            System.out.println(s);
        }*/

        assertTrue(diaDia.getPartita().isFinita());
        assertFalse(diaDia.getPartita().giocatoreIsVivo());
    }
}
