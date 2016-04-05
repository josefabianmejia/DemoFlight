package com.payU.data;

import org.springframework.data.repository.CrudRepository;

import com.payU.data.domain.Airplane;

public interface IAirplaneRepository extends CrudRepository<Airplane, Long>{

}
