package searchEngineTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Enums.*;
import mainPackage.*;
import position.Position;
import sample.*;
import searchEngine.*;
import user.ChangeableUser;
import user.PermanentExpert;



public class searchEngineTest {
	
	App system = new App();
	ChangeableUser mariano = new ChangeableUser("mariano789", system);
	PermanentExpert sergio = new PermanentExpert("sergioCASLA", system);
	PermanentExpert andrea = new PermanentExpert("andreaCAI", system);
	Position pos = new Position(1,1, system);
	
	@BeforeEach
	public void setUp() {
		//creacion: 2015-5-15 - última votación: 2020-5-15 - tipo detectado: Vinchuca_Sordida - nivel v : votada
		mariano.uploadSample(EVinchuca.Sordida, pos);
		Sample votada = system.getSamples().get(0);
		votada.setFechaCreacion(LocalDate.of(2015, 5, 15));
		votada.ultimaReview().setFechaReview(LocalDate.of(2020, 5, 15));
		
		//creacion: 2018-5-15 - última votación: 2019-5-15 - tipo detectado: Vinchuca_Guasayana - nivel v : verificada
		mariano.uploadSample(EVinchuca.Infestans, pos);
		Sample verificada = system.getSamples().get(1); 
		sergio.addReview(verificada, OpinionValue.Vinchuca_Guasayana);
		andrea.addReview(verificada, OpinionValue.Vinchuca_Guasayana); //queda verificada
		verificada.setFechaCreacion(LocalDate.of(2018, 5, 15));
		verificada.ultimaReview().setFechaReview(LocalDate.of(2019, 5, 15));
		
		//creacion: 2013-5-15 - última votación: 2013-5-15 - tipo detectado: Vinchuca_Sordida - nivel v : votada
		mariano.uploadSample(EVinchuca.Sordida, pos);
		Sample votada2 = system.getSamples().get(2);
		votada2.setFechaCreacion(LocalDate.of(2013, 5, 15));
		votada2.ultimaReview().setFechaReview(LocalDate.of(2013, 5, 15));
		
		//creacion: 2010-5-15 - última votación: 2023-5-15 - tipo detectado: Vinchuca_Infestans - nivel v : votada
		mariano.uploadSample(EVinchuca.Infestans, pos);
		Sample votada3 = system.getSamples().get(3);
		votada3.setFechaCreacion(LocalDate.of(2010, 5, 15));
		votada3.ultimaReview().setFechaReview(LocalDate.of(2023, 5, 15));
		
		//creacion: 2014-5-15 - última votación: 2016-5-15 - tipo detectado: Chinche_Foliada - nivel v : verificada
		mariano.uploadSample(EVinchuca.Infestans, pos);
		Sample verificada2 = system.getSamples().get(4); 
		sergio.addReview(verificada2, OpinionValue.Chinche_Foliada);
		andrea.addReview(verificada2, OpinionValue.Chinche_Foliada); //queda verificada
		verificada2.setFechaCreacion(LocalDate.of(2014, 5, 15));
		verificada2.ultimaReview().setFechaReview(LocalDate.of(2016, 5, 15));
	}
	
	@Test
	public void buscar() {
		SearchEngine serEng = new SearchEngine();
		List<LogicalOperator> logOps = new ArrayList<LogicalOperator>();
		logOps.add(LogicalOperator.Or);
		logOps.add(LogicalOperator.Or);
		logOps.add(LogicalOperator.Or);
		List<Sample> results = serEng.buscar(system.getSamples(), LocalDate.of(2017, 1, 1) , LocalDate.of(2020, 1, 1), 
				OpinionValue.Vinchuca_Sordida, "votada", logOps);
		//cumplen: verificada - votada - votada 3 - votada 2
		assertEquals(4, results.size());
	}
	
	/*
 * public List<Sample> buscar(List<Sample> samples, LocalDate fechaCreacion, LocalDate fechaUltVot, OpinionValue tipoDetectado,
		String nivelDeVerificacion, List<LogicalOperator> operators) {
	 */
	
}
