package co.com.payu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.payu.data.domain.Airport;
import co.com.payu.data.domain.Flight;
import co.com.payu.service.IFlightService;

@RestController
@RequestMapping("/payu/demo/api/airports")
@CrossOrigin
public class AirportController {

	@Autowired
	private IFlightService fService;	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Airport> airports = fService.findAllAirports();
		return new ResponseEntity<List<Airport>>(airports,HttpStatus.OK);
	}
		
}
