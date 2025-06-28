package userTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;
import mainPackage.App;
import position.Position;
import sample.Sample;
import user.*;

public class ExpertUserTest {
	App system;
	User user;
	Sample s1;
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new User("Elias009", system);
		s1 =  new Sample(user, EVinchuca.Guasayana, new Position(1,1), system);
		
		//Pone el estado en Expert
		for(int x = 0; x < 30; x++) {
			user.uploadSample(EVinchuca.Sordida, new Position(1,1));
			user.addReviewTest(s1, OpinionValue.Chinche_Foliada);
		}
	}

	
	@Test
	public void CambiarDeEstadoABacisPorReviews() {
		assertEquals(EUserState.Expert, user.getExpertise());
		
		s1 =  new Sample(user, EVinchuca.Guasayana, new Position(1,1), system);
		system.getSamplesNoRegion().clear();
		
		for(int x = 0; x < 5; x++) {
			user.addReviewTest(s1, OpinionValue.Chinche_Foliada);
		}
		
		assertEquals(EUserState.Basic, user.getExpertise());
	}
	
	@Test
	public void CambiarDeEstadoABacisPorSample() {
		assertEquals(EUserState.Expert, user.getExpertise());

		system.getSamplesNoRegion().clear();
		
		for(int x = 0; x < 5; x++) {
			user.uploadSample(EVinchuca.Sordida, new Position(1,1));
		}
		
		assertEquals(EUserState.Basic, user.getExpertise());
	}
	

}
