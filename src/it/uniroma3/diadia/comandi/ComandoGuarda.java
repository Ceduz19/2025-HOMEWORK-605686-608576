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
        io.mostraMessaggio("Stato: " + (partita.isFinita() ? "finita" : "in corso"));

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

        io.mostraMessaggio("CFU: " + giocatore.getCfu());

        io.mostraMessaggio("--- BORSA");
        Borsa borsa = giocatore.getBorsa();
        if (borsa == null) io.mostraMessaggio("[!] Il giocatore non ha alcuna borsa");
        else io.mostraMessaggio(borsa.toString());
    }

    private void mostraInfoStanzaCorrente(Partita partita, IO io) {
        io.mostraMessaggio("\n---- STANZA CORRENTE");
        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();

        if (stanzaCorrente == null) io.mostraMessaggio("[!] Il giocatore non si trova in nessuna stanza");
        else io.mostraMessaggio(stanzaCorrente.toString());
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
