package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
        IO io = partita.getIo();
        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Nessun attrezzo da posare specificato!");
            return;
        }

        Borsa borsa = partita.getGiocatore().getBorsa();

        if(!borsa.hasAttrezzo(nomeAttrezzo)) {
            io.mostraMessaggio("L'attrezzo \"" + nomeAttrezzo + "\" non è prensente nella borsa!");
            return;
        }

        Attrezzo attrezzoDaSpostare = borsa.getAttrezzo(nomeAttrezzo);
        if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaSpostare)) {
            borsa.removeAttrezzo(nomeAttrezzo);
            io.mostraMessaggio("Hai posato: "+attrezzoDaSpostare.getNome());
        }
        else
            io.mostraMessaggio("Stanza piena!");
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }

    @Override
    public String getNome() {
        return "posa";
    }

    @Override
    public String getParametro() {
        return this.nomeAttrezzo;
    }
}
