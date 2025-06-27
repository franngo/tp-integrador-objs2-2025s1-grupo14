package sample;

import Enums.*;

public class Closed implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		
	}

	@Override
	public boolean isValid(EUserState expertise) {
		return false;
	}

	@Override 
	public void checkStateChange(EUserState expertise, Sample sample, OpinionValue opinion) {
		//no hace nada porque este es el "estado final". No existe un cambio de estado a otro estado.
	}
	
	@Override
	public String nivelDeVerificacion() {
		return "verificada";
	}

	@Override
	public OpinionValue result(Sample sample) {
		return sample.currentResult();
	}

}
