package ar.edu.unq.poo2.tpintegrador.organizaciones;

import java.util.List;

import mainPackage.Region;

public class EventManager {
	
	private List<Iobserver> uploadSubs;
	private List<Iobserver> validationSubs;
	
	
	//suscribe
	public void suscribeUpload (Iobserver observer) {
		uploadSubs.add(observer);
	}
	
	public void suscribeValidation (Iobserver observer) {
		validationSubs.add(observer);
	}
	
	//ususcribe
	
	public void unsuscribeUpload (Iobserver observer) {
		uploadSubs.remove(observer);
	}
	
	public void unsuscribeValidation (Iobserver observer) {
		validationSubs.remove(observer);
	}
	
	
	public void notify(String event, Region region) {
		if(event.equalsIgnoreCase("upload")) {
			uploadSubs.forEach(s -> s.notifyUpload(region));
		} 
		if (event.equalsIgnoreCase("validation")) {
			validationSubs.forEach(s -> s.notifyValidation(region));
		}
	}
	
	

}
