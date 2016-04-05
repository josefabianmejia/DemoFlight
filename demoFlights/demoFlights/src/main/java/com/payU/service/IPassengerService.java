package com.payU.service;

import java.util.List;
import java.util.Set;

import com.payU.data.domain.Flight;
import com.payU.data.domain.Passenger;

public interface IPassengerService {
	
	public boolean createOrUpdatePassenger(Passenger passenger);
	
	public Passenger findPassengerById(Passenger passenger);	
	
	public Passenger findPassengerByIdentification(Passenger passenger);
	
	public List<Passenger> findAllPassengers();	
		
	public boolean removePassenger(Passenger passenger);
	
	public boolean bookFlight(Flight flight,int chairs);
}
