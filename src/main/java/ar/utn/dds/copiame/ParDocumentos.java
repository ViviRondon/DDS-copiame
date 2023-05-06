package ar.utn.dds.copiame;

import java.util.ArrayList;
import java.util.List;

public class ParDocumentos {

	private Documento documento1;
	private Documento documento2;
	private List<RevisionDocumento> revisiones ;
	
	public ParDocumentos(Documento documento1, Documento documento2) {
		super();
		this.documento1 = documento1;
		this.documento2 = documento2;
		this.revisiones = new ArrayList<RevisionDocumento>();
	}

	public Documento getDocumento1() {
		return documento1;
	}

	public Documento getDocumento2() {
		return documento2;
	}
	
	public float distancia() {
		return this.documento1.distancia(documento2) ;
	}
	
	public float puntaje() {
		Double sum = this.revisiones.stream().mapToDouble(x-> x.getValorCopia()).sum();
		return sum.floatValue() / this.revisiones.size() ;
	}
	
	public Boolean esCopia(float umbral) {
		return this.puntaje() < umbral;
	}
	
	public void addRevision(RevisionDocumento rev) {
		this.revisiones.add(rev);
	}
	public boolean finalizado() {
		return this.revisiones.stream().allMatch(x -> x.finalizado());
	}
	
}
