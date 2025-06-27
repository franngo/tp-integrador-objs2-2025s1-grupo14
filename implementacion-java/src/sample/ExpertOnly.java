package sample;


import java.util.List;
import Enums.*;
import mainPackage.Region;

public class ExpertOnly implements ISampleState{

	@Override
	public void changeState(Sample sample) {
//		if(sample.getApp() != null) {
//			List<Region> reg = sample.getLocation().getRegions(sample.getLocation().getApp());
//			if(reg.stream().map(r -> r.getSamplesInRegion(sample.getLocation().getApp().getSamples())).flatMap(s -> s.stream()).toList().contains(sample)){	
//				sample.getLocation().getRegions(sample.getLocation().getApp()).stream().forEach(r -> r.notify("validation", sample));
//			}
//		}
//		sample.setState(new Closed());
		
	}

	@Override
	public boolean isValid(String expertise) {
		if(expertise == "Basic") {
			System.out.println("No pueden opinar usuarios Nivel Basico, solo expertos");
			return false;
		}
		return true;
	}

	@Override
	public void checkStateChange(String expertise, Sample sample,OpinionValue opinion) {
		if(sample.expertsCoinciden(opinion)) {
			this.changeState(sample);
			System.out.println("Se cierran los comentarios. Ya coincidieron dos expertos y esta verificada!");
		}
	}

	@Override
	public String nivelDeVerificacion() {
		return "votada";
	}

}
