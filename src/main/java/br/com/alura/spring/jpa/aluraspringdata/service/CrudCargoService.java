package br.com.alura.spring.jpa.aluraspringdata.service;

import br.com.alura.spring.jpa.aluraspringdata.orm.Cargo;
import br.com.alura.spring.jpa.aluraspringdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    private Boolean system = true;
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system)  {
            System.out.println("Qual acao voce quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            final int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                case 2:
                    atualizar(scanner);
                case 3:
                    visualizar();
                case 4:
                    deletar(scanner);
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o ID do registro");
        final int id = scanner.nextInt();
        System.out.println("Descricao do Cargo");
        String descricao = scanner.next();
        Cargo cargo =  new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Atualizado");
    }

    private void visualizar() {
        Iterable<Cargo> cargos =  cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o ID do registro");
        final int id = scanner.nextInt();
        cargoRepository.deleteById(id);
        System.out.println("Deletado");

    }

}
