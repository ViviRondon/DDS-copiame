package ar.utn.dds.copiame;

public class ParDocumentos {

	private Documento documento1;
	private Documento documento2;
	
	public ParDocumentos(Documento documento1, Documento documento2) {
		super();
		this.documento1 = documento1;
		this.documento2 = documento2;
	}

	public Documento getDocumento1() {
		return documento1;
	}

	public Documento getDocumento2() {
		return documento2;
	}
	
	public Boolean esCopia(float umbral) {
		return this.documento1.distancia(documento2) < umbral;
	}
	
	
}
