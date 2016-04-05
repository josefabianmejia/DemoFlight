package co.com.payu.test.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.domain.Airplane;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.Route;
import co.com.payu.service.IAirplaneService;
import co.com.payu.service.IFlightService;
import co.com.payu.service.IRouteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class FlightServiceTest {

	@Autowired
	private IFlightService fService;
	
	@Test//(expected = HttpMessageNotReadableException.class)
	@Ignore
	@Transactional
	public void create() {
		long idAirplane = 2;
		long idRoute = 2;
		
		Airplane airplane = new Airplane(idAirplane);
		Route route =  new Route(idRoute);		
		
		LocalDate date = new LocalDate(2016,3,22);
		LocalTime timeOut = new LocalTime(8,20,0);
		
		Flight flight = new Flight();
		flight.setAirplane(airplane);
		flight.setRoute(route);
		flight.setDate(date);
		flight.setTimeOut(timeOut);
		
		System.out.println("f:"+date.toString()+" to:"+timeOut.toString());
				
		assertNull(flight.getId());
		fService.createFlight(flight);
		assertNull(flight.getId());	
		
	}

}
