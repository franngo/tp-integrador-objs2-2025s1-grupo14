package sample;

import Enums.OpinionValue;

public class Closed implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		
	}

	@Override
	public boolean isValid(String expertise) {
		return false;
	}

	@Override
	public void addReview(String expertise, Sample sample,OpinionValue opinion) {
		
	}

}
