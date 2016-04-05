package co.com.payu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import co.com.payu.data.IRouteRepository;
import co.com.payu.data.domain.Route;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * service routes 
 */

@Service
@Transactional
public class RouteService implements IRouteService {

	@Autowired
	private IRouteRepository rRepository;

	@Override
	public Route createOrUpdateRoute(Route route) {
		try{
			return rRepository.save(route);
		}catch(Exception exp){ return null;}
	}

	@Override
	public Route findRouteById(Long id) {
		if(exist(id)){			
			return rRepository.findOne(id);
		}
	return null;
	}

	@Override
	public List<Route> findAllRoutes() {
		try{
			return (List<Route>)rRepository.findAll();
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removeRoute(Route route) {
		if(exist(route.getId())){
			rRepository.delete(route);
			return true;
		}
	return false;
	}

	private boolean exist(Long id){
		if(!rRepository.exists(id)){ 
			throw new HttpMessageNotReadableException("La ruta '"+id+"' no se encuentra registrada");
		}
		return true;	
	}
	
}
