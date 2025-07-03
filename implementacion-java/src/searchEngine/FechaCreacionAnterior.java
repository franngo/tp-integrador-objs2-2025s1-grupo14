package searchEngine;

import sample.Sample;
import java.time.LocalDate;

public class FechaCreacionAnterior extends Criterio {
	
	private LocalDate fechaCreacion;
	
	public FechaCreacionAnterior(LocalDate fechaCreacion) {
		super();
		this.fechaCreacion = fechaCreacion;
	}

	@Override	
	public boolean cumpleCriterio(Sample sample) {
		return sample.getFechaCreacion().isBefore(fechaCreacion);
	}

}
