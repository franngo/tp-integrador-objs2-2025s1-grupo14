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
	
	public int countUpload = 0; //La utilizamos solamente para los tests, ya que no nos salió usando Mockito
	public int countValidation = 0; //La utilizamos solamente para los tests, ya que no nos salió usando Mockito
	
	public Organizacion(String name,TipoDeOrganizacion tipoONG, int employeesAmount) {
		this.name = name;
		this.tipoONG = tipoONG;
		this.employeesAmount = employeesAmount;
	}
  
	@Override
	public void notifyValidation(Sample sample, Region region) {
		validationAction.nuevoEvento(this, region, sample);
		countValidation++;
	}

	@Override
	public void notifyUpload(Sample sample, Region region) {
		uploadAction.nuevoEvento(this, region, sample);
		countUpload++;
	}
	
	public void setValidationAction(FuncionalidadExterna validationFunc) {
		this.validationAction = validationFunc;
	}
  
	public void setUploadAction(FuncionalidadExterna uploadFunc) {
		this.uploadAction = uploadFunc;
	}
	
	public String getName() {
		return this.name;
	}

  
}
