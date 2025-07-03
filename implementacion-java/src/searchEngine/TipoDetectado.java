package searchEngine;

import sample.Sample;
import Enums.OpinionValue;

public class TipoDetectado extends Criterio {
	
	private OpinionValue tipoDetectado;
	
	public TipoDetectado(OpinionValue tipoDetectado) {
		super();
		this.tipoDetectado = tipoDetectado;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.currentResult().equals(tipoDetectado);
	}
	
}
