package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {

    private String direzione;

    @Override
    public void esegui(Partita partita) {
        IO io = partita.getIo();

        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        if (direzione == null) {
            io.mostraMessaggio("Nessuna direzione specificata!");
            return;
        }

        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Non esiste alcuna stanza adiacente a " + this.direzione + "!");
            return;
        }

        partita.getLabirinto().setStanzaCorrente(prossimaStanza);
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
        io.mostraMessaggio("Sei andato nella stanza a " + this.direzione);
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }
}
