package com.payU.service;

import java.util.Set;

import com.payU.data.domain.Route;

public interface IRouteService {

	public boolean createOrUpdateRoute(Route route);
	
	public Route findRouteById(Route route);
	
	public Set<Route> findAllRoutes();
		
	public boolean removeRoute(Route route);
}
