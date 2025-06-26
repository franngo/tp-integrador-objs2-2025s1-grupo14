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
		Stream<Sample> ss = samples.stream();
		Stream<Sample> ss1 = Stream.empty();
		Stream<Sample> ss2 = Stream.empty();
		Stream<Sample> ss3 = Stream.empty();
		Stream<Sample> ss4 = Stream.empty();
		if(fechaCreacion != null) {
			ss1= ss.filter((s) -> s.getFechaCreacion().isAfter(fechaCreacion)); //si es incluído fechaCreacion, le hago .minusDays(1)
		}
		if(fechaUltVot != null) {
			ss2= ss.filter((s) -> s.ultimaVotacion().isAfter(fechaUltVot));
		}
		if(tipoDetectado != null) {
			ss3= ss.filter((s) -> s.currentResult().equals(tipoDetectado));
		}
		if(nivelDeVerificacion != null) {
			ss4= ss.filter((s) -> s.nivelDeVerificacion().equals(nivelDeVerificacion));
		}
		return Stream.of(ss1, ss2, ss3, ss4).flatMap((smps) -> smps).collect(Collectors.toList()); //de esta forma, son todos OR
	}
}
