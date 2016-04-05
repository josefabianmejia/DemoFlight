package co.com.payu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.payu.data.domain.Passenger;
import co.com.payu.service.IPassengerService;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * passenger controller 
 */

@RestController
@RequestMapping("/payu/demo/api/passengers")
@CrossOrigin
public class PassengerController {
	
	@Autowired
	private IPassengerService pService;
	
	public PassengerController() { }
	
	/**	
	 * 
	 * @param passenger
	 * @return Response entity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Passenger passenger){
		Passenger p = pService.createOrUpdatePassenger(passenger);					
		return new ResponseEntity<Passenger>(p,HttpStatus.CREATED);
	}
	
	/**	 
	 * 
	 * @param id
	 * @return Response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Passenger passenger  = pService.findPassengerById(id);		
		return new ResponseEntity<Passenger>(passenger,HttpStatus.OK);		
	}
			
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Passenger> passengers = pService.findAllPassengers();		
		return new ResponseEntity<List<Passenger>>(passengers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Passenger passenger){
		pService.createOrUpdatePassenger(passenger);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id){
		pService.removePassenger(new Passenger(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
