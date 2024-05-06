package ecommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetodoPagamento {
	private String nome;
	
	private static List<MetodoPagamento> listaMetodiPagamento = new ArrayList<MetodoPagamento>(
			Arrays.asList(new MetodoPagamento("paypal"), new MetodoPagamento("carta di credito"), new MetodoPagamento("bonifico bancario")));
			
	public void aggiungiMetodoPagamento(MetodoPagamento metodoPagamento) {
		MetodoPagamento.listaMetodiPagamento.add(metodoPagamento);
	}
	
	public MetodoPagamento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<MetodoPagamento> getLista() {
		return MetodoPagamento.listaMetodiPagamento;
	}

	public static void setLista(List<MetodoPagamento> lista) {
		MetodoPagamento.listaMetodiPagamento = lista;
	} 
	

	
}
