package searchEngine;

import sample.Sample;
import Enums.OpinionValue;
import Enums.LogicalOperator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.*;

public class SearchEngine {
	/*
	 *  Precondición: 
	 * -Se deben pasar n-1 conectores lógicos, siendo n la cantidad de criterios que se pasan como argumento.
	 */
	public List<Sample> buscar(List<Sample> samples, List<Criterio> criterios, List<LogicalOperator> operators) {
		
		List<List<Sample>> listasCumplen= criterios.stream().
				map((criterio) -> criterio.lasQueCumplenCriterio(samples) ).collect(Collectors.toList());
		
		Set<Sample> aDevolver = new HashSet<Sample>();
		aDevolver.addAll(listasCumplen.get(0)); 
		//Ya que, si hubo un solo criterio y no hay ningún conector lógico, no tengo que hacer operaciones lógicas
		
		//uso ciclo for porque quiero recorrar tanto los operadores lógicos como las listas que cumplen los criterios
		for(int i=0; i < operators.size(); i++) {
			int finI = i; //porque no puedo usar una variable de ciclo -que no es final- en una expresión lambda
			if(operators.get(i).equals(LogicalOperator.And)) {
				aDevolver = aDevolver.stream().filter((s) -> listasCumplen.get(finI+1).contains(s)).collect(Collectors.toSet()); 
				//se toman las que cumplen tanto la expresión analizada hasta ahora como tmb el próximo criterio de la expresión
			} else { //caso Or
				aDevolver.addAll(listasCumplen.get(finI+1));
				//se toman las que cumplen la expresión analizada hasta ahora o cumplen el próximo criterio de la expresión
			}
		}
		
		return aDevolver.stream().collect(Collectors.toList());
		
	}
}
