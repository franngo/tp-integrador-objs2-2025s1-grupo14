package ar.edu.unq.poo2.tpintegrador.organizaciones;

import mainPackage.Region;
import sample.Sample;

public class EmisorPorConsolaValidacion implements FuncionalidadExterna {
	
	@Override
	public void nuevoEvento(Organizacion ong, Region region, Sample sample) {
		System.out.println("##########\n" +
		"Se le notifica a la organización " + ong.getName() + " que la zona de cobertura de nombre "
		+ region.getName() + " ha reportado un nuevo evento de validación para la muestra del usuario " 
		+ sample.getUser().getName() + ", la cual cierra con el resultado final de " + sample.currentResult().toString() + "."
		+ "\n##########");
	}
	
}