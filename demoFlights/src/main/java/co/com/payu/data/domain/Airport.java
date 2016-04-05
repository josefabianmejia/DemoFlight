package co.com.payu.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * Entity Airport
 */

@Entity
@Table(name = "AIRPORT")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AIRPORT")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "PHONE")
	private String phone;
	
	
	public Airport() { }

	public Airport(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
