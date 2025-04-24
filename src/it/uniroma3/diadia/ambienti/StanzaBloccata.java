package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

    private final String dirBloccata;
    private final String nomeAttrezzoSblocco; //nome dell'attrezzo che permette di andare nella stanza di dirBloccata

    public StanzaBloccata(String nome, String dirBloccata, String nomeAttrezzoSblocco) {
        super(nome);
        this.dirBloccata = dirBloccata;
        this.nomeAttrezzoSblocco = nomeAttrezzoSblocco;
    }

    @Override
    public Stanza getStanzaAdiacente(String direzione) {
       return stanzaSbloccata(direzione) ? super.getStanzaAdiacente(direzione) : this;
    }

    @Override
    public String getDescrizione() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(getNome());

        risultato.append("\nUscite: ");
        for (String direzione : getDirezioni())
            if (direzione != null && stanzaSbloccata(direzione)) risultato.append(" ").append(direzione);

        risultato.append("\nAttrezzi nella stanza: ");
        for (int i = 0; i < this.numeroAttrezzi; i++)
            risultato.append(attrezzi[i].toString()).append(" ");

        return risultato.toString();
    }

    /**
     * @param direzione direzione della stanza da controllare.
     * @return {@code true} se è possibile andare nella stanza della direzione indicata, altrimenti {@code false}.
     */
    private boolean stanzaSbloccata(String direzione) {
        return dirBloccata == null || !dirBloccata.equals(direzione) || nomeAttrezzoSblocco == null || hasAttrezzo(nomeAttrezzoSblocco);
    }
}
