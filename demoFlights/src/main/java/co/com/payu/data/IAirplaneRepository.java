package co.com.payu.data;

import org.springframework.data.repository.CrudRepository;

import co.com.payu.data.domain.Airplane;

/**
 * 
 * @author JOSE FABIAN MEJIA
 *
 * DAO Airplane 
 */
public interface IAirplaneRepository extends CrudRepository<Airplane, Long>{

}
