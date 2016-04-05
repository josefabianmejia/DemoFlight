package co.com.payu.data.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * Entity Flight Reservation 
 */

@Entity
@Table(name = "FLIGHT_RESERVATION")
public class FlightReservation {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESERVATION")
	private String id;
	
	@Column(name = "DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;
	
	@Column(name = "NUMBER_CHAIRS")
	private int numberChairs;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PASSENGER")
	private Passenger passenger;
	
	@ManyToOne
	@JoinColumn(name = "ID_FLIGHT")
	private Flight flight;
	
	public FlightReservation() { }
	
	public FlightReservation(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNumberChairs() {
		return numberChairs;
	}

	public void setNumberChairs(int numberChairs) {
		this.numberChairs = numberChairs;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}	

}
