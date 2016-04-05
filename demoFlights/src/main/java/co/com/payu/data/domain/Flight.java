package co.com.payu.data.domain;

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
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * Entity Flight 
 */

@Entity
@Table(name = "FLIGHT")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "ID_FLIGHT")
	private Long id;
	
	@Column(name = "DATE")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;
	
	@Column(name = "TIME_OUT")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)	
	private LocalTime timeOut;
	
	@Column(name = "ARRIVAL_TIME")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)	
	private LocalTime arrivalTime;
	
	@ManyToOne
	@JoinColumn(name = "ID_AIRPLANE")
	private Airplane airplane;
	
	@ManyToOne
	@JoinColumn(name = "ID_ROUTE")
	private Route route;
	
	public Flight() { }
	
	public Flight(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalTime timeOut) {
		this.timeOut = timeOut;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
