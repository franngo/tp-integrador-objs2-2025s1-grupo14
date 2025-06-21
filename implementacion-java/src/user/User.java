package user;

import sample.*;


import Enums.*;
import mainPackage.*;
import position.*;

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
        Sample sample = new Sample(name, specie, location);
        
        //Crea la primer review con la especie que el usuario identifico. (Pasa de un enum a otro)
        //El paso funciona en orden, E1(a,b,c) y E2(1,2,3) => E1.a pasa a E2.1. en el orden en que se define      
        this.addReview(sample, OpinionValue.values()[specie.ordinal()]); 
        
        //Agrega el sample a la App
        system.addSample(sample);
    }

    public void addReview(Sample sample, OpinionValue opinion) {
    	// solucion temploral, para que se puede agregar el LocalDate a Changeable usuario solo si se puede sube la review   	
    	
    	if(sample.puedeOpinar(name, this.getExpertise())) { 
    		sample.addReview(opinion, this.getExpertise(), this.getName()); 
    		//this.uploadedReviewsDates(); El expertOnly tambien la tiene pero no la usa.
    	}     
    }
    
    
    //va en otro lado, no tiene sentido que se tenga que conocer a una sample x para crear otra sample.
    public Sample sampleFactory(EVinchuca specie, Position location) {
    	return new Sample(name,specie,location);
    }
    
 //   protected abstract void uploadedReviewsDates();
	abstract public String getExpertise();
	
}