package ecommerce;

import java.util.List;

public class Cliente extends Utente{
	
	private List<OrdineVendita> ordiniVendita;

	public Cliente(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome, codiceFiscale);
	}
	
	public Cliente(String nome, String cognome, String codiceFiscale, List<String> numeriTelefono,
			List<IndirizzoUtente> indirizzi) {
		super(nome, cognome, codiceFiscale, numeriTelefono, indirizzi);
	}



	public void creaOrdineVendita(
			List<RigaOrdine> righeOrdine,IndirizzoUtente indirizzoFatturazione, IndirizzoUtente indirizzoSpedizione, MetodoPagamento metodoPagamento) {
		this.ordiniVendita.add(new OrdineVendita(indirizzoFatturazione, indirizzoSpedizione, metodoPagamento,righeOrdine));
	}
	
	

}
