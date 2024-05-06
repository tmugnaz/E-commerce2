package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	private String nome;
	private String cognome;
	private String codiceFiscale ;
	private Ruolo ruolo;
	private List<String> numeriTelefono= new ArrayList<String>();
	
	public Utente(String nome, String cognome, String codiceFiscale, Ruolo ruolo) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.ruolo = ruolo;
		
	}
	
	
	
	
	
	public void aggiungiNumeroTelefono(String numero) {
		
		this.getNumeriTelefono().add(numero);
	}
	
	public void StampaInfoUtente() {
		System.out.println("nome: "+this.getNome()+", cognome: "+this.getCognome()+", codice fiscale: "+this.getCodiceFiscale()+
							", ruolo: "+this.getRuolo().name());
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
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}






	public List<String> getNumeriTelefono() {
		return numeriTelefono;
	}






	public void setNumeriTelefono(List<String> numeriTelefono) {
		this.numeriTelefono = numeriTelefono;
	}

	
	
	

}
