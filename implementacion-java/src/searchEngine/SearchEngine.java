package searchEngine;

import sample.Sample;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import Enums.*;
import java.util.stream.*;

public class SearchEngine {
	/*
	 * Aclaración: Si no se quiere utilizar uno de los criterios en la búsqueda, se debe pasar un null para dicho parámetro
	 * Precondiciones: 
	 * -Se debe pasar al menos un criterio no nulo.
	 * -Se deben pasar n-1 conectores lógicos, siendo n la cantidad de criterios no nulos que se pasan como argumento.
	 */
//	public List<Sample> buscar(List<Sample> samples, LocalDate fechaCreacion, LocalDate fechaUltVot, OpinionValue tipoDetectado,
//			String nivelDeVerificacion, List<LogicalOperator> operators) {
//		
//		Set<Sample> ss1 = new HashSet<Sample>();
//		Set<Sample> ss2 = new HashSet<Sample>();
//		Set<Sample> ss3 = new HashSet<Sample>();
//		Set<Sample> ss4 = new HashSet<Sample>();
//		
//		if(fechaCreacion != null) {
//			ss1= samples.stream().filter((s) -> s.getFechaCreacion().isAfter(fechaCreacion)).collect(Collectors.toSet()); //si es incluído fechaCreacion, le hago .minusDays(1)
//		}
//		if(fechaUltVot != null) {
//			ss2= samples.stream().filter((s) -> s.ultimaVotacion().isAfter(fechaUltVot)).collect(Collectors.toSet());
//		}
//		if(tipoDetectado != null) {
//			ss3= samples.stream().filter((s) -> s.currentResult().equals(tipoDetectado)).collect(Collectors.toSet());
//		}
//		if(nivelDeVerificacion != null) {
//			ss4= samples.stream().filter((s) -> s.nivelDeVerificacion().equals(nivelDeVerificacion)).collect(Collectors.toSet());
//		}
//		
//		List<Set<Sample>> sets= Stream.of(ss1, ss2, ss3, ss4).filter((smps) -> !(smps.isEmpty()) ).collect(Collectors.toList()); //sets NO NULOS
//		
//		Set<Sample> aDevolver = sets.get(0); //ya que, si hubo un solo criterio y no hay ningún conector lógico, no tengo que 
//											 //hacer operaciones lógicas (y sabemos que hubo al menos un criterio por precond).
//		
//		for(int i=0; i < operators.size(); i++) {
//			int finI = i; //porque no puedo usar una variable de ciclo -que no es final- en una expresión lambda
//			if(operators.get(i).equals(LogicalOperator.And)) {
//				aDevolver = aDevolver.stream().filter((s) -> sets.get(finI+1).contains(s)).collect(Collectors.toSet()); 
//				//se toman los que cumplen tanto la expresión analizada hasta ahora como tmb el próximo criterio de la expresión
//			} else { //caso Or
//				aDevolver.addAll(sets.get(finI+1));
//				//se toman los que cumplen la expresión analizada hasta ahora o cumplen el próximo criterio de la expresión
//			}
//		}
//		
//		return aDevolver.stream().collect(Collectors.toList());
//		
//	}
}
