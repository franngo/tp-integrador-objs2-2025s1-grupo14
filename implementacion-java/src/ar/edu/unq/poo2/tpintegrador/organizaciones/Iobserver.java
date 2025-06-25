package ar.edu.unq.poo2.tpintegrador.organizaciones;


import mainPackage.Region;
import sample.Sample;

public interface Iobserver {
	
	public void notifyValidation(Sample sample, Region region);
	public void notifyUpload(Sample sample, Region region);
	
}
