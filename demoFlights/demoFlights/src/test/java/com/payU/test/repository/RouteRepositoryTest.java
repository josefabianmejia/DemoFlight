package com.payU.test.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.payU.DemoFlightsApplication;
import com.payU.data.IRouteRepository;
import com.payU.data.domain.Airport;
import com.payU.data.domain.Route;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class RouteRepositoryTest {

	@Autowired
	private IRouteRepository rRepository;
	
	private Route findById(Long id) {
		return rRepository.findOne(id);
	}

	@Test
	@Transactional
	public void create() {
		long idOrigAirp = 3;
		long idDestAirp = 4;		
		float duration = (float) 2;
		
		Airport originAirport = new Airport(idOrigAirp);
		Airport detinationAirport = new Airport(idDestAirp);
		Route route = new Route();
		
		route.setDuration(duration);
		route.setOriginAirport(originAirport);
		route.setDetinationAirport(detinationAirport);
		//validate null
		assertNull(route.getId());
		//save
		rRepository.save(route);
		//validate not null
		assertNotNull(route.getId());		
	}
	
	@Test
	@Transactional
	public void findById() {
		long id = 3;
		Route route = findById(id);
		assertNotNull(route);
	}
	
	@Test
	@Transactional
	public void findAll() {
		List<Route> routes = (List<Route>)rRepository.findAll();
		assertFalse(routes.isEmpty());
	}
	
	@Test
	@Transactional
	public void update() {
		long id = 4;
		float duration = (float)1.5;
		Route route = findById(id);
		assertNotNull(route);
		
		//update
		route.setDuration(duration);
		rRepository.save(route);
		
		//find
		route = findById(id);
		assertTrue(route.getDuration() == duration);
	}
	
	@Test
	@Transactional
	public void remove() {
		long id = 4;
		Route route = findById(id);
		assertNotNull(route);
		rRepository.delete(route);
	}	

}
