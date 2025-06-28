package userTest;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EUserState;
import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import position.Position;
import sample.Sample;
import user.*;

public class UserGeneralTest {
	App system;
	User user;
	Sample s1;
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new User("Elias009", system);
		s1 =  new Sample(user, EVinchuca.Guasayana, new Position(1,1), system);
	}
	
	@Test
	public void BasicStateInicial() {
		assertEquals(EUserState.Basic, user.getExpertise());
		assertEquals("Elias009", user.getName());
		assertEquals(system, user.getApp());
	}
	
	
	@Test
	public void puedeUploadSampleTest() {
		user.uploadSample(EVinchuca.Sordida, new Position(1,1));	
		assertEquals(1, system.getSamplesTotal().size()); 
		
	}
	@Test
	public void primerReview() {
		user.uploadSample(EVinchuca.Sordida, new Position(1,1));	
		assertEquals(OpinionValue.Vinchuca_Sordida, system.getSamplesTotal().getFirst().getReviews().getFirst().getOpinion());
	}
	
	@Test
	public void noPuedeSubirReviewEnSuMuestra() {
		user.uploadSample(EVinchuca.Sordida, new Position(1,1));
		assertEquals(OpinionValue.Vinchuca_Sordida, system.getSamplesTotal().getFirst().getReviews().getFirst().getOpinion());
		assertEquals(1, system.getSamplesTotal().getFirst().getReviews().size());
		
		
		user.addReview(s1, OpinionValue.Phtia_Chinche);	
		assertEquals(1, system.getSamplesTotal().getFirst().getReviews().size());
	}
	
	@Test
	public void noPuedeHacerReviewEnSampleQueYaHizo() {
		Sample sampleReview = new Sample(new User("Pepetest", system), EVinchuca.Guasayana, new Position(1,1), system);
		
		user.addReview(sampleReview, OpinionValue.Chinche_Foliada);
		assertEquals(user, sampleReview.getReviews().get(0).getUser());
		assertEquals(1, sampleReview.getReviews().size());
		
		user.addReview(sampleReview, OpinionValue.ImagenPocoClara);
		assertEquals(1, sampleReview.getReviews().size());
	}

}
