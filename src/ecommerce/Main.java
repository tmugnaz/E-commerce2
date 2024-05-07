package ecommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	//METODI AMMINISTRATORE
	// CREAZIONE ARTICOLI	
	// CREAZIONE CATEGORIE 
	// STAMPA ARTICOLI INFO
	// STAMPA LISTA CATEGORIE
	// CANCELLA ARTICOLO
	// CANCELLA CATEGORIE
	
	
	
	

	public static void avviaApplicazione() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("vuoi loggare come amministratore o come cliente (1/2)");
		int sceltaUtente = scanner.nextInt();
		List<Articolo> inventario = popolaInventario();
		scanner.nextLine();
		switch (sceltaUtente) {
		case (1):
			Amministratore admin = loginAdmin(scanner);
			System.out.println("Ciao Amministratore");
			menùAmministratore(scanner, admin,inventario);

			break;
		case (2):
			//Cliente cliente = loginCliente();
			List<Articolo> listaArticoli = popolaInventario();
			stampaListaArticoliDisponibili(listaArticoli);
			creaRigaOrdineEOrdine(listaArticoli);
			

			break;
		default:
			System.out.println("hai sbagliato riprova");
			break;
		}

	}

	public static Amministratore loginAdmin(Scanner scanner) {
		String nome, cognome, codiceFiscale;
		System.out.println("Buongiorno! , prego autenticarsi inserendo nome, cognome e codice Fiscale");
		nome = scanner.nextLine();
		cognome = scanner.nextLine();
		codiceFiscale = scanner.nextLine();
		Amministratore admin = new Amministratore(nome, cognome, codiceFiscale);
		admin.StampaInfoUtente();
		System.out.println();
		System.out.println("STATO -> AUTENTICATO....caricamento menù in corso");
		return admin;

	}

	public static void menùAmministratore(Scanner scanner, Amministratore admin,List<Articolo> inventario) {
		boolean continuaEsecuzione = true;
		while (continuaEsecuzione==true) {
			stampaMenù();
			String scelta = scanner.nextLine();
			switch (scelta) {
			case ("1"):
				break;
			case ("2"):
				break;
			case ("3"):
				StampaInventario(inventario);
				break;
			case ("4"):
				stampaCategorie();
				break;
			case ("5"):
				break;
			case ("6"):
				break;
			case ("7"):
				System.out.println("Uscita...");
				continuaEsecuzione = false;
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
				break;
			}

		}
	}

	public static void stampaMenù() {
		System.out.println("╭───────────────────────────────────────╮\n" +
			               "│     Menù Amministratore               │\n" +
			               "│                                       │\n" +
			               "│   Seleziona un'opzione:               │\n" +
			               "│   1. Creazione articoli               │\n" +
			               "│   2. Creazione Categorie              │\n" +
			               "│   3. Visualizza lista articoli        │\n" +
			               "│   4. Visualizza lista categorie       │\n" +
			               "│   5. Elimina Articolo                 │\n" +
			               "│   6. Elimina Categoria                │\n" +
			               "│   7. Uscita                           │\n" +
			               "│                                       │\n" +
			               "╰───────────────────────────────────────╯");






		}
	
	public static List<Articolo> popolaInventario(){
		Categoria elettronica = new Categoria("Elettronica", 22, 10);
        Categoria smartphone = new Categoria("Smartphone", 22, 5);
        Categoria laptop = new Categoria("Laptop", 22, 8);
        Categoria abbigliamento = new Categoria("Abbigliamento", 22, 15);
        Categoria uomo = new Categoria("Uomo", 22, 10);
        Categoria donna = new Categoria("Donna", 22, 10);
        Categoria casa = new Categoria("Casa", 22, 5);
        Categoria mobili = new Categoria("Mobili", 22, 5);
        
        
        elettronica.aggiungiSottoCategoria(smartphone);
        elettronica.aggiungiSottoCategoria(laptop);
        abbigliamento.aggiungiSottoCategoria(uomo);
        abbigliamento.aggiungiSottoCategoria(donna);
        casa.aggiungiSottoCategoria(mobili);
        
       
        Categoria.aggiungiCategoria(elettronica);
        Categoria.aggiungiCategoria(abbigliamento);
        Categoria.aggiungiCategoria(casa);

        
        Articolo articolo1 = new Articolo("iPhone 12", 1L, 1000, smartphone);
        Articolo articolo2 = new Articolo("Samsung Galaxy S21", 2L, 800, smartphone);
        Articolo articolo3 = new Articolo("MacBook Pro", 3L, 1500, laptop);
        Articolo articolo4 = new Articolo("Dolce & Gabbana Shirt", 4L, 200, uomo);
        Articolo articolo5 = new Articolo("Gucci Dress", 5L, 500, donna);
        Articolo articolo6 = new Articolo("IKEA Sofa", 6L, 700, mobili);
        Articolo articolo7 = new Articolo("IKEA Table", 7L, 300, mobili);
        
       
        List<Articolo> inventario = new ArrayList<>();
        inventario.add(articolo1);
        inventario.add(articolo2);
        inventario.add(articolo3);
        inventario.add(articolo4);
        inventario.add(articolo5);
        inventario.add(articolo6);
        inventario.add(articolo7);
		
		return inventario;
	}

	public static void StampaInventario(List<Articolo> inventario) {
		System.out.println("Inventario:");
        for (Articolo articolo : inventario) {
            System.out.println("Nome: " + articolo.getNome() + 
            		", Prezzo: " + articolo.getPrezzo() + ", "
            				+ "Categoria: " + articolo.getCategoria().getNome());
        }
	}
	 public static void stampaCategorie() {
	        for (Categoria categoria : Categoria.getListaCategorie()) {
	            System.out.println(categoria.getNome());
	            if (!categoria.getSottoCategorie().isEmpty()) {
	                for (Categoria sottocategoria : categoria.getSottoCategorie()) {
	                    System.out.println("\t" + sottocategoria.getNome());
	                }
	            }
	        }
	    }
	 
	 //
	 //
	 //Codici relativi al cliente
	 //
	 //
	 
	 public static List<Cliente> databaseCliente() {
		 return new ArrayList<>(Arrays.asList(
				 new Cliente("Mario", "Rossi", "FNE0FNFN0J902", new ArrayList<>(Arrays.asList("34832440208")), new ArrayList<>(Arrays.asList(
						 new IndirizzoUtente("via gramsci", "11", "Firenze", TipoIndirizzo.FATTURAZIONE),
						 new IndirizzoUtente("via calatafimi", "34", "Bologna", TipoIndirizzo.FATTURAZIONE),
						 new IndirizzoUtente("via vittorio manuele veneto", "89", "Milano", TipoIndirizzo.SPEDIZIONE)
						 ))),
				 new Cliente("Filippo", "Costa", "NFEOIFW20920"),
				 new Cliente("Andrea", "Russo", "IBGO40JIFODS"),
				 new Cliente("Luigi", "Bianchi", "UREWI839939"),
				 new Cliente("Leonardo", "Gallo", "ONPKMOHPK32")
				 ));
	 }
	 
	 public static Cliente loginCliente() {
		 Cliente cliente = new Cliente("null", "null", "null");
		 List<Cliente> listaClienti = databaseCliente();
		 Scanner scanner = new Scanner(System.in);
		 boolean clienteNonTrovato = true;
		 while(clienteNonTrovato) {
			 System.out.println("Inserire nome");
			 String nomeCliente = scanner.nextLine();
			 System.out.println("Inserire cognome");
			 String cognomeCliente = scanner.nextLine();
			 for (Cliente databaseCliente : listaClienti) {
				if (databaseCliente.getNome().equalsIgnoreCase(nomeCliente) && databaseCliente.getCognome().equalsIgnoreCase(cognomeCliente)) {
					cliente = databaseCliente;
					System.out.println("Benvenuto "+cliente.getNome()+" "+cliente.getCognome());
					cliente.StampaInfoUtente();
					clienteNonTrovato = false;
				}
			}
			if (clienteNonTrovato) {
				System.out.println("Nome o cognome sbagliato/i\n"+"Riprova");
				System.out.println("<---x--->");
			}
		 }
		 scanner.close();
		return cliente;
	 }
	  
	 public static void stampaListaArticoliDisponibili(List<Articolo> listaArticoli) {
		 System.out.println("───────────────────────────────────────\n" +
	               "Scegli gli articoli da acquistare             \n");
		 for (Articolo articolo : listaArticoli) {
			System.out.println("id: "+articolo.getId()+" nome: "+articolo.getNome()+" prezzo: "+articolo.getPrezzo()+"€"+" categoria: "+articolo.getCategoria().getNome());
		}
	       
		 System.out.println("───────────────────────────────────────");
	 }
	 
	 public static void creaRigaOrdineEOrdine(List<Articolo> listaArticolo) {
		 List<RigaOrdine> listaRigaOrdine = new ArrayList<>();
		 boolean fineOrdine = false;
		 Scanner scanner = new Scanner(System.in);
		 while (!fineOrdine) {
			 System.out.println("Inserire l'id dell'articolo che si vuole acquistare o\n" +
					 "- digitale -2 per visualizzare il tuo ordine attuale\n" +
			 		 "- digitale -1 per annullare l'ordine\n" +
					 "- digitale 0 per confermare l'ordine");
			 System.out.println("───────────────────────────────────────");
			 int idArticolo = scanner.nextInt();
			 scanner.nextLine();
			 if (idArticolo == -2) {
				 System.out.println("───────────────────────────────────────\n"+
			 "Ordini nel carrello");
				 for (RigaOrdine rigaOrdine : listaRigaOrdine) {
					 System.out.println(rigaOrdine.getArticolo().getNome()+" qta: "+rigaOrdine.getQta());
				}
				 System.out.println("───────────────────────────────────────");
			 }
			 if (idArticolo == -1) {
				 System.out.println("Hai annullato l'ordine");
				 fineOrdine = true;
			 }
			 if (idArticolo == 0) {
				 System.out.println("Hai confermato l'ordine");
				 fineOrdine = true;
			 }
			 else {
				 boolean articoloTrovato = false;
				 for (Articolo articolo : listaArticolo) {
					if (articolo.getId() == idArticolo) {
						System.out.println("Hai selezionato l'articolo: "+articolo.getNome());
						System.out.println("Inserire la quantità che si vuole acquistare");
						int qtaArticolo = scanner.nextInt();
						scanner.nextLine();
						RigaOrdine rigaOrdine = new RigaOrdine(articolo, qtaArticolo, articolo.getCategoria().getSconto(), articolo.getCategoria().getIva());
						listaRigaOrdine.add(rigaOrdine);
						System.out.println("Hai inserito "+rigaOrdine.getQta()+" "+rigaOrdine.getArticolo().getNome()+" nel tuo ordine");
						System.out.println("───────────────────────────────────────");
						articoloTrovato = true;
					}
				}
				 if (!articoloTrovato) {
					 System.out.println("L'articolo non è stato trovato\n"+"Riprova");
				 }
			 }
			 
		 }
	 }
}


