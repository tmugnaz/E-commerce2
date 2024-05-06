package ecommerce;

import java.util.ArrayList;
import java.util.List;

public abstract class Utente {
	private String nome;
	private String cognome;
	private String codiceFiscale ;
	private List<String> numeriTelefono= new ArrayList<String>();
	private List<IndirizzoUtente> indirizzi = new ArrayList<IndirizzoUtente>();
	
	public Utente(String nome, String cognome, String codiceFiscale) {
	
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		
	}
	
	
	public void aggiungiIndirizzo(String via, String cap, String citta, TipoIndirizzo tipoIndirizzo) {
		IndirizzoUtente i = new IndirizzoUtente(via, cap, citta, tipoIndirizzo);
		this.indirizzi.add(i);
	}
	
	public void aggiungiIndirizzo(IndirizzoUtente i) {
		this.indirizzi.add(i);
	}
	
	public void aggiungiNumeroTelefono(String numero) {
		
		this.getNumeriTelefono().add(numero);
	}
	
	public void StampaInfoUtente() {
		System.out.println("nome: "+this.getNome()+", cognome: "+this.getCognome()
		+", codice fiscale: "+this.getCodiceFiscale());
		int cont =1;
		for (String string : numeriTelefono) {
			System.out.println("numero "+cont+":"+string);
			cont++;
		}
	}
	
	
	
	
	//GETTER E SETTER------------
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	



	public List<String> getNumeriTelefono() {
		return numeriTelefono;
	}






	public void setNumeriTelefono(List<String> numeriTelefono) {
		this.numeriTelefono = numeriTelefono;
	}

	
	
	

}
