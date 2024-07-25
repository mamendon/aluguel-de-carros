package br.ufg.inf.bsi.alugueldecarros;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufg.inf.bsi.alugueldecarros.domain.Endereco;
import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;
import br.ufg.inf.bsi.alugueldecarros.repositories.PessoaRepository;

@SpringBootApplication
public class AluguelDeCarrosApplication implements CommandLineRunner {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AluguelDeCarrosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		 
		Pessoa pessoa1 = new Pessoa(null, "marcelo", "12312312312", "marcelo@ufg.com", "111111111");
        Endereco endereco1 = new Endereco(null, "Rua A", "123", "Apto 1", "Centro", "74000000", "Cidade A", pessoa1);
        pessoa1.setEndereco(endereco1);

        Pessoa pessoa2 = new Pessoa(null, "matheus", "12312312312", "matheus@ufg.com", "111111111");
        Endereco endereco2 = new Endereco(null, "Rua B", "456", "Apto 2", "Bairro B", "75000000", "Cidade B", pessoa2);
        pessoa2.setEndereco(endereco2);

        Pessoa pessoa3 = new Pessoa(null, "carine", "12312312312", "carine@ufg.com", "111111111");
        Endereco endereco3 = new Endereco(null, "Rua C", "789", "Apto 3", "Bairro C", "76000000", "Cidade C", pessoa3);
        pessoa3.setEndereco(endereco3);

        Pessoa pessoa4 = new Pessoa(null, "gabriel", "12312312312", "gabriel@ufg.com", "111111111");
        Endereco endereco4 = new Endereco(null, "Rua D", "101", "Apto 4", "Bairro D", "77000000", "Cidade D", pessoa4);
        pessoa4.setEndereco(endereco4);
	
		
		pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4));
	}

}
