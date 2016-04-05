package com.payU.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payU.data.IAirplaneRepository;
import com.payU.data.domain.Airplane;

@Service
@Transactional
public class AirplaneService implements IAirplaneService {

	@Autowired
	private IAirplaneRepository aRepository;
	
	@Override
	public boolean createOrUpdateAirplane(Airplane airplane) {
		try{
			aRepository.save(airplane);
			return true;
		}catch(Exception exp){ return false;}
	}

	@Override
	public Airplane findAirplaneById(Airplane airplane) {
		try{
			 return aRepository.findOne(airplane.getId());
		}catch(Exception exp){ return null;}
	}

	@Override
	public Set<Airplane> findAllAirplanes() {
		try{
			return (Set<Airplane>)aRepository.findAll();
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removeAirplane(Airplane airplane) {
		try{
			aRepository.delete(airplane);
			return true;
		}catch(Exception exp){ return false;}
	}

}
