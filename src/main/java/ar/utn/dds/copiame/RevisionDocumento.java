package ar.utn.dds.copiame;

import java.time.LocalDateTime;

public class RevisionDocumento {
	private ParDocumentos par;
	private LocalDateTime fecha;
	private RevisionEstado estado;
	private Float valorCopia;

	public RevisionDocumento(ParDocumentos parDocumentos) {
		super();
		this.estado = RevisionEstado.Pendiente;
		this.fecha = LocalDateTime.now();
		this.par = parDocumentos;
	}

	public ParDocumentos getPar() {
		return par;
	}

	public void setPar(ParDocumentos par) {
		this.par = par;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public RevisionEstado getEstado() {
		return estado;
	}

	public void setEstado(RevisionEstado estado) {
		this.estado = estado;
	}

	public float getValorCopia() {
		return valorCopia;
	}

	public void setValorCopia(float valorCopia) {
		this.valorCopia = valorCopia;
	}

	public boolean finalizado() {
		return this.valorCopia != null;
	}

}
