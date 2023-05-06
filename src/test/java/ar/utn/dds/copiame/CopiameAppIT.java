package ar.utn.dds.copiame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CopiameAppIT {

	@Test
	public void testBronceTexto() throws Exception {
		// Armado del Escenario
		Lote lote = new Lote("src/test/resources/lote1");		
		lote.validar();
		lote.cargar();
		float umbral = 0.5f;
		AnalsisDeCopia analisis = new AnalsisDeCopia(umbral, lote);	
		analisis.addEvaluador(new EvaluadorDeCopiaAutomatico());
		
		// Ejecucion
		analisis.procesar();
		ResultadoLote resultado = analisis.resultado();
		
		// Chequeo
		
		assertEquals(1, resultado.getPosiblesCopias().size(),
				"Hay al menos una copia, ya que Pepe y Raúl se copiaron "); 
		
	}
	@Test
	public void testPlataTexto() throws Exception {
		// Armado del Escenario
		Lote lote = new Lote("src/test/resources/lote1");		
		lote.validar();
		lote.cargar();
		float umbral = 0.4f;
		AnalsisDeCopia analisis = new AnalsisDeCopia(umbral, lote);	
		analisis.addEvaluador(new EvaluadorDeCopiaAutomatico());
		Revisor revisor = new Revisor();
		List<Revisor> revisores = Arrays.asList(revisor);
		
		EvaluadorDeCopiaManual eval = new EvaluadorDeCopiaManual(revisores,1.0);
		analisis.addEvaluador(eval);
				
		// Ejecucion
		analisis.procesar();
		
		// Marco manualmente el valor de copia en un valor alto
		// 1 --> no se copiaron  |  0 se copiaron y los docs son identicos
		for (RevisionDocumento revision : revisor.getRevisar()) {
			revision.setValorCopia(0.9f);
		} 
		
		ResultadoLote resultado = analisis.resultado();
		
		// Chequeo
		
		assertEquals(0, resultado.getPosiblesCopias().size(),
				"La revisión manual cambio el resultado de la posible copia, con lo que no se tiene que detectar copia alguna"); 
		
	}
	
}
