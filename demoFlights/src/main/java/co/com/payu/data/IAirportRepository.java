package co.com.payu.data;

import org.springframework.data.repository.CrudRepository;

import co.com.payu.data.domain.Airport;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * DAO Airport 
 */
public interface IAirportRepository extends CrudRepository<Airport, Long>{

}
