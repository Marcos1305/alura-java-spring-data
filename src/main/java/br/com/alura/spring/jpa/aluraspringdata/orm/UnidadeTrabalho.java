package br.com.alura.spring.jpa.aluraspringdata.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public String toString() {
        return "UnidadeTrabalho{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    private String descricao;
    private String endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
