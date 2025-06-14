package mainPackage;

import java.util.ArrayList;
import java.util.List;

import sample.Sample;

public class App {
	private List<Sample> samples = new ArrayList<Sample>();
	//private List<Region> regions = new ArrayList<Region>();
	
	public void addSample(Sample sample) {
		samples.add(sample);
	}
}
