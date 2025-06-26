package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import position.*;
import Enums.*;
import mainPackage.App;
import mainPackage.Review;
import java.time.LocalDate;


public class Sample {
	private String user;
	private String photo;
	private EVinchuca specie;
	private Position location;
	private ISampleState state;
	private LocalDate fechaCreacion;
	private App system;
	
	private List<Review> reviews = new ArrayList<Review>();
	
	public Sample(String user, EVinchuca specie ,Position location, LocalDate fechaCreacion) {
		this.user = user;
		this.photo = "photo.png"; //es la misma en todos. En este contexto no tiene importancia.
		this.specie = specie;
		this.location = location;
		state = new Open();
		this.fechaCreacion = fechaCreacion;
		this.system = null;
	}

	public void addReview(OpinionValue opinion,String expertise, String userName, LocalDate fechaReview) {
		/*
		 * Agrega la opion del usuario si el estado lo permite.
		 */
		
		//Este condicional cumple la funcion de testear el cambio de estado sin tener que recurrir al usuario.
		if(this.puedeOpinar(userName,expertise)) { //podria solo tener state.isValid(...param...)
			state.checkStateChange(expertise, this, opinion);
			reviews.add(new Review(opinion, expertise, userName, fechaReview));
		}
	}
	
	
	public boolean puedeOpinar(String userName, String expertise) {
		/*
		 * Verifica si el usuario puede opinar en esta muestra, dependiendo su estado y que tenga haya una opinion de el.
		 */
		return  state.isValid(expertise) &&
				reviews.stream()
				.map(r -> r.getUserName())
				.filter(user -> user.equalsIgnoreCase(userName))
				.toList().size() != 1; // se puede cambiar la forma pero no entiendí el noneMatch().
		/*
		 * Si es 0 no es su Sample, puede opinar. Si es 1 o ya opino o es su Sample.
		 */
	}

	public OpinionValue currentResult() { //filtro número 3 utilizado por el buscador
		/*
		 * Indica el resultado de la muestra actual, basandose en las opiniones que tiene.
		 */
		double max = 0;
		double curr = 0;
		OpinionValue maxOpinion = OpinionValue.Ninguna;
		
		for(OpinionValue ov : OpinionValue.values()) {
			curr = Collections.frequency(
					this.listLevel().stream().
					map(r -> r.getOpinion()).toList()
					, ov);
			
			if(max < curr) {
				max = curr;
				maxOpinion = ov;
			} else if (max == curr) {
				maxOpinion = OpinionValue.Ninguna; //resultado de empate
			}
			
			
		}
		return maxOpinion;
	
	}
	
	
	public List<Review> listLevel() {
		/*
		 * Devuelve una lista de Opiniones(Review) que hayan hecho los expertos si el state es ExpertOnly, sino devuelve la lista de todas las opiniones.
		 */
		if(state instanceof ExpertOnly || state instanceof Closed) {
			return reviews.stream().filter(r -> r.getExpertise().equalsIgnoreCase("Expert")).toList();
		}
		return reviews;
	}
	
	public List<Sample> getSamplesInRangeToMe(List<Sample> samples, double radius, MeasureUnit mu) {
        return this.location.getSamplesInRangeToMe(samples, radius, mu);
    }

	//GETTERS Y SETTERS (algunos se usan solo para los test)
	public String getUser() {
		return user;
	}

	public EVinchuca getSpecie() {
		return specie;
	}

	public Position getLocation() {
		return location;
	}

	public ISampleState getState() {
		return state;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setState(ISampleState state) {
		this.state = state;
		
	}
	
	public LocalDate getFechaCreacion() { //filtro número 1 utilizado por el buscador
		return fechaCreacion;
	}
	
	public App getApp() {
		return system;
	}
	
	public void setApp(App s) {
		system = s;
	}

	public boolean expertsCoinciden(OpinionValue opinion) {
		return this.listLevel().stream().filter(r -> r.getOpinion() == opinion).count() >= 1;
	
	}
	
	public LocalDate ultimaVotacion() { //filtro número 2 utilizado por el buscador
		return reviews.get(reviews.size()-1).getFechaReview(); //agarramos la última review añadida, o sea, la más reciente
	}
	
	public String nivelDeVerificacion() { //filtro número 4 utilizado por el buscador
		return state.nivelDeVerificacion();
	}
	
}
