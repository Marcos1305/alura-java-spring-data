package br.com.alura.spring.jpa.aluraspringdata.repository;

import br.com.alura.spring.jpa.aluraspringdata.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Long> {
}