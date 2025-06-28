package userTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;
import mainPackage.App;
import position.Position;
import sample.Sample;
import user.*;

public class BasicUserTest {
	App system;
	User user;
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new User("Elias009", system);
	}
	
	@Test
	public void BasicStateInicial() {
		assertEquals(EUserState.Basic, user.getExpertise());
	}
	
	@Test
	public void CambiarDeEstado() {
		assertEquals(EUserState.Basic, user.getExpertise());
		Sample s1 = new Sample(user, EVinchuca.Guasayana, new Position(1,1), system);
		
		for(int x = 0; x < 30; x++) {
			user.addReviewTest(s1, OpinionValue.Chinche_Foliada);
			user.uploadSample(EVinchuca.Sordida, new Position(1,1));
		}
		
		assertEquals(EUserState.Expert, user.getExpertise());
	}
	

}
