package ecommerce;

public class Amministratore extends Utente{

	public Amministratore(String nome, String cognome, String codiceFiscale) {
		super(nome, cognome, codiceFiscale);
	}
	
	public Articolo creaArticolo(String nomeArticolo, Long idArticolo, int prezzoArticolo, Categoria categoriaArticolo) {
		return new Articolo(nomeArticolo, idArticolo, prezzoArticolo, categoriaArticolo);
	}
	
	public Categoria creaCategoria(String nomeCategoria, int ivaCategoria, int scontoCategoria, Categoria categoriaPadre, boolean isSottoCategoria) {
		Categoria categoria = new Categoria(nomeCategoria, ivaCategoria,scontoCategoria);
		if(isSottoCategoria) {			
			categoriaPadre.aggiungiSottoCategoria(categoria);
		}
		else {
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
}
