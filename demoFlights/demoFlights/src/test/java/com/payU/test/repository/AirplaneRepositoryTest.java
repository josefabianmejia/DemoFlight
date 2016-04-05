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
import com.payU.data.IAirplaneRepository;
import com.payU.data.domain.Airplane;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class AirplaneRepositoryTest {

	@Autowired
	private IAirplaneRepository aRepository;
	
	
	private Airplane findById(Long id){
		return aRepository.findOne(id);
	}
	
	@Test
	@Transactional
	public void create() {
		Airplane airplane = new Airplane();
		airplane.setMarker("Airbus ");
		airplane.setModel("A-310");
		airplane.setCapacity(265);
		//validate null
		assertNull(airplane.getId());
		//save
		aRepository.save(airplane);
		//validate not null
		assertNotNull(airplane.getId());		
	}
	
	@Test
	@Transactional
	public void findById() {
		long id = 2;
		Airplane airplane = findById(id);
		assertNotNull(airplane);
	}
	
	@Test
	@Transactional
	public void findAll() {
		List<Airplane> airplanes = (List<Airplane>)aRepository.findAll();
		assertFalse(airplanes.isEmpty());
	}
	
	@Test
	@Transactional
	public void update() {
		long id = 4;
		Airplane airplane = findById(id);
		assertNotNull(airplane);
		
		//update
		airplane.setCapacity(265);
		airplane.setMarker("Airbus");
		airplane.setModel("A-310");
		aRepository.save(airplane);
		
		//find
		airplane = findById(id);
		assertTrue(airplane.getCapacity() == 265);
		assertTrue(airplane.getMarker().equals("Airbus"));
		assertTrue(airplane.getModel().equals("A-310"));
		
		
	}
	
	@Test
	@Transactional
	public void remove() {
		long id = 2;
		Airplane airplane = findById(id);
		assertNotNull(airplane);
		aRepository.delete(airplane);
	}	
	

}
