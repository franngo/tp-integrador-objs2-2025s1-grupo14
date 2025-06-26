package ar.edu.unq.poo2.tpintegrador.organizaciones;

import Enums.TipoDeOrganizacion;
import mainPackage.Region;
import sample.Sample;

public class Organizacion implements Iobserver{
	private String name;
	private TipoDeOrganizacion tipoONG;
	private int employeesAmount;
	private FuncionalidadExterna validationAction;
	private FuncionalidadExterna uploadAction;
	
	public int countUpload = 0; //solo para los test. Porque no se usar Mockito :).
	public int countValidation = 0;
	
	public Organizacion(String name,TipoDeOrganizacion tipoONG, int employeesAmount) {
		this.name = name;
		this.tipoONG = tipoONG;
		this.employeesAmount = employeesAmount;
	}
	
	@Override
	public void notifyValidation(Sample sample, Region region) {
		//validationAction.nuevoEvento(this, region, sample);
		System.out.println("Nueva muestra verificada: \nSample: " + sample + "\nRegion: " + region + "\nONG: " + name);
		countValidation++;
	}


	@Override
	public void notifyUpload(Sample sample, Region region) {
		//uploadAction.nuevoEvento(this, region, sample);
		System.out.println("Nueva muestra subida: \nSample: " + sample + "\nRegion: " + region + "\nONG: " + name);
		countUpload++;
	}
	
	public void setValidationAction(FuncionalidadExterna valitionFunc) {
		validationAction = valitionFunc;
	}
	public void setUploadAction(FuncionalidadExterna uploadFunc) {
		uploadAction = uploadFunc;
	}
}
