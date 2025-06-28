package sampleTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.Open;
import sample.Sample;
import user.User;

public class OpenStateSample {
	
	Sample s1 ;
	App syst;
	User u1;
	@BeforeEach
	public void setUp() {
		syst = new App();
		u1 = new User("Pepe", syst);
		
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1),syst); //falta el location
		
	}
	
	@Test
	public void basicAddReviews() {
		s1.addReview(OpinionValue.Chinche_Foliada, u1);
		s1.addReview(OpinionValue.ImagenPocoClara, new User("Pepe2", syst));
		s1.addReview(OpinionValue.Chinche_Foliada, new User("Pepe3", syst));
		
		
		assertTrue(s1.getState() instanceof Open);
		assertEquals(3, s1.getReviews().size());
	}
	
	@Test
	public void getDateReview() {
		s1.addReview(OpinionValue.Vinchuca_Guasayana, u1, LocalDate.of(1990, 05, 19));
		assertEquals( LocalDate.of(1990, 05, 19), s1.getReviews().getFirst().getFechaReview());
	}
}
