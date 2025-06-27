package mainPackage;

import Enums.OpinionValue;
import user.User;

import java.time.LocalDate;

public class Review {
	
	private OpinionValue opinion;
	private String expertise;
	private User user;
	private LocalDate fechaReview;
	
	
	public Review(OpinionValue opinion,User user, LocalDate fechaReview) {
		this.opinion = opinion;
		this.expertise = user.getExpertise();
		this.user = user;
		this.fechaReview = fechaReview;
	}

	public OpinionValue getOpinion() {
		return opinion;
	}

	public String getExpertise() {
		return expertise;
	}

	public User getUser() {
		return user;
	}
	
	public LocalDate getFechaReview() {
		return fechaReview;
	}
	
	public void setFechaReview(LocalDate fechaReview) { //para testear el SearchEngine
		this.fechaReview = fechaReview;
	}

}
