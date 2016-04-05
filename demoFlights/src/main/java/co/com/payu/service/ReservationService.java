package co.com.payu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import co.com.payu.data.IReservationRepository;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.FlightReservation;

@Service
@Transactional
public class ReservationService implements IReservationService {

	@Autowired
	private IReservationRepository rRepository;
	
	@Autowired
	private IFlightService fService;
	
	
	@Override
	public FlightReservation createReservation(FlightReservation reservation) {
		int numChairs = reservation.getNumberChairs(); 
		if(numChairs>0){			
			if(availableChairs(reservation.getFlight(), numChairs))
				return rRepository.save(reservation);
			else
				throw new HttpMessageNotReadableException("No hay '"+numChairs+"' sillas disponibles");	
		}else throw new HttpMessageNotReadableException(numChairs +" es un número de sillas incorrecto");			
	}
	
	private boolean availableChairs(Flight flight, int numChairs){	
		Integer availableChairs = fService.findAvailableChairs(flight.getId());		
			if(availableChairs != null)				
				return (availableChairs-numChairs)>=0;	
		return true;
	}

	@Override
	public List<FlightReservation> findAll() {
		return (List<FlightReservation>) rRepository.findAll();
	}
	
	

}
