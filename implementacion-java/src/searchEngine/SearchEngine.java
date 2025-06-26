package searchEngine;

import sample.Sample;
import java.util.List;
import java.time.LocalDate;
import Enums.*;
import java.util.stream.*;

public class SearchEngine {
	/*
	 * Aclaración: Si no se quiere utilizar uno de los criterios en la búsqueda, se debe pasar un null para dicho parámetro
	 */
	public List<Sample> buscar(List<Sample> samples, LocalDate fechaCreacion, LocalDate fechaUltVot, OpinionValue tipoDetectado,
			String nivelDeVerificacion) {
		/*
		Stream<Sample> ss = samples.stream().filter((s) -> 
			(fechaCreacion != null && s.getFechaCreacion().isAfter(fechaCreacion)) && 
				s.ultimaVotacion().isAfter(fechaUltVot) &&
				s.currentResult().equals(tipoDetectado) &&
				s.nivelDeVerificacion().equals(nivelDeVerificacion) );
		return ss.collect(Collectors.toList());
		*/
		Stream<Sample> ss = samples.stream();
		if(fechaCreacion != null) {
			ss.filter((s) -> s.getFechaCreacion().isAfter(fechaCreacion));
		}
		if(fechaUltVot != null) {
			ss.filter((s) -> s.ultimaVotacion().isAfter(fechaUltVot));
		}
		if(tipoDetectado != null) {
			ss.filter((s) -> s.currentResult().equals(tipoDetectado));
		}
		if(nivelDeVerificacion != null) {
			ss.filter((s) -> s.nivelDeVerificacion().equals(nivelDeVerificacion));
		}
		return ss.collect(Collectors.toList());
	}
}
