package co.com.payu.data.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * embeddable Contact 
 */

@Embeddable
public class Contact {

	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	public Contact() { }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
}
