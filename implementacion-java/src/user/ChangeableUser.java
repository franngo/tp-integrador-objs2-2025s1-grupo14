package user;
import sample.*;
import position.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Enums.*;
import mainPackage.App;

public class ChangeableUser extends User {
    private List<LocalDate> uploadedSamplesDates = new ArrayList<LocalDate>();  //esto es para el cálculo statCheck(), para ver si cambió de nivel
    private List<LocalDate> uploadedReviewsDates = new ArrayList<LocalDate>();  //esto es para el cálculo statCheck(), para ver si cambió de nivel

    public ChangeableUser (String name, App system) {
        super(name,  system);
        state = new Basic();
    }

    @Override
    public void uploadSample(EVinchuca specie, Position location) {
    	/*
    	 * Cuando sube un sample, agrega la fecha en su historial. (No importa que sample sube)
    	 */
        super.uploadSample(specie, location);
        uploadedSamplesDates.add(LocalDate.now()); //hay que cargar la LocalDate actual
    }

    @Override
    public void review(Sample sample, OpinionValue opinion) {
        this.statCheck(); //para ver si se tiene que actualizar el state
        super.review(sample, opinion);
    }

    @Override
    protected String getExpertise() {
        return state.getExpertise(); //si es Basic retornará "Basic" y si es Expert retornará "Expert"
    }

    private void statCheck() {
        state.statCheck(this, uploadedSamplesDates, uploadedReviewsDates);
        //cambia o no cambia dependiendo de si las 20 reviews más reciente son todas hechas en los últimos nosecuantos días y las 10 
        //samples más recientes son todas hechas también en los últimos nosecuantos días.
    }
    
    protected void setState(IUserState state) {
    	this.state = state;
    }

	@Override
	protected void uploadedReviewsDates() {
		uploadedReviewsDates.add(LocalDate.now());		
	}
}