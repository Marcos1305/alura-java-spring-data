package br.com.alura.spring.jpa.aluraspringdata.repository;

import br.com.alura.spring.jpa.aluraspringdata.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
}