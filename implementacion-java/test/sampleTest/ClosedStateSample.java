package sampleTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.Closed;
import sample.ExpertOnly;
import sample.Open;
import sample.Sample;
import user.PermanentE;
import user.User;

public class ClosedStateSample {
	
	Sample s1 ;
	App syst;
	User u1;
	User u1B;
	User u2;
	User u3;
	
	@BeforeEach
	public void setUp() {
		syst = new App();
		u1 = new User("Pepe", syst);
		u1B = new User("Pepe1B", syst);
		u2 = new PermanentE("Pepe2", syst);
		u3 = new PermanentE("Pepe3", syst);
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1),syst);
		
	}
	

	
	@Test
	public void ClosedReview() {
		u1.addReview(s1, OpinionValue.Chinche_Foliada);
		assertTrue(s1.getState() instanceof Open);
		
		u2.addReview(s1, OpinionValue.Phtia_Chinche);
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		
		u3.addReview(s1, OpinionValue.Phtia_Chinche);
		assertTrue(s1.getState() instanceof Closed);
	
		u1B.addReview(s1, OpinionValue.Chinche_Foliada);
		assertEquals(3, s1.getReviews().size());
	}
	
	@Test

	public void NoCambiaDeEstadoPorqueLosExpertosNoOpinanLoMismoTest() {

		u1.addReview(s1, OpinionValue.Chinche_Foliada);
		assertTrue(s1.getState() instanceof Open);
		
		u2.addReview(s1, OpinionValue.Phtia_Chinche);
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		u3.addReview(s1, OpinionValue.ImagenPocoClara);
		assertTrue(s1.getState() instanceof ExpertOnly);
			
		u1B.addReview(s1, OpinionValue.Chinche_Foliada);
		
		
		assertFalse(s1.getState() instanceof Closed);
		assertEquals(3, s1.getReviews().size());


	}
}
