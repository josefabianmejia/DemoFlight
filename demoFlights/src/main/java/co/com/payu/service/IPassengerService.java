package co.com.payu.service;

import java.util.List;

import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.Passenger;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * interface service passenger 
 */

public interface IPassengerService {
	
	public Passenger createOrUpdatePassenger(Passenger passenger);
	
	public Passenger findPassengerById(Long id);	
	
	public Passenger findPassengerByIdentification(String identification);
	
	public List<Passenger> findAllPassengers();	
		
	public boolean removePassenger(Passenger passenger);
	
	public boolean bookFlight(Flight flight,int chairs);
}
