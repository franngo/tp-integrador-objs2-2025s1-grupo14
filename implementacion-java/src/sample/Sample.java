package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Enums.*;
import mainPackage.Review;
import net.bytebuddy.asm.Advice.This;

public class Sample {
	//Esto es una prueba para ver si se hacer esto en eclipse
	private String user;
	private String photo;
	private EVinchuca specie;
	//private Position location;
	private ISampleState state;
	
	private List<Review> reviews = new ArrayList<Review>();
	
	
	//CONSTRUCTUR
	public Sample(String user, EVinchuca specie) { //,Position location ) {
		this.user = user;
		this.photo = "photo.png";
		this.specie = specie;
		//this.location = location;
		state = new Open();
	}

	public void addReview(OpinionValue opinion,String expertise, String userName) {
		/*
		 * Agrega la opion del usuario si el estado lo permite.
		 */
		
		if(state.isValid(expertise, this)) {
			reviews.add(new Review(opinion, expertise, userName));
		}
	}
	
	
	public OpinionValue currentResult() {
		double max = 0;
		double curr = 0;
		OpinionValue maxOpinion = OpinionValue.Ninguna;
		
		for(OpinionValue ov : OpinionValue.values()) {
			curr = Collections.frequency(
					this.listLevel().stream().map(r -> r.getOpinion()).toList()  , ov);
			
			if(max < curr) {
				max = curr;
				maxOpinion = ov;
			} else if (max == curr) {
				maxOpinion = OpinionValue.Ninguna; //resultado de empate
			}
			
			
		}
		return maxOpinion;
	
	}
	
	
	private List<Review> listLevel() {
		if(state instanceof ExpertOnly) {
			return reviews.stream().filter(r -> r.getExpertise().equalsIgnoreCase("Expert")).toList();
		}
		return reviews;
	}

	//GETTERS Y SETTERS
	public String getUser() {
		return user;
	}

	public EVinchuca getSpecie() {
		return specie;
	}

//	public Position getLocation() {
//		return location;
//	}

	public ISampleState getState() {
		return state;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setState(ISampleState state) {
		this.state = state;
	}
	
	
	
}
