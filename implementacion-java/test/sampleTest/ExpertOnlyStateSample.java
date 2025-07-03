package sampleTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.ExpertOnly;
import sample.Open;
import sample.Sample;
import user.PermanentE;
import user.User;

public class ExpertOnlyStateSample {
	
	Sample s1 ;
	App syst;
	User u1;
	User u2;
	User u3;
	
	@BeforeEach
	public void setUp() {
		syst = new App();
		u1 = new User("Pepe", syst);
		u2 = new PermanentE("Pepe2", syst);
		u3 = new User("Pepe3", syst);
		s1 =  new Sample(u1, EVinchuca.Guasayana, new Position(1,1),syst);
		
	}
	
	@Test
	public void ExpertAddReviews() {
		u1.addReview(s1, OpinionValue.Chinche_Foliada);
		assertTrue(s1.getState() instanceof Open);
		
		u2.addReview(s1, OpinionValue.Phtia_Chinche);
		assertTrue(s1.getState() instanceof ExpertOnly);
		
		u3.addReview(s1, OpinionValue.Phtia_Chinche);
		assertEquals(2, s1.getReviews().size());
	}
}
