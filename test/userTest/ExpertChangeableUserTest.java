package userTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import mainPackage.App;
import user.*;

public class ExpertChangeableUserTest {
	App system;
	ChangeableUser user;
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new ChangeableUser("Elias009", system);
		
		user.setState(new Expert());
	}

	
	@Test
	public void CambiarDeEstadoABacisPorReviews() {
		assertEquals("Expert", user.getExpertise());
		
		
		user.setCantidadReviewsDated(15, LocalDate.of(1995,06,19));
		for(int x = 0; x < 11; x++) {
			user.uploadSample(EVinchuca.Sordida, null);
		}
		
		user.statCheck();
		assertEquals("Basic", user.getExpertise());
	}
	
	@Test
	public void CambiarDeEstadoABacisPorSample() {
		assertEquals("Expert", user.getExpertise());
		
		
		user.setCantidadReviewsDated(32, LocalDate.now());
		for(int x = 0; x < 5; x++) {
			user.uploadSample(EVinchuca.Sordida, null);
		}
		
		user.statCheck();
		assertEquals("Basic", user.getExpertise());
	}

}
