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
		Sample s1 = new Sample(new User("Pepe", system), EVinchuca.Guasayana, pos, system);
		Sample s2 = new Sample(new User("Pepe2", system), EVinchuca.Infestans, new Position(1,1),system);
		
		EventManager EM = new EventManager();
		Position posR = new Position(2,1);
		Region rA = new Region(posR, 1000d, "Varela", EM);
		
		User u1 = new User("Pepe", system);
		User u2 = new PermanentE("Pepe2", system);
		User u3 = new PermanentE("Pepe3", system);
		User u4 = new PermanentE("Pepe4", system);
		
		Organizacion ONG1 = new Organizacion("Ong1", TipoDeOrganizacion.Salud, 32);
		Organizacion ONG2 = new Organizacion("Ong2", TipoDeOrganizacion.Asistencia, 32);
		
		system.addRegios(rA);
//		EM.suscribeUpload(ONG1);
//		EM.suscribeValidation(ONG2);
		System.out.println(u1.getExpertise());
		for(int x = 0; x < 30; x++) {
			u1.uploadSample(EVinchuca.Sordida, pos);
		}
		for(int x = 0; x < 30; x++) {
			u1.addReviewTest(s1, OpinionValue.Chinche_Foliada);
		}
		
		System.out.println(u1.getExpertise());
		system.addSample(s2);
//		System.out.println("Samples: " + system.getSamplesNoRegion());
//		System.out.println("Samples in region: " + rA.getSamples());
		
		//System.out.println("Samples in region: " + rA.getSamples().stream().map(s -> s.getUser()).map(u -> u.getName()).toList());
		
		
		
//		u1.addReview(s1, OpinionValue.Chinche_Foliada);
//		System.out.println("s1: " +s1.getState().toString());
//		
//		u2.addReview(s1, OpinionValue.Phtia_Chinche);
//		
//		u3.addReview(s1, OpinionValue.Phtia_Chinche);
//		System.out.println("s2: " +s1.getState().toString());
//		
//		u4.addReview(s1, OpinionValue.ImagenPocoClara);
//		System.out.println("s3: " +s1.getState().toString());
//		
//
//		System.out.println("CR: "+ s1.currentResult());


	}
}
