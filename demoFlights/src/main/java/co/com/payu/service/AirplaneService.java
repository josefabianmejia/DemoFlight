package co.com.payu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import co.com.payu.data.IAirplaneRepository;
import co.com.payu.data.domain.Airplane;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * service airplane 
 */

@Service
@Transactional
public class AirplaneService implements IAirplaneService {

	@Autowired
	private IAirplaneRepository aRepository;
	
	@Override		
	public Airplane createOrUpdateAirplane(Airplane airplane) {
		try{
			return aRepository.save(airplane);
		}catch(Exception exp){ return null;}
	}

	@Override
	public Airplane findAirplaneById(Long id) {
		if(exist(id)){
			return aRepository.findOne(id);	
		}
		return null;
	}

	@Override
	public List<Airplane> findAllAirplanes() {
		try{
			return (List<Airplane>)aRepository.findAll();
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removeAirplane(Airplane airplane) {
		if(exist(airplane.getId())){
			aRepository.delete(airplane);
			return true;
		}
		return false;
	}
	
	private boolean exist(Long id){
		if(!aRepository.exists(id)){ 
			throw new HttpMessageNotReadableException("El avión '"+id+"' no se encuentra registrado");
		}
		return true;	
	}
}
