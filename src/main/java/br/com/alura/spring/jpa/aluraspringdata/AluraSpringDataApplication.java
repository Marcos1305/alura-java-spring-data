package br.com.alura.spring.jpa.aluraspringdata;

import br.com.alura.spring.jpa.aluraspringdata.orm.Cargo;
import br.com.alura.spring.jpa.aluraspringdata.repository.CargoRepository;
import br.com.alura.spring.jpa.aluraspringdata.service.CrudCargoService;
import br.com.alura.spring.jpa.aluraspringdata.service.CrudFuncionarioService;
import br.com.alura.spring.jpa.aluraspringdata.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.jpa.aluraspringdata.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataApplication implements CommandLineRunner {
	private Boolean system = true;

	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	private final RelatoriosService relatoriosService;

	public AluraSpringDataApplication(CrudCargoService cargoService,
								 CrudFuncionarioService funcionarioService,
								 CrudUnidadeTrabalhoService unidadeTrabalhoService,
									  RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorio");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
