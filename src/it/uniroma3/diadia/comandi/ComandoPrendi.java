package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
        IO io = partita.getIo();

        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Nessun attrezzo da prendere specificato!");
            return;
        }

        Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
        if(!stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
            io.mostraMessaggio("L'attrezzo \"" + nomeAttrezzo + "\" non è prensente nella stanza!");
            return;
        }

        Attrezzo attrezzoDaSpostare = stanzaCorrente.getAttrezzo(nomeAttrezzo);
        if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaSpostare)) {
            stanzaCorrente.removeAttrezzo(attrezzoDaSpostare);
            io.mostraMessaggio("Hai preso: "+ attrezzoDaSpostare.getNome());
        }
        else
            io.mostraMessaggio("Borsa piena!");
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public String getNome() {
        return "prendi";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
}
