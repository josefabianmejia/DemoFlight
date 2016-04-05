package co.com.payu.data;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.payu.data.domain.Airplane;
import co.com.payu.data.domain.Flight;


/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * DAO Flight 
 */
public interface IFlightRepository extends CrudRepository<Flight, Long>{
		
	/**
	 * 
	 * @param airplane
	 * @param date ->date flight 
	 * @param time1 ->time out flight 
	 * @param time2 ->arrival time flight
	 * @return
	 */
	@Query(value = " select f from Flight f "+
			   " where f.airplane = ?1 and f.date = ?2 and "+
			   " ( (?3 between f.timeOut and f.arrivalTime)  or (?4 between f.timeOut and f.arrivalTime) )")
	public List<Flight> findByAirplaneAndDateAndTimeOutBetween (Airplane airplane, LocalDate date,LocalTime time1,LocalTime time2);

	/**
	 * 
	 * @param idFlight
	 * @return
	 */
	@Query(value = "select f.airplane.capacity - "+
						"( select coalesce(sum(r.numberChairs),'0') from FlightReservation r where r.flight.id = ?1 group by r.flight ) "+  
			" from Flight f "+ 
			" where f.id = ?1")
	public Integer findAvailableChairs(Long idFlight);
	
	/**
	 * 
	 * @param flight
	 * @return
	 */
	@Query(value = " select sum(numberChairs) from FlightReservation r "+
				   " where r.flight = ?1 "+
			       " group by r.flight")
	public int numberChairReserved(Flight flight);
	
	/**
	 * 
	 * @param idAirplane
	 * @param f1
	 * @param f2
	 * @return
	 */
	
//	@Query("select r.flight.route, sum(r.numberChairs) "+
//				" from FlightReservation r"+
//				" where r.flight.airplane = ?1"+
//				" group by r.flight.route")
//	public List<Object[]> findFlightsByAirplane(Long airplane);
	
}
