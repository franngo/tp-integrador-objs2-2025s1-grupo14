package sample;

import Enums.OpinionValue;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		sample.setState(new Closed());
	}

	@Override
	public boolean isValid(String expertise) {
		if(expertise == "Basic") {
			System.out.println("No pueden opinar usuarios Nivel Basico, Solo expertos");
			return false;
		}
		return true;
	}

	@Override
	public void addReview(String expertise, Sample sample,OpinionValue opinion) {
		if(sample.expertsCoincides(opinion)) {
			this.changeState(sample);
			System.out.println("Se cierran los comentarios ya opinaron dos expetos y esta verificada!");
		}
	}

}
