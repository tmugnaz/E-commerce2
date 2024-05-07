package ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private String nome;
	private int iva;
	private int sconto;
	private List<Categoria> sottoCategorie = new ArrayList<Categoria>();
	private static List<Categoria> listaCategorie = new ArrayList<Categoria>();
	
	public void aggiungiSottoCategoria(Categoria categoria) {
		this.sottoCategorie.add(categoria);
	}
	public int getSconto() {
		return sconto;
	}


	public Categoria(String nome, int iva, int sconto) {
		super();
		this.nome = nome;
		this.iva = iva;
		this.sconto = sconto;
	}


	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	
	
	
	public Categoria (String nome) {
		this.nome=nome;
	}
	

	public int getIva() {
		return iva;
	}


	public void setIva(int iva) {
		this.iva = iva;
	}


	public Categoria(String nome, List<Categoria> sottoCategorie) {
		this.nome = nome;
		this.sottoCategorie = sottoCategorie;
	}

	public List<Categoria> getSottoCategorie() {
		return sottoCategorie;
	}

	public void setSottoCategorie(List<Categoria> sottoCategorie) {
		this.sottoCategorie = sottoCategorie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static void aggiungiCategoria(Categoria categoria) {
		Categoria.listaCategorie.add(categoria);
	}
	public static void rimuoviCategoria(Categoria categoria) {
		Categoria.listaCategorie.remove(categoria);
				
	}
	public static List<Categoria> getListaCategorie(){
		return Categoria.listaCategorie;
	}
	

}
