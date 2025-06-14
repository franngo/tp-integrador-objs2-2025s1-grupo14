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
    	//se crea la sample
        Sample sample = new Sample(name,specie,location);
        
        //Crea la primer review con la especie que el usuario identifico. (Pasa de un enum a otro)
        //El paso funciona en orden, E1(a,b,c) y E2(1,2,3) => E1.a pasa a E2.1. en el orden en que se define      
        this.review(sample, OpinionValue.values()[specie.ordinal()]); 
        
        //Agrega el sample a la app
        system.addSample(sample);
    }

    public void review(Sample sample, OpinionValue opinion) {
    	// solucion temploral, para que se puede agregar el LocalDate a Changeable usuario solo si se puede sube la review   	
    	if(sample.puedeOpinar(name, this.getExpertise())) { 
    		sample.addReview(opinion, this.getExpertise(), this.getName()); 
    		this.uploadedReviewsDates();
    	}
        
        
        //acá, si no se puede agregar review, 
        //tira excepción y la review nunca se añade a la de esa Sample
        //creo que está mejor pasarle los parámetros, primero validar (con isValid) si se puede cargar una review para dicha muestra, y, si
        //se puede, ahí la generamos y la cargamos. Sino, estaríamos generando siempre una Review, pero en algunas ocasiones nos la van
        //a terminar descartando si no pasa la validación en Sample (lo digo xq en el anterior UML pasabamos una Review ya generada y, por
        //tanto, la validación se hacía sobre la Review ya generada, la cual podía terminar descartada.
    }

    protected abstract void uploadedReviewsDates();
	abstract protected String getExpertise();
}