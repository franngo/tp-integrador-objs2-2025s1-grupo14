package sample;

import Enums.*;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		if(sample.getApp() != null) { //Solo para test. NO existe un caso donde la sample no tenga App fuera de los test.
			sample.notifyValidation();
		}
		sample.setState(new Closed());
		
	}

	@Override
	public boolean isValid(EUserState expertise) {
		if(expertise == EUserState.Basic) {
			System.out.println("No pueden opinar usuarios Nivel Basico, solo expertos");
			return false;
		}
		return true;
	}

	@Override
	public void checkStateChange(EUserState expertise, Sample sample,OpinionValue opinion) {
		if(sample.expertsCoinciden(opinion)) {
			this.changeState(sample);
			System.out.println("Se cierran los comentarios. Ya coincidieron dos expertos y esta verificada!");
		}
	}

	@Override
	public String nivelDeVerificacion() {
		return "votada";
	}

	@Override
	public OpinionValue result(Sample sample) {
		return sample.result(EUserState.Expert);
	}





}
