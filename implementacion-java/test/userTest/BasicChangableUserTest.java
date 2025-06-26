package userTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.Sample;
import user.ChangeableUser;
import user.*;
import user.PermanentExpert;

public class BasicChangableUserTest {
	App system;
	ChangeableUser user;
	Position pos = new Position(1,1, system);
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new ChangeableUser("Elias009", system);
	}
	
	@Test
	public void BasicStateInicial() {
		user.statCheck();
		assertEquals("Basic", user.getExpertise());
	}
	
	@Test
	public void CambiarDeEstado() {
		assertEquals("Basic", user.getExpertise());
		user.setCantidadReviewsDated(21, LocalDate.now());
		for(int x = 0; x < 11; x++) {
			user.uploadSample(EVinchuca.Sordida, pos);
		}
		
		user.statCheck();
		assertEquals("Expert", user.getExpertise());
	}

}
