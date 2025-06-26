package searchEngine;

import sample.Sample;
import java.util.List;
import java.time.LocalDate;
import Enums.*;
import java.util.stream.*;

public class SearchEngine {
	public List<Sample> buscar(List<Sample> samples, LocalDate fechaCreacion, LocalDate fechaUltVot, OpinionValue tipoDetectado,
			String nivelDeVerificacion) {
		Stream<Sample> ss = samples.stream().filter((s) -> s.getFechaCreacion().isAfter(fechaCreacion) && 
				s.ultimaVotacion().isAfter(fechaUltVot) && s.currentResult().equals(tipoDetectado) &&
				s.nivelDeVerificacion().equals(nivelDeVerificacion));
		return ss.collect(Collectors.toList());
	}
}
