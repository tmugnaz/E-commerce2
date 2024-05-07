package ecommerce;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		avviaApplicazione();

	}

	/*
	 * serie utenti preimpostati da passare in input a applicazione menu di gestione
	 * (differente menu per cliente e amministrazione interfaccia per cfreazione
	 * ordini e righe ordine da parte utente creazione categorie e articoli per
	 * amministratori
	 * 
	 */

	public static void avviaApplicazione() {
		Scanner scanner = new Scanner(System.in); 
			System.out.println("vuoi loggare come amministratore o come cliente (1/2)");
			int sceltaUtente = scanner.nextInt();
			scanner.nextLine();
			switch (sceltaUtente) {
			case (1):
				System.out.println("ciao amministratore");
				
				break;
			case (2):
				System.out.println("ciao cliente");

				break;
			default:
				System.out.println("hai sbagliato riprova");
				break;
			}
		
		
	}
}
