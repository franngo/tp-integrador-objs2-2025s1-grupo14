package tpIntegradorGrupo14;

import java.util.Arrays;
import sample.*;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import Enums.OpinionValue;
import mainPackage.Review;
import sample.Sample;

public class Main {
	
	@Test
	public static void main(String[] args) {
		Sample s1 = new Sample("Pepe", EVinchuca.Guasayana);

		
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Pepe");
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Elias");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Exerpt2");
		s1.addReview(OpinionValue.Chinche_Foliada, "Expert", "Expert3");
		s1.addReview(OpinionValue.ImagenPocoClara, "Basic", "Ana");
		s1.addReview(OpinionValue.Chinche_Foliada, "Basic", "Mario");
		
		
		System.out.println(s1.currentResult());;
	}

}
