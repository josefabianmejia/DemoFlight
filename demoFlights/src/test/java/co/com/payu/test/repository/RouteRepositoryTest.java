package co.com.payu.test.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.IRouteRepository;
import co.com.payu.data.domain.Airport;
import co.com.payu.data.domain.Route;

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
	@Ignore
	@Transactional
	public void create() {
		long idOrigAirp = 2;
		long idDestAirp = 1;		
		LocalTime duration = new LocalTime(4,0);
		
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
	@Ignore
	@Transactional
	public void findById() {
		long id = 2;
		Route route = findById(id);
		assertNotNull(route);
	}
	
	@Test
	@Ignore
	@Transactional
	public void findAll() {
		List<Route> routes = (List<Route>)rRepository.findAll();
		assertFalse(routes.isEmpty());
	}
	
	@Test
	@Ignore
	@Transactional
	public void update() {
		long id = 2;
		LocalTime duration = new LocalTime(2,0,0);
		Route route = findById(id);
		assertNotNull(route);
		
		//update
		route.setDuration(duration);
		rRepository.save(route);
		
		//find
		route = findById(id);
	}
	
	@Test
	@Ignore
	@Transactional
	public void remove() {
		long id = 1;
		Route route = findById(id);
		assertNotNull(route);
		rRepository.delete(route);
	}	

}
