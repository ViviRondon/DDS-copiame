package ar.utn.dds.copiame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiaMeApp {

	
	
	public static void main(String[] args) {
		
		// Valido argumentos del usuario --> Capa Presentación
		Path pathLote = Paths.get(args[0]);
		if ( ! Files.exists( pathLote )) {
			System.err.println("'" + args[0] + "' no existe...");
			System.exit(1);
		}
		// ------------------------------------
		
		// Cargo el Lote del Sistema de archivos --> Utilizo la Capa de fuente de datos
		Lote lote = new Lote(args[0]);
		try {
			lote.validar();
			lote.cargar();
		} catch (IOException e) {
			System.err.println("error al cargar el directorio con documentos: ");
			e.printStackTrace();
			System.exit(2);
		}
		// ------------------------------------------------
		
		System.err.println("Se detectaron " + lote.getDocumentos().size() + " documentos.");
		
		// Utilizo al dominio -- NO leo datos de otra fuente -- NO pido ni muestro información 
		float umbral = 0.5f;
		AnalsisDeCopia analisis = new AnalsisDeCopia(umbral, lote);		
		ResultadoLote resultado = analisis.resultado();
		//--------------------
		
		// Muestro la informacion por pantall --> Capa de Presentación
		System.err.println("Se detectaron " + resultado.getPosiblesCopias().size() + " posibles copias.");
		for (ParDocumentos par : resultado.getPosiblesCopias()) {
			System.out.println(par.getDocumento1().getAutor() + " " + par.getDocumento2().getAutor() );
		}
		//-------------
	}

}
