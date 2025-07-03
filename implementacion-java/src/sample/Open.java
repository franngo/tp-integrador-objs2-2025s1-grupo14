package sample;

import Enums.*;

public class Open implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		sample.setState(new ExpertOnly());
	}

	@Override
	public boolean isValid(EUserState expertise) {
		return true;
	}

	@Override
	public void checkStateChange(EUserState expertise, Sample sample, OpinionValue opinion) {
		if(expertise == EUserState.Expert) {
			System.out.println("A partir de ahora opinan Expertos");
			this.changeState(sample);
		}
		
	}
	
	@Override
	public OpinionValue result(Sample sample) {
		return sample.result(EUserState.Basic);
	}
	
	
	@Override
	public String nivelDeVerificacion() {
		return "votada";
	}



}
