package co.com.payu.web;

import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_2.planner.logical.greedy.findShortestPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.payu.data.domain.FlightReservation;
import co.com.payu.service.IReservationService;

@RestController
@RequestMapping("/payu/demo/api/reservations")
@CrossOrigin
public class ReservationController {
	
	@Autowired
	private IReservationService rService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody FlightReservation reservation){
		FlightReservation r = rService.createReservation(reservation);
		return new ResponseEntity<FlightReservation>(r,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<FlightReservation> reservations = rService.findAll();		
		return new ResponseEntity<List<FlightReservation>>(reservations,HttpStatus.OK);
	}	

}
