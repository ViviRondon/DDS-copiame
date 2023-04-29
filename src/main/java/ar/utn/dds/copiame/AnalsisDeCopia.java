package ar.utn.dds.copiame;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.paukov.combinatorics3.Generator;

public class AnalsisDeCopia {
	
	private float umbral;
	private Lote lote;
		
	public AnalsisDeCopia(float umbral, Lote lote) {
		super();
		this.umbral = umbral;
		this.lote = lote;
	}
	
	public float getUmbral() {
		return umbral;
	}
	
	public void setUmbral(float umbral) {
		this.umbral = umbral;
	}
	
	public Lote getLote() {
		return lote;
	}
		
	
	public ResultadoLote procesar() {
		// Genero todos los pares de documentos Posibles
		List<ParDocumentos> pares = Generator.combination(this.lote.getDocumentos())
	       .simple(2)
	       .stream()
	       .map(t-> new ParDocumentos(t.get(0),t.get(1)) ) 
	       .collect(Collectors.toList());
		
		// Armo el resultado procesando cada par
		ResultadoLote rl = new ResultadoLote();
		rl.setFechaInicio(LocalDateTime.now());
		for (ParDocumentos parDocumentos : pares) {
			if(parDocumentos.esCopia(this.umbral)) {
				rl.agregarPar(parDocumentos);	
			}
			
		}
		rl.setFechaFin(LocalDateTime.now());
		
		return rl;
	}
	

}
