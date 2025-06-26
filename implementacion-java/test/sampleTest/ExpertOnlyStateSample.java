package sampleTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import sample.ExpertOnly;
import sample.Open;
import sample.Sample;

public class ExpertOnlyStateSample {
	
	Sample s1 ;

	
	@BeforeEach
	public void setUp() {
		s1 =  new Sample("Pepe", EVinchuca.Guasayana, null, LocalDate.now()); //falta el location
		
	}
	
	@Test
	public void ExpertAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe", LocalDate.now());
		assertTrue(s1.getState() instanceof Open);
		
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana", LocalDate.now());
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe", LocalDate.now());
		
		assertEquals(2, s1.getReviews().size());
	}
}
