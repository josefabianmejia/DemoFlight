package com.payU.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payU.data.IPassengerRepository;
import com.payU.data.domain.Flight;
import com.payU.data.domain.Passenger;

@Service
@Transactional
public class PassengerService implements IPassengerService {

	@Autowired
	private IPassengerRepository pRepository;
	
	@Override
	public boolean createOrUpdatePassenger(Passenger passenger) {
		try{
			pRepository.save(passenger);
			return true;
		}catch(Exception exp){ return false;}
	}

	@Override
	public Passenger findPassengerById(Passenger passenger) {
		try{
			return pRepository.findOne(passenger.getId());
		}catch(Exception exp){ return null;}
	}

	@Override
	public Passenger findPassengerByIdentification(Passenger passenger) {
		try{
			return pRepository.findByIdentification(passenger);
		}catch(Exception exp){ return null;}
	}
	
	@Override
	public List<Passenger> findAllPassengers() {
		try{
			return (List<Passenger>)pRepository.findAll();			
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		try{
			pRepository.delete(passenger);
			return true;
		}catch(Exception exp){ return false;}
	}

	@Override
	public boolean bookFlight(Flight flight, int chairs) {
		try{
			
			
			return true;
			
		}catch(Exception exp){ return false;}
	}

}
