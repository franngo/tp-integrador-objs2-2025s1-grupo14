package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import position.*;
import user.User;
import Enums.*;
import mainPackage.*;


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
		state = new Open();
		currResult =  OpinionValue.values()[specie.ordinal()];
	
	
	}

	public void addReview(OpinionValue opinion, User user) {
		/*
		 * Agrega la opion del usuario
		 */
		
			state.checkStateChange(user.getExpertise(), this, opinion);
			reviews.add(new Review(opinion, user, LocalDate.now()));
			currResult = state.result(this);

	}
	
	//para los test, sin tener usuario

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
//		double max = 0;
//		double curr = 0;
//		OpinionValue currResult = OpinionValue.Ninguna;
		
//		currResult = state.result(this);
	
//		for(OpinionValue ov : OpinionValue.values()) {
//			curr = Collections.frequency(
//					this.listLevel(state.getLevel()).stream().
//					map(r -> r.getOpinion()).toList()
//					, ov);
//			
//			if(max < curr) {
//				max = curr;
//				currResult = ov;
//			} else if (max == curr) {
//				currResult = OpinionValue.Ninguna; //resultado de empate
//			}
//			
//		}
		
		return currResult;
	
	}
	
	public OpinionValue result(EUserState expertise) {
		Map<Long, OpinionValue> freq = new HashMap<Long, OpinionValue>();
			for(OpinionValue ov : OpinionValue.values()) {
				freq.put(this.listLevel(expertise).stream().map(r -> r.getOpinion()).filter(o -> o == ov).count(), ov);
			}
		Long maxFreq =  freq.keySet().stream().max(Long::compare).get();
		return freq.get(maxFreq);
	}
	
	public boolean expertsCoinciden(OpinionValue opinion) {
		return this.listLevel(EUserState.Expert).stream().anyMatch(r -> r.getOpinion() == opinion);
		
	}
	
	public List<Review> listLevel(EUserState expertice) {
		/*
		 * Devuelve una lista de Opiniones(Review) que tengan el expertice dado.
		 */
		if(expertice == EUserState.Basic) {
			return reviews;
		}
		
		return reviews.stream().filter(r -> r.getExpertise() == expertice).toList();

	}
	
	public void notifyValidation() {
		List<Region> regionsSample = system.getRegions().stream()
				.filter(r -> r.getSamples().contains(this)).toList();
		regionsSample.forEach(r -> r.notify("validation", this));
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
	

	//Para test
	public void addReview(OpinionValue opinion, User user, LocalDate date) {
		/*
		 * Agrega la opion del usuario de una fecha espesifica, para probar los test
		 */
		
			state.checkStateChange(user.getExpertise(), this, opinion);
			reviews.add(new Review(opinion, user, date));

	}

	
//	
//	public LocalDate ultimaVotacion() { //filtro número 2 utilizado por el buscador
//		return reviews.get(reviews.size()-1).getFechaReview(); //agarramos la última review añadida, o sea, la más reciente
//	}
//	
//	public String nivelDeVerificacion() { //filtro número 4 utilizado por el buscador
//		return state.nivelDeVerificacion();
//	}
//	
//	public Review ultimaReview() { //para testear el SearchEngine
//		return reviews.get(reviews.size()-1);
//	}
//	
}
