package searchEngine;

import sample.Sample;
import java.time.LocalDate;

public class FechaCreacionPosterior extends Criterio {
	
	private LocalDate fechaCreacion;
	
	public FechaCreacionPosterior(LocalDate fechaCreacion) {
		super();
		this.fechaCreacion = fechaCreacion;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.getFechaCreacion().isAfter(fechaCreacion);
	}

}
