package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import position.*;
import user.User;
import Enums.*;
import mainPackage.App;
import mainPackage.Review;
import java.time.LocalDate;


public class Sample {
	private User user;
	private String photo;
	private EVinchuca specie;
	private ISampleState state;
	private Position location;
	private LocalDate fechaCreacion;
	private App system;
	private OpinionValue currResult;
	
	private List<Review> reviews = new ArrayList<Review>();
	
	
	public Sample(User user, EVinchuca specie ,Position location, App system) {
		this.user = user;
		this.photo = "photo.png"; //es la misma en todos. En este contexto no tiene importancia.
		this.specie = specie;
		this.location = location;
		this.system = system;
		currResult =  OpinionValue.values()[specie.ordinal()];
	
	
	}

	public void addReview(OpinionValue opinion, User user, LocalDate fechaReview) {
		/*
		 * Agrega la opion del usuario si el estado lo permite.
		 */
		
		//Este condicional cumple la funcion de testear el cambio de estado sin tener que recurrir al usuario.
		if(this.puedeOpinar(user)) { //podria solo tener state.isValid(...param...)
			state.checkStateChange(user.getExpertise(), this, opinion);
			reviews.add(new Review(opinion, user, fechaReview));
		}
	}
	
	
	public boolean puedeOpinar(User user) {
		/*
		 * Verifica si el usuario puede opinar en esta muestra, dependiendo su estado y que tenga haya una opinion de el.
		 */
		return  state.isValid(user.getExpertise()) &&
				reviews.stream()
				.map(r -> r.getUser()).noneMatch(u -> u == user);

	}

	public OpinionValue currentResult() { //filtro número 3 utilizado por el buscador
		/*
		 * Indica el resultado de la muestra actual, basandose en las opiniones que tiene.
		 */
		//CAMBIAR Y HACELO QUE DEPENDE DEL ESTADO, TRABAJAR CON STREAMS, CUARDAS EL CURRENTRESULT PARA QUE NO LO TENGA QUE CALCULAR CADA VEZ QUE SE PREGUNTA
		// SI EL ESTADO ES CLOSED EL CURRENT RESULT YA NO PUEDE CAMBIAR, NO VALE LA PENA CALCULARLO.
		double max = 0;
		double curr = 0;
		OpinionValue currResult = OpinionValue.Ninguna;
		
		for(OpinionValue ov : OpinionValue.values()) {
			curr = Collections.frequency(
					this.listLevel().stream().
					map(r -> r.getOpinion()).toList()
					, ov);
			
			if(max < curr) {
				max = curr;
				currResult = ov;
			} else if (max == curr) {
				currResult = OpinionValue.Ninguna; //resultado de empate
			}
			
		}
		
		return currResult;
	
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
	

	//GETTERS Y SETTERS (algunos se usan solo para los test)
	public User getUser() {
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
	
	public void setFechaCreacion(LocalDate fechaCreacion) { //para testear el SearchEngine
		this.fechaCreacion = fechaCreacion;
	}
	
	public App getApp() {
		return system;
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
	
	public Review ultimaReview() { //para testear el SearchEngine
		return reviews.get(reviews.size()-1);
	}
	
}
