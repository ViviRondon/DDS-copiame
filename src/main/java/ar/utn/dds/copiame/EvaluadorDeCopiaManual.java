package ar.utn.dds.copiame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvaluadorDeCopiaManual implements EvaluadorDeCopia {

	private List<Revisor> revisores;
	private Double porcentajeRev;

	public EvaluadorDeCopiaManual(List<Revisor> revisores, Double porcentajeRev) {
		super();
		this.revisores = revisores;
		this.porcentajeRev = porcentajeRev;
	}

	public List<Revisor> getRevisores() {
		return revisores;
	}

	@Override
	public void procesar(List<ParDocumentos> pares) {
		List<ParDocumentos> pares2 = new ArrayList<ParDocumentos>(pares);
		Collections.shuffle(pares2);
		Double n = Math.abs(porcentajeRev * pares.size());
		List<ParDocumentos> subList = pares2.subList(0, n.intValue());

		for (ParDocumentos parDocumentos : subList) {
			Revisor elegirRevisor = this.elegirRevisor();
			RevisionDocumento rd = new RevisionDocumentoManual(parDocumentos, elegirRevisor());			
			parDocumentos.addRevision(rd);
			elegirRevisor.addRevision(rd);
		}

	}

	private Revisor elegirRevisor() {
		// no va a quedar balanceado, pero no nos importa
		// por ahora tampoco vamos a implementar el limite de trabajos del revisor
		List<Revisor> revisores2 = new ArrayList<Revisor>(this.revisores);
		Collections.shuffle(revisores2);
		return revisores2.get(0);
	}

}
