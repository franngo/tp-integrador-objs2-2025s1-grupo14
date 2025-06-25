package ar.edu.unq.poo2.tpintegrador.organizaciones;

import java.util.ArrayList;
import java.util.List;

import Enums.TipoDeOrganizacion;
import mainPackage.Region;
import position.Position;
import user.User;

public class Organizacion implements Iobserver {
 
	private Position location;
	private TipoDeOrganizacion type;
	private int amountEmployees; // se setea arbitrariamente, ya que no importa en el contexto del tp
	private FuncionalidadExterna validationAction;
	private FuncionalidadExterna uploadAction;
	
	
	
	//asumimos que se puede crear una ong sin saber sus funcionalidades de manera previa 
	public Organizacion (Position location, TipoDeOrganizacion type, int amountEmployees) {
		super();
		this.location = location;
		this.type = type;
		this.amountEmployees = amountEmployees;
		
	}



	@Override
	public void notifyValidation(Region region) {
		
		
	}



	@Override
	public void notifyUpload(Region region) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}


