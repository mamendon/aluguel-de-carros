package br.ufg.inf.bsi.alugueldecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
}
