package ecommerce;

import java.awt.List;

public class IndirizzoUtente {
	
	private String via;
	private String cap;
	private String citta;
	private TipoIndirizzo tipoIndirizzo;
	
	public IndirizzoUtente(String via, String cap, String citta, TipoIndirizzo tipoIndirizzo) {
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.tipoIndirizzo = tipoIndirizzo;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public TipoIndirizzo getTipoIndirizzo() {
		return tipoIndirizzo;
	}

	public void setTipoIndirizzo(TipoIndirizzo tipoIndirizzo) {
		this.tipoIndirizzo = tipoIndirizzo;
	}
	
	

}
