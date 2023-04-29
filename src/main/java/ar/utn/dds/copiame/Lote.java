package ar.utn.dds.copiame;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lote {

	private String directorio;
	private Set<Documento> documentos;
	
	public Lote(String directorio) {
		super();
		this.directorio = directorio;
		this.documentos = new HashSet<Documento>();
	}
	
	public String getDirectorio() {
		return directorio;
	}

	public Set<Documento> getDocumentos() {
		return new HashSet<Documento>(documentos);
	}
	
	public void validar() throws FileNotFoundException {
		Path path = Paths.get(this.directorio);
		if (!Files.exists(path)) {
			throw new FileNotFoundException(directorio);
		}
	}
	
	public void cargar() throws IOException {
		Path path = Paths.get(this.directorio);
		for (Path docPath : Files.list(path).collect(Collectors.toList()) ) {
			if (docPath.toString().endsWith(".txt")) {
				String autor = docPath.getFileName().toString().replace(".txt","").replace("_"," ");
				String content = Files.readString(docPath);
				Documento doc = new Documento(autor, content);
				this.documentos.add(doc);	
			}
			
		}
	}
	
	
}
