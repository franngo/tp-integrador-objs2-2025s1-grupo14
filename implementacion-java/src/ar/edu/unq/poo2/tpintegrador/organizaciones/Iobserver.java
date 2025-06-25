package ar.edu.unq.poo2.tpintegrador.organizaciones;

import mainPackage.Region;

public interface Iobserver {
	
	public void notifyValidation(Region region);
	public void notifyUpload(Region region);
	
}
