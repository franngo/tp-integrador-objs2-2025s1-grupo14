package ar.edu.unq.poo2.tpintegrador.organizaciones;

import mainPackage.Region;
import sample.Sample;

public class Organizacion implements Iobserver{
	private String name;
	
	public Organizacion(String name) {
		this.name = name;
	}
	@Override
	public void notifyValidation(Sample sample, Region region) {
		//validationAction.nuevoEvento(this, region, sample);
		System.out.println("Nueva muestra verificada: \nSample: " + sample + "\nRegion: " + region + "\nONG: " + name);
		
	}

	@Override
	public void notifyUpload(Sample sample, Region region) {
		//uploadAction.nuevoEvento(this, region, sample);
		System.out.println("Nueva muestra subida: \nSample: " + sample + "\nRegion: " + region + "\nONG: " + name);
	}
	
}
