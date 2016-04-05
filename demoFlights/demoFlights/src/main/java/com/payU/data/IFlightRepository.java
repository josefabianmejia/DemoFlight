package com.payU.data;

import org.springframework.data.repository.CrudRepository;

import com.payU.data.domain.Flight;

public interface IFlightRepository extends CrudRepository<Flight, Long>{

}
