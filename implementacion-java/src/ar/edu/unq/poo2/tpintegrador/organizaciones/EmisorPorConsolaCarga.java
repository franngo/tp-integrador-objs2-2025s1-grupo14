package ar.edu.unq.poo2.tpintegrador.organizaciones;

import mainPackage.Region;
import sample.Sample;

public class EmisorPorConsolaCarga implements FuncionalidadExterna {
	
	@Override
	public void nuevoEvento(Organizacion ong, Region region, Sample sample) {
		System.out.println("##########\n" +
		"Se le notifica a la organización " + ong.getName() + " que la zona de cobertura de nombre "
		+ region.getName() + " ha reportado un nuevo evento de carga por el usuario " + sample.getUser().getName()
		+ " con el resultado inicial de " + sample.currentResult().toString() + "."
		+ "\n##########");
	}
	
}
