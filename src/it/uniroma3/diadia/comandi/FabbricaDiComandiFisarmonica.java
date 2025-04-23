package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

    @Override
    public Comando costruisciComando(String istruzione) {
        if (istruzione == null) return new ComandoNonValido();

        Scanner scannerDiParole = new Scanner(istruzione);
        String nomeComando;
        String parametro = null;
        Comando comando;

        if (scannerDiParole.hasNext())
            nomeComando = scannerDiParole.next();
        else
            return new ComandoNonValido();

        switch (nomeComando) {
            case "aiuto":
                comando = new ComandoAiuto();
                break;
            case "fine":
                comando = new ComandoFine();
                break;
            case "vai":
                comando = new ComandoVai();
                break;
            case "prendi":
                comando = new ComandoPrendi();
                break;
            case "posa":
                comando = new ComandoPosa();
                break;
            case "guarda":
                comando = new ComandoGuarda();
                break;
            default:
                comando = new ComandoNonValido();
                break;
        }

        if (scannerDiParole.hasNext())
            parametro = scannerDiParole.next();

        comando.setParametro(parametro);
        return comando;
    }
}
