package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Borsa borsa;
	
	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.labirinto = partita.getLabirinto();
		this.giocatore = partita.getGiocatore();
		this.borsa = giocatore.getBorsa();
		
	}
	

	public void gioca(IOConsole console) {
		String istruzione;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione,console));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione,IOConsole console) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(console); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro(),console);
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto(console);
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro(),console);
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro(),console);
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole console) {
		for(int i=0; i< elencoComandi.length; i++)
			console.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione,IOConsole console) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		console.mostraMessaggio(labirinto.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!"); // si desidera smettere
	}
	
	//Prende un attrezzo dalla stanza
	private void prendi(String nomeAttrezzo,IOConsole console) {
		if (nomeAttrezzo == null)
			console.mostraMessaggio("Quale attrezzo vuoi prendere?");
		
		if(!this.labirinto.getStanzaCorrente().hasAttrezzo(nomeAttrezzo))
			console.mostraMessaggio("Attrezzo non prensente nella stanza!");

		Attrezzo attrezzoDaSpostare = this.labirinto.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(this.giocatore.getBorsa().addAttrezzo(attrezzoDaSpostare)) {
			this.labirinto.getStanzaCorrente().removeAttrezzo(attrezzoDaSpostare);
			console.mostraMessaggio("Hai preso: "+attrezzoDaSpostare.getNome());
		}
		else
			console.mostraMessaggio("Borsa piena!");
	}
	
	//Posa un attrezzo nella stanza
	private void posa(String nomeAttrezzo,IOConsole console) {
		if (nomeAttrezzo == null)
			console.mostraMessaggio("Quale attrezzo vuoi posare?");
		
		if(!this.borsa.hasAttrezzo(nomeAttrezzo))
			console.mostraMessaggio("Attrezzo non prensente nella borsa!");
		
		Attrezzo attrezzoDaSpostare = this.borsa.getAttrezzo(nomeAttrezzo);
		if(this.labirinto.getStanzaCorrente().addAttrezzo(attrezzoDaSpostare)) {
			this.borsa.removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("Hai posato: "+attrezzoDaSpostare.getNome());
		}
		else
			console.mostraMessaggio("Stanza piena!");
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca(console);
	}
}