package sample;

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
	public void addReview(String expertise, Sample sample) {
		if(expertise.equalsIgnoreCase("Expert")) {
			System.out.println("A partir de ahora opinan Expertos");
			this.changeState(sample);
		}
		
	}

}
