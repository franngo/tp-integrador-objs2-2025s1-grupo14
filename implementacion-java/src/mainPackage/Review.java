package mainPackage;

import Enums.OpinionValue;
import java.time.LocalDate;

public class Review {
	
	private OpinionValue opinion;
	private String expertise;
	private String userName;
	private LocalDate fechaReview;
	
	
	public Review(OpinionValue opinion, String expertise, String userName, LocalDate fechaReview) {
		this.opinion = opinion;
		this.expertise = expertise;
		this.userName = userName;
		this.fechaReview = fechaReview;
	}

	public OpinionValue getOpinion() {
		return opinion;
	}

	public String getExpertise() {
		return expertise;
	}

	public String getUserName() {
		return userName;
	}
	
	public LocalDate getFechaReview() {
		return fechaReview;
	}
	
	public void setFechaReview(LocalDate fechaReview) { //para testear el SearchEngine
		this.fechaReview = fechaReview;
	}

}
