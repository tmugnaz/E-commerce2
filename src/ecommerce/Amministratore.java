package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Amministratore extends Utente {

	public Amministratore(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome, codiceFiscale);
	}

	public Articolo creaArticolo(String nomeArticolo, Long idArticolo, int prezzoArticolo,
			Categoria categoriaArticolo) {
		return new Articolo(nomeArticolo, idArticolo, prezzoArticolo, categoriaArticolo);
	}

	public Categoria creaCategoria(String nomeCategoria, int ivaCategoria, int scontoCategoria,
			Categoria categoriaPadre, boolean isSottoCategoria) {
		Categoria categoria = new Categoria(nomeCategoria, ivaCategoria, scontoCategoria);
		if (isSottoCategoria) {
			categoriaPadre.aggiungiSottoCategoria(categoria);
		} else {
			Categoria.aggiungiCategoria(categoria);
		}
		return categoria;
	}

	public void setSconto(int scontoCategoria, Categoria categoria) {
		categoria.setSconto(scontoCategoria);
	}

	public void setIva(int ivaCategoria, Categoria categoria) {
		categoria.setIva(ivaCategoria);
	}

	public void creaCategoriaPadreScanner(Scanner scanner) {
		try {
			System.out.println("Inserisci il nome della categoria:");
			String nomeCategoria = scanner.nextLine();

			System.out.println("Inserisci l'IVA della categoria:");
			int iva = scanner.nextInt();

			System.out.println("Inserisci lo sconto della categoria:");
			int sconto = scanner.nextInt();

			Categoria nuovaCategoria = new Categoria(nomeCategoria, iva, sconto);

			Categoria.aggiungiCategoria(nuovaCategoria);

			System.out.println("Categoria creata con successo!");
		} catch (InputMismatchException e) {
			System.out.println("Errore: assicurati di inserire un numero intero per l'IVA e lo sconto.");
		} finally {

		}

	}

	public void creaSottoCategoriaScanner(Scanner scanner) {
		try {
            System.out.println("Inserisci il nome della categoria madre:");
            String nomeCategoriaMadre = scanner.nextLine();
            
            
            
            if (searchCategoriaByName(nomeCategoriaMadre) != null) {
            	System.out.println("Inserisci il nome della categoria:");
    			String nomeCategoria = scanner.nextLine();

    			System.out.println("Inserisci l'IVA della categoria:");
    			int iva = scanner.nextInt();

    			System.out.println("Inserisci lo sconto della categoria:");
    			int sconto = scanner.nextInt();

    			Categoria nuovaSottoCategoria = new Categoria(nomeCategoria, iva, sconto);
                
                
                
    			searchCategoriaByName(nomeCategoriaMadre).aggiungiSottoCategoria(nuovaSottoCategoria);
                
                System.out.println("Sottocategoria aggiunta a " + searchCategoriaByName(nomeCategoriaMadre).getNome());
            } else {
                System.out.println("Categoria madre non trovata.");
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante l'aggiunta della sottocategoria: " + e.getMessage());
        } finally {
            
        }
	}

	private static Categoria searchCategoriaByName(String nomeCategoria) {
		for (Categoria categoria : Categoria.getListaCategorie()) {
			if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
				return categoria;
			}
		}
		return null;
	}

	public void menùCategoriaScanner(Scanner scanner) {
		boolean continuaEsecuzione = true;
		while (continuaEsecuzione == true) {
			System.out.println("╭───────────────────────────────────────╮\n"
					+ "│     Menù Categorie                    │\n" + "│                                       │\n"
					+ "│   Seleziona un'opzione:               │\n" + "│   1. Crea MacroCategoria              │\n"
					+ "│   2. Crea SottoCategoria              │\n" + "│   3. Modifica Categoria               │\n"
					+ "│   4. Elimina Categoria                │\n" + "│   5. Visualizza lista Categorie       │\n"
					+ "│   6. Uscita                           │\n" + "│                                       │\n"
					+ "╰───────────────────────────────────────╯");
			String scelta = scanner.nextLine();
			switch (scelta) {
			case ("1"):
				this.creaCategoriaPadreScanner(scanner);
				break;
			case ("2"):
				this.creaSottoCategoriaScanner(scanner);
				break;
			case ("3"):
				this.modificaCategoriaScanner(scanner);
				break;
			case ("4"):
				this.eliminaCategoriaScanner(scanner);
				break;
			case ("5"):
				Main.stampaCategorie();
				break;
			case ("6"):
				System.out.println("Uscita...");
				continuaEsecuzione = false;
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
				break;
			}
		}
	}

	private void eliminaCategoriaScanner(Scanner scanner) {
		System.out.println("Inserisci il nome della categoria da modificare:");
        String nomeCategoria = scanner.nextLine();
		Categoria.rimuoviCategoria(searchCategoriaByName(nomeCategoria));
		System.out.println("Categoria Eliminata con successo");
	}

	private void modificaCategoriaScanner(Scanner scanner) {
		System.out.println("Inserisci il nome della categoria da modificare:");
        String nomeCategoria = scanner.nextLine();
        try{System.out.println("Cosa vuoi Fare?");
        System.out.println("per modificare l'iva digita 1");
        System.out.println("per modificare lo sconto digita 2");
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta) {
        case(1):
        	System.out.println("digitare il valore da sostituire con quello corrente, che è: "+ 
        			searchCategoriaByName(nomeCategoria).getIva());
        	int nuovaIva = scanner.nextInt();
        	scanner.nextLine();
        	this.setIva(nuovaIva, searchCategoriaByName(nomeCategoria));
        	break;
        case (2):
        	System.out.println("digitare il valore da sostituire con quello corrente, che è: "+ 
        			searchCategoriaByName(nomeCategoria).getSconto());
        	int nuovoSconto = scanner.nextInt();
        	scanner.nextLine();
        	this.setIva(nuovoSconto, searchCategoriaByName(nomeCategoria));
        	break;
        	
        }
        } catch (InputMismatchException e) {
			System.out.println("Errore: assicurati di inserire un numero ");
		} finally {

		}
		
		
	}
}
