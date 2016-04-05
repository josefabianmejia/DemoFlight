package com.payU.test.repository;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.payU.DemoFlightsApplication;
import com.payU.data.IReservationRepository;
import com.payU.data.domain.Flight;
import com.payU.data.domain.FlightReservation;
import com.payU.data.domain.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class ReservationTest {

	@Autowired
	private IReservationRepository rRepository;
	
	@Test
	public void create() {

		long idPassenger = 3;
		long idFlight = 7;
		int chairs = 2;
		
		Passenger passenger = new Passenger(idPassenger);
		Flight flight = new Flight(idFlight);
		FlightReservation reservation =  new FlightReservation();
		
		reservation.setDate(new LocalDate().now());
		reservation.setNumberChairs(chairs);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		
		assertNull(reservation.getId());
		rRepository.save(reservation);
		assertNotNull(reservation.getId());
		
	}

}
