package co.com.payu.service;

import java.util.List;

import org.joda.time.LocalDate;

import co.com.payu.data.domain.Airport;
import co.com.payu.data.domain.Flight;

public interface IFlightService {
	
	public Flight createFlight(Flight flight);	
	
	public Flight findById(Long id);
	
	public List<Flight> findAll();
	
	public List<Flight> findByDate(LocalDate date);	
	
	public List<Airport> findAllAirports();
	
	public Integer findAvailableChairs(Long idFlight);
	
	
}
