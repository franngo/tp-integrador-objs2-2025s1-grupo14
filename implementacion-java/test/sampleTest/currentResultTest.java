package sampleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
		s1 =  new Sample("Pepe", EVinchuca.Guasayana, pos, LocalDate.now()); //falta el location
		
	}
	
	@Test
	public void basicAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe", LocalDate.now());
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana", LocalDate.now());
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe", LocalDate.now());
		
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.Chinche_Foliada, s1.currentResult());
	}
	
	@Test
	public void ExpertAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe", LocalDate.now());	
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana", LocalDate.now());
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe", LocalDate.now());
		
		
		assertEquals(2, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	@Test
	public void CloseReview() {
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe", LocalDate.now());	
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Ana", LocalDate.now());
		s1.addReview(OpinionValue.ImagenPocoClara, "Expert", "Maria Clara", LocalDate.now());
		
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe", LocalDate.now());
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	
}
