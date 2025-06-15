package sampleTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import sample.Closed;
import sample.ExpertOnly;
import sample.Open;
import sample.Sample;

public class ClosedStateSample {
	
	Sample s1 ;

	
	@BeforeEach
	public void setUp() {
		s1 =  new Sample("Pepe", EVinchuca.Guasayana, null); //falta el location
		
	}

	
	@Test
	public void CloseReview() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
		assertTrue(s1.getState() instanceof Open);
		
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana");
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Maria Clara");
		assertTrue(s1.getState() instanceof Closed);
		
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		assertEquals(3, s1.getReviews().size());
	}
}
