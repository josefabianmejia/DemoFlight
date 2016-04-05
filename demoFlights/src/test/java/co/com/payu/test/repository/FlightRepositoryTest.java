package co.com.payu.test.repository;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.solr.client.solrj.response.RangeFacet.Numeric;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.IFlightRepository;
import co.com.payu.data.IRouteRepository;
import co.com.payu.data.domain.Airplane;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class FlightRepositoryTest {

	@Autowired
	private IFlightRepository fRepository;
	
	@Autowired
	private IRouteRepository rRepository;
	
	@Test
	@Ignore
	@Transactional
	public void create() {

		long idAirplane = 2;
		long idRoute = 2;
		
		Airplane airplane = new Airplane(idAirplane);
		Route route = rRepository.findOne(idRoute);
		Flight flight = new Flight();
		
		int horsDuration = route.getDuration().getHourOfDay();
		int minsDuration = route.getDuration().getMinuteOfHour();
				
		LocalDate date = new LocalDate(2016,3,25);  
		LocalTime timeOut = new LocalTime(8,30,0);
		LocalTime arrivalTime = timeOut.plusHours(horsDuration).plusMinutes(minsDuration);
		
		flight.setDate(date);
		flight.setTimeOut(timeOut);		
		flight.setArrivalTime(arrivalTime);
		flight.setAirplane(airplane);
		flight.setRoute(route);
		
		assertNull(flight.getId());
		fRepository.save(flight);
		assertNull(flight.getId());
				
	}
	
	@Test	
	@Ignore
	@Transactional
	public void findByAirplaneAndDateAndTimeOutBetween(){
		
		long idAirplane = 2;
		long idRoute = 2;
		
		Airplane airplane = new Airplane(idAirplane);
		Route route = rRepository.findOne(idRoute);
		
		LocalDate date = new LocalDate(2016,3,25);  
		LocalTime timeOut = new LocalTime(20,30,0);
		int horsDuration = route.getDuration().getHourOfDay();
		int minsDuration = route.getDuration().getMinuteOfHour();
		LocalTime arrivalTime = timeOut.plusHours(horsDuration).plusMinutes(minsDuration);
				
		List<Flight> flights = fRepository.findByAirplaneAndDateAndTimeOutBetween(airplane, date,timeOut,arrivalTime);
		assertNotNull(flights);
		assertTrue(!flights.isEmpty());	
		
		for(Flight f: flights){
			System.out.println("vuelo: "+f.getId());
		}
		
	}
	
	@Test	
	@Ignore
	public void findAvailableChairs(){
		long idFlight = 2;		
		int aChairs = 0;
		aChairs = fRepository.findAvailableChairs(idFlight);
		assertTrue(aChairs==1);
		System.out.println(aChairs+ " sillas disponibles en el vuelo: "+idFlight);
	}
	
	@Test
	@Ignore
	public void numberChairReserved(){
		int numberChairsReserved = 0;
		long idFlight = 2;
		Flight flight = new Flight(idFlight);		
		numberChairsReserved = fRepository.numberChairReserved(flight);		
		System.out.println("* "+numberChairsReserved+" sillas reservadas para el vuelo: "+idFlight);
	}
	
	//@Test	
	//@Ignore
//	public void findFlightsByAirplane(){
//		long idAirplane = 2;
//		Airplane airplane = new Airplane(idAirplane);
//		LocalDate f1 = new LocalDate(2016,3,1);
//		LocalDate f2 = new LocalDate(2016,3,30);
//
//		List<Object[]> list = fRepository.findFlightsByAirplane(idAirplane);
//		assertNotNull(list);
//		assertFalse(list.isEmpty());
//		
//	}	

}
