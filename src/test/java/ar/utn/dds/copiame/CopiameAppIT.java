package ar.utn.dds.copiame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopiameAppIT {
	@Test
	public void testBronceTexto() throws Exception {
// Armado del Escenario
		Lote lote = new Lote("src/test/resources/lote1");
		lote.validar();
		lote.cargar();
		float umbral = 0.5f;
		AnalsisDeCopia analisis = new AnalsisDeCopia(umbral, lote);
// Ejecución
		ResultadoLote resultado = analisis.procesar();
// Chequeo
		assertEquals(1, resultado.getPosiblesCopias().size(),
				"Hay al menos una copia, ya que Pepe y Raúl se copiaron ");
	}
}
