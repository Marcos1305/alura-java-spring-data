package br.com.alura.spring.jpa.aluraspringdata.specification;

import br.com.alura.spring.jpa.aluraspringdata.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFuncionario {
    public static Specification<Funcionario> nome(String nome) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        });
    }

    public static Specification<Funcionario> cpf(String cpf) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(cpf), "cpf");
        });
    }

    public static Specification<Funcionario> salario(Double salario) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get("salario"), salario);
        });
    }

    public static Specification<Funcionario> dataContratacao(LocalDate data) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get("dataContratacao"), data);
        });
    }
}
