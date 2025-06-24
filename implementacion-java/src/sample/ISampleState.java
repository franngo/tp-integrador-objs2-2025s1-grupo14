package sample;

import Enums.OpinionValue;

public interface ISampleState {
	public void changeState(Sample sample);
	public boolean isValid(String  expertise);
	public void addReview(String expertise, Sample sample,OpinionValue opinion);
}
