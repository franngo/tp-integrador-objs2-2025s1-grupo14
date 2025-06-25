package regionsYPositions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Enums.EVinchuca;
import position.Kilometers;
import position.Position;
import sample.Sample;

public class SampleTest {
	Position bsAs = new Position(-34.6037, -58.3816, null);
	Position stgoDeChile = new Position(-33.4489, -70.6693, null); //a 1139km de bsAs
	Position montevideo = new Position(-34.7276, -56.2159, null); //a 199km de bsAs
	Position bahiaBlanca = new Position(-38.7155, -62.2615, null); //a 573km de bsAs
	Position stgoDelEstero = new Position(-27.79, -64.2628, null); //a 941km de bsAs

	Sample sBsAs = new Sample("fidelElBravo", EVinchuca.Infestans, bsAs);
	Sample sStgoDeChile = new Sample("marce678", EVinchuca.Infestans, stgoDeChile);
	Sample sMontevideo = new Sample("andrea2001", EVinchuca.Sordida, montevideo);
	Sample sBahiaBlanca = new Sample("edgarErnesto4", EVinchuca.Guasayana, bahiaBlanca);
	Sample sStgoDelEstero = new Sample("lucho234", EVinchuca.Infestans, stgoDelEstero);
	
	@Test
	public void samplesInRangeTest() {
		List <Sample> ss = new ArrayList<Sample>();
		ss.add(sStgoDeChile);
		ss.add(sMontevideo);
		ss.add(sBahiaBlanca);
		ss.add(sStgoDelEstero);
		List <Sample> ssInRange = sBsAs.getSamplesInRangeToMe(ss, 573, new Kilometers());
		assertEquals(2, ssInRange.size());
		assertTrue(ssInRange.contains(sMontevideo));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertFalse(ssInRange.contains(sStgoDelEstero));
		assertFalse(ssInRange.contains(sStgoDeChile));
		ssInRange = sBsAs.getSamplesInRangeToMe(ss, 1000, new Kilometers());
		assertEquals(3, ssInRange.size());
		assertTrue(ssInRange.contains(sMontevideo));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertTrue(ssInRange.contains(sStgoDelEstero));
		assertFalse(ssInRange.contains(sStgoDeChile));
	}
}
