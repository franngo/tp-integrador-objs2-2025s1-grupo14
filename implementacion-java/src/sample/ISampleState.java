package sample;

import Enums.*;

public interface ISampleState {
	
	public void changeState(Sample sample);
	public boolean isValid(EUserState  expertise);
	
	public void checkStateChange(EUserState expertise, Sample sample, OpinionValue opinion);
	
	
//	public String nivelDeVerificacion();
	public OpinionValue result(Sample sample);
}
