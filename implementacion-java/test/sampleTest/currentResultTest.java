package sampleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Enums.*;
import mainPackage.*;
import position.Position;
import sample.*;
import user.PermanentE;
import user.User;

public class currentResultTest {
	
	
	Sample s1 ;
	App syst;
	User u1;
	User u2;
	User u3;
	
	@BeforeEach
	public void setUp() {
		syst = new App();
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1),syst); //falta el location
		
	}
	
	@Test
	public void basicAddReviews() {
		u1 = new User("Pepe", syst);
		u2 = new User("Pepe2", syst);
		u3 = new User("Pepe3", syst);
		
		assertEquals(EVinchuca.Guasayana, s1.getSpecie());
		assertEquals("photo.png", s1.getPhoto());
		
		s1.addReview(OpinionValue.Chinche_Foliada, u1);
		s1.addReview(OpinionValue.ImagenPocoClara, new User("Pepe2", syst));
		s1.addReview(OpinionValue.Chinche_Foliada, new User("Pepe3", syst));
		
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.Chinche_Foliada, s1.currentResult());
	}
	
	@Test
	public void ExpertAddReviews() {
		u1 = new User("Pepe", syst);
		u2 = new PermanentE("Pepe2", syst);
		u3 = new User("Pepe3", syst);
		
		s1.addReview(OpinionValue.Chinche_Foliada, u1);	
		s1.addReview(OpinionValue.ImagenPocoClara, u2);
		s1.addReview(OpinionValue.Phtia_Chinche, u3);
		
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	
	@Test
	public void CloseReview() {
		u1 = new User("Pepe", syst);
		u2 = new PermanentE("Pepe2", syst);
		u3 = new PermanentE("Pepe3", syst);
		
		s1.addReview(OpinionValue.Chinche_Foliada, u1);	
		s1.addReview(OpinionValue.ImagenPocoClara, u2);
		s1.addReview(OpinionValue.ImagenPocoClara, u3);
		
		assertEquals(3, s1.getReviews().size());
		assertEquals(OpinionValue.ImagenPocoClara, s1.currentResult());
	}
	@Test
	public void EmpateReviewBascis() {
		u1 = new User("Pepe", syst);
		u2 = new User("Pepe2", syst);
		u3 = new User("Pepe3", syst);
		User u4 = new User("pepe4", syst);
		
		s1.addReview(OpinionValue.Chinche_Foliada, u1);	
		s1.addReview(OpinionValue.ImagenPocoClara, u2);
		s1.addReview(OpinionValue.ImagenPocoClara, u3);
		s1.addReview(OpinionValue.Chinche_Foliada, u4);
		
		assertEquals(4, s1.getReviews().size());
		assertEquals(OpinionValue.Ninguna, s1.currentResult());
	}
	
	
	@Test
	public void EmpateReviewExperts() {
		u1 = new PermanentE("Pepe", syst);
		u2 = new PermanentE("Pepe2", syst);
		u3 = new PermanentE("Pepe3", syst);
		User u4 = new PermanentE("pepe4", syst);
		
		s1.addReview(OpinionValue.Chinche_Foliada, u1);	
		s1.addReview(OpinionValue.ImagenPocoClara, u2);
		s1.addReview(OpinionValue.ImagenPocoClara, u3);
		s1.addReview(OpinionValue.Chinche_Foliada, u4);
		
		assertEquals(4, s1.getReviews().size());
		assertEquals(OpinionValue.Ninguna, s1.currentResult());
	}
	
	
}
