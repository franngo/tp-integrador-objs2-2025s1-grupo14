package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import sample.Sample;

public class App {
	private List<Sample> samples = new ArrayList<Sample>();
	private List<Region> regions = new ArrayList<Region>();
	
	
//	//samples en region x
//	public void addSample(Sample sample, Region region) {
//		//region.addSample(sample);
//		samples.add(sample);
//		sample.setApp(this);
//		//region.notify("upload", sample);
//		sample.getLocation().getRegions(this).forEach(r -> r.notify("upload", sample));
//	}
//	
	
	//samples que no se encuentran en una region
	public void addSample(Sample sample) {
		samples.add(sample);
		sample.setApp(this);
		sample.getLocation().getRegions(this).forEach(r -> r.notify("upload", sample));
	}
	
	public List<Sample> getSamples(){
		return samples;
		//return regions.stream().map(r -> r.getSamplesInRegion()).flatMap(s -> s.stream()).collect(Collectors.toList());
	}
	
	public void addRegios(Region region) {
		regions.add(region);
	}
	
	public List<Region> getRegions(){
		return regions;
	}
}
//PRUEBA PARA EL PULL REQUEST