package ar.utn.dds.copiame;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResultadoLote {
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;

	private List<ParDocumentos> posiblesCopias;

	public ResultadoLote() {
		super();
		this.posiblesCopias = new ArrayList<ParDocumentos>();
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<ParDocumentos> getPosiblesCopias() {
		// encapsulamos la coleccion para que no puedan manipularla sin usar agregarPar
		return new ArrayList<ParDocumentos>(posiblesCopias);
	}

	public void agregarPar(ParDocumentos par) {
		this.posiblesCopias.add(par);
	}
	
}
