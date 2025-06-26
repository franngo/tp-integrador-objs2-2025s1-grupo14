package sample;

import Enums.OpinionValue;

public class Open implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		sample.setState(new ExpertOnly());
	}

	@Override
	public boolean isValid(String expertise) {
		return true;
	}

	@Override
	public void checkStateChange(String expertise, Sample sample, OpinionValue opinion) {
		if(expertise.equalsIgnoreCase("Expert")) {
			System.out.println("A partir de ahora opinan Expertos");
			this.changeState(sample);
		}
		
	}
	
	@Override
	public String nivelDeVerificacion() {
		return "votada";
	}

}
