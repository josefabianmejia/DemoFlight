package com.payU.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payU.data.IRouteRepository;
import com.payU.data.domain.Route;

@Service
@Transactional
public class RouteService implements IRouteService {

	@Autowired
	private IRouteRepository rRepository;

	@Override
	public boolean createOrUpdateRoute(Route route) {
		try{
			rRepository.save(route);
			return true;
		}catch(Exception exp){ return false;}
	}

	@Override
	public Route findRouteById(Route route) {
		try{
			return rRepository.findOne(route.getId());
		}catch(Exception exp){ return null;}
	}

	@Override
	public Set<Route> findAllRoutes() {
		try{
			return (Set<Route>)rRepository.findAll();
		}catch(Exception exp){ return null;}
	}

	@Override
	public boolean removeRoute(Route route) {
		try{
			rRepository.delete(route);
			return true;
		}catch(Exception exp){ return false;}
	}
	
	
}
