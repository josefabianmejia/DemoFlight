package co.com.payu.test.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.payu.DemoFlightsApplication;
import co.com.payu.data.IAirportRepository;
import co.com.payu.data.domain.Airport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class AirportRepositoryTest {

	@Autowired
	private IAirportRepository aRepository;
	
	private Airport findById(Long id) {
		return aRepository.findOne(id);
	}

	@Test
	@Ignore
	@Transactional
	public void create() {
		Airport airport = new Airport();
		airport.setName("Medellín Olaya Herrera");
		airport.setCity("Medellin");
		airport.setPhone("3322111");
		
		//validate null
		assertNull(airport.getId());
		//save
		aRepository.save(airport);
		//validate not null
		assertNotNull(airport.getId());		
	}
	
	@Test
	@Ignore
	@Transactional
	public void findById() {
		long id = 2;
		Airport airport = findById(id);
		assertNotNull(airport);
	}
	
	@Test
	@Ignore
	@Transactional
	public void findAll() {
		List<Airport> airports = (List<Airport>)aRepository.findAll();
		assertFalse(airports.isEmpty());
	}
	
	@Test
	@Ignore
	@Transactional
	public void update() {
		long id = 2;
		Airport airport = findById(id);
		assertNotNull(airport);
		
		//update
		airport.setName("airport");
		aRepository.save(airport);
		
		//find
		airport = findById(id);
		assertTrue(airport.getName().equals("airport"));				
		
	}
	
	@Test
	@Ignore
	@Transactional
	public void remove() {
		long id = 2;
		Airport airport = findById(id);
		assertNotNull(airport);
		aRepository.delete(airport);
	}	

}
