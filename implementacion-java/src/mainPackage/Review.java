package mainPackage;

import Enums.OpinionValue;

public class Review {
	
	OpinionValue opinion;
	String expertise;
	String userName;
	
	
	
	public Review(OpinionValue opinion, String expertise, String userName) {
		this.opinion = opinion;
		this.expertise = expertise;
		this.userName = userName;
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

	

}
