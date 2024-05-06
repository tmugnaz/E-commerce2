package ecommerce;

public class main {

	public static void main(String[] args) {
		
		Utente mario = new Utente("mario","rossi","msssrss",Ruolo.AMMINISTRATORE_DI_SISTEMA);
		mario.aggiungiNumeroTelefono("33333333");
		mario.aggiungiNumeroTelefono("2222222222");
		mario.StampaInfoUtente();
		
	}

}
