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
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * Entity Route 
 */

@Entity
@Table(name = "ROUTE")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROUTE")
	private Long id;
	
	
	@Column(name = "DURATION")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)	
	private LocalTime duration;
	
	@ManyToOne
	@JoinColumn(name = "ID_AIRPORT_I")
	private Airport originAirport;	

	@ManyToOne
	@JoinColumn(name = "ID_AIRPORT_D")
	private Airport detinationAirport;
	
	public Route() { }
	
	public Route(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(Airport originAirport) {		
		this.originAirport = originAirport;
	}

	public Airport getDetinationAirport() {
		return detinationAirport;
	}

	public void setDetinationAirport(Airport detinationAirport) {
		this.detinationAirport = detinationAirport;
	}

}

