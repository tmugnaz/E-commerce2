package ecommerce;

import java.util.List;

public class OrdineVendita {
	
	private IndirizzoUtente indirizzoFatturazione;
	private IndirizzoUtente indirizzoSpedizione;
	private StatoOrdine statoOrdine;
	private MetodoPagamento metodoPagamento;
	private List<RigaOrdine> righeOrdini;
	
	public List<RigaOrdine> getRigheOrdini() {
		return righeOrdini;
	}

	public void setRigheOrdini(List<RigaOrdine> righeOrdini) {
		this.righeOrdini = righeOrdini;
	}

	public OrdineVendita(IndirizzoUtente indirizzoFatturazione, IndirizzoUtente indirizzoSpedizione, MetodoPagamento metodoPagamento,List<RigaOrdine> righeOrdine) {
		this.indirizzoFatturazione = indirizzoFatturazione;
		this.indirizzoSpedizione = indirizzoSpedizione;
		this.statoOrdine = StatoOrdine.CREATO;
		this.metodoPagamento = metodoPagamento;
		this.righeOrdini=righeOrdine;
	}
	
	public void aggiungiRigaOrdine(Articolo articolo, int qta) {
		RigaOrdine rigaOrdine = new RigaOrdine(articolo, qta, articolo.getCategoria().getIva(), articolo.getCategoria().getSconto());
		this.righeOrdini.add(rigaOrdine);
	}
	
	public IndirizzoUtente getIndirizzoFatturazione() {
		return indirizzoFatturazione;
	}

	public void setIndirizzoFatturazione(IndirizzoUtente indirizzoFatturazione) {
		this.indirizzoFatturazione = indirizzoFatturazione;
	}

	public IndirizzoUtente getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(IndirizzoUtente indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public StatoOrdine getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	
	
}
