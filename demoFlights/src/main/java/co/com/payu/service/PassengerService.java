package co.com.payu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import co.com.payu.data.IPassengerRepository;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.Passenger;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * service passengers 
 */

@Service
@Transactional
public class PassengerService implements IPassengerService {

	@Autowired
	private IPassengerRepository pRepository;
	
	@Override
	public Passenger createOrUpdatePassenger(Passenger passenger) {
		try{
			return pRepository.save(passenger);
		}catch(Exception exp){ return null;}
	}

	@Override
	public Passenger findPassengerById(Long id) {	
		if(exist(id)){
			return pRepository.findOne(id);
		}
	return null;
	}

	@Override
	public Passenger findPassengerByIdentification(String identification) {		
		Passenger passenger = pRepository.findByIdentification(identification);
		if(passenger == null) 
			throw new HttpMessageNotReadableException("El pasajero "+identification+" no se encuentra registrado");
		return passenger;
	}
	
	@Override
	public List<Passenger> findAllPassengers() {
		try{
			return (List<Passenger>)pRepository.findAll();			
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
			if(exist(passenger.getId())){
				pRepository.delete(passenger);
				return true;
			}
		return false;
	}

	@Override
	public boolean bookFlight(Flight flight, int chairs) {
		try{			
			return true;			
		}catch(Exception exp){ return false;}
	}
	
	private boolean exist(Long id){
		if(!pRepository.exists(id)){ 
			throw new HttpMessageNotReadableException("El pasajero '"+id+"' no se encuentra registrado");
		}
		return true;	
	}
}
