package com.payU.data;

import org.springframework.data.repository.CrudRepository;

import com.payU.data.domain.Airport;

public interface IAirportRepository extends CrudRepository<Airport, Long>{

}
