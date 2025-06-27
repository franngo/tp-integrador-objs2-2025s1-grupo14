package searchEngine;

import sample.Sample;

public class NivelDeVerificacion extends Criterio {

	private String nivelDeVerificacion;
	
	public NivelDeVerificacion(String nivelDeVerificacion) {
		super();
		this.nivelDeVerificacion = nivelDeVerificacion;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.nivelDeVerificacion().equals(nivelDeVerificacion);
	}
	
}
