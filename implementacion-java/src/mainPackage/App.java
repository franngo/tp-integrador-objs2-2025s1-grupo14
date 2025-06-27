package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import sample.Sample;

public class App {
	private List<Sample> samples = new ArrayList<Sample>();
	private List<Region> regions = new ArrayList<Region>();
	
	//samples que no se encuentran en una region
	public void addSample(Sample sample) {
		regions.forEach(r -> r.addSample(sample));
	}
	
	
	public List<Sample> getSamples(){
		List<Sample> samplesTotal = regions.stream().map(r -> r.getSamples()).flatMap(s -> s.stream()).collect(Collectors.toList());
		samplesTotal.addAll(samples);
		return samplesTotal;
	}
	
	public void addRegios(Region region) {
		regions.add(region);
	}
	
	public List<Region> getRegions(){
		return regions;
	}
}