package co.com.payu.service;

import java.util.List;

import co.com.payu.data.domain.FlightReservation;

public interface IReservationService {
	
	public FlightReservation createReservation(FlightReservation reservation);
	
	public List<FlightReservation> findAll();

}
