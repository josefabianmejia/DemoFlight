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

import co.com.payu.data.domain.Flight;
import co.com.payu.service.IFlightService;

@RestController
@RequestMapping("/payu/demo/api/flights")
@CrossOrigin
public class FlightController {

	@Autowired
	private IFlightService fService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Flight flight){
		Flight f = fService.createFlight(flight);
		return new ResponseEntity<Flight>(f,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Flight> flights = fService.findAll();
		return new ResponseEntity<List<Flight>>(flights,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Flight flight = fService.findById(id);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
		
}
