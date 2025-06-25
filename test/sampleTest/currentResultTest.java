package sampleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Enums.*;
import mainPackage.*;
import position.Position;
import sample.*;

public class currentResultTest {
	
	Sample s1 ;
	Position pos = new Position(1,1, null); // la app no es importante aca
	
	@BeforeEach
	public void setUp() {
		s1 =  new Sample("Pepe", EVinchuca.Guasayana, pos); //falta el location
		
	}
	
	@Test
	public void basicAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.Chinche_Foliada, s1.currentResult());
	}
	
	@Test
	public void ExpertAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");	
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana");
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		
		assertEquals(2, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	@Test
	public void CloseReview() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");	
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana");
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Maria Clara");
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	
}
