package co.com.payu.data;

import org.springframework.data.repository.CrudRepository;

import co.com.payu.data.domain.FlightReservation;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * DAO FlightReservation 
 */
public interface IReservationRepository extends CrudRepository<FlightReservation, Long>{	

}
