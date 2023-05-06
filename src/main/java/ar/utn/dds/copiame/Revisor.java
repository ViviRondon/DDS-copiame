package ar.utn.dds.copiame;

import java.util.ArrayList;
import java.util.List;

public class Revisor {

	private String nombre;
	private List<RevisionDocumento> revisar;
	
	
	

	public Revisor() {
		super();
		this.revisar = new ArrayList<RevisionDocumento>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RevisionDocumento> getRevisar() {
		return revisar;
	}

	public void setRevisar(List<RevisionDocumento> revisar) {
		this.revisar = revisar;
	}

	public void addRevision(RevisionDocumento rev) {
		this.revisar.add(rev);
	}

}
