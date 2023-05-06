package ar.utn.dds.copiame;

import java.util.List;

public class EvaluadorDeCopiaAutomatico implements EvaluadorDeCopia {

	@Override
	public void procesar(List<ParDocumentos> pares) {
		
		for (ParDocumentos parDocumentos : pares) {
			RevisionDocumento rd = new RevisionDocumento(parDocumentos);
			rd.setValorCopia(parDocumentos.distancia());
			parDocumentos.addRevision(rd);
		}

	}

}
