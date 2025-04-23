package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoGuarda implements Comando {

    @Override
    public void esegui(Partita partita) {
        IO io = partita.getIo();

        io.mostraMessaggio("###### PARITA ######");
        io.mostraMessaggio("- Stato: " + (partita.isFinita() ? "finita" : "in corso"));

        mostraInfoGiocatore(partita, io);
        mostraInfoStanzaCorrente(partita, io);

        io.mostraMessaggio("###############");
    }

    private void mostraInfoGiocatore(Partita partita, IO io) {
        io.mostraMessaggio("\n---- GIOCATORE");
        Giocatore giocatore = partita.getGiocatore();

        if (giocatore == null) {
            io.mostraMessaggio("[!] La partita non presenta alcuna istanza di un giocatore");
            return;
        }

        io.mostraMessaggio("- CFU: " + giocatore.getCfu());

        io.mostraMessaggio("--- BORSA");
        Borsa borsa = giocatore.getBorsa();
        if (borsa == null) {
            io.mostraMessaggio("[!] Il giocatore non ha alcuna borsa");
            return;
        }

        io.mostraMessaggio("- Peso max: " + borsa.getPesoMax());
        io.mostraMessaggio("- Peso attuale: " + borsa.getPeso());
    }

    private void mostraInfoStanzaCorrente(Partita partita, IO io) {
        io.mostraMessaggio("\n---- STANZA CORRENTE");
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();

        if (stanzaCorrente == null) {
            io.mostraMessaggio("[!] Il giocatore non si trova in nessuna stanza");
            return;
        }

        String nome = stanzaCorrente.getNome();
        String desc = stanzaCorrente.getDescrizione();

        io.mostraMessaggio("- Nome: " + (nome == null ? "nessuno" : nome));
        io.mostraMessaggio("- Descrizione: " + (desc == null ? "nessuna" : desc));

        String[] direzioni = stanzaCorrente.getDirezioni();
        StringBuilder direzioniDisp = new StringBuilder();
        String curr;
        for (int i = 0; i < direzioni.length; i++) {
            curr = direzioni[i];
            if (curr == null) break;

            direzioniDisp.append(curr);
            if (i+1 < direzioni.length && direzioni[i+1] != null) direzioniDisp.append(", ");
        }

        io.mostraMessaggio("- Direzioni disponibili: " + direzioniDisp);

    }

    @Override
    public void setParametro(String parametro) {
        //no params needed
    }

    @Override
    public String getNome() {
        return "guarda";
    }

    @Override
    public String getParametro() {
        return null;
    }
}
