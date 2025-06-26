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
	public void checkStateChange(String expertise, Sample sample, OpinionValue opinion) {
		//no hace nada porque este es el "estado final". No existe un cambio de estado a otro estado.
	}
	
	@Override
	public String nivelDeVerificacion() {
		return "verificada";
	}

}
