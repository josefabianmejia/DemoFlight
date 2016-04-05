package co.com.payu.test.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.FlightReservation;
import co.com.payu.data.domain.Passenger;
import co.com.payu.service.IReservationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class ReservationServiceTest {

	@Autowired
	private IReservationService rService;
	
	@Test
	@Ignore
	@Transactional
	public void create() {
		
		long idPassenger = 2;
		long idFlight = 2;
		int numberChairs = 4;
		LocalDate date = new LocalDate().now();
		
		Passenger passenger = new Passenger(idPassenger);
		Flight flight = new Flight(idFlight);		
		
		FlightReservation reservation = new FlightReservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setNumberChairs(numberChairs);
		reservation.setDate(date);		
		
		assertNull(reservation.getId());
		rService.createReservation(reservation);
		assertNotNull(reservation.getId());
		
	}
	
	
	@Test(expected = HttpMessageNotReadableException.class)
	@Ignore
	public void createIncorrectNumChairs() {
		
		long idPassenger = 1;
		long idFlight = 1;
		int numberChairs = -5;
		LocalDate date = new LocalDate().now();
		
		Passenger passenger = new Passenger(idPassenger);
		Flight flight = new Flight(idFlight);		
		
		FlightReservation reservation = new FlightReservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setNumberChairs(numberChairs);
		reservation.setDate(date);		
		
		assertNull(reservation.getId());
		rService.createReservation(reservation);
		assertNull(reservation.getId());		
	}
	
	@Test
	@Ignore
	@Transactional
	public void createNewPassenger() {
		
		long idFlight = 1;
		int numberChairs = 2;
		//LocalDate date = new LocalDate().now();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName("lorena");
		passenger.setLastName("aguilar");
		passenger.setIdentification("345");
		
		Flight flight = new Flight(idFlight);		
		
		FlightReservation reservation = new FlightReservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setNumberChairs(numberChairs);
		//reservation.setDate(date);		
		
		assertNull(reservation.getId());
		rService.createReservation(reservation);
		assertNotNull(reservation.getId());		
	}

}
