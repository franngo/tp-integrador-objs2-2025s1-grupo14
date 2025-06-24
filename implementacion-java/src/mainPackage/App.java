package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import sample.Sample;

public class App {
	//private List<Sample> samples = new ArrayList<Sample>();
	private List<Region> regions = new ArrayList<Region>();
	
	public void addSample(Sample sample, Region region) {
		region.addSample(sample);
	}
	
	public List<Sample> getSamples(){
		return regions.stream().map(r -> r.getSamplesInRegion())
				.flatMap(s -> s.stream()).collect(Collectors.toList());
	}
	
	public void addRegios(Region region) {
		regions.add(region);
	}
	
	public List<Region> getRegions(){
		return regions;
	}
}
