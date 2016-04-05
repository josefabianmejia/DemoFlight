package com.payU.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payU.data.domain.Passenger;
import com.payU.service.IPassengerService;

@RestController
@RequestMapping("/payU/demo/api/passengers")
public class PassengerController {
	
	@Autowired
	private IPassengerService pService;
	
	public PassengerController() { }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Passenger passenger){
		try{
			pService.createOrUpdatePassenger(passenger);
		}catch(Exception exp){ }
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Passenger passenger = null;
		try{
			passenger = pService.findPassengerById(new Passenger(id));
		}catch(Exception exp){ }
		
		return new ResponseEntity<>(passenger,HttpStatus.OK);		
	}
			
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Passenger> passengers = null;
		try{
			passengers = pService.findAllPassengers();
		}catch(Exception exp){ }
		
		return new ResponseEntity<>(passengers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Passenger passenger){
		try{
			pService.createOrUpdatePassenger(passenger);
		}catch(Exception exp){ }
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id){
		try{
			pService.removePassenger(new Passenger(id));
		}catch(Exception exp){ }
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
