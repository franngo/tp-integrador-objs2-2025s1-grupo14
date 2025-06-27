package searchEngine;

import sample.Sample;
import java.time.LocalDate;

public class FechaUltimaVotacionPosterior extends Criterio {
	
	private LocalDate fechaUltimaVotacion;
	
	public FechaUltimaVotacionPosterior(LocalDate fechaUltimaVotacion) {
		super();
		this.fechaUltimaVotacion = fechaUltimaVotacion;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.ultimaVotacion().isAfter(fechaUltimaVotacion);
	}

}
