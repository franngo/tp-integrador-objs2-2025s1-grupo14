package tpIntegradorGrupo14;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Enums.*;
import mainPackage.*;
import sample.*;

public class currentResultTest {
	
	
	Sample s1 ;

	
	@BeforeEach
	public void setUp() {
		s1 =  new Sample("Pepe", EVinchuca.Guasayana); //falta el location
		
		//mock

		
	}
	
	@Test
	public void basicAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		
		assertTrue(s1.getState() instanceof Open);
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.Chinche_Foliada, s1.currentResult());
	}
	
	@Test
	public void ExpertAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
		assertTrue(s1.getState() instanceof Open);
		
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana");
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		assertEquals(2, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
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
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	
}
