package sample;

public interface ISampleState {
	public void changeState(Sample sample);
	public boolean isValid(String  expertise,Sample sample);
}
