package regionsYPositions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import mainPackage.App;
import position.Kilometers;
import position.Position;
import sample.Sample;
import user.User;

public class SampleTest {
	App system;
	Position bsAs = new Position(-34.6037, -58.3816); //a 256km de arielAzul
	Position bahiaBlanca = new Position(-38.7155, -62.2615); //a 318km de arielAzul
	Position montevideo = new Position(-34.7276, -56.2159); //a 390km de arielAzul
	Position stgoDeChile = new Position(-33.4489, -70.6693); //a 1037km de arielAzul
	Position stgoDelEstero = new Position(-27.79, -64.2628); //a 1054km de arielAzul

	Sample sBsAs = new Sample(new User("Pepe", system), EVinchuca.Infestans, bsAs, system);
	Sample sStgoDeChile = new Sample(new User("Pepe2", system), EVinchuca.Infestans, stgoDeChile, system);
	Sample sMontevideo = new Sample(new User("Pepe3", system), EVinchuca.Sordida, montevideo, system);
	Sample sBahiaBlanca = new Sample(new User("Pepe4", system), EVinchuca.Guasayana, bahiaBlanca, system);
	Sample sStgoDelEstero = new Sample(new User("Pepe5", system), EVinchuca.Infestans, stgoDelEstero, system);
	
	@BeforeEach
	public void setUp() {
		system = new App();
	}
	
	
	@Test
	public void samplesInRangeTest() {
		system.addSample(sStgoDeChile);
		system.addSample(sMontevideo);
		system.addSample(sBahiaBlanca);
		system.addSample(sStgoDelEstero);
		List <Sample> ss = system.getSamplesTotal();
		
		List <Sample> ssInRange = bsAs.getSamplesInRangeToMe(ss, 573, new Kilometers());
		
		assertEquals(2, ssInRange.size());
		assertTrue(ssInRange.contains(sMontevideo));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertFalse(ssInRange.contains(sStgoDelEstero));
		assertFalse(ssInRange.contains(sStgoDeChile));
		
		ssInRange = bsAs.getSamplesInRangeToMe(ss, 1000, new Kilometers());
		assertEquals(3, ssInRange.size());
		assertTrue(ssInRange.contains(sMontevideo));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertTrue(ssInRange.contains(sStgoDelEstero));
		assertFalse(ssInRange.contains(sStgoDeChile));
	}
}
