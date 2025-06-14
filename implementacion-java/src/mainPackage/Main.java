package mainPackage;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;
import sample.Open;
import sample.Sample;
import user.*;
public class Main {

	public static void main(String[] args) {
			Sample s1 =  new Sample("Pepe", EVinchuca.Guasayana, null); //falta el location
			
		
		
		//	System.out.println(s1.puedeOpinar("Pepe"));

			s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
			s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
			s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
			
			assertTrue(s1.getState() instanceof Open);
			assertEquals(3, s1.getReviews().size());
		
		
	}
}
