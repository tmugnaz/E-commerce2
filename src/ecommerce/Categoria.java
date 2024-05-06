package ecommerce;

import java.util.List;

public class Categoria {
	private String nome;
	
	private List<Categoria> sottoCategorie;
	
	
	public Categoria (String nome) {
		this.nome=nome;
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
	
	

}
