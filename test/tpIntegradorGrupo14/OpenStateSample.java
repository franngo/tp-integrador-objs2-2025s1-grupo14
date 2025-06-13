package tpIntegradorGrupo14;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import sample.Open;
import sample.Sample;

public class OpenStateSample {
	
	Sample s1 ;

	
	@BeforeEach
	public void setUp() {
		s1 =  new Sample("Pepe", EVinchuca.Guasayana); //falta el location
		
	}
	
	@Test
	public void basicAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		
		assertTrue(s1.getState() instanceof Open);
		assertEquals(3, s1.getReviews().size());
	}
	
}
