package searchEngine;

import sample.Sample;
import java.time.LocalDate;

public class FechaUltimaVotacionAnterior extends Criterio {
	
	private LocalDate fechaUltimaVotacion;
	
	public FechaUltimaVotacionAnterior(LocalDate fechaUltimaVotacion) {
		super();
		this.fechaUltimaVotacion = fechaUltimaVotacion;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.ultimaVotacion().isBefore(fechaUltimaVotacion);
	}

}
