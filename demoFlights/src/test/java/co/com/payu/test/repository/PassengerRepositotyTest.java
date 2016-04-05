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
import co.com.payu.data.IPassengerRepository;
import co.com.payu.data.domain.Contact;
import co.com.payu.data.domain.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoFlightsApplication.class)
@Rollback(true)
public class PassengerRepositotyTest {

	@Autowired
	private IPassengerRepository pRepository;
	
	
	private Passenger findById(Long id){
		return pRepository.findOne(id);
	}
	
	@Test
	@Ignore
	@Transactional
	public void create() {
		Contact contact = new Contact();
		contact.setAddress("BARRIO 20 DE JULIO");
		contact.setPhone("332322");
		contact.setEmail("KAREN@HOTMAIL.COM");
		
		Passenger passenger = new Passenger();
		passenger.setIdentification("43321111");
		passenger.setFirstName("KAREN");
		passenger.setLastName("LOZANO PEREZ");
		passenger.setContact(contact);
		
		assertNull(passenger.getId());
		pRepository.save(passenger);
		assertNotNull(passenger.getClass());
		
	}
	
	@Test	
	@Ignore
	public void findById(){
		long id = 2;
		Passenger passenger = findById(id);
		assertNotNull(passenger);
	}
	
	@Test
	@Ignore
	public void findAll(){
		List<Passenger> passengers = (List<Passenger>)pRepository.findAll();
		assertFalse(passengers.isEmpty());
	}
	
	@Test
	@Ignore
	@Transactional
	public void update(){
		
		//find 
		long id = 2;
		Passenger passenger = findById(id);
		
		//validate		
		assertNotNull(passenger);
		
		passenger.getContact().setAddress("BARRIO LA EL POGRESO");
		passenger.getContact().setPhone("305899777");
		passenger.getContact().setEmail("MILA@GMAIL.COM");
		//update
		pRepository.save(passenger);
		
		//validate update
		passenger = findById(id);		
		assertTrue(passenger.getContact().getPhone().equals("305899777"));
		assertTrue(passenger.getContact().getAddress().equals("BARRIO LA EL POGRESO"));
		assertTrue(passenger.getContact().getEmail().equals("MILA@GMAIL.COM"));
	}
	
	@Test
	@Ignore
	@Transactional
	public void remove(){
		long id = 2;
		Passenger passenger = findById(id);
		assertNotNull(passenger);
		pRepository.delete(passenger);
	}
	
	

}
