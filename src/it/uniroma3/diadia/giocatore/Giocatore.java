package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	public static final int CFU_INIZIALI = 20;
	
	private Borsa borsa;
	private int cfu;

	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
