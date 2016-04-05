package com.payU.data;

import org.springframework.data.repository.CrudRepository;

import com.payU.data.domain.FlightReservation;

public interface IReservationRepository extends CrudRepository<FlightReservation, Long>{

}
