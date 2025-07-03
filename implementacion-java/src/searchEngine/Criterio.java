package searchEngine;

import sample.Sample;
import java.util.List;
import java.util.stream.Collectors;

abstract public class Criterio {
	
	//cada criterio CONCRETO almacena un parámetro de búsqueda del tipo que corresponde para realizar el filtrado
	
	public List<Sample> lasQueCumplenCriterio(List<Sample> samples) {
		return samples.stream().filter((s) -> this.cumpleCriterio(s)).collect(Collectors.toList());
	}
	
	abstract public boolean cumpleCriterio(Sample sample);
}
