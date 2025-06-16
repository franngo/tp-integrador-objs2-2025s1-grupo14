package userTest;

import static org.junit.Assert.assertEquals;

import javax.swing.text.Position;

import org.junit.jupiter.api.*;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import sample.Sample;
import user.PermanentExpert;

public class UserPermatenExpertTest {
	App system;
	PermanentExpert user;
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new PermanentExpert("Elias009", system);
	}
	
	
	@Test
	public void puedeUploadSampleTest() {
		user.uploadSample(EVinchuca.Sordida, null); //Poner position
		
		assertEquals(1, system.getSamples().size()); 
	}
	@Test
	public void primerReview() {
		user.uploadSample(EVinchuca.Sordida, null); //Poner position
		Sample sample = system.getSamples().get(0);
		
		assertEquals(OpinionValue.Vinchuca_Sordida, sample.getReviews().get(0).getOpinion());
	}
	
	@Test
	public void noPuedeSubirReviewEnSuMuestra() {
		user.uploadSample(EVinchuca.Sordida, null); //Poner position
		Sample sample = system.getSamples().get(0);
		assertEquals(1, sample.getReviews().size());
		
		user.addReview(sample, OpinionValue.Phtia_Chinche);	
		assertEquals(1, sample.getReviews().size());
	}

}
