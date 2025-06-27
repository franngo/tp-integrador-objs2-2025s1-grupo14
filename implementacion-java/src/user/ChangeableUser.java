package user;
import sample.*;
import position.*;

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
    	 * Cuando sube un sample, agrega la fecha en su historial. (No importa que fecha es de que sample)
    	 */
        super.uploadSample(specie, location);
        uploadedSamplesDates.add(LocalDate.now()); //hay que cargar la LocalDate actual
    }

    @Override
    public void addReview(Sample sample, OpinionValue opinion) {
    	/*
    	 * Verifica el esatdo y delega la tarea a su clase padre.
    	 */
        this.statCheck(); //para ver si se tiene que actualizar el state
        super.addReview(sample, opinion, fechaReview);
        if(sample.puedeOpinar(name, this.getExpertise())) {
    		this.uploadReviewsDates(fechaReview);
        }
    }

    @Override
    public String getExpertise() {
        return state.getExpertise(); //si es Basic retornará "Basic" y si es Expert retornará "Expert"
    }

    public void statCheck() {
        state.statCheck(this, uploadedSamplesDates, uploadedReviewsDates);
        //cambia o no cambia dependiendo de si las 20 reviews más reciente son todas hechas en los últimos nosecuantos días y las 10 
        //samples más recientes son todas hechas también en los últimos nosecuantos días.
    }
    
    public void setState(IUserState state) { //public para los test
    	this.state = state;
    }

	// @Override
	protected void uploadReviewsDates(LocalDate fechaReview) {
		uploadedReviewsDates.add(fechaReview);		
	}

	public List<LocalDate> getUploadedSamplesDates() {
		return uploadedSamplesDates;
	}

	public List<LocalDate> getUploadedReviewsDates() {
		return uploadedReviewsDates;
	}
	
	
	//para calcular los cambios de estado
	protected double cantidadDeFechasEntreDias(List<LocalDate> dates, int days) {
		/*
		 * Devuelve la cantidad de dates en una lista que estan entre n(days) dias antes de la fecha de hoy.
		 */
		return dates.stream().filter(date -> this. estaFechaEntreDias(date, days)).count();
	}
	
	protected boolean estaFechaEntreDias(LocalDate date, int days) {
		/*
		 * Indica si la fecha dada (date) esta antes que mañana y despúes de la fehca (hoy - days);
		 */
		return date.isBefore(LocalDate.now().plusDays(1)) && date.isAfter(LocalDate.now().minusDays(days));
	}
	
	
	//Test
	
	public void setCantidadReviewsDated(int cantidad, LocalDate date) {
		for(int x = 0; x < cantidad; x++) {
			uploadedReviewsDates.add(date);
		}
	}
	
	public IUserState getState() {
		return state;
	}
}