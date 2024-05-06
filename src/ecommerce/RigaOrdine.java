package ecommerce;

public class RigaOrdine {
	
	
	private Articolo articolo;
	private int prezzoUnitarioArticolo;
	private int qta ;
	private int sconto;
	private int iva;
	
	public RigaOrdine(Articolo articolo, int qta, int sconto, int iva) {
		this.articolo = articolo;
		this.prezzoUnitarioArticolo = articolo.getPrezzo();
		this.qta = qta;
		this.sconto = sconto;
		this.iva = iva;
	}
	
	
	
	
	public Articolo getArticolo() {
		return articolo;
	}




	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}




	//GETTER E SETTER----------------
	public int getPrezzoUnitario() {
		return prezzoUnitarioArticolo;
	}
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitarioArticolo = prezzoUnitario;
	}
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public int getSconto() {
		return sconto;
	}
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}

	
	
}
