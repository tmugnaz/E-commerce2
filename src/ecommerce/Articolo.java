package ecommerce;

public class Articolo {

	private String nome;
	private Long id;
	private int prezzo;
	private Categoria categoria;

	public Articolo(String nome, Long id, int prezzo, Categoria categoria) {
		this.nome = nome;
		this.id = id;
		this.prezzo = prezzo;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void getInfo() {
		System.out.println("Nome: " + this.getNome() + ", Prezzo: " + this.getPrezzo() + ", " + "Categoria: "
				+ this.getCategoria().getNome());
	}

}
