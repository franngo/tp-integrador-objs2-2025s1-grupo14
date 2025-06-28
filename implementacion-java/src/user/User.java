package user;

import sample.*;
import Enums.*;
import mainPackage.*;
import position.*;
import java.time.LocalDate;
import java.util.List;

public class User {
    protected String name;
    protected IUserState state;
    protected App system;
    
    public User(String name, App system) {
        this.name = name;
        this.system = system;
        state = new Basic();
    }
    



    public void uploadSample(EVinchuca specie, Position location) {
    	/*
    	 * Sube la una sample a la App si se puede.
    	 */
    	
    	//se crea la sample
        Sample sample = new Sample(this, specie, location, system);
        
        //Crea la primer review con la especie que el usuario identifico. (Pasa de un enum a otro)
        //El paso funciona en orden, E1(a,b,c) y E2(1,2,3) => E1.a pasa a E2.1. en el orden en que se define      
        
        this.addReview(sample, OpinionValue.values()[specie.ordinal()]); 
	     system.addSample(sample);

    }

    public void addReview(Sample sample, OpinionValue opinion) { 
    	if(sample.puedeOpinar(this)) {	
    		state.statCheck(this);
    		sample.addReview(opinion, this); 
    	}
     
    }
    
    //CALCULOS
	// no cumple el single responsability, se deberian mover a otra clase.
	protected double cantidadDeFechasEntreDias(List<LocalDate> dates, int days) {
		/*
		 * Devuelve la cantidad de dias en una lista que estan entre n(days) dias antes de la fecha de hoy.
		 */
		return dates.stream().filter(date -> this. estaFechaEntreDias(date, days)).count();
	}
	
	protected boolean estaFechaEntreDias(LocalDate date, int days) {
		/*
		 * Indica si la fecha dada (date) esta antes que mañana y despúes de la fehca (hoy - days);
		 */
		return date.isBefore(LocalDate.now().plusDays(1)) && date.isAfter(LocalDate.now().minusDays(days));
	}
	

    //SETTERS
    
    public void changeState(IUserState state) {
    	this.state = state;
    }
    
    //GETTERS
    public String getName() {
    	return this.name;
    }
	public EUserState getExpertise() {
		return state.getExpertise();
	}
	
	public App getApp() {
		return system;
	}
	
	public List<Sample> getSamples(){
		return system.getSamplesTotal().stream().filter(s -> s.getUser() == this).toList();
	}
	
	public List<Review> getReviews(){
		return system.getSamplesTotal().stream()
				.map(s -> s.getReviews())
				.flatMap(r -> r.stream())
				.filter(r -> r.getUser() == this).toList();
	}
	
	public List<LocalDate> getSampleDates(){
		return this.getSamples().stream().map(s -> s.getFechaCreacion()).toList();
	}
	public List<LocalDate> getReviewsDates(){
		return this.getReviews().stream().map(r -> r.getFechaReview()).toList();
	}
}