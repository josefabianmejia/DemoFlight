package co.com.payu.service;

import java.util.List;

import co.com.payu.data.domain.Airplane;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * interface service airplane 
 */
public interface IAirplaneService {
	
	public Airplane createOrUpdateAirplane(Airplane airplane);
	
	public Airplane findAirplaneById(Long id);
	
	public List<Airplane> findAllAirplanes();
		
	public boolean removeAirplane(Airplane airplane);

}
