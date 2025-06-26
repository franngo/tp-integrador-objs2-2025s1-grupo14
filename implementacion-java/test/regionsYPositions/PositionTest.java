package regionsYPositions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.EVinchuca;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import position.*;
import sample.*;

public class PositionTest {
	Position bsAs = new Position(-34.6037, -58.3816, null);
	Position stgoDeChile = new Position(-33.4489, -70.6693, null); //a 1139km de bsAs
	Position montevideo = new Position(-34.7276, -56.2159, null); //a 199km de bsAs
	Position bahiaBlanca = new Position(-38.7155, -62.2615, null); //a 573km de bsAs
	Position stgoDelEstero = new Position(-27.79, -64.2628, null); //a 941km de bsAs
	
	@Test
	public void distanceTest() {
		assertEquals(1139, bsAs.getDistanceTo(stgoDeChile, new Kilometers()));
		assertEquals(1139000, bsAs.getDistanceTo(stgoDeChile, new Meters()));
		assertEquals(199, bsAs.getDistanceTo(montevideo, new Kilometers()));
		assertEquals(199000, bsAs.getDistanceTo(montevideo, new Meters()));
		assertEquals(573, bsAs.getDistanceTo(bahiaBlanca, new Kilometers()));
		assertEquals(573000, bsAs.getDistanceTo(bahiaBlanca, new Meters()));
		assertEquals(941, bsAs.getDistanceTo(stgoDelEstero, new Kilometers()));
		assertEquals(941000, bsAs.getDistanceTo(stgoDelEstero, new Meters()));
	}
	
	@Test
	public void positionsInRangeToMeTest() {
		List <Position> ps = new ArrayList<Position>();
		ps.add(stgoDeChile);
		ps.add(montevideo);
		ps.add(bahiaBlanca);
		ps.add(stgoDelEstero);
		List <Position> psInRange = bsAs.positionsInRangeToMe(ps, 573, new Kilometers());
		assertEquals(2, psInRange.size());
		assertTrue(psInRange.contains(montevideo));
		assertTrue(psInRange.contains(bahiaBlanca));
		assertFalse(psInRange.contains(stgoDelEstero));
		assertFalse(psInRange.contains(stgoDeChile));
		psInRange = bsAs.positionsInRangeToMe(ps, 1000, new Kilometers());
		assertEquals(3, psInRange.size());
		assertTrue(psInRange.contains(montevideo));
		assertTrue(psInRange.contains(bahiaBlanca));
		assertTrue(psInRange.contains(stgoDelEstero));
		assertFalse(psInRange.contains(stgoDeChile));
	}
	
	@Test
	public void samplesInRangeTest() {
		List <Sample> ss = new ArrayList<Sample>();
		Sample sStgoDeChile = new Sample("marce678", EVinchuca.Infestans, stgoDeChile, LocalDate.now());
		Sample sMontevideo = new Sample("andrea2001", EVinchuca.Sordida, montevideo, LocalDate.now());
		Sample sBahiaBlanca = new Sample("edgarErnesto4", EVinchuca.Guasayana, bahiaBlanca, LocalDate.now());
		Sample sStgoDelEstero = new Sample("lucho234", EVinchuca.Infestans, stgoDelEstero, LocalDate.now());
		ss.add(sStgoDeChile);
		ss.add(sMontevideo);
		ss.add(sBahiaBlanca);
		ss.add(sStgoDelEstero);
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