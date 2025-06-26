package sample;

import Enums.*;

public interface ISampleState {
	
	public void changeState(Sample sample);
	public boolean isValid(String  expertise);
	public void checkStateChange(String expertise, Sample sample, OpinionValue opinion);
	public String nivelDeVerificacion();
  
}
