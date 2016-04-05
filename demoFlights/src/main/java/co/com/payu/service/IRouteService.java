package co.com.payu.service;

import java.util.List;

import co.com.payu.data.domain.Route;


/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * interface service routes 
 */

public interface IRouteService {

	public Route createOrUpdateRoute(Route route);
	
	public Route findRouteById(Long id);
	
	public List<Route> findAllRoutes();
		
	public boolean removeRoute(Route route);
}
