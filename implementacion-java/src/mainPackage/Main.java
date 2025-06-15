package mainPackage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;
import sample.Open;
import sample.Sample;
import user.ChangeableUser;
import userTest.*;
public class Main {

	public static void main(String[] args) {
		
		App system;
		ChangeableUser user;
		system = new App();
		user = new ChangeableUser("Elias009", system);


			user.setCantidadReviewsDated(21, LocalDate.now());
			for(int x = 0; x < 11; x++) {
				user.uploadSample(EVinchuca.Sordida, null);
			}
			
			
			
			System.out.println(user.getState().cantidadDeFechasEntreDias(user.getUploadedReviewsDates(), 30));
			System.out.println(user.getUploadedReviewsDates().size());
			System.out.println(user.getUploadedSamplesDates().size());
			user.statCheck();
			System.out.println(user.getExpertise());

		
		
		
		
		
//			Sample s1 =  new Sample("Pepe", EVinchuca.Guasayana, null); //falta el location
			
		
		
		//	System.out.println(s1.puedeOpinar("Pepe"));
//
//			s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Pepe");
//			s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
//			s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Felipe");
//			
//			assertTrue(s1.getState() instanceof Open);
//			assertEquals(3, s1.getReviews().size());
//		
		
	}
}
