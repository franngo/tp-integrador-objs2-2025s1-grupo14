package userTest;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.*;

import Enums.EUserState;
import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.Sample;
import user.*;

public class UserPermatenExpertTest {
	App system;
	User user;
	Sample s1;
	@BeforeEach
	public void setUp() {
		system = new App();
		s1 =  new Sample(user, EVinchuca.Guasayana, new Position(1,1), system);
		user = new PermanentE("Elias009", system);
	}
	
	
	@Test
	public void NoPuedeCambiarDeEstado() {
		for(int x = 0; x < 5; x++) {
			user.uploadSample(EVinchuca.Sordida, new Position(1,1));
			user.addReviewTest(s1, OpinionValue.Chinche_Foliada);
		}
		
		assertEquals(EUserState.Expert, user.getExpertise()); 
	}


}
