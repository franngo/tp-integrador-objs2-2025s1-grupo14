package sample;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		sample.setState(new Closed());
	}

	@Override
	public boolean isValid(String expertise,Sample sample) {
		if(expertise == "Basic") {
			System.out.println("No pueden opinar usuarios Nivel Basico, Solo expertos");
			return false;
		}
		this.changeState(sample);
		System.out.println("Se cierran los comentarios ya opinaron dos expetos y esta verificada!");
		return true;
	}

}
