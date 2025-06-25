package sample;


import java.util.List;
import java.util.stream.Collectors;

import Enums.*;
import mainPackage.Region;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
		if(sample.getApp() != null) {
			List<Region> reg = sample.getLocation().getRegions(sample.getLocation().getApp());
			if(reg.stream().map(r -> r.getSamplesInRegion(sample.getLocation().getApp().getSamples())).flatMap(s -> s.stream()).toList().contains(sample)){	
				sample.getLocation().getRegions(sample.getLocation().getApp()).stream().forEach(r -> r.notify("validation", sample));
			}
		}
		sample.setState(new Closed());
		
	}

	@Override
	public boolean isValid(String expertise) {
		if(expertise == "Basic") {
			System.out.println("No pueden opinar usuarios Nivel Basico, Solo expertos");
			return false;
		}
		return true;
	}

	@Override
	public void addReview(String expertise, Sample sample,OpinionValue opinion) {
		if(sample.expertsCoincides(opinion)) {
			this.changeState(sample);
			System.out.println("Se cierran los comentarios ya opinaron dos expetos y esta verificada!");
		}
	}


}
