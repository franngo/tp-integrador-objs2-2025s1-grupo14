package sample;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		sample.setState(new Closed());
	}

	@Override
	public boolean isValid(String expertise,Sample sample) {
		if(expertise == "Basic") {
			return false;
		}
		this.changeState(sample);
		return true;
	}

}
