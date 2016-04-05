package com.payU.data;

import org.springframework.data.repository.CrudRepository;

import com.payU.data.domain.Passenger;

public interface IPassengerRepository extends CrudRepository<Passenger, Long> {

	public Passenger findByIdentification(Passenger passenger);
}
