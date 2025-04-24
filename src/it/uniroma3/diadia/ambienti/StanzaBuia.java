package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private final String nomeAttrezzo; //nome dell'attrezzo richiesto per vedere la descrizione della stanza

    public StanzaBuia(String nomeStanza, String nomeAttrezzo) {
        super(nomeStanza);
        this.nomeAttrezzo = nomeAttrezzo;
    }

    @Override
    public String getDescrizione() {
        return hasAttrezzo(nomeAttrezzo) ? super.getDescrizione() : "qui c'è buio pesto";
    }
}
