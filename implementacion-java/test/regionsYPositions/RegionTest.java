package regionsYPositions;
import Enums.EVinchuca;
import mainPackage.Region;
import position.*;
import sample.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegionTest {
	Position arielAzul = new Position(-36.5327, -59.9211, null);
	
	Position bsAs = new Position(-34.6037, -58.3816, null); //a 256km de arielAzul
	Position bahiaBlanca = new Position(-38.7155, -62.2615, null); //a 318km de arielAzul
	Position montevideo = new Position(-34.7276, -56.2159, null); //a 390km de arielAzul
	Position stgoDeChile = new Position(-33.4489, -70.6693, null); //a 1037km de arielAzul
	Position stgoDelEstero = new Position(-27.79, -64.2628, null); //a 1054km de arielAzul
	
	Region pba = new Region(arielAzul, 350, "Provincia de Buenos Aires", null);
	
	@Test
	public void getSamplesInRegionTest() {
		Sample sBsAs = new Sample("fidelElBravo", EVinchuca.Infestans, bsAs, LocalDate.now());
		Sample sStgoDeChile = new Sample("marce678", EVinchuca.Infestans, stgoDeChile, LocalDate.now());
		Sample sMontevideo = new Sample("andrea2001", EVinchuca.Sordida, montevideo, LocalDate.now());
		Sample sBahiaBlanca = new Sample("edgarErnesto4", EVinchuca.Guasayana, bahiaBlanca, LocalDate.now());
		Sample sStgoDelEstero = new Sample("lucho234", EVinchuca.Infestans, stgoDelEstero, LocalDate.now());
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
	
	@Test
	public void checkOverlapsTest() {
		//Region que nace dentro de pba, por lo que se da solapamiento.
		Region partidoBahiaBlanca = new Region(bahiaBlanca, 10, "Partido de Bahía Blanca", null);
		//Region que no nace dentro de pba, pero, por su radio, se solapa con esta.
		Position rioDeLaPlata = new Position(-34.7849, -57.2300, null); //entre medio de CABA y Montevideo
		Region rRioDeLaPlata = new Region(rioDeLaPlata, 123, "Río de La Plata", null);
		//Region que no nace dentro de pba y con un radio tal que no se solapa con esta.
		Region regionMetropolitanaChile = new Region(stgoDeChile, 121, "Región Metropolitana (Chile)", null);
		List<Region> rs = new ArrayList<Region>();
		rs.add(partidoBahiaBlanca);
		rs.add(rRioDeLaPlata);
		rs.add(regionMetropolitanaChile);
		List<Region> overlaps = pba.checkOverlaps(rs);
		assertEquals(2, overlaps.size());
		assertTrue(overlaps.contains(partidoBahiaBlanca));
		assertTrue(overlaps.contains(rRioDeLaPlata));
		assertFalse(overlaps.contains(regionMetropolitanaChile));
	}
	
}
