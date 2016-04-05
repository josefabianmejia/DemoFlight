package com.payU.test.repository;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.payU.DemoFlightsApplication;
import com.payU.data.IFlightRepository;
import com.payU.data.domain.Airplane;
import com.payU.data.domain.Flight;
import com.payU.data.domain.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class FlightRepositoryTest {

	@Autowired
	private IFlightRepository iRepository;
	
	@Test
	@Transactional
	public void create() {

		long idAirplane = 4;
		long idRoute = 3;
		LocalDate date = new LocalDate(2016,3,23);  
		LocalTime timeOut = new LocalTime(13,00,0);
		LocalTime arrivalTime = new LocalTime(15, 30, 00);
			
		
		Airplane airplane = new Airplane(idAirplane);
		Route route = new Route(idRoute);
		Flight flight = new Flight();
		flight.setDate(date);
		flight.setTimeOut(timeOut);
		flight.setArrivalTime(arrivalTime);
		flight.setAirplane(airplane);
		flight.setRoute(route);
		
		assertNull(flight.getId());
		iRepository.save(flight);
		
	}

}
