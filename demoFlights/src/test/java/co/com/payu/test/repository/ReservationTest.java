package co.com.payu.test.repository;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.IReservationRepository;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.FlightReservation;
import co.com.payu.data.domain.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class ReservationTest {

	@Autowired
	private IReservationRepository rRepository;
	
	@Test
	@Ignore
	public void create() {

		long idPassenger = 1;
		long idFlight = 2;
		int chairs = 3;
		
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
