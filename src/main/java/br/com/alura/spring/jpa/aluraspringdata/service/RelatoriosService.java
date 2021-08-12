package br.com.alura.spring.jpa.aluraspringdata.service;

import br.com.alura.spring.jpa.aluraspringdata.orm.Cargo;
import br.com.alura.spring.jpa.aluraspringdata.orm.Funcionario;
import br.com.alura.spring.jpa.aluraspringdata.orm.FuncionarioProjecao;
import br.com.alura.spring.jpa.aluraspringdata.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    private FuncionarioRepository repository;

    public void inicial(Scanner scanner) {
        while (system)  {
            System.out.println("Qual acao de relatorio voce quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario nome");
            System.out.println("2 - Busca funcionario nome, data, salario");
            System.out.println("3 - Busca funcionario data contratacao");
            System.out.println("4 - Busca funcionario salario");


            final int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scanner);
                case 3:
                    buscaFuncionarioDataContratacao(scanner);
                case 4:
                    buscaFuncionarioSalario();
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();
        List<Funcionario> list = repository.findByNome(nome);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioSalario() {
        List<FuncionarioProjecao> list = repository.findFuncionarioSalario();
        list.forEach(f -> System.out.println("Funcionario: id: " + f.getId() + " nome: " + f.getNome() + " salario: " + f.getSalario()));
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar:");
        String nome = scanner.next();

        System.out.println("Qual data deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);


        System.out.println("Qual salario deseja pesquisar:");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = repository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner) {
        System.out.println("Qual data deseja pesquisar:");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = repository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);
    }
}
