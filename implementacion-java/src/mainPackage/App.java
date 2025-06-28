package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sample.Sample;

public class App {
	private List<Sample> samples = new ArrayList<Sample>();
	private List<Region> regions = new ArrayList<Region>();
	
	//samples que no se encuentran en una region
	public void addSample(Sample sample) {
		if(regions.isEmpty() || regions.stream().noneMatch(r -> r.isPosInside(sample.getLocation()))){
			samples.add(sample);
		} else {
			regions.stream().filter(r -> r.isPosInside(sample.getLocation())).forEach(r -> r.addSample(sample));;
		}
	}
	
	
	public List<Sample> getSamplesTotal(){
		List<Sample> samplesTotal = regions.stream().map(r -> r.getSamples()).flatMap(s -> s.stream()).collect(Collectors.toList());
		samplesTotal.addAll(samples);
		return samplesTotal;
	}
	
	public List<Sample> getSamplesNoRegion(){
		return samples;
	}
	
	public void addRegion(Region region) {
		regions.add(region);
	}
	
	public List<Region> getRegions(){
		return regions;
	}
}