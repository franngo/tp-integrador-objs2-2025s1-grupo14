package userTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.App;
import sample.Sample;
import user.*;

public class ChangeableUserGeneralTest {
	App system;
	ChangeableUser user;
	
	@BeforeEach
	public void setUp() {
		system = new App();
		user = new ChangeableUser("Elias009", system);
	}
	
	@Test
	public void BasicStateInicial() {
		assertEquals("Basic", user.getExpertise());
		assertTrue(user.getState() instanceof  Basic);
	}
	
	@Test
	public void guardaFechaDeUploadSample() {
		user.uploadSample(EVinchuca.Sordida, null); //Poner position
		assertEquals(user.getUploadedSamplesDates().get(0), LocalDate.now());
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
		
		user.review(sample, OpinionValue.Phtia_Chinche);	
		assertEquals(1, sample.getReviews().size());
	}
	
	@Test
	public void noPuedeHacerReviewEnSampleQueYaHizo() {
		Sample sampleReview = new Sample("Pepe", EVinchuca.Guasayana, null);
		
		user.review(sampleReview, OpinionValue.Chinche_Foliada);
		assertEquals("Elias009", sampleReview.getReviews().get(0).getUserName());
		
		user.review(sampleReview, OpinionValue.ImagenPocoClara);
		//assertEquals("Elias009", sampleReview.getReviews().get(1).getUserName()); fuera de largo
		assertEquals(1, sampleReview.getReviews().size());
	}

}
