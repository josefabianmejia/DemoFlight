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

import co.com.payu.data.domain.Route;
import co.com.payu.service.IRouteService;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * Route controller 
 */

@RestController
@RequestMapping("/payu/demo/api/routes")
@CrossOrigin
public class RouteController {
	
	@Autowired
	private IRouteService rService;
	
	public RouteController() { }
	
	/**	
	 * 
	 * @param Route
	 * @return Response entity
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Route route){
		Route r = rService.createOrUpdateRoute(route);					
		return new ResponseEntity<Route>(r,HttpStatus.CREATED);
	}
	
	/**	 
	 * 
	 * @param id
	 * @return Response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Route route  = rService.findRouteById(id);		
		return new ResponseEntity<Route>(route,HttpStatus.OK);		
	}
			
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Route> routes = rService.findAllRoutes();		
		return new ResponseEntity<List<Route>>(routes,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Route route){
		rService.createOrUpdateRoute(route);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Long id){
		rService.removeRoute(new Route(id));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
