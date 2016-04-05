package com.payU.service;

import java.util.Set;

import com.payU.data.domain.Airplane;

public interface IAirplaneService {
	
	public boolean createOrUpdateAirplane(Airplane airplane);
	
	public Airplane findAirplaneById(Airplane airplane);
	
	public Set<Airplane> findAllAirplanes();
		
	public boolean removeAirplane(Airplane airplane);

}
