package user;

import sample.*;
import Enums.*;
import mainPackage.*;
import position.*;
import java.time.LocalDate;
import java.util.List;

public abstract class User {
    protected String name;
    protected IUserState state;
    protected App system;
    
    public User(String name, App system) {
        this.name = name;
        this.system = system;
    }

    private String getName() {
        return this.name;
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
    		sample.addReview(opinion, this, LocalDate.now()); 
     
    }
    
//    public void addReview(Sample sample, OpinionValue opinion) {
//    	this.addReview(sample, opinion, LocalDate.now());     
//    }
    
 //   protected abstract void uploadedReviewsDates();
	abstract public String getExpertise();
	
	
	public App getApp() {
		return system;
	}
	
	public List<Sample> getSamples(){
		return system.getSamples().stream().filter(s -> s.getUser() == this).toList();
	}
	
	public List<Review> getReviews(){
		return system.getSamples().stream()
				.map(s -> s.getReviews())
				.flatMap(r -> r.stream())
				.filter(r -> r.getUser() == this).toList();
	}
}