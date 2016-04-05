package co.com.payu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.Period;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import co.com.payu.data.IAirportRepository;
import co.com.payu.data.IFlightRepository;
import co.com.payu.data.domain.Airplane;
import co.com.payu.data.domain.Airport;
import co.com.payu.data.domain.Flight;
import co.com.payu.data.domain.Route;

@Service
@Transactional
public class FlightService implements IFlightService {
	
	@Autowired
	private IFlightRepository fRepository;
	
	@Autowired
	private IAirportRepository aRepository;
	
	@Autowired
	private IRouteService rService;
		

	public FlightService() { }
	
	@Override
	public Flight createFlight(Flight flight) {
			
			Route route =  rService.findRouteById(flight.getRoute().getId());		
			int horsDuration = route.getDuration().getHourOfDay();
			int minsDuration = route.getDuration().getMinuteOfHour();
					
			LocalTime arrivalTime = flight.getTimeOut().plusHours(horsDuration).plusMinutes(minsDuration);
			flight.setArrivalTime(arrivalTime);
			
			if(isAvailableAirplane(flight.getAirplane(),flight.getDate(),flight.getTimeOut(),arrivalTime))
				return fRepository.save(flight); 					
			else
				throw new HttpMessageNotReadableException("El avión no se encuentra disponible el '"+
						flight.getDate()+"' a las '"+flight.getTimeOut()+"' horas");
	}
	
	@Override
	public Flight findById(Long id) {
		if(exist(id))
			return fRepository.findOne(id);
		throw new HttpMessageNotReadableException("El vuelo '"+id+"' no se encuentra registrado");
	}
	
	private boolean isAvailableAirplane(Airplane airplane, LocalDate date, LocalTime timeOut, LocalTime arrivalTime){
		List<Flight> flights = fRepository.findByAirplaneAndDateAndTimeOutBetween(airplane,date,timeOut,arrivalTime);
		if(flights != null & !flights.isEmpty())
				return false;
		return true;
	}

	@Override
	public List<Flight> findAll() {
		try{
			return (List<Flight>)fRepository.findAll();
		}catch(Exception excp){ return null;}
	}

	@Override
	public List<Flight> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airport> findAllAirports() {
		try{
			return (List<Airport>)aRepository.findAll();
		}catch(Exception excp){ return null;}
	}

	@Override
	public Integer findAvailableChairs(Long idFlight) {		
		return fRepository.findAvailableChairs(idFlight);
	}

	private boolean exist(Long id){
		if(!fRepository.exists(id)){ 
			throw new HttpMessageNotReadableException("El vuelo '"+id+"' no se encuentra registrado");
		}
		return true;	
	}
}
