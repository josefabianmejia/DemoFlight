package co.com.payu.data;

import org.springframework.data.repository.CrudRepository;

import co.com.payu.data.domain.Passenger;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * DAO Passenger 
 */
public interface IPassengerRepository extends CrudRepository<Passenger, Long> {

	public Passenger findByIdentification(String identification);
}
