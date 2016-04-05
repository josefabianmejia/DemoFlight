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

import co.com.payu.data.domain.Airplane;
import co.com.payu.service.IAirplaneService;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * airplane controller 
 */

@RestController
@RequestMapping("/payu/demo/api/airplanes")
@CrossOrigin
public class AirplaneController {
	
	@Autowired
	private IAirplaneService aService;
	
	public AirplaneController() { }
	
	/**	
	 * 
	 * @param Airplane
	 * @return Response entity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Airplane airplane){
		Airplane a = aService.createOrUpdateAirplane(airplane);					
		return new ResponseEntity<Airplane>(a,HttpStatus.CREATED);
	}
	
	/**	 
	 * 
	 * @param id
	 * @return Response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Airplane airplane  = aService.findAirplaneById(id);		
		return new ResponseEntity<Airplane>(airplane,HttpStatus.OK);		
	}
		
	/**	
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Airplane> airplanes = aService.findAllAirplanes();		
		return new ResponseEntity<List<Airplane>>(airplanes,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Airplane airplane){
		aService.createOrUpdateAirplane(airplane);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id){
		aService.removeAirplane(new Airplane(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
