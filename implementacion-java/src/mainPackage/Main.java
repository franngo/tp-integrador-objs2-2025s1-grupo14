package mainPackage;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;
import ar.edu.unq.poo2.tpintegrador.organizaciones.*;
import sample.Open;
import sample.Sample;
import user.ChangeableUser;
import position.*;
public class Main {

	public static void main(String[] args) {
		
		App system = new App();
		Position pos = new Position(1,1, system);
		Sample s1 = new Sample("PedroMatias", EVinchuca.Guasayana, pos);
		Sample s2 = new Sample("Elias", EVinchuca.Infestans, pos);
		
		EventManager EM = new EventManager();
		Position posR = new Position(3,1, system);
		Region rA = new Region(posR, 1000d, "Varela", EM);
		
		organizacion ONG1 = new organizacion("Ong1");
		organizacion ONG2 = new organizacion("Ong2");
		
		EM.suscribeUpload(ONG1);
		system.addSample(s1, rA);
		system.addSample(s2, rA);
		
		system.addRegios(rA);
		//system.addSample(s1, rA);
		
		
		EM.suscribeValidation(ONG2);
		EM.suscribeUpload(ONG1);
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe1");
		s1.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
		
		s2.addReview(OpinionValue.Phtia_Chinche, "Expert", "Pepe2");
		s2.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe3");
		s2.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe45");
		
		
	}
}
