package ecommerce;

public class RigaOrdine {
	
	
	
	private int prezzoUnitario;
	private int qta ;
	private int sconto;
	private int iva;
	
	public RigaOrdine(int prezzoUnitario, int qta, int sconto, int iva) {
		
		this.prezzoUnitario = prezzoUnitario;
		this.qta = qta;
		this.sconto = sconto;
		this.iva = iva;
	}
	
	
	
	
	//GETTER E SETTER----------------
	public int getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(int prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
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
