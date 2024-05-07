package ecommerce;

import java.util.InputMismatchException;
import java.util.List;
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

	public void setNomeCategoria(String nome, Categoria categoria) {
		categoria.setNome(nome);
	}

	public void setIva(int ivaCategoria, Categoria categoria) {
		categoria.setIva(ivaCategoria);
	}
	/// METODI ADMIN CATEGORIA--------------------------------------------

	public void creaCategoriaPadreScanner(Scanner scanner) {
		try {
			System.out.println("Inserisci il nome della categoria:");
			String nomeCategoria = scanner.nextLine();

			System.out.println("Inserisci l'IVA della categoria:");
			int iva = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Inserisci lo sconto della categoria:");
			int sconto = scanner.nextInt();
			scanner.nextLine();

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
				scanner.nextLine();

				System.out.println("Inserisci lo sconto della categoria:");
				int sconto = scanner.nextInt();
				scanner.nextLine();

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
					+ "│   6. Visualizza info Categoria        │\n" + "│   7. Uscita                           │\n"
					+ "│                                       │\n" + "╰───────────────────────────────────────╯");
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
				stampaInfoCategoriaSpecifica(scanner);
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

	public static void stampaInfoCategoriaSpecifica(Scanner scanner) {
		System.out.println("Inserisci il nome della categoria :");
		String nomeCategoria = scanner.nextLine();

		Categoria categoria = searchCategoriaByName(nomeCategoria);

		if (categoria != null) {
			System.out.println("Informazioni della categoria: " + categoria.getNome());
			System.out.println("IVA: " + categoria.getIva() + "%");
			System.out.println("Sconto: " + categoria.getSconto() + "%");

			List<Categoria> sottoCategorie = categoria.getSottoCategorie();
			if (!sottoCategorie.isEmpty()) {
				System.out.println("Sottocategorie:");
				for (Categoria sottoCategoria : sottoCategorie) {
					System.out.println("Informazioni della categoria: " + sottoCategoria.getNome());
					System.out.println("IVA: " + sottoCategoria.getIva() + "%");
					System.out.println("Sconto: " + sottoCategoria.getSconto() + "%");
				}
			} else {
				System.out.println("Nessuna sottocategoria.");
			}
		} else {
			System.out.println("Categoria non trovata.");
		}
	}

	private void eliminaCategoriaScanner(Scanner scanner) {
		System.out.println("Inserisci il nome della categoria da modificare:");
		String nomeCategoria = scanner.nextLine();
		Categoria.rimuoviCategoria(searchCategoriaByName(nomeCategoria));
		System.out.println("Categoria Eliminata con successo");
	}

	private void modificaCategoriaArticolo(Scanner scanner, Categoria categoria) {
		try {
			System.out.println("Cosa vuoi Fare?");
			System.out.println("per modificare l'iva digita 1");
			System.out.println("per modificare lo sconto digita 2");
			System.out.println("per modificare il nome digita 3");
			int scelta = scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
			case (1):
				System.out
						.println("digitare il valore da sostituire con quello corrente, che è: " + categoria.getIva());
				int nuovaIva = scanner.nextInt();
				scanner.nextLine();
				this.setIva(nuovaIva, categoria);
				break;
			case (2):
				System.out.println(
						"digitare il valore da sostituire con quello corrente, che è: " + categoria.getSconto());
				int nuovoSconto = scanner.nextInt();
				scanner.nextLine();
				this.setIva(nuovoSconto, categoria);
				break;
			case (3):
				System.out.println(
						"digitare il nome  da sostituire con quello corrente, che è: " + categoria.getSconto());
				String nuovoNome = scanner.nextLine();
				this.setNomeCategoria(nuovoNome, categoria);
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Errore: assicurati di inserire un numero ");
		} finally {

		}
	}

	private void modificaCategoriaScanner(Scanner scanner) {
		System.out.println("Inserisci il nome della categoria da modificare:");
		String nomeCategoria = scanner.nextLine();
		if (searchCategoriaByName(nomeCategoria) != null) {
			Categoria categoria = searchCategoriaByName(nomeCategoria);

			try {
				System.out.println("Cosa vuoi Fare?");
				System.out.println("per modificare l'iva digita 1");
				System.out.println("per modificare lo sconto digita 2");
				System.out.println("per modificare il nome digita 3");
				int scelta = scanner.nextInt();
				scanner.nextLine();
				switch (scelta) {
				case (1):
					System.out.println(
							"digitare il valore da sostituire con quello corrente, che è: " + categoria.getIva());
					int nuovaIva = scanner.nextInt();
					scanner.nextLine();
					this.setIva(nuovaIva, categoria);
					break;
				case (2):
					System.out.println(
							"digitare il valore da sostituire con quello corrente, che è: " + categoria.getSconto());
					int nuovoSconto = scanner.nextInt();
					scanner.nextLine();
					this.setIva(nuovoSconto, categoria);
					break;
				case (3):
					System.out.println(
							"digitare il nome  da sostituire con quello corrente, che è: " + categoria.getSconto());
					String nuovoNome = scanner.nextLine();
					this.setNomeCategoria(nuovoNome, categoria);
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Errore: assicurati di inserire un numero ");
			} finally {

			}
		} else {
			System.out.println("categoria non trovata");
		}

	}
	/// METODI ADMIN INVENTARIO---------------------------------------------

	public void menùArticoloScanner(Scanner scanner, List<Articolo> inventario) {
		boolean continuaEsecuzione = true;
		while (continuaEsecuzione == true) {
			System.out.println("╭───────────────────────────────────────╮\n"
					+ "│     Menù Articoli                     │\n" + "│                                       │\n"
					+ "│   Seleziona un'opzione:               │\n" + "│   1. Crea nuovo Articolo              │\n"
					+ "│   2. Modifica Articolo                │\n" + "│   3. Elimina Articolo                 │\n"
					+ "│   4. Visualizza Inventario            │\n" + "│   5. Visualizza info Articolo         │\n"
					+ "│   6. Uscita                           │\n" + "│                                       │\n"
					+ "╰───────────────────────────────────────╯");
			String scelta = scanner.nextLine();
			switch (scelta) {
			case ("1"):
				this.creaArticoloScanner(scanner, inventario);
				break;
			case ("2"):
				this.modificaArticoloScanner(scanner, inventario);
				break;
			case ("3"):
				this.EliminaArticoloScanner(scanner, inventario);
				break;
			case ("4"):
				Main.StampaInventario(inventario);
				break;
			case ("5"):
				this.stampaInfoArticoloSpecifico(scanner, inventario);
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

	private void stampaInfoArticoloSpecifico(Scanner scanner, List<Articolo> inventario) {
		System.out.println("Inserisci l'id dell'articolo che desideri vedere");

		Long idTarget = scanner.nextLong();
		scanner.nextLine();
		searchArticolobyId(idTarget, inventario).getInfo();
	}

	private void EliminaArticoloScanner(Scanner scanner, List<Articolo> inventario) {
		System.out.println("Inserisci l'id dell'articolo che desideri eliminare");

		Long idTarget = scanner.nextLong();
		scanner.nextLine();
		inventario.remove(searchArticolobyId(idTarget, inventario));
		System.out.println("articolo eliminato");
	}

	private void modificaArticoloScanner(Scanner scanner, List<Articolo> inventario) {
		System.out.println("Inserisci l'id dell'articolo che desideri eliminare");

		Long idTarget = scanner.nextLong();
		scanner.nextLine();
		if (searchArticolobyId(idTarget, inventario) != null) {
			Articolo articolo = searchArticolobyId(idTarget, inventario);
			articolo.getInfo();
			System.out.println("Cosa vuoi modificare?");
			System.out.println("╭───────────────────────────────────────╮\n"
					+ "│   Seleziona un'opzione:               │\n" + "│                                       │\n"
					+ "│   1. Modifica nome                    │\n" + "│   2. Modifica Prezzo                  │\n"
					+ "│   3. Modifica Categoria               │\n" + "│                                       │\n"
					+ "│   4. Annulla                          │\n" + "│                                       │\n"
					+ "╰───────────────────────────────────────╯");

			try {
				String scelta = scanner.nextLine();

				switch (scelta) {
				case ("1"):
					System.out.println("inserisci il nuovo nome per l'articolo");
					String nuovoNome = scanner.nextLine();
					articolo.setNome(nuovoNome);
					break;
				case ("2"):
					System.out.println("inserisci il nuovo prezzo per l'articolo");
					int nuovoPrezzo = scanner.nextInt();
					scanner.nextLine();
					articolo.setPrezzo(nuovoPrezzo);
					break;
				case ("3"):
					this.modificaCategoriaArticolo(scanner, articolo.getCategoria());
					break;

				case ("4"):
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Errore: assicurati di inserire un numero ");
			} finally {

			}
		} else {
			System.out.println("articolo non trovato");
		}

	}

	private void creaArticoloScanner(Scanner scanner, List<Articolo> inventario) {
		try {
			System.out.println("Inserisci il nome dell'articolo:");
			String nomeArticolo = scanner.nextLine();
			long idArticolo = this.prossimoId(inventario);
			System.out.println("Inserisci il prezzo dell'articolo:");
			int prezzoArticolo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Inserisci il nome della categoria dell'articolo:");
			String nomeCategoria = scanner.nextLine();
			Categoria categoriaArticolo = searchCategoriaByName(nomeCategoria);
			if (categoriaArticolo == null) {
				System.out.println("Categoria non trovata.");
				return;
			}
			Articolo nuovoArticolo = new Articolo(nomeArticolo, idArticolo, prezzoArticolo, categoriaArticolo);

			inventario.add(nuovoArticolo);

			System.out.println("Articolo creato con successo!");
		} catch (InputMismatchException e) {
			System.out.println("Errore: assicurati di inserire un numero ");
		} finally {

		}
	}

	private Long prossimoId(List<Articolo> inventario) {
		Long maxId = 0L;
		for (Articolo articolo : inventario) {
			if (articolo.getId() > maxId) {
				maxId = articolo.getId();
			}
		}
		return maxId + 1;
	}

	private Articolo searchArticolobyId(Long id, List<Articolo> inventario) {
		for (Articolo articolo : inventario) {
			if (articolo.getId() == id) {
				return articolo;
			}

		}
		return null;
	}
}
