package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

    private static final String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

    @Override
    public void esegui(Partita partita) {
        for (String string : elencoComandi) partita.getIo().mostraMessaggio(string + " ");
    }

    @Override
    public void setParametro(String parametro) {
        //no params needed
    }

    @Override
    public String getNome() {
        return "aiuto";
    }

    @Override
    public String getParametro() {
        return null;
    }
}
