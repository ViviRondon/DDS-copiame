package ar.utn.dds.copiame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DocumentoTest {
	
	@Test
	public void testDocumentosIguales() {
		Documento doc1 = new Documento("","hola");
		Documento doc2 = new Documento("","hola");
		assertEquals(0,doc1.distancia(doc2), 
				"los textos que son iguales tienen que dar una distancia de 0");
		 
	}
	
	@Test
	public void testDocumentosDistintos() {
		Documento doc1 = new Documento("","chau");
		Documento doc2 = new Documento("","hola");
		assertEquals(1,doc1.distancia(doc2),
				"los textos que son totalmente distintos tienen que dar una distancia de 1");
	}
	
	@Test
	public void testDocumentosParecidos() {
		Documento doc1 = new Documento("","hola");
		Documento doc2 = new Documento("","halo");
		// el 3er parámetro es una toleracia para comparar (decir si son iguales) los números con punto flotante 
		assertEquals(0.5,doc1.distancia(doc2),0.1,
				"los textos que son parecidos en un 50% tienen que dar ~0.5");
		
	}

}
