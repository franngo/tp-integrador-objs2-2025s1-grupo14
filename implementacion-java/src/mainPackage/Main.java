package mainPackage;

import Enums.*;
import ar.edu.unq.poo2.tpintegrador.organizaciones.*;

import sample.*;
import user.*;
import position.*;
public class Main {

	public static void main(String[] args) {

	

		App system = new App();
		Position pos = new Position(1,1);
		Sample s1 = new Sample(new ChangeableUser("Pepe", system), EVinchuca.Guasayana, pos, system);
		Sample s2 = new Sample(new ChangeableUser("Pepe2", system), EVinchuca.Infestans, new Position(1,2),system);
		
		EventManager EM = new EventManager();
		Position posR = new Position(2,1);
		Region rA = new Region(posR, 1000d, "Varela", EM);
		
//		Organizacion ONG1 = new Organizacion("Ong1", null, 32);
//		Organizacion ONG2 = new Organizacion("Ong2", null, 32);

		system.addRegios(rA);
		
		//EM.suscribeUpload(ONG1);
		system.addSample(s1);
		system.addSample(s2);
		
		System.out.println(system.getSamples());
		
//		System.out.println("R1: " + s1.getLocation().getRegions(system));
//		System.out.println("R2: " + s2.getLocation().getRegions(system));
//		
//		//system.addSample(s1, rA);
//		System.out.println("A:" + rA.getSamplesInRegion(system.getSamples()));
//
//		
//		EM.suscribeValidation(ONG2);
//		System.out.println("AAA: " + ONG1.countValidation);
//
//		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe1");
//		s1.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
//		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
//		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
//		System.out.println("AAA: " + ONG1.countValidation);
//		
//		s2.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
//		s2.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
//		s2.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
//
	}
}
