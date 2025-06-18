package regionsYPositions;
import Enums.EVinchuca;
import mainPackage.Region;
import position.*;
import sample.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RegionTest {
	Position arielAzul = new Position(-36.5327, -59.9211);
	
	Position bsAs = new Position(-34.6037, -58.3816); //a 256km de arielAzul
	Position bahiaBlanca = new Position(-38.7155, -62.2615); //a 318km de arielAzul
	Position montevideo = new Position(-34.7276, -56.2159); //a 390km de arielAzul
	Position stgoDeChile = new Position(-33.4489, -70.6693); //a 1037km de arielAzul
	Position stgoDelEstero = new Position(-27.79, -64.2628); //a 1054km de arielAzul

	Sample sBsAs = new Sample("fidelElBravo", EVinchuca.Infestans, bsAs);
	Sample sStgoDeChile = new Sample("marce678", EVinchuca.Infestans, stgoDeChile);
	Sample sMontevideo = new Sample("andrea2001", EVinchuca.Sordida, montevideo);
	Sample sBahiaBlanca = new Sample("edgarErnesto4", EVinchuca.Guasayana, bahiaBlanca);
	Sample sStgoDelEstero = new Sample("lucho234", EVinchuca.Infestans, stgoDelEstero);
	
	Region pba = new Region(arielAzul, 350, "Provincia de Buenos Aires");
	
	@Test
	public void getSamplesInRegionTest() {
		List <Sample> ss = new ArrayList<Sample>();
		ss.add(sBsAs);
		ss.add(sBahiaBlanca);
		ss.add(sMontevideo);
		ss.add(sStgoDeChile);
		ss.add(sStgoDelEstero);
		List<Sample> ssInRange = pba.getSamplesInRegion(ss);
		assertEquals(2, ssInRange.size());
		assertTrue(ssInRange.contains(sBsAs));
		assertTrue(ssInRange.contains(sBahiaBlanca));
		assertFalse(ssInRange.contains(sMontevideo));
		assertFalse(ssInRange.contains(sStgoDeChile));
		assertFalse(ssInRange.contains(sStgoDelEstero));
	}
	
}
