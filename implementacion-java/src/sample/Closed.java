package sample;

public class Closed implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		
	}

	@Override
	public boolean isValid(String expertise,Sample sample) {
		return false;
	}

}
